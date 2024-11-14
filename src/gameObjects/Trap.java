package gameObjects;

import utils.Point2D;

public class Trap extends GameObject {
	private static final String NAME = "Trap";
	private static final int LAYER = 0;
	private static final GameObjectType OBJECT_TYPE = GameObjectType.TRAP;

	public Trap(Point2D startingPosition) {
		super(NAME, startingPosition, LAYER, OBJECT_TYPE);
	}
}


