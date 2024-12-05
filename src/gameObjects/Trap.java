package gameObjects;

import utils.Point2D;

public class Trap extends GameObject {
	private static final String NAME = "Trap";
	private static final int LAYER = 0;
	private static final int DAMAGE = 10;

	public Trap(Point2D startingPosition) {
		super(NAME, startingPosition, LAYER);
	}
	
	public void activateTrap(Character character) {
		character.updateHealth(DAMAGE);
	}
	
	@Override
	public boolean isWalkable() {
		return false;
	}
	
	@Override
	public boolean isCrossable() {
		return true;
	}
	
	@Override
	public boolean isClimbable() {
		return false;
	}
	
	@Override
	public boolean isAttackable() {
		return false;
	}
	
	@Override
	public boolean isCollectable() {
		return false;
	}
	
	@Override
	public boolean isTrap() {
		return true;
	}
	
	@Override
	public boolean isObjective() {
		return false;
	}
	
	@Override
	public boolean isFallable() {
		return true;
	}
}


