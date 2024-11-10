package objects;

import pt.iscte.poo.game.Room;

public class Banana {
	private int posX;
	private int posY;
	private int damage;
	
	public Banana(int startX, int startY, int bananaDamage) {
		this.posX = startX;
		this.posY = startY;
		this.damage = bananaDamage;
	}
	
	public int getX() {
		return this.posX;
	}
	
	public int getY() {
		return this.posY;
	}
	
	public int getDamage() {
		return this.damage;
	}
	
	/*** Banana will fall 1 tile ***/
	public void fall() {
		if (getY() > Room.MIN_POSITION) {
			this.posY--;
		} else {
			removeBanana();
		}
	}
	
	private void removeBanana() {
		// TODO: a banana tem de deixar de existir
	}
}