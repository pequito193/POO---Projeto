package gameObjects;

import utils.Point2D;

public class Trap extends GameObject {
	private static final String NAME = "Trap";
	private static final int LAYER = 0;
	private static final int DAMAGE = 20;

	public Trap(Point2D startingPosition) {
		super(NAME, startingPosition, LAYER);
	}
	
	public void activateTrap(Character c) {
		c.updateHealth(- DAMAGE);
	}
	
	@Override
	public boolean isTrap() {
		return true;
	}
	
	@Override
	public boolean isFallable() {
		return true;
	}
}


