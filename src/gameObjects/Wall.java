package gameObjects;

import utils.Point2D;

public class Wall extends GameObject {
	private static final String NAME = "Wall";
	private static final int LAYER = 1;
	
	public Wall(Point2D startingPosition) {
		super(NAME, startingPosition, LAYER);
	}
	
	@Override
	public boolean isWalkable() {
		return true;
	}
	
	@Override
	public boolean isCrossable() {
		return false;
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
		return false;
	}
	
	@Override
	public boolean isObjective() {
		return false;
	}

	@Override
	public boolean isFallable() {
		return false;
	}
}
