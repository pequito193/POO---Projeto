package gameObjects;

import pt.iscte.poo.gui.ImageGUI;
import utils.Point2D;
import utils.Utils;

public abstract class Collectable extends GameObject {
	public Collectable(String name, Point2D startingPosition, int layer) {
		super(name, startingPosition, layer);
	}
	
	public void updateStats(Character character) {
		updateStatsImplementation(character);
		
		Utils.deleteGameObject(this);
	}
	
	protected abstract void updateStatsImplementation(Character character);
	
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
		return true;
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
