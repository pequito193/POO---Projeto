package characters;

import objects.Banana;

public class DonkeyKong extends Character {
	private enum Actions {
		LEFT,
		RIGHT,
		THROW,
		STAND,
	};
	
	// Difere do damage da classe Character, o qual se refere a dano de toque
	// O DonkeyKong fica mais forte em cada nivel
	private int bananaDamage;
	
	public DonkeyKong(int posX, int posY, int health, int damage, int bananaDamage) {
		super(posX, posY, health, damage);
		
		this.bananaDamage = bananaDamage;
	}
	
	public void moveRandomly() {
		Actions action = randomAction();
		
		switch (action) {
			case LEFT:
				super.moveLeft();
				break;
			
			case RIGHT:
				super.moveRight();
				break;
				
			case THROW:
				throwBanana();
				break;
				
			case STAND:
				// Do nothing
				break;
		}
	}
	
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
		Banana banana = new Banana(super.getX(), super.getY(), this.bananaDamage);
		banana.fall();
	}
}