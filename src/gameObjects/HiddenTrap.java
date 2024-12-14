package gameObjects;

import utils.Point2D;

public class HiddenTrap extends Trap {
	private static final String NAME_HIDDEN = "Wall";
	private static final String NAME_NOT_HIDDEN = "Trap";

	public HiddenTrap(Point2D startingPosition) {
		super(NAME_HIDDEN, startingPosition);
	}
	
	@Override
	public void activateTrap(Character c) {
		c.updateHealth(- DAMAGE);
		
		setName(NAME_NOT_HIDDEN);
		redrawObject();
	}
}


