package gameObjects;

import utils.Point2D;

public abstract class Goal extends GameObject {
	private static final int LAYER = 0;
	
	public Goal(String name, Point2D startingPosition) {
		super(name, startingPosition, LAYER);
	}
	
	public abstract void finishRoom(int roomNumber);
	
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
		return false;
	}
	
	@Override
	public boolean isObjective() {
		return true;
	}
	
	@Override
	public boolean isFallable() {
		return false;
	}
}