package gameObjects;

import utils.Point2D;

public class Player extends Character {
	private static final String NAME = "JumpMan";
	private static final int LAYER = 0;
	private static final int BASE_HEALTH = 100;
	private static final int BASE_DAMAGE = 20;
	
	public Player(Point2D startingPosition) {
		super(NAME, startingPosition, LAYER, BASE_DAMAGE, BASE_DAMAGE);
	}
}
