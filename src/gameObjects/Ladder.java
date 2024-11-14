package gameObjects;

import utils.Point2D;

public class Ladder extends GameObject {
	private static final String NAME = "Ladder";
	private static final int LAYER = 0;
	private static final GameObjectType OBJECT_TYPE = GameObjectType.CLIMBABLE;
	
	public Ladder(Point2D startingPosition) {
		super(NAME, startingPosition, LAYER, OBJECT_TYPE);
	}
}
