package gameObjects;

import pt.iscte.poo.gui.ImageGUI;
import utils.Point2D;
import utils.Utils;

public abstract class Collectable extends GameObject {
	private static final int LAYER = 2;
	
	public Collectable(String name, Point2D startingPosition) {
		super(name, startingPosition, LAYER);
	}
	
	public void updateStats(Character character) {
		updateStatsImplementation(character);
		
		deleteObject();
	}
	
	protected abstract void updateStatsImplementation(Character character);
	
	@Override
	public boolean isCrossable() {
		return true;
	}
	
	@Override
	public boolean isCollectable() {
		return true;
	}
	
	@Override
	public boolean isFallable() {
		return true;
	}
}
