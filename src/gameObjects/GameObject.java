package gameObjects;

import pt.iscte.poo.gui.ImageTile;
import utils.Point2D;

public class GameObject implements ImageTile {
	public static enum GameObjectType {
		/*** Map elements ***/
		INTRESPASSABLE,   // solid blocks
		CLIMBABLE,        // ladders
		COLLECTIBLE,      // powerups
		STATIC,           // no gameplay effect
		TRAP,
		PROJECTILE,
		DOOR,
		
		/*** NPCs ***/
		PLAYER,
		ENEMY,
		PRINCESS,
	}
	
	private final String name;
	private Point2D position;
	private final int layer;
	private final GameObjectType objectType;
	
	public GameObject(String name, Point2D startingPosition, int layer, GameObjectType type) {
		this.name = name;
		this.position = startingPosition;
		this.layer = layer;
		this.objectType = type;
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
	
	public GameObjectType getObjectType() {
		return this.objectType;
	}
	
	public void setPosition(Point2D newPosition) {
		this.position = newPosition;
	}
}