package game;

import java.io.IOException;

import pt.iscte.poo.gui.ImageGUI;
import pt.iscte.poo.observer.Observed;
import pt.iscte.poo.observer.Observer;
import utils.Direction;

public class GameEngine implements Observer {
	
	private Room currentRoom;
	private int lastTickProcessed = 0;
	
	public GameEngine() throws IOException {
		ImageGUI.getInstance().update();
		currentRoom= new Room("././rooms/room0.txt");
	}

	@Override
	public void update(Observed source) {
		
		if (ImageGUI.getInstance().wasKeyPressed()) {
			int k = ImageGUI.getInstance().keyPressed();
			//System.out.println("Keypressed " + k);
			if (Direction.isDirection(k)) {
				//System.out.println("Direction! ");
				currentRoom.move(Direction.directionFor(k), currentRoom.getRoomLayout());
			}
		}
		int t = ImageGUI.getInstance().getTicks();
		while (lastTickProcessed < t) {
			processTick();
		}
		ImageGUI.getInstance().update();
	}

	private void processTick() {
		//System.out.println("Tic Tac : " + lastTickProcessed);
		lastTickProcessed++;
	}



}
