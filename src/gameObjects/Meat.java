package gameObjects;

import utils.Point2D;

public class Meat extends Collectable {
	private static final String NAME = "GoodMeat";
	private static final int HEALTH_BUFF = 20;
	
	public Meat(Point2D startingPosition) {
		super(NAME, startingPosition);
	}
	
	@Override
	public void updateStatsImplementation(Character character) {
		character.updateHealth(HEALTH_BUFF);
	}
}
