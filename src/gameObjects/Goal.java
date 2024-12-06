package gameObjects;

import utils.Point2D;

public abstract class Goal extends GameObject {
	private static final int LAYER = 0;
	
	public Goal(String name, Point2D startingPosition) {
		super(name, startingPosition, LAYER);
	}
	
	public abstract void finishRoom(int roomNumber);
	
	@Override
	public boolean isCrossable() {
		return true;
	}
	
	@Override
	public boolean isObjective() {
		return true;
	}
}