public abstract class Pizza {
    String description = "Unknown Pizza";
    double baseCost = 8.0;

    public String getDescription() {
        return description;
    }

    public double getBaseCost() {
        return baseCost;
    }

    public abstract double cost();

    public static class PizzaBuilder {
        protected String pizzaStyle;
        protected String crustType;
        protected String cheeseType;

        public PizzaBuilder() {
        }

        public PizzaBuilder buildPizzaStyle(String style) {
            this.pizzaStyle = style;
            return this;
        }

        public PizzaBuilder buildCrustType(String crustType) {
            this.crustType = crustType;
            return this;
        }

        public PizzaBuilder buildCheeseType(String cheeseType) {
            this.cheeseType = cheeseType;
            return this;
        }

        public Pizza build() {
            return new CustomPizza(this);
        }
    }
}

class CustomPizza extends Pizza {
    private String pizzaStyle;
    private String crustType;
    private String cheeseType;

    public CustomPizza(Pizza.PizzaBuilder builder) {
        this.pizzaStyle = builder.pizzaStyle;
        this.crustType = builder.crustType;
        this.cheeseType = builder.cheeseType;
        this.description = pizzaStyle + " Style, " + crustType + " Crust, " + cheeseType + " Cheese";
    }

    public double cost() {
        return baseCost;
    }
}
