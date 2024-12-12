package gameObjects;

import utils.Point2D;

public class Fire extends GameObject {
	private static final String NAME = "Fire_old";
	private static final int LAYER = 3;
	
	public Fire(Point2D startPosition) {
		super(NAME, startPosition, LAYER);
	}
}