package gameObjects;

import utils.Point2D;

public class Princess extends GameObject {
	private static final String NAME = "Princess";
	private static final int LAYER = 0;
	private static final GameObjectType OBJECT_TYPE = GameObjectType.PRINCESS;
	
	public Princess(Point2D startingPosition) {
		super(NAME, startingPosition, LAYER, OBJECT_TYPE);
	}
}
