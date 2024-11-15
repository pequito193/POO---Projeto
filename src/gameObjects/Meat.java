package gameObjects;

import utils.Point2D;

public class Meat extends Collectible {
	private static final String NAME = "GoodMeat";
	private static final int LAYER = 0;
	private static final int HEALTH_BUFF = 20;
	
	public Meat(Point2D startingPosition) {
		super(NAME, startingPosition, LAYER);
	}
	
	@Override
	public void updateStats(Character character) {
		character.updateHealth(HEALTH_BUFF);
	}
}
