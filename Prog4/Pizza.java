package L3.Prog4;

import java.text.DecimalFormat;

public class Pizza {
    private  PizzaSize pizzaSize;
    private  PizzaType pizzaType;
    private int quantity;
    private double price;
    private static double TAX = 0.03;
    public Pizza(PizzaSize ps, PizzaType pt, int qty)
    {
        pizzaSize = ps;
        pizzaType = pt;
        quantity = qty;
        calculatePrice();
    }
    void calculatePrice()
    {
        double basePrice = switch (pizzaSize) {
            case SMALL -> 8.00;
            case MEDIUM -> 10.00;
            case LARGE -> 12.00;
        };
        double type = switch (pizzaType) {
            case VEGGIE -> 1.00;
            case PEPPERONI -> 2.00;
            case CHEEZE -> 1.50;
            case BBQCHICKEN -> 2.00;
        };
        price = (basePrice + type) * quantity;
    }
    public String printOrderSummary() {
        double tax = this.price * TAX;
        double totalPrice = this.price + tax;
        DecimalFormat df = new DecimalFormat("0.00");

        return String.format(
                "Pizza Order:\n" +
                        "Size: %s\n" +
                        "Type: %s\n" +
                        "Qty: %d\n" +
                        "Price: $%.2f\n" +
                        "Tax: $%.2f\n" +
                        "Total Price: $%.2f\n",
                pizzaSize.toString(),
                pizzaType.toString(),
                quantity,
                price,
                tax,
                totalPrice
        );
    }


    public static void main(String[] args) {

        Pizza pizza1 = new Pizza(PizzaSize.SMALL, PizzaType.VEGGIE, 2);
        Pizza pizza2 = new Pizza(PizzaSize.MEDIUM, PizzaType.PEPPERONI, 1);
        Pizza pizza3 = new Pizza(PizzaSize.LARGE, PizzaType.BBQCHICKEN, 2);


        System.out.println(pizza1.printOrderSummary());
        System.out.println(pizza2.printOrderSummary());
        System.out.println(pizza3.printOrderSummary());
    }


}
