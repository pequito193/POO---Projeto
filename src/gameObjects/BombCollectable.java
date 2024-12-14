package gameObjects;

import utils.Point2D;

public class BombCollectable extends Collectable {
	private static final String NAME = "Bomb";
	
	public BombCollectable(Point2D startingPosition) {
		super(NAME, startingPosition);
	}
	
	@Override
	public void updateStatsImplementation(Character character) {
		// Se um inimigo tocar na bomba ela só desaparece
		if (character.getClass() != Player.class) {
			return;
		}
		
		Player p = (Player) character;
		p.pickupBomb();
	}
}
