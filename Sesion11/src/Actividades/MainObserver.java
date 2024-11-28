package Actividades;

import java.util.ArrayList;
import java.util.List;

//Interfaz Observer
interface Observer {
 void update(String message);
}

//Clase Usuario (Observer concreto)
class User implements Observer {
 private String name;

 public User(String name) {
     this.name = name;
 }

 @Override
 public void update(String message) {
     System.out.println(name + " recibió: " + message);
 }
}

//Clase Notificador (Sujeto)
class Notifier {
 private List<Observer> observers = new ArrayList<>();

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
}

//Clase Principal
public class MainObserver {
 public static void main(String[] args) {
     Notifier notifier = new Notifier();

     Observer user1 = new User("Carlos");
     Observer user2 = new User("Ana");

     notifier.subscribe(user1);
     notifier.subscribe(user2);

     notifier.notifyObservers("¡Promoción del 20% en productos electrónicos!");
     notifier.unsubscribe(user1);
     notifier.notifyObservers("¡Nueva colección de invierno disponible!");
 }
}
