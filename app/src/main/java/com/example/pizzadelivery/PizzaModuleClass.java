package com.example.pizzadelivery;

public class PizzaModuleClass {
    String pizza_user_id;
    String pizza_name;
    String pizza_price;
    String pizza_quantity;
    String pizza_total;



    public PizzaModuleClass(String pizza_user_id, String pizza_name, String pizza_price, String pizza_quantity) {
        this.pizza_user_id = pizza_user_id;
        this.pizza_name = pizza_name;
        this.pizza_price = pizza_price;
        this.pizza_quantity = pizza_quantity;
    }

    public PizzaModuleClass() {
    }

    public String getPizza_user_id() {
        return pizza_user_id;
    }

    public void setPizza_user_id(String pizza_user_id) {
        this.pizza_user_id = pizza_user_id;
    }

    public String getPizza_name() {
        return pizza_name;
    }

    public void setPizza_name(String pizza_name) {
        this.pizza_name = pizza_name;
    }

    public String getPizza_price() {
        return pizza_price;
    }

    public void setPizza_price(String pizza_price) {
        this.pizza_price = pizza_price;
    }

    public String getPizza_quantity() {
        return pizza_quantity;
    }

    public void setPizza_quantity(String pizza_quantity) {
        this.pizza_quantity = pizza_quantity;
    }
    public String getPizza_total() {
        return pizza_total;
    }

    public void setPizza_total(String pizza_total) {
        this.pizza_total = pizza_total;
    }
}
