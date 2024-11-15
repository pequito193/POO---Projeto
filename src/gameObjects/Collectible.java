package gameObjects;

import utils.Point2D;

public abstract class Collectible extends GameObject {
	private static final GameObjectType OBJECT_TYPE = GameObjectType.COLLECTIBLE;
	
	public Collectible(String name, Point2D startingPosition, int layer) {
		super(name, startingPosition, layer, OBJECT_TYPE);
	}
	
	public abstract void updateStats(Character character);
}
