package gameObjects;

import java.util.ArrayList;
import java.util.List;

import game.GameEngine;
import pt.iscte.poo.gui.ImageGUI;
import utils.Point2D;

public class Player extends Character {
	private static final String NAME = "JumpMan";
	private static final int BASE_HEALTH = 100;
	private static final int BASE_DAMAGE = 20;
	private static final boolean CAN_WIN = true;
	private List<BombProjectile> bombs;
	private Point2D startingPosition;
	private int livesLeft;
	
	public Player(Point2D startingPosition) {
		super(NAME, startingPosition, BASE_HEALTH, BASE_DAMAGE, CAN_WIN);
		this.bombs = new ArrayList<BombProjectile>();
		this.startingPosition= startingPosition;
		this.livesLeft = 3;
	}
	
	private void loseLife() {
		if (this.livesLeft > 1) {
			this.livesLeft--;
			setPosition(this.startingPosition);
			updateHealth(BASE_HEALTH);
		}
		
		else {
			GameEngine.getInstance().resetGame();
		}
	}
	
	@Override
	public void deleteObject() {
		loseLife();
	}
	
	public void pickupBomb() {
		BombProjectile bomb = new BombProjectile(getPosition());
		
		this.bombs.add(bomb);
	}
	
	public void dropBomb() {
		if (this.bombs.isEmpty()) {
			return;
		}
		
		BombProjectile newBomb = bombs.getLast();
		
		newBomb.dropBomb(getPosition());
	}
	
	public void updateBombs() {
		if (this.bombs.isEmpty()) return;
		
		for (int i = 0; i < this.bombs.size(); i++) {
			BombProjectile bomb = this.bombs.get(i);
			
			bomb.updateState();
			
			if (bomb.getHasBeenUsed()) {
				this.bombs.removeLast();
				i--;
			}
		}
	}
}
