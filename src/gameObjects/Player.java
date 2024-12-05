package gameObjects;

import utils.Point2D;

public class Player extends Character {
	private static final String NAME = "JumpMan";
	private static final int BASE_HEALTH = 1000;
	private static final int BASE_DAMAGE = 20;
	private static final boolean CAN_WIN = true;
	
	public Player(Point2D startingPosition) {
		super(NAME, startingPosition, BASE_DAMAGE, BASE_DAMAGE, CAN_WIN);
	}
}
