package gameObjects;

import game.GameEngine;
import pt.iscte.poo.gui.ImageGUI;
import pt.iscte.poo.gui.ImageTile;
import utils.Point2D;

public abstract class GameObject implements ImageTile {
	private String name;
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
	
	public void setName(String newName) {
		this.name = newName;
	}
	
	public void setPosition(Point2D newPosition) {
		this.position = newPosition;
	}
	
	public void redrawObject() {
		ImageGUI.getInstance().removeImage(this);
		ImageGUI.getInstance().addImage(this);
	}
	
	public void deleteObject() {
		ImageGUI.getInstance().removeImage(this);
		GameEngine.getInstance().getCurrentRoom().removeGameObject(this);
	}
	
	// GameObject interactions
	public boolean isWalkable() {
		return false;
	}
	
	public boolean isCrossable() {
		return false;
	}
	
	public boolean isClimbable() {
		return false;
	}
	
	public boolean isAttackable() {
		return false;
	}
	
	public boolean isCollectable() {
		return false;
	}
	
	public boolean isTrap() {
		return false;
	}
	
	public boolean isObjective() {
		return false;
	}
	
	public boolean isFallable() {
		return false;
	}
	
	public boolean isEnemy() {
		return false;
	}
}