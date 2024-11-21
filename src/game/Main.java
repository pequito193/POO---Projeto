package game;

import java.io.IOException;

import pt.iscte.poo.gui.ImageGUI;

public class Main {

	public static void main(String[] args) throws IOException {
		ImageGUI gui = ImageGUI.getInstance();
		GameEngine engine = GameEngine.getInstance();
		gui.setStatusMessage("Good luck!");
		gui.registerObserver(engine);
		gui.go();
	}
	
}
