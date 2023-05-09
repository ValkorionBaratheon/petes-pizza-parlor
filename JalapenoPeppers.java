public class JalapenoPeppers extends ToppingDecorator {
    public JalapenoPeppers(Pizza pizza) {
        super(pizza);
    }

    public String getDescription() {
        return pizza.getDescription() + ", JalapenoPeppers";
    }

    public double cost() {
        return pizza.cost() + 0.75;
    }
}

