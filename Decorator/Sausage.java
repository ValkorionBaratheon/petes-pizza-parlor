package Decorator;

public class Sausage extends ToppingDecorator {
    public Sausage(PizzaComponent pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Sausage";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 1.00;
    }
}
