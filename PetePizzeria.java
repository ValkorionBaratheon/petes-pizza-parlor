import Builder.Pizza;
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
        int choice;
        String pizzaStyle;
        String crustType;
        String cheeseType;

        System.out.println("\nWelcome to Pete's Pizza Parlor!");
        System.out.println("We pride ourselves in our long-standing pizza-making heritage. Once your mouth experiences this deliciousness, all other pizzas will be ruined or your money back!");

        Scanner scanner = new Scanner(System.in);


        System.out.println("\nBefore you begin, the base price of a pizza is: $" + String.format("%.2f", Pizza.getBasePrice()));
        System.out.println("\nWhat kind of pizza would you like? \n" +
                            "1: New York \n" +
                            "2: Extra Thin \n" +
                            "3: Deep Dish \n" +
                            "Enter the number corresponding to your choice.");
        choice = scanner.nextInt();

        switch (choice) {
            case 1:
                pizzaStyle = "New York Style";
                break;
            case 2:
                pizzaStyle = "Extra Thin Style";
                break;
            case 3:
                pizzaStyle = "Deep Dish Style";
                break;
            default:
                throw new IllegalArgumentException("Invalid choice.");
        }

        System.out.println("\nChoose your crust type: \n" +
                            "1: Regular \n" + 
                            "2: Gluten-Free");
        choice = scanner.nextInt();

        if (choice == 1) {
            crustType = "Regular Crust";
        } else if (choice == 2) {
            crustType = "Gluten-Free Crust";
        } else {
            throw new IllegalArgumentException("Invalid choice.");
        }

        System.out.println("\nChoose your cheese type: \n" +
                            "1: Mozzarella \n" +
                            "2: Provolone \n" +
                            "3: Cheddar");
        choice = scanner.nextInt();

        if (choice == 1) {
            cheeseType = "Mozzarella Cheese";
        } else if (choice == 2) {
            cheeseType = "Provolone Cheese";
        } else if (choice == 3) {
            cheeseType = "Cheddar Cheese";
        } else {
            throw new IllegalArgumentException("Invalid choice.");
        }

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
            } else if (choice == 1) {
                pizza = new Mushrooms(pizza);
            } else if (choice == 2) {
                pizza = new Onions(pizza);
            } else if (choice == 3) {
                pizza = new JalapenoPeppers(pizza);
            } else if (choice == 4) {
                pizza = new Pepperoni(pizza);
            } else if (choice == 5) {
                pizza = new Sausage(pizza);
            } else {
                System.out.println("Invalid choice. Please select one of the following integers: 1, 2, 3, 4, 5");
            }

            System.out.println("Your current total is: $" + String.format("%.2f", pizza.getCost()));
        }

        System.out.println("\nGreat! Now that you have picked your toppings, your total is: $" + String.format("%.2f", pizza.getCost()));
        System.out.println("Don't worry about it right now though. Pay us only after you've tried and loved your pizza!");

        System.out.println("\n30 minutes pass.");

        System.out.println("\nPete walks out from the kitchen with a pizza in his hands.");
        System.out.println("Your " + pizza.getDescription() + " pizza is ready!");

        System.out.println("\nWould you like to eat your pizza now?");
        System.out.println("Type 'yes' or 'no'");
        scanner.nextLine();
        String eat = scanner.nextLine();

        if (eat.equalsIgnoreCase("yes")) {
            Command eatCommand = new EatCommand(pizza);
            eatCommand.execute();
            //System.out.println("\nPete walks out from the kitchen.");
            System.out.println("\nPete: 'You got some mighty fine taste there, kid. I love me a good " + pizza.getDescription() + ". That's my favorite too!'");
        } else {
            //System.out.println("\nPete walks out from the kitchen.");
            System.out.println("\nPete: 'Get outta here! What, you too good for my pizza parlor? The youngsters these days. Sheesh!'");
        }

        System.out.println("\nWe hope you enjoyed your pizza! Would you like to pay for the pizza now? Your bill is $" + String.format("%.2f", pizza.getCost()) + ".");
        System.out.println("Type 'yes' or 'no'");
        String pay = scanner.nextLine();

        if (pay.equalsIgnoreCase("yes")) {
            Command payCommand = new PayCommand(pizza);
            payCommand.execute();
            System.out.println("\nPete: 'Now that's some honor, kid. You've made Ol' Pete proud. You were raised right. Here's a free New York cheesecake - on the house. You earned it, kid.'");
            System.out.println("\nThanks for choosing Pete's Pizza Parlor!");
        } else {
            System.out.println("\nPete: 'You thief! Get back here you little punk! Sal, Paulie, Giovanni - teach this punk not to mess with Pete!'");
            System.out.println("\nPete's friends chased you down. They cornered you in an alley. You screamed for help, but it was too late. You died. You should've paid Pete.");
        }

        scanner.close();
    }
}

