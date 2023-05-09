public class EatCommand implements Command {
    private Pizza pizza;

    public EatCommand(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public void execute() {
        System.out.println("\nYou eat your " + pizza.getDescription() + " pizza. It was delicious!");
    }
}

