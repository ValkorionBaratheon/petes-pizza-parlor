package Builder;

import Decorator.PizzaComponent;

public class Pizza implements PizzaComponent{
    private String pizzaStyle;
    private String crustType;
    private String cheeseType;
    private double cost;
    private static final double BASE_PRICE = 10.00;

    public static class Builder {
        private String pizzaStyle;
        private String crustType;
        private String cheeseType;
        private double cost = BASE_PRICE;

        public Builder(String pizzaStyle, String crustType, String cheeseType) {
            this.pizzaStyle = pizzaStyle;
            this.crustType = crustType;
            this.cheeseType = cheeseType;
        }

        public Builder pizzaStyle(String pizzaStyle) {
            this.pizzaStyle = pizzaStyle;
            return this;
        }

        public Builder crustType(String crustType) {
            this.crustType = crustType;
            return this;
        }

        public Builder cheeseType(String cheeseType) {
            this.cheeseType = cheeseType;
            return this;
        }

        public Pizza build() {
            return new Pizza(this);
        }
    }

    private Pizza(Builder builder) {
        this.pizzaStyle = builder.pizzaStyle;
        this.crustType = builder.crustType;
        this.cheeseType = builder.cheeseType;
        this.cost = builder.cost;
    }

    public String getPizzaStyle() {
        return pizzaStyle;
    }

    public String getCrustType() {
        return crustType;
    }

    public String getCheeseType() {
        return cheeseType;
    }

    public String toString() {
        return pizzaStyle + " with " + crustType + " and " + cheeseType;
    }

    public static double getBasePrice() {
        return BASE_PRICE;
    }

    @Override
    public String getDescription() {
        return pizzaStyle + ", " + crustType + ", " + cheeseType;
    }

    @Override
    public double getCost() {
        return cost;
    }
}
