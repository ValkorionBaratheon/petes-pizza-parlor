import java.util.Scanner;

public class PetePizzeria {
    public static void main(String[] args) {
        System.out.println("\nWelcome to Pete's Pizza Parlor!");
        System.out.println("We pride ourselves in our long-standing pizza-making heritage. Once your mouth experiences this deliciousness, all other pizzas will be ruined or your money back!\n");

        Scanner scanner = new Scanner(System.in);
        PizzaBuilder pizzaBuilder = new PizzaBuilder();
        Pizza pizza;

        System.out.println("What kind of pizza would you like? (1: New York, 2: Extra Thin, 3: Deep Dish). Enter the number corresponding to your choice.");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                pizzaBuilder.buildPizzaStyle("New York Style");
                break;
            case 2:
                pizzaBuilder.buildPizzaStyle("Extra Thin Style");
                break;
            case 3:
                pizzaBuilder.buildPizzaStyle("Deep Dish Style");
                break;
            default:
                throw new IllegalArgumentException("Invalid choice.");
        }

        System.out.println("\nChoose your crust type: (1: Regular, 2: Gluten-Free)");
        choice = scanner.nextInt();

        if (choice == 1) {
            pizzaBuilder.buildCrustType("Regular Crust");
        } else if (choice == 2) {
            pizzaBuilder.buildCrustType("Gluten-Free Crust");
        } else {
            throw new IllegalArgumentException("Invalid choice.");
        }

        System.out.println("\nChoose your cheese type: (1: Mozzarella, 2: Provolone, 3: Cheddar)");
        choice = scanner.nextInt();

        if (choice == 1) {
            pizzaBuilder.buildCheeseType("Mozzarella Cheese");
        } else if (choice == 2) {
            pizzaBuilder.buildCheeseType("Provolone Cheese");
        } else if (choice == 3) {
            pizzaBuilder.buildCheeseType("Cheddar Cheese");
        } else {
            throw new IllegalArgumentException("Invalid choice.");
        }

        pizza = pizzaBuilder.getPizza();

        System.out.println("\nChoose your toppings (Enter the number of the topping and press enter. Type '0' when done):");
        System.out.println("1: Mushrooms\n2: Onions\n3: Jalapeno Peppers\n4: Pepperoni\n5: Sausage");

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
                System.out.println("Invalid choice. Please try again.");
            }
        }

        System.out.println("\nYour pizza has been made: " + pizza.getDescription());

        System.out.println("\nDo you want to eat your pizza now? (Type yes or no)");
        scanner.nextLine(); // Consume newline left-over
        String eat = scanner.nextLine();

        if (eat.equalsIgnoreCase("yes")) {
            Command eatCommand = new EatCommand(pizza);
            eatCommand.execute();
            System.out.println("\nPete walks out from the kitchen.");
            System.out.println("Pete: 'You got some mighty fine taste there, kid. We love a good " + pizza.getDescription() + ". That's my favorite too. Great minds think alike.'");
        } else {
            System.out.println("Pete: 'Get outta here! What, you too good for my pizza parlor? The youngsters these days. Sheesh!'");
        }

        System.out.println("\nDo you want to pay for the pizza? (Type yes or no)");
        String pay = scanner.nextLine();

        if (pay.equalsIgnoreCase("yes")) {
            Command payCommand = new PayCommand(pizza);
            payCommand.execute();
            System.out.println("\nPete: 'Now that's some honor, kid. You've made Ol' Pete proud. You were raises right. Here's a free New York cheesecake - on the house. You earned it, kid.'");
            System.out.println("Thanks for choosing Pete's Pizza Parlor!");
        } else {
            System.out.println("\nPete: 'You thief! Get back here you little punk! Sal, Paulie, Giovanni - teach this punk not to mess with Pete!'");
            System.out.println("Pete's friends chased you down. They cornered you in an alley. You screamed for help, but it was too late. You died. You should've paid Pete.");
        }

        scanner.close();
    }
}

