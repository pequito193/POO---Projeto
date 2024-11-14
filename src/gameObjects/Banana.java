package gameObjects;

import utils.Point2D;

public class Banana extends GameObject {
	private static final String NAME = "Hammer";  // TODO: add "Banana.png" image
	private static final int LAYER = 0;
	private static final GameObjectType OBJECT_TYPE = GameObjectType.PROJECTILE;
	private int damage;
	
	public Banana(Point2D startingPosition, int damage) {
		super(NAME, startingPosition, LAYER, OBJECT_TYPE);
		this.damage = damage;
	}
	
	public int getDamage() {
		return this.damage;
	}
	
	/*** Banana will fall 1 tile ***/
	public void fall() {/*
		if (getY() > Room.MIN_POSITION) {
			this.posY--;
		} else {
			removeBanana();
		}*/
	}
	
	private void removeBanana() {
		// TODO: a banana tem de deixar de existir
	}
}