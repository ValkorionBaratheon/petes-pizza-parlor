import Builder.Pizza;
import Command.Customer;
import Command.Invoker;
import Command.Command;
import Command.EatCommand;
import Command.PayCommand;
import Decorator.JalapenoPeppers;
import Decorator.Mushrooms;
import Decorator.Onions;
import Decorator.Pepperoni;
import Decorator.PizzaComponent;
import Decorator.Sausage;
import java.util.Scanner;

public class PetePizzeria {
    public static void main(String[] args) {
        Pizza.Builder pizzaBuilder;
        PizzaComponent pizza;
        Invoker i;
        Customer customer;
        int choice;
        String pizzaStyle;
        String crustType;
        String cheeseType;
        String eat;
        String pay;
        String[] pizzaStyles = {"New York Style", "Extra Thin Style", "Deep Dish Style"};
        String[] crustTypes = {"Regular Crust", "Gluten-Free Crust"};
        String[] cheeseTypes = {"Mozzarella Cheese", "Provolone Cheese", "Cheddar Cheese"};
        String[] confirm = {"Yes", "No"};

        System.out.println("\nWelcome to Pete's Pizza Parlor!");
        System.out.println("We pride ourselves in our long-standing pizza-making heritage. Once your mouth experiences this deliciousness, all other pizzas will be ruined or your money back!");

        Scanner scanner = new Scanner(System.in);

        System.out.println("\nBefore you begin, the base price of a pizza is: $" + String.format("%.2f", Pizza.getBasePrice()));

        choice = getUserChoice("\nWhat kind of pizza would you like?", pizzaStyles, scanner);
        pizzaStyle = pizzaStyles[choice - 1];

        choice = getUserChoice("\nWhat kind of crust would you like?", crustTypes, scanner);
        crustType = crustTypes[choice - 1];

        choice = getUserChoice("\nWhat kind of cheese would you like?", cheeseTypes, scanner);
        cheeseType = cheeseTypes[choice - 1];

        pizzaBuilder = new Pizza.Builder(pizzaStyle, crustType, cheeseType);
        pizza = pizzaBuilder.build();
        
        System.out.println("\nChoose your toppings:");
        System.out.println("1: Mushrooms ($" + String.format("%.2f", Mushrooms.getAdd()) + ")\n" +
                           "2: Onions ($" + String.format("%.2f", Onions.getAdd()) + ")\n" +
                           "3: Jalapeno Peppers ($" + String.format("%.2f", JalapenoPeppers.getAdd()) + ")\n" +
                           "4: Pepperoni ($" + String.format("%.2f", Pepperoni.getAdd()) + ")\n" +
                           "5: Sausage ($" + String.format("%.2f", Sausage.getAdd()) + ")\n" +
                           "Enter the number of the topping you want and press enter. Type '0' when done.");
        
        while (true) {
            choice = scanner.nextInt();
            if (choice == 0) {
                break;
            } 
            else if (choice == 1) {
                pizza = new Mushrooms(pizza);
            } 
            else if (choice == 2) {
                pizza = new Onions(pizza);
            } 
            else if (choice == 3) {
                pizza = new JalapenoPeppers(pizza);
            } 
            else if (choice == 4) {
                pizza = new Pepperoni(pizza);
            } 
            else if (choice == 5) {
                pizza = new Sausage(pizza);
            } 
            else {
                System.out.println("Invalid choice. Please type one of the following integers: 1, 2, 3, 4, 5");
            }

            System.out.println("Your current total is: $" + String.format("%.2f", pizza.getCost()));
        }

        System.out.println("\nGreat! Now that you have picked your toppings, your total is: $" + String.format("%.2f", pizza.getCost()));
        System.out.println("Don't worry about it right now though. Pay us only after you've tried and loved your pizza!");

        System.out.println("\n30 minutes pass.");

        System.out.println("\nPete walks out from the kitchen with a pizza in his hands.");
        System.out.println("Your " + pizza.getDescription() + " pizza is ready!");

        customer = new Customer(pizza);
        Command e = new EatCommand(customer);
        Command p = new PayCommand(customer);

        choice = getUserChoice("\nWould you like to eat your pizza now?", confirm, scanner);
        eat = confirm[choice - 1];
        
        if (eat.equalsIgnoreCase(confirm[0])) {
            i = new Invoker(e);
            i.doCommand();
            System.out.println("\nPete: 'You got some mighty fine taste there, kid. I love me a good " + customer.getDescription() + ". That's my favorite too!'");
            System.out.println("\nWe hope you enjoyed your pizza! ");
        } else {
            System.out.println("\nPete: 'Get outta here! What, you too good for my pizza parlor? The youngsters these days. Sheesh!'");
            System.out.println("\nWe hope you will enjoy your pizza later!");
        }

        System.out.println("\nYour bill is $" + String.format("%.2f", customer.getCost()) + ".");
        choice = getUserChoice("\nWould you like to pay for the pizza now?", confirm, scanner);
        pay = confirm[choice - 1];

        if (pay.equalsIgnoreCase(confirm[0])) {
            i = new Invoker(p);
            i.doCommand();
            System.out.println("\nPete: 'Now that's some honor, kid. You've made Ol' Pete proud. You were raised right. Here's a free New York cheesecake - on the house. You earned it, kid.'");
            System.out.println("\nThanks for choosing Pete's Pizza Parlor!\n");
        } else {
            System.out.println("\nPete: 'You thief! Get back here you little punk! Sal, Paulie, Giovanni - teach this punk not to mess with Pete!'");
            System.out.println("\nPete's friends chased you down. They cornered you in an alley. You screamed for help, but it was too late. You died. You should've paid Pete.\n");
        }

        scanner.close();
    }

    public static int getUserChoice(String prompt, String[] options, Scanner scanner) {
        int choice;

        System.out.println(prompt);
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ": " + options[i]);
        }
        System.out.println("Enter the number corresponding to your choice.");

        while (true) {
            choice = scanner.nextInt();
            if (choice >= 1 && choice <= options.length) {
                break;
            }
            System.out.println("Invalid choice. Please type one of the following integers:");
            for (int i = 1; i <= options.length; i++) {
                System.out.print(i + (i < options.length ? ", " : ""));
            }
            System.out.println();
        }
        return choice;
    }
}
