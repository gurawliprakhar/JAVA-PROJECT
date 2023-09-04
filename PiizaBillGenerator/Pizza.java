public class Pizza {

	private int price;
	private boolean veg;
	private int extraCheesePrice = 100;
	private int extraToppingsPrice = 150;
	private int backPackPrice = 20;
	private int basePizzaPrice;
	private boolean isExtraCheeseAdded;
	private boolean isExtraToppingsAdded;
	private boolean isConfirmedForTakeAway;

	public Pizza(boolean veg) {
		super();
		this.veg = veg;
		if (this.veg) {
			this.price = 300;
		} else {
			this.price = 400;
		}
		basePizzaPrice = this.price;
	}

	public void addExtraCheese() {
		System.out.println("Extra Cheese added");
		this.price += extraCheesePrice;
		isExtraCheeseAdded = true;
	}

	public void addExtraToppings() {
		System.out.println("Extra Topping added");
		this.price += extraToppingsPrice;
		isExtraToppingsAdded = true;
	}

	public void takeAway() {
		System.out.println("Take away Confirmed");
		this.price += backPackPrice;
		isConfirmedForTakeAway = true;
	}

	public void getBill() {
		String bill = "";
		System.out.println("Pizza: " + basePizzaPrice);
		if (isExtraCheeseAdded) {
			bill += "Extra cheese added : " + extraCheesePrice + "\n";
		}
		if (isExtraToppingsAdded) {
			bill += "Extra Toppings added : " + extraToppingsPrice + "\n";
		}
		if (isConfirmedForTakeAway) {
			bill += "Take away: " + backPackPrice + "\n";
		}
		bill += "bill: " + this.price + "\n";
		System.out.println(bill);
	}
}
