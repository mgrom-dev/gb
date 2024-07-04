package ru.gb.hw;

public class Homework {

  /**
   * Напрограммировать электронную очередь.
   * 1. Класс TicketNumberGenerator - бин (синглтон), у которого есть метод createNewNumber()
   * 1.1 Метод createNewNumber возвращает строки вида "Ticket #X", где X - UUID (UUID.randomUUID().toString())
   *
   * Пример:
   * TicketNumberGenerator generator = context.getBean(TicketNumberGenerator.class);
   * System.out.println(generator.createNewNumber()); // "Ticket #b0b3a25d-2135-4b18-9dec-08d494b96b06"
   * System.out.println(generator.createNewNumber()); // "Ticket #379c5673-50c3-4daf-a53f-a396a3d34535"
   * System.out.println(generator.createNewNumber()); // "Ticket #b4cc4e55-69b2-4c49-867f-09735fea292a"
   *
   * 2. Создать класс Ticket (не бин!!!) с полями:
   * 2.1. String number - номер тикета
   * 2.2. LocalDateTime createdAt - дата создания
   * 2.3. ... (любые другие поля)
   *
   * 3. Класс "Табло" - бин (синглтон), у которого есть поле ticketNumberGenerator
   *    и метод метод newTicket(), который создает объетк класса Ticket с значениями полей:
   * 3.1 number - результат вызова TicketNumberGenerator#createNewNumber
   * 3.2 createdAt - LocalDateTime.now()
   * 3.3 ...
   */

  @Configuration
  public class TicketNumberGenerator {
    private static final TicketNumberGenerator instance = new TicketNumberGenerator();

    private TicketNumberGenerator() {
    }

    public static TicketNumberGenerator getInstance() {
        return instance;
    }

    public String createNewNumber() {
        return "Ticket #" + UUID.randomUUID().toString();
    }
  }

  public class Ticket {
    private String number;
    private LocalDateTime createdAt;
    private String customerName;
    private String customerPhone;

    public Ticket(String number, LocalDateTime createdAt, String customerName, String customerPhone) {
        this.number = number;
        this.createdAt = createdAt;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
    }

    // Getters and setters
  }

  @Service
  public class TicketBoard {
    private final TicketNumberGenerator ticketNumberGenerator;
    private final List<Ticket> tickets = new ArrayList<>();

    public TicketBoard(TicketNumberGenerator ticketNumberGenerator) {
        this.ticketNumberGenerator = ticketNumberGenerator;
    }

    public Ticket newTicket(String customerName, String customerPhone) {
        String number = ticketNumberGenerator.createNewNumber();
        LocalDateTime createdAt = LocalDateTime.now();
        Ticket ticket = new Ticket(number, createdAt, customerName, customerPhone);
        tickets.add(ticket);
        return ticket;
    }

    public List<Ticket> getTickets() {
        return new ArrayList<>(tickets);
    }
  }

  @RestController
  public class TicketController {
    private final TicketBoard ticketBoard;

    public TicketController(TicketBoard ticketBoard) {
        this.ticketBoard = ticketBoard;
    }

    @PostMapping("/tickets")
    public Ticket createTicket(@RequestParam String customerName, @RequestParam String customerPhone) {
        return ticketBoard.newTicket(customerName, customerPhone);
    }

    @GetMapping("/tickets")
    public List<Ticket> getTickets() {
        return ticketBoard.getTickets();
    }
  }  

}
