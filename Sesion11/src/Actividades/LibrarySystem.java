package Actividades;

import java.util.*;

//Observer: Interfaz y usuarios
interface Observer {
 void update(String message);
}

class LibraryUser implements Observer {
 private String name;

 public LibraryUser(String name) {
     this.name = name;
 }

 @Override
 public void update(String message) {
     System.out.println(name + " recibió: " + message);
 }
}

//Sujeto: Biblioteca
class Library {
 private List<Observer> observers = new ArrayList<>();
 private List<String> books = new ArrayList<>();

 public void subscribe(Observer observer) {
     observers.add(observer);
 }

 public void unsubscribe(Observer observer) {
     observers.remove(observer);
 }

 public void notifyObservers(String message) {
     for (Observer observer : observers) {
         observer.update(message);
     }
 }

 public void addBook(String book) {
     books.add(book);
     notifyObservers("Nuevo libro disponible: " + book);
 }

 public List<String> getBooks() {
     return books;
 }
}

//Strategy: Estrategias de préstamo
interface LoanStrategy {
 int getLoanDays();
}

class StandardLoan implements LoanStrategy {
 public int getLoanDays() {
     return 14; // 14 días estándar
 }
}

class QuickLoan implements LoanStrategy {
 public int getLoanDays() {
     return 7; // 7 días para préstamos rápidos
 }
}

class ExtendedLoan implements LoanStrategy {
 public int getLoanDays() {
     return 30; // 30 días para préstamos extendidos
 }
}

//Contexto: Gestión de préstamos
class LoanManager {
 private LoanStrategy loanStrategy;

 public void setLoanStrategy(LoanStrategy loanStrategy) {
     this.loanStrategy = loanStrategy;
 }

 public int calculateLoanDays() {
     return loanStrategy.getLoanDays();
 }
}

//Command: Interfaz y comandos concretos
interface Command {
 void execute();
}

class AddBookCommand implements Command {
 private Library library;
 private String book;

 public AddBookCommand(Library library, String book) {
     this.library = library;
     this.book = book;
 }

 @Override
 public void execute() {
     library.addBook(book);
 }
}

class NotifyUsersCommand implements Command {
 private Library library;
 private String message;

 public NotifyUsersCommand(Library library, String message) {
     this.library = library;
     this.message = message;
 }

 @Override
 public void execute() {
     library.notifyObservers(message);
 }
}

class LoanBookCommand implements Command {
 private String book;
 private LoanManager loanManager;

 public LoanBookCommand(String book, LoanManager loanManager) {
     this.book = book;
     this.loanManager = loanManager;
 }

 @Override
 public void execute() {
     System.out.println("Libro prestado: " + book + " | Días de préstamo: " + loanManager.calculateLoanDays());
 }
}

//Invocador: Control de biblioteca
class LibraryController {
 private Command command;

 public void setCommand(Command command) {
     this.command = command;
 }

 public void pressButton() {
     command.execute();
 }
}

//Clase Principal
public class LibrarySystem {
 public static void main(String[] args) {
     // Configuración de la biblioteca (Observer)
     Library library = new Library();
     Observer user1 = new LibraryUser("María");
     Observer user2 = new LibraryUser("José");

     library.subscribe(user1);
     library.subscribe(user2);

     // Configuración de préstamos (Strategy)
     LoanManager loanManager = new LoanManager();
     loanManager.setLoanStrategy(new StandardLoan()); // Estrategia inicial

     // Configuración de comandos e invocador
     LibraryController controller = new LibraryController();

     // Agregar libros y notificar usuarios
     controller.setCommand(new AddBookCommand(library, "El Quijote"));
     controller.pressButton();

     controller.setCommand(new AddBookCommand(library, "Cien Años de Soledad"));
     controller.pressButton();

     // Realizar un préstamo
     controller.setCommand(new LoanBookCommand("El Quijote", loanManager));
     controller.pressButton();

     // Cambiar estrategia de préstamo y realizar otro préstamo
     loanManager.setLoanStrategy(new ExtendedLoan());
     controller.setCommand(new LoanBookCommand("Cien Años de Soledad", loanManager));
     controller.pressButton();

     // Notificar un mensaje general
     controller.setCommand(new NotifyUsersCommand(library, "La biblioteca estará cerrada mañana."));
     controller.pressButton();
 }
}
