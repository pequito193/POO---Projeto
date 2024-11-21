package gameObjects;

import utils.Point2D;

public class Princess extends Goal {
	private static final String NAME = "Princess";
	
	public Princess(Point2D startingPosition) {
		super(NAME, startingPosition);
	}
	
	@Override
	public void finishRoom(int roomNumber) {
		// TODO
	}
}
