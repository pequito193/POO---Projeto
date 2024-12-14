package gameObjects;

import java.util.List;

import game.GameEngine;
import game.Room;
import pt.iscte.poo.gui.ImageGUI;
import utils.Point2D;

public class Banana extends GameObject {
	private static final String NAME = "Banana";
	private static final int LAYER = 2;
	private int damage;
	
	public Banana(Point2D startingPosition, int damage) {
		super(NAME, startingPosition, LAYER);
		this.damage = damage;
	}
	
	public int getDamage() {
		return this.damage;
	}
	
	public void drawBanana() {
		ImageGUI.getInstance().addImage(this);
	}
	
	public void deleteBanana() {
		ImageGUI.getInstance().removeImage(this);
	}
	
	public void fall() {
		if (getPosition().getY() < Room.MAX_POSITION) {
			Point2D newPosition = new Point2D(getPosition().getX(), getPosition().getY() + 1);
			setPosition(newPosition);
			checkForPlayer();
		}
	}
	
	private void checkForPlayer() {
		Room currentRoom = GameEngine.getInstance().getCurrentRoom();
		List<GameObject> room = currentRoom.getRoom();
		
		for (GameObject obj : room) {
			if (obj.isAttackable() && obj.getPosition().equals(getPosition())) {
				Character c = (Character) obj;
				c.updateHealth(- this.damage);
			}
		}
	}
	
	@Override
	public boolean isCrossable() {
		return true;
	}
	
	@Override
	public boolean isFallable() {
		return true;
	}
}