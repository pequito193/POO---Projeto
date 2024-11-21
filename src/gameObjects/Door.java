package gameObjects;

import game.GameEngine;
import utils.Point2D;

public class Door extends Goal {
	private static final String NAME = "DoorClosed";
	
	public Door(Point2D startingPosition) {
		super(NAME, startingPosition);
	}
	
	@Override
	public void finishRoom(int roomNumber) {
		GameEngine.getInstance().setNewRoom(roomNumber + 1);
	}
}
