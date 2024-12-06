package gameObjects;

import utils.Point2D;

public class Background extends GameObject {
	private static final String NAME = "Background";
	private static final int LAYER = 0;
	
	public Background(Point2D startingPosition) {
		super(NAME, startingPosition, LAYER);
	}
	
	@Override
	public boolean isCrossable() {
		return true;
	}
	
	@Override
	public boolean isFallable() {
		return true;
	}
}
