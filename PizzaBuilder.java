public class PizzaBuilder {
    private Pizza pizza;

    public PizzaBuilder() {
        pizza = new Pizza() {
            public double cost() {
                return 9.50;
            }
        };
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void buildPizzaStyle(String style) {
        pizza.description = style;
    }

    public void buildCrustType(String crustType) {
        pizza.description += ", " + crustType;
    }

    public void buildCheeseType(String cheeseType) {
        pizza.description += ", " + cheeseType;
    }
}
