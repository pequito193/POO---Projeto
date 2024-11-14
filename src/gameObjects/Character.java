package gameObjects;

import game.Room;
import utils.Direction;
import utils.Point2D;

public class Character extends GameObject {
	private int health;
	private int damage;
	
	public Character(String name, Point2D startingPosition, int layer, GameObjectType objectType, int health, int damage) {
		super(name, startingPosition, layer, objectType);
		
		this.health = health;
		this.damage = damage;
	}
	
	public int getHealth() {
		return this.health;
	}
	
	public int getDamage() {
		return this.damage;
	}
	
	public void move(Direction direction, GameObject[][] room) {
		Point2D newPosition = super.getPosition().plus(direction.asVector());
	    if (newPosition.getX() >= Room.MIN_POSITION  && newPosition.getX() <= Room.MAX_POSITION &&
	        newPosition.getY() >= Room.MIN_POSITION && newPosition.getY() <= Room.MAX_POSITION) {
	    	// TODO: melhorar esta logica
	    	if (room[newPosition.getX()][newPosition.getY()].getObjectType() != GameObjectType.INTRESPASSABLE) {
	    		super.setPosition(super.getPosition().plus(direction.asVector()));
	    	}
	    }
	}
	
	public void updateHealth(int value) {
		int newValue = this.health + value;
		this.health = newValue >= 0 ? newValue : 0; 
	}
	
	public void updateDamage(int value) {
		int newValue = this.damage + value;
		this.damage = newValue >= 0 ? newValue : 0; 
	}
}