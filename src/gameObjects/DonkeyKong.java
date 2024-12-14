package gameObjects;

import java.util.ArrayList;
import java.util.List;

import game.GameEngine;
import game.Room;
import pt.iscte.poo.gui.ImageGUI;
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
	private static final int BASE_HEALTH = 100;
	private static final int BASE_DAMAGE = 20;
	private static final int BASE_BANANA_DAMAGE = 10;
	private static final boolean CAN_WIN = false;
	private List<Banana> activeBananas;
	private int bananaDamage;
	
	public DonkeyKong(Point2D startingPosition){
		super(NAME, startingPosition, BASE_HEALTH, BASE_DAMAGE, CAN_WIN);
		this.activeBananas = new ArrayList<>();
		this.bananaDamage = BASE_BANANA_DAMAGE;
	}
	
	public void doSomething() {
		Actions action = randomAction();
		
		switch (action) {
			case LEFT:
				super.move(new Point2D(super.getPosition().getX() - 1, super.getPosition().getY()));
				break;
			
			case RIGHT:
				super.move(new Point2D(super.getPosition().getX() + 1, super.getPosition().getY()));
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
		Banana banana = new Banana(super.getPosition(), this.bananaDamage);
		this.activeBananas.add(banana);
		banana.drawBanana();
	}
	
	public void updateBananas() {
		for (Banana b : this.activeBananas) {
			b.fall();
			
			if (b.getPosition().getY() >= Room.MAX_POSITION) {
				b.deleteBanana();
			}
		}
	}
	
	@Override
	public void deleteObject() {
		for (Banana b : this.activeBananas) {
			b.deleteBanana();
		}
		
		ImageGUI.getInstance().removeImage(this);
		GameEngine.getInstance().getCurrentRoom().removeGameObject(this);
	}
	
	@Override
	public boolean isEnemy() {
		return true;
	}
}