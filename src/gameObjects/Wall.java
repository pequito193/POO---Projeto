package gameObjects;

import utils.Point2D;

public class Wall extends GameObject {
	private static final String NAME = "Wall";
	private static final int LAYER = 1;
	private static final GameObjectType OBJECT_TYPE = GameObjectType.STATIC;
	
	public Wall(Point2D startingPosition) {
		super(NAME, startingPosition, LAYER, OBJECT_TYPE);
	}
}
