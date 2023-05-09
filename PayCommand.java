public class PayCommand implements Command {
    private Pizza pizza;

    public PayCommand(Pizza pizza) {
        this.pizza = pizza;
    }

    public void execute() {
        System.out.println("You've paid $" + pizza.cost() + " for your pizza.");
    }
}
