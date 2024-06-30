package ru.gb.lesson4.hw;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import jakarta.persistence.*;

@Data
@Entity
@Table(name = "\"user\"")
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Post> posts = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PostComment> comments = new ArrayList<>();

    public User(String name) {
        this.name = name;
    }

    static public void saveUser(User user, Session session) {
        Transaction transaction = null;
        try {
            transaction = session.getTransaction();
            if (!transaction.isActive()) {
                transaction = session.beginTransaction();
                session.persist(user);
                transaction.commit();
            } else {
                session.persist(user);
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    static public User getUser(Long id, Session session) {
        try {
            return session.get(User.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    static public List<User> getAllUsers(Session session) {
        try {
            Query<User> query = session.createQuery("from User", User.class);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    static public void deleteUser(Long id, Session session) {
        Transaction transaction = null;
        try {
            transaction = session.getTransaction();
            if (!transaction.isActive()) {
                transaction = session.beginTransaction();
                User user = session.get(User.class, id);
                if (user != null) {
                    session.remove(user);
                    System.out.println("User is deleted");
                }
                transaction.commit();
            } else {
                User user = session.get(User.class, id);
                if (user != null) {
                    session.remove(user);
                    System.out.println("User is deleted");
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
        StringBuilder posts = new StringBuilder("[");
        for (Post post : this.posts) {
            posts.append(
                    String.format("{id: %s, title: %s, time: %s}", post.getId(), post.getTitle(), post.getTimestamp()))
                    .append(",");
        }
        posts.deleteCharAt(posts.length() - 1).append("]");
        StringBuilder comments = new StringBuilder("[");
        for (PostComment comment : this.comments) {
            comments.append(
                    String.format("{id: %s, text: %s, postId: %s}", comment.getId(), comment.getText(), comment.getPost().getId()))
                   .append(",");
        }
        comments.deleteCharAt(comments.length() - 1).append("]");
        return "User [id=" + id + ", name=" + name + "\nposts=" + posts.toString() + "\ncomments=" + comments.toString() + "]";
    }
}