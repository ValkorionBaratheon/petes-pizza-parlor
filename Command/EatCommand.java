package Command;

public class EatCommand implements Command {
    private Customer customer;

    public EatCommand(Customer c) {
        customer = c;
    }

    @Override
    public void execute() {
        customer.eatPizza();
    }
}