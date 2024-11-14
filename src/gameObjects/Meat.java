package gameObjects;

import utils.Point2D;

public class Meat extends GameObject {
	private static final String NAME = "GoodMeat";
	private static final int LAYER = 0;
	private static final GameObjectType OBJECT_TYPE = GameObjectType.COLLECTIBLE;
	private static final int HEALTH_BUFF = 20;
	
	public Meat(Point2D startingPosition) {
		super(NAME, startingPosition, LAYER, OBJECT_TYPE);
	}
	
	public static void buffHealth(Character character) {
		character.updateHealth(HEALTH_BUFF);
	}
}
