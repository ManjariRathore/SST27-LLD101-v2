package beverages_decorator;

public class Client {

	public static void main(String[] args) {
		
		Beverage coffee = new Coffee();
		System.out.println("Coffee: "+ coffee.cost());

		Beverage coffeeCappuccino = new Cappuccino(coffee);
		System.out.println("Cappuccino: "+ coffeeCappuccino.cost());
		

		coffee = new Coffee();
		Beverage coffeeLatte = new Latte(coffee);
		System.out.println("Latte: "+ coffeeLatte.cost());
	}

}