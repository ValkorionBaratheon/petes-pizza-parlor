package Decorator;

public class Onions extends ToppingDecorator {
    public Onions(PizzaComponent pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Onions";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 1.00;
    }
}
