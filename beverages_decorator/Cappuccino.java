package beverages_decorator;

public class Cappuccino extends Beverage {
	private final Beverage beverage;

	public Cappuccino(Beverage beverage) {
		this.beverage = beverage;
	}

	@Override
	public int cost() {
		return beverage.cost() + 7;
	}

}