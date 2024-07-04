package ru.gb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import ru.gb.core.EmailSender;
import ru.gb.scope.Prototype;
import ru.gb.scope.Singleton;

@SpringBootApplication
public class Application {

	// bean1, bean2, bean3(prototype), ...
	// AppContext[bean1, bean2, bean3(prototype)] HashMap<String, Object>
	// ...
	// context.close()
	// -> bean1.preDestroy()

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

		// Bean - объект, жизненным циклом которого управляет Spring
		// ApplicationContext - контейнер для бинов
		// Singleton - класс, у которого только 1 объект
		EmailSender emailSender = context.getBean(EmailSender.class);
		emailSender.sendEmail(
			"test", "asfdad", "inchestnov.dump@gmail.com"
		);

		// Scope - [Singleton, Prototype, | Session, Request, ...]
		System.out.println("Singleton #1 = " + context.getBean(Singleton.class).getId());
		System.out.println("Singleton #2 = " + context.getBean(Singleton.class).getId());
		System.out.println("Singleton #3 = " + context.getBean(Singleton.class).getId());

		System.out.println("Prototype #1 = " + context.getBean(Prototype.class).getId()); // 2
		System.out.println("Prototype #2 = " + context.getBean(Prototype.class).getId()); // 3
		System.out.println("Prototype #3 = " + context.getBean(Prototype.class).getId()); // 4

		Singleton singleton = context.getBean(Singleton.class);
		singleton.printIds();
		singleton.printIds();
		singleton.printIds();

	}

}
