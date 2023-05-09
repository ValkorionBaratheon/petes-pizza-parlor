package Decorator;

public class Pepperoni extends ToppingDecorator {
    private static final double ADD = 1.00;

    public Pepperoni(PizzaComponent pizza) {
        super(pizza);
    }

    public static double getAdd() {
        return ADD;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Pepperoni";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + ADD;
    }
}
