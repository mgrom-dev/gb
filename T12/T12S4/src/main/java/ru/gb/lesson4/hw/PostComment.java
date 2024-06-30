package ru.gb.lesson4.hw;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import jakarta.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class PostComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public PostComment(String text, Post post, Date timestamp, User user) {
        this.text = text;
        this.post = post;
        this.timestamp = timestamp;
        this.user = user;
    }

    public static void savePostComment(PostComment postComment, Session session) {
        Transaction transaction = null;
        try {
            transaction = session.getTransaction();
            if (!transaction.isActive()) {
                transaction = session.beginTransaction();
                session.persist(postComment);
                transaction.commit();
            } else {
                session.persist(postComment);
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public static PostComment getPostComment(Long id, Session session) {
        try {
            return session.get(PostComment.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<PostComment> getAllPostComments(Session session) {
        try {
            Query<PostComment> query = session.createQuery("from PostComment", PostComment.class);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void deletePostComment(Long id, Session session) {
        Transaction transaction = null;
        try {
            transaction = session.getTransaction();
            if (!transaction.isActive()) {
                transaction = session.beginTransaction();
                PostComment postComment = session.get(PostComment.class, id);
                if (postComment != null) {
                    session.remove(postComment);
                    System.out.println("PostComment is deleted");
                }
                transaction.commit();
            } else {
                PostComment postComment = session.get(PostComment.class, id);
                if (postComment != null) {
                    session.remove(postComment);
                    System.out.println("PostComment is deleted");
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
        String post = String.format("{id: %s}", this.post.getId());
        return "PostComment [id=" + id + ", text=" + text + ", post=" + post + ", timestamp=" + timestamp + ", user="
                + user + "]";
    }

    
}