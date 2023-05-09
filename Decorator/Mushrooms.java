package Decorator;

public class Mushrooms extends ToppingDecorator {
    private static final double ADD = 1.00;

    public Mushrooms(PizzaComponent pizza) {
        super(pizza);
    }

    public static double getAdd() {
        return ADD;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Mushrooms";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + ADD;
    }
}
