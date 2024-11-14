package gameObjects;

import utils.Point2D;

public class Sword extends GameObject {
	private static final String NAME = "Sword";
	private static final int LAYER = 0;
	private static final GameObjectType OBJECT_TYPE = GameObjectType.COLLECTIBLE;
	private static final int DAMAGE_BUFF = 10;
	
	public Sword(Point2D startingPosition) {
		super(NAME, startingPosition, LAYER, OBJECT_TYPE);
	}
	
	public static void buffDamage(Character character) {
		character.updateDamage(DAMAGE_BUFF);
	}
}
