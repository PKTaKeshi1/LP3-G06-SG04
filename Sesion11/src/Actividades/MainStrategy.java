package Actividades;

//Interfaz Strategy
interface DiscountStrategy {
 double applyDiscount(double price);
}

//Estrategias concretas
class NoDiscount implements DiscountStrategy {
 public double applyDiscount(double price) {
     return price; // Sin descuento
 }
}

class FixedDiscount implements DiscountStrategy {
 public double applyDiscount(double price) {
     return price - 10; // Descuento fijo de 10 unidades
 }
}

class PercentageDiscount implements DiscountStrategy {
 public double applyDiscount(double price) {
     return price * 0.8; // Descuento del 20%
 }
}

//Contexto
class PriceCalculator {
 private DiscountStrategy discountStrategy;

 public void setDiscountStrategy(DiscountStrategy discountStrategy) {
     this.discountStrategy = discountStrategy;
 }

 public double calculatePrice(double price) {
     return discountStrategy.applyDiscount(price);
 }
}

//Clase Principal
public class MainStrategy {
 public static void main(String[] args) {
     PriceCalculator calculator = new PriceCalculator();

     calculator.setDiscountStrategy(new NoDiscount());
     System.out.println("Precio sin descuento: " + calculator.calculatePrice(100));

     calculator.setDiscountStrategy(new FixedDiscount());
     System.out.println("Precio con descuento fijo: " + calculator.calculatePrice(100));

     calculator.setDiscountStrategy(new PercentageDiscount());
     System.out.println("Precio con descuento porcentual: " + calculator.calculatePrice(100));
 }
}
