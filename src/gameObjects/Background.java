package gameObjects;

import utils.Point2D;

public class Background extends GameObject {
	private static final String NAME = "Background";
	private static final int LAYER = 0;
	private static final GameObjectType OBJECT_TYPE = GameObjectType.STATIC;
	
	public Background(Point2D startingPosition) {
		super(NAME, startingPosition, LAYER, OBJECT_TYPE);
	}
}
