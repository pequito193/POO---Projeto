package gameObjects;

import java.util.List;

import game.GameEngine;
import utils.Point2D;

public class Bat extends Character {
	private static enum Actions {
		LEFT,
		RIGHT,
		DOWN,
	};
	
	private static final String NAME = "Bat";
	private static final int BASE_HEALTH = 1;
	private static final int BASE_DAMAGE = 10;
	private static final boolean CAN_WIN = false;
	
	public Bat(Point2D startingPosition){
		super(NAME, startingPosition, BASE_HEALTH, BASE_DAMAGE, CAN_WIN);
	}
	
	public void doSomething() {
		Actions action = canGoDown() ? Actions.DOWN : randomAction();
		
		switch (action) {
			case LEFT:
				super.move(new Point2D(super.getPosition().getX() - 1, super.getPosition().getY()));
				break;
			
			case RIGHT:
				super.move(new Point2D(super.getPosition().getX() + 1, super.getPosition().getY()));
				break;
				
			case DOWN:
				super.move(new Point2D(super.getPosition().getX(), super.getPosition().getY() + 1));
				break;
		}
	}
	
	private boolean canGoDown() {
		List<GameObject> room = GameEngine.getInstance().getCurrentRoom().getRoom();
		Point2D belowBatPosition = new Point2D(getPosition().getX(), getPosition().getY() + 1);
		
		for (GameObject o : room) {
			if (!o.getPosition().equals(belowBatPosition)) {
				continue;
			}
			
			if (!o.isCrossable()) {
				return false;
			}
		}
		
		return true;
	}
	
	private Actions randomAction() {
		int randomValue = (int) (Math.random() * 3);
		
		switch (randomValue) {
			case 0:
				return Actions.LEFT;
				
			case 1:
				return Actions.RIGHT;
				
			default:
				return Actions.DOWN;
		}
	}
	
	@Override
	public boolean isEnemy() {
		return true;
	}
}