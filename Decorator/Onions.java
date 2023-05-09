package Decorator;

public class Onions extends ToppingDecorator {
    private static final double ADD = 1.00;

    public Onions(PizzaComponent pizza) {
        super(pizza);
    }

    public static double getAdd() {
        return ADD;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Onions";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + ADD;
    }
}
