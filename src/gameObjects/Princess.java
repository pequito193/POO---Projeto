package gameObjects;

import java.util.List;

import game.GameEngine;
import game.Scoreboard;
import pt.iscte.poo.gui.ImageGUI;
import utils.Point2D;

public class Princess extends Goal {
	private static final String NAME = "Princess";
	
	public Princess(Point2D startingPosition) {
		super(NAME, startingPosition);
	}
	
	@Override
	public void finishRoom(int roomNumber) {
		int time = GameEngine.getInstance().getRunDurationInSeconds();
		Scoreboard.saveScore(time);
		
		List<String> highscores = Scoreboard.getHighscores();
		String highscoreString = "";
		
		for (int i = 0; i < highscores.size(); i++) {
			String h = highscores.get(i);
			
			highscoreString += i + 1 + ": ";
			highscoreString += h;
			highscoreString += "\n";
		}
		
		ImageGUI.getInstance().showMessage("SCOREBOARD", highscoreString);
		
		GameEngine.getInstance().resetGame();
	}
}
