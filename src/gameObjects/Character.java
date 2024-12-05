package gameObjects;

import java.util.List;

import game.Room;
import pt.iscte.poo.gui.ImageGUI;
import utils.Direction;
import utils.Point2D;
import utils.Utils;

public class Character extends GameObject {
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
	
	
	public void move(Point2D newPosition, List<GameObject> room, int roomNum) {
		if (Utils.isOutsideBounds(newPosition)) return;
		
		for (GameObject o : room) {
			// Skip object if it is not located in the new position
			if (!Utils.arePositionsEqual(o.getPosition(), newPosition) || o == this) continue;
			
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
					door.finishRoom(roomNum);
				}
				
				else if (o.getClass() == Princess.class) {
					Princess princess = (Princess) o;
					princess.finishRoom(roomNum);
				}
			}
			
			// Check trap
			if (o.isTrap()) {
				// TODO: fix (temos de verificar se o tile de baixo é uma trap, não o tile onde estamos)
				Trap trap = (Trap) o;
				trap.activateTrap(this);
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
				
				return;
			}
			
			// Check crossable
			if (!o.isCrossable()) {
				return;
			}
		}
		
		// No object found -> we are moving into an empty tile, therefore we can move
		moveIntoCrossableTile(newPosition, room);
	}
	
		
	private void moveIntoCrossableTile(Point2D newPos, List<GameObject> room) {
		if (Utils.isMovementHorizontal(getPosition(), newPos)) {
			super.setPosition(newPos);
		}
		
		else if (Utils.isOnClimbableObject(newPos, room)
				&& Utils.isMovementUpwards(getPosition(), newPos)) {
			super.setPosition(newPos);
		}
	}
	
	public void fall() {
		System.out.println("falling");
		super.setPosition(new Point2D(getPosition().getX(), getPosition().getY() + 1));
	}
	
	public void updateHealth(int value) {
		int newValue = this.health + value;
		
		this.health = newValue <= 0 ? 0 : newValue;
		
		if (this.health <= 0) {
			Utils.deleteGameObject(this);
		}
	}
	
	public void updateDamage(int value) {
		int newValue = this.damage + value;
		this.damage = newValue >= 0 ? newValue : 0; 
	}
	
	@Override
	public boolean isWalkable() {
		return false;
	}
	
	@Override
	public boolean isCrossable() {
		return false;
	}
	
	@Override
	public boolean isClimbable() {
		return false;
	}
	
	@Override
	public boolean isAttackable() {
		return true;
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
	
	@Override
	public boolean isFallable() {
		return false;
	}
}