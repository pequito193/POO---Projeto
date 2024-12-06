package gameObjects;

import utils.Point2D;

public class Sword extends Collectable {
	private static final String NAME = "Sword";
	private static final int DAMAGE_BUFF = 20;
	
	public Sword(Point2D startingPosition) {
		super(NAME, startingPosition);
	}
	
	@Override
	public void updateStatsImplementation(Character character) {
		character.updateDamage(DAMAGE_BUFF);
	}
}
