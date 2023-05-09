package Decorator;

public class Pepperoni extends ToppingDecorator {
    public Pepperoni(PizzaComponent pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Pepperoni";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 1.00;
    }
}
