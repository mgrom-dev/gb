package ru.gb.lesson4.hw;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Homework {

  /**
   * Используя hibernate, создать таблицы:
   * 1. Post (публикация) (id, title)
   * 2. PostComment (комментарий к публикации) (id, text, post_id)
   *
   * Написать стандартные CRUD-методы: создание, загрузка, удаление.
   *
   * Доп. задания:
   * 1. * В сущностях post и postComment добавить поля timestamp с датами.
   * 2. * Создать таблицу users(id, name) и в сущностях post и postComment
   * добавить ссылку на юзера.
   * 3. * Реализовать методы:
   * 3.1 Загрузить все комментарии публикации
   * 3.2 Загрузить все публикации по идентификатору юзера
   * 3.3 ** Загрузить все комментарии по идентификатору юзера
   * 3.4 **** По идентификатору юзера загрузить юзеров, под чьими публикациями он
   * оставлял комменты.
   * // userId -> List<User>
   *
   *
   * Замечание:
   * 1. Можно использовать ЛЮБУЮ базу данных (например, h2)
   * 2. Если запутаетесь, приходите в группу в телеграме или пишите
   * мне @inchestnov в личку.
   */

  private static final String[] NAMES = {
      "Александр", "Михаил", "Дмитрий", "Андрей", "Алексей", "Сергей", "Иван", "Евгений", "Николай", "Павел",
      "Владимир", "Юрий", "Георгий", "Олег", "Виктор", "Максим", "Роман", "Кирилл", "Антон", "Игорь", "Александра",
      "Галина", "Татьяна", "Юля", "Полина", "Маша"
  };

  public static void main(String[] args) {
    Random random = new Random();
    Configuration configuration = new Configuration().configure();
    SessionFactory sessionFactory = configuration.buildSessionFactory();
    Session session = sessionFactory.openSession();

    session.beginTransaction();

    // Создаем пользователей
    List<User> users = IntStream.range(0, 10)
        .mapToObj(i -> new User(NAMES[random.nextInt(NAMES.length)]))
        .collect(Collectors.toList());
    // сохраняем в бд
    users.forEach(user -> User.saveUser(user, session));

    // Создаем публикации
    List<Post> posts = IntStream.range(0, 50)
        .mapToObj(i -> {
          Date time = new Date(System.currentTimeMillis() - random.nextLong(1000L * 60 * 60 * 24 * 365 * 2));
          User user = users.get(random.nextInt(users.size()));
          Post post = new Post("Post #" + (i + 1), time, user);
          user.getPosts().add(post);
          return post;
        })
        .collect(Collectors.toList());
    posts.forEach(post -> {
      Post.savePost(post, session);
    });

    // Создаем комментарии
    List<PostComment> postComments = IntStream.range(0, 50)
        .mapToObj(i -> {
          Date time = new Date(System.currentTimeMillis() - random.nextLong(1000L * 60 * 60 * 24 * 365 * 2));
          User user = users.get(random.nextInt(users.size()));
          Post post = posts.get(random.nextInt(posts.size()));
          PostComment postComment = new PostComment("Some text #" + i, post, time, user);
          user.getComments().add(postComment);
          post.getComments().add(postComment);
          return postComment;
        })
        .collect(Collectors.toList());
    postComments.forEach(postComment -> {
      PostComment.savePostComment(postComment, session);
    });

    session.getTransaction().commit();

    System.out.println("Пользователи:\n------------------------------------------------------------");
    for (User user : User.getAllUsers(session)) {
      System.out.println(user);
    }
    System.out.println("Посты:\n------------------------------------------------------------");
    for (Post post : Post.getAllPosts(session)) {
      System.out.println(post);
    }
    System.out.println("Комментарии:\n------------------------------------------------------------");
    for (PostComment postComment : PostComment.getAllPostComments(session)) {
      System.out.println(postComment);
    }

    System.out.println("Все комментарии публикации №5:\n------------------------------------------------------------");
    for (PostComment postComment : getAllPostComments(5L, session)) {
      System.out.println("Comment id: " + postComment.getId() + ", text: " + postComment.getText());
    }
    System.out.println("Все публикации юзера №1:\n------------------------------------------------------------");
    for (Post post : getAllPostsUser(1L, session)) {
      System.out.println("Post id: " + post.getId() + ", title: " + post.getTitle());
    }
    System.out.println("Все комментарии юзера №1:\n------------------------------------------------------------");
    for (PostComment postComment : getAllPostCommentsUser(1L, session)) {
      String text = String.format("Post id: %s, text: %s, postId: %s",
          postComment.getId(), postComment.getText(), postComment.getPost().getId());
      System.out.println(text);
    }
    System.out.println(
        "Юзеры, под чьими публикациями юзер №1 оставлял комменты:\n------------------------------------------------------------");
    for (User user : getAllUsersPostCommentUser(1L, session)) {
      StringBuilder postsId = new StringBuilder();
      for (Post post : getAllPostsUser(user.getId(), session)) {
        postsId.append(post.getId()).append(", ");
      }
      postsId.setLength(postsId.length() - 2);
      String text = String.format("User id: %s, name: %s, postIds: [%s]",
          user.getId(), user.getName(), postsId.toString());
      System.out.println(text);
    }

    session.close();
    sessionFactory.close();
  }

  // 3.1 Загрузить все комментарии публикации
  public static List<PostComment> getAllPostComments(Long id, Session session) {
    return Post.getPost(id, session).getComments();
  }

  // * 3.2 Загрузить все публикации по идентификатору юзера
  public static List<Post> getAllPostsUser(Long id, Session session) {
    return User.getUser(id, session).getPosts();
  }

  // * 3.3 ** Загрузить все комментарии по идентификатору юзера
  public static List<PostComment> getAllPostCommentsUser(Long id, Session session) {
    return User.getUser(id, session).getComments();
  }

  // 3.4 **** По идентификатору юзера загрузить юзеров, под чьими публикациями он
  // оставлял комменты. userId -> List<User>
  public static List<User> getAllUsersPostCommentUser(Long id, Session session) {
    List<PostComment> postComments = getAllPostCommentsUser(id, session);
    return postComments.stream()
        .map(PostComment::getPost)
        .map(Post::getUser)
        .distinct()
        .collect(Collectors.toList());
  }
}
