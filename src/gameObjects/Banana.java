package gameObjects;

import game.Room;
import pt.iscte.poo.gui.ImageGUI;
import utils.Point2D;

public class Banana extends GameObject {
	private static final String NAME = "Hammer";  // TODO: add "Banana.png" image
	private static final int LAYER = 0;
	private int damage;
	
	public Banana(Point2D startingPosition, int damage) {
		super(NAME, startingPosition, LAYER);
		this.damage = damage;
	}
	
	public int getDamage() {
		return this.damage;
	}
	
	// Banana falls 1 tile
	public void fall() {
		if (getPosition().getY() > Room.MIN_POSITION) {
			int posX = getPosition().getX();
			int posY = getPosition().getY() - 1;
			setPosition(new Point2D(posX, posY));
		} else {
			removeBanana();
		}
	}
	
	public void removeBanana() {
		ImageGUI.getInstance().removeImage(this);
	}
	
	@Override
	public boolean isWalkable() {
		return false;
	}
	
	@Override
	public boolean isCrossable() {
		return true;
	}
	
	@Override
	public boolean isClimbable() {
		return false;
	}
	
	@Override
	public boolean isAttackable() {
		return false;
	}
	
	@Override
	public boolean isCollectable() {
		return false;
	}
	
	@Override
	public boolean isTrap() {
		return false;
	}
	
	@Override
	public boolean isObjective() {
		return false;
	}
}