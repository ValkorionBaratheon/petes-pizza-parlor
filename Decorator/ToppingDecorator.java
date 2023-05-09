package Decorator;

public abstract class ToppingDecorator implements PizzaComponent {
    protected PizzaComponent pizza;

    public ToppingDecorator(PizzaComponent p) {
        pizza = p;
    }
}