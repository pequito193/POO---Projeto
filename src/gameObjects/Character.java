package gameObjects;

import game.Room;
import utils.Direction;
import utils.Point2D;
import utils.Utils;

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
	
	
	public void move(Point2D newPosition, GameObject[][] room) {
		GameObject object = room[newPosition.getX()][newPosition.getY()];
		
		if (object == null) {
			if (Utils.isMovementHorizontal(getPosition(), newPosition)) {
				super.setPosition(newPosition);
			}
			
			// Para o caso em que estamos no topo da escada e o quadrante de cima está vazio
			else if (Utils.isOnClimbableObject(room, getPosition())
					&& Utils.isMovementUpwards(getPosition(), newPosition)) {
				super.setPosition(newPosition);
			}
			
			return;
		}
		
		switch (object.getObjectType()) {
			case COLLECTIBLE:
				// TODO:
				break;
			case TRAP:
				// TODO:
				break;
			case CLIMBABLE:
				super.setPosition(newPosition);
				break;
			case ENEMY:
				// TODO:
				break;
			case DOOR:
				// TODO:
				break;
			case PRINCESS:
				// TODO:
				break;
			case PROJECTILE:
				// TODO:
				break;
			default:
				break;	
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