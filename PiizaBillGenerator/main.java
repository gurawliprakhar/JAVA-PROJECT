import java.util.Scanner;
public class main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Welcome to the Pizza Shop");
		
		System.out.println("Is the pizza vegetarian ? (true/false): ");
		boolean isVegetarian = scan.nextBoolean();
		Pizza pizza = new Pizza(isVegetarian);

		System.out.print("Add extra cheese (true/false): ");
        boolean addExtraCheese = scan.nextBoolean();
        if (addExtraCheese) {
            pizza.addExtraCheese();
        }

        System.out.print("Add extra toppings (true/false): ");
        boolean addExtraToppings = scan.nextBoolean();
        if (addExtraToppings) {
            pizza.addExtraToppings();
        }

        System.out.print("Is it for take-away (true/false): ");
        boolean isTakeAway = scan.nextBoolean();
        if (isTakeAway) {
            pizza.takeAway();
        }

        pizza.getBill();
        
        scan.close();
	}

}
