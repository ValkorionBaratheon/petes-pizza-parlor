package Command;

public class PayCommand implements Command {
    private Customer customer;

    public PayCommand(Customer c) {
        customer = c;
    }

    @Override
    public void execute() {
        customer.payPete();
    }
}