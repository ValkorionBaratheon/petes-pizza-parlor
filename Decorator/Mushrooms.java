package Decorator;

public class Mushrooms extends ToppingDecorator {
    public Mushrooms(PizzaComponent pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Mushrooms";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 1.00;
    }
}
