public class Onions extends ToppingDecorator {
    public Onions(Pizza pizza) {
        super(pizza);
    }

    public String getDescription() {
        return pizza.getDescription() + ", Onions";
    }

    public double cost() {
        return pizza.cost() + 0.75;
    }
}

