package gameObjects;

import game.GameEngine;
import pt.iscte.poo.gui.ImageGUI;
import utils.Point2D;

public class Player extends Character {
	private static final String NAME = "JumpMan";
	private static final int BASE_HEALTH = 100;
	private static final int BASE_DAMAGE = 20;
	private static final boolean CAN_WIN = true;
	
	public Player(Point2D startingPosition) {
		super(NAME, startingPosition, BASE_HEALTH, BASE_DAMAGE, CAN_WIN);
	}
	
	@Override
	public void deleteObject() {
		ImageGUI.getInstance().clearImages();
		GameEngine.getInstance().resetGame();
	}
}
