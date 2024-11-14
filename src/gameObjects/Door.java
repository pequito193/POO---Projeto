package gameObjects;

import game.Room.RoomNumber;
import utils.Point2D;

public class Door extends GameObject {
	private static final String NAME = "DoorClosed";
	private static final int LAYER = 0;
	private static final GameObjectType OBJECT_TYPE = GameObjectType.DOOR;
	
	public Door(Point2D startingPosition) {
		super(NAME, startingPosition, LAYER, OBJECT_TYPE);
	}
	
	public void goThrough(RoomNumber roomNumber) {
		// TODO: go to next room
	}
}
