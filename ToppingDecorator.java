public class ToppingDecorator extends PizzaDecorator {
    protected Pizza pizza;

    public ToppingDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    public String getDescription() {
        return pizza.getDescription();
    }

    public double cost() {
        return pizza.cost();
    }
}
