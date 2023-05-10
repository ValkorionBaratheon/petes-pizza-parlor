package Decorator;

public class JalapenoPeppers extends ToppingDecorator {
    private static final double ADD = 1.25;

    public JalapenoPeppers(PizzaComponent pizza) {
        super(pizza);
    }

    public static double getAdd() {
        return ADD;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Jalapeno Peppers";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + ADD;
    }
}
