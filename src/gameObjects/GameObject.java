package gameObjects;

import pt.iscte.poo.gui.ImageTile;
import utils.Point2D;

public abstract class GameObject implements ImageTile {
	private final String name;
	private Point2D position;
	private final int layer;
	
	public GameObject(String name, Point2D startingPosition, int layer) {
		this.name = name;
		this.position = startingPosition;
		this.layer = layer;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Point2D getPosition() {
		return this.position;
	}
	
	public int getLayer() {
		return this.layer;
	}
	
	
	public void setPosition(Point2D newPosition) {
		this.position = newPosition;
	}
	
	// GameObject interactions
	public abstract boolean isWalkable();
	public abstract boolean isCrossable();
	public abstract boolean isClimbable();
	public abstract boolean isAttackable();
	public abstract boolean isCollectable();
	public abstract boolean isTrap();
	public abstract boolean isObjective();
	public abstract boolean isFallable();
}