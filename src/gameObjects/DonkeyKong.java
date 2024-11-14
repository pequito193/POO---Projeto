package gameObjects;

import utils.Point2D;
import utils.Vector2D;

public class DonkeyKong extends Character {
	private static enum Actions {
		LEFT,
		RIGHT,
		THROW,
		STAND,
	};
	
	private static final String NAME = "DonkeyKong";
	private static final int LAYER = 0;
	private static final GameObjectType OBJECT_TYPE = GameObjectType.ENEMY;
	private static final int BASE_HEALTH = 100;
	private static final int BASE_DAMAGE = 20;
	private static final int BASE_BANANA_DAMAGE = 10;
	private int bananaDamage;
	
	public DonkeyKong(Point2D startingPosition){
		super(NAME, startingPosition, LAYER, OBJECT_TYPE, BASE_HEALTH, BASE_DAMAGE);
		this.bananaDamage = BASE_BANANA_DAMAGE;
	}
	
	public void increaseBananaDamage(int bonus) {
		this.bananaDamage += bonus;
	}
	
	// TODO
	/*
	public void doSomething() {
		Actions action = randomAction();
		
		switch (action) {
			case LEFT:
				super.move(new Vector2D(-1, 0));
				break;
			
			case RIGHT:
				super.move(new Vector2D(1, 0));
				break;
				
			case THROW:
				throwBanana();
				break;
				
			case STAND:
				// Do nothing
				break;
		}
	}
	*/
	
	private Actions randomAction() {
		int randomValue = (int) (Math.random() * 4);
		
		switch (randomValue) {
			case 0:
				return Actions.LEFT;
				
			case 1:
				return Actions.RIGHT;
				
			case 2:
				return Actions.THROW;
				
			default:
				return Actions.STAND;
		}
	}
	
	private void throwBanana() {
		Banana banana = new Banana(super.getPosition(), this.bananaDamage);
		banana.fall();
	}
}