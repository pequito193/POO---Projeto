package gameObjects;

import utils.Point2D;

public class Sword extends Collectible {
	private static final String NAME = "Sword";
	private static final int LAYER = 0;
	private static final int DAMAGE_BUFF = 10;
	
	public Sword(Point2D startingPosition) {
		super(NAME, startingPosition, LAYER);
	}
	
	@Override
	public void updateStats(Character character) {
		character.updateDamage(DAMAGE_BUFF);
	}
}
