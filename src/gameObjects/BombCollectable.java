package gameObjects;

import utils.Point2D;

public class BombCollectable extends Collectable {
	private static final String NAME = "Green";
	
	public BombCollectable(Point2D startingPosition) {
		super(NAME, startingPosition);
	}
	
	@Override
	public void updateStatsImplementation(Character character) {
		// Se o DK tocar na bomba ela só desaparece
		if (character.getClass() == DonkeyKong.class) {
			return;
		}
		
		Player p = (Player) character;
		p.pickupBomb();
	}
}
