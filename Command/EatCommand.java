package Command;

import Decorator.PizzaComponent;

public class EatCommand implements Command {
    private PizzaComponent pizza;

    public EatCommand(PizzaComponent pizza) {
        this.pizza = pizza;
    }

    @Override
    public void execute() {
        System.out.println("\nYou decided to eat your " + pizza.getDescription() + " pizza.");
    }
}