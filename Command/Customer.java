package Command;

import Decorator.PizzaComponent;

public class Customer implements PizzaComponent{
    private PizzaComponent pizza;

    public Customer(PizzaComponent p) {
        pizza = p;
    }

    public void eatPizza() {
        System.out.println("\nYou decided to eat your " + pizza.getDescription() + " pizza.");
    }
    public void payPete() {
        System.out.println("\nYou paid $" + pizza.getCost() + " for your " + pizza.getDescription() + " pizza.");
    }
    
    @Override
    public String getDescription() {
        return pizza.getDescription();
    }

    @Override
    public double getCost() {
        return pizza.getCost();
    }
}
