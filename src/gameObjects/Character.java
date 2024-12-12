package gameObjects;

import java.util.List;

import game.GameEngine;
import game.Room;
import utils.Point2D;
import utils.Utils;

public abstract class Character extends GameObject {
	private int health;
	private int damage;
	private static final int LAYER = 2;
	private boolean canWin;
	
	public Character(String name, Point2D startingPosition, int health, int damage, boolean canWin) {
		super(name, startingPosition, LAYER);
		this.canWin = canWin;
		this.health = health;
		this.damage = damage;
	}
	
	public int getHealth() {
		return this.health;
	}
	
	public int getDamage() {
		return this.damage;
	}
	
	public void move(Point2D newPosition) {
		if (Utils.isOutsideBounds(newPosition)) return;
		
		Room currentRoom = GameEngine.getInstance().getCurrentRoom();
		
		List<GameObject> room = currentRoom.getRoom();
		int roomNumber = currentRoom.getRoomNumber();
		
		for (GameObject o : room) {
			// Skip object if it is not located in the new position
			if (!o.getPosition().equals(newPosition) || o == this) continue;
			
			// Check climbable
			if (o.isClimbable()) {
				super.setPosition(newPosition);
			}
			
			// Check attackable
			if (o.isAttackable()) {
				Character character = (Character) o;
				character.updateHealth(- this.damage);
			}
			
			// Check objective
			if (o.isObjective() && canWin) {
				if (o.getClass() == Door.class) {
					Door door = (Door) o;
					door.finishRoom(roomNumber);
				}
				
				else if (o.getClass() == Princess.class) {
					Princess princess = (Princess) o;
					princess.finishRoom(roomNumber);
				}
				
				return;
			}
			
			// Check collectable
			if (o.isCollectable()) {
				if (o.getClass() == Meat.class) {
					Meat meat = (Meat) o;
					meat.updateStats(this);
				}
				
				else if (o.getClass() == Sword.class) {
					Sword sword = (Sword) o;
					sword.updateStats(this);
				}
				
				else if (o.getClass() == BombCollectable.class) {
					BombCollectable bomb = (BombCollectable) o;
					bomb.updateStats(this);
				}
				
				return;
			}
			
			// Check crossable
			if (!o.isCrossable()) {
				return;
			}
		}
		
		// No object found -> we are moving into an empty tile, therefore we can move
		moveIntoCrossableTile(newPosition);
	}
		
	private void moveIntoCrossableTile(Point2D newPos) {
		List<GameObject> room = GameEngine.getInstance().getCurrentRoom().getRoom();
		
		if (Utils.isMovementHorizontal(getPosition(), newPos)) {
			super.setPosition(newPos);
		}
		
		else if (Utils.isOnClimbableObject(newPos, room)
				&& Utils.isMovementUpwards(getPosition(), newPos)) {
			super.setPosition(newPos);
		}
	}
	
	public void fall() {
		Point2D newPosition = new Point2D(getPosition().getX(), getPosition().getY() + 1);
		setPosition(newPosition);
	}
	
	public void updateHealth(int value) {
		int newValue = this.health + value;
		
		this.health = newValue <= 0 ? 0 : newValue;
		
		if (this.health <= 0) {
			deleteObject();
		}
	}
	
	public void updateDamage(int value) {
		int newValue = this.damage + value;
		this.damage = newValue >= 0 ? newValue : 0; 
	}
	
	@Override
	public boolean isWalkable() {
		return true;
	}

	@Override
	public boolean isAttackable() {
		return true;
	}
}