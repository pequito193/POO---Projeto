package characters;

import pt.iscte.poo.game.Room;
import pt.iscte.poo.utils.Point2D;
import objects.Manel;

public class Character extends Manel {
	private int posX;
	private int posY;
	private int health;
	private int damage;
	
	public Character(int posX, int posY, int health, int damage) {
		super(new Point2D(posX, posY));
		
		this.posX = posX;
		this.posY = posY;
		this.health = health;
		this.damage = damage;
	}
	
	public int getX() {
		return this.posX;
	}
	
	public int getY() {
		return this.posY;
	}
	
	public int getHealth() {
		return this.health;
	}
	
	public int getDamage() {
		return this.damage;
	}
	
	public void moveRight() {
		if (getX() < Room.MAX_POSITION) {
			this.posX++;
		}
	}
	
	public void moveLeft() {
		if (getX() > Room.MIN_POSITION) {
			this.posX--;
		}
	}
	
	public void moveUp() {
		if (getY() < Room.MAX_POSITION) {
			this.posY++;
		}
	}
	
	public void moveDown() {
		if (getY() > Room.MIN_POSITION) {
			this.posY++;
		}
	}
	
	public void updateHealth(int variance) {
		int newValue = this.health + variance;
		this.health = newValue >= 0 ? newValue : 0; 
	}
	
	public void updateDamage(int variance) {
		int newValue = this.damage + variance;
		this.damage = newValue >= 0 ? newValue : 0; 
	}
}