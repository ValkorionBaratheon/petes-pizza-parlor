package Command;

import Decorator.PizzaComponent;

public class PayCommand implements Command {
    private PizzaComponent pizza;

    public PayCommand(PizzaComponent pizza) {
        this.pizza = pizza;
    }

    @Override
    public void execute() {
        System.out.println("\nYou paid $" + pizza.getCost() + " for your " + pizza.getDescription() + " pizza.");
    }
}