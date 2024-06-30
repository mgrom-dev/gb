package ru.gb.lesson4.hw;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import jakarta.persistence.*;

@Data
@Entity
@Table(name = "\"post\"")
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PostComment> comments = new ArrayList<>();

    public Post(String title, Date timestamp, User user) {
        this.title = title;
        this.timestamp = timestamp;
        this.user = user;
    }

    public static void savePost(Post post, Session session) {
        Transaction transaction = null;
        try {
            transaction = session.getTransaction();
            if (!transaction.isActive()) {
                transaction = session.beginTransaction();
                session.persist(post);
                transaction.commit();
            } else {
                session.persist(post);
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public static Post getPost(Long id, Session session) {
        try {
            return session.get(Post.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<Post> getAllPosts(Session session) {
        try {
            Query<Post> query = session.createQuery("from Post", Post.class);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void deletePost(Long id, Session session) {
        Transaction transaction = null;
        try {
            transaction = session.getTransaction();
            if (!transaction.isActive()) {
                transaction = session.beginTransaction();
                Post post = session.get(Post.class, id);
                if (post != null) {
                    session.remove(post);
                    System.out.println("Post is deleted");
                }
                transaction.commit();
            } else {
                Post post = session.get(Post.class, id);
                if (post != null) {
                    session.remove(post);
                    System.out.println("Post is deleted");
                }
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        String user = String.format("{id: %s, name: %s}", this.user.getId(), this.user.getName());
        StringBuilder comments = new StringBuilder("[");
        for (PostComment comment : this.comments) {
            comments.append(
                    String.format("{id: %s, text: %s, time: %s}", comment.getId(), comment.getText(), comment.getTimestamp()))
                    .append(",");
        }
        comments.deleteCharAt(comments.length() - 1).append("]");
        return "Post [id=" + id + ", title=" + title + ", timestamp=" + timestamp + ", user=" + user + ", comments="
                + comments.toString() + "]";
    }
}
