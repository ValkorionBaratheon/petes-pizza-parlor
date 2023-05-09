public class Sausage extends ToppingDecorator {
    public Sausage(Pizza pizza) {
        super(pizza);
    }

    public String getDescription() {
        return pizza.getDescription() + ", Sausage";
    }

    public double cost() {
        return pizza.cost() + 1.50;
    }
}

