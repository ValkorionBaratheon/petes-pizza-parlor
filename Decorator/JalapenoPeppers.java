package Decorator;

public class JalapenoPeppers extends ToppingDecorator {
    public JalapenoPeppers(PizzaComponent pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Jalapeno Peppers";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 1.00;
    }
}
