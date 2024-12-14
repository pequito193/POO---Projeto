package gameObjects;

import utils.Point2D;

public abstract class Trap extends GameObject {
	private static final int LAYER = 0;
	protected static final int DAMAGE = 20;

	public Trap(String name, Point2D startingPosition) {
		super(name, startingPosition, LAYER);
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


