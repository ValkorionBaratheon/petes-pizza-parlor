package Decorator;

public class Sausage extends ToppingDecorator {
    private static final double ADD = 1.00;

    public Sausage(PizzaComponent pizza) {
        super(pizza);
    }

    public static double getAdd() {
        return ADD;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Sausage";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + ADD;
    }
}
