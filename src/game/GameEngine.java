package game;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import gameObjects.GameObject;
import pt.iscte.poo.gui.ImageGUI;
import pt.iscte.poo.observer.Observed;
import pt.iscte.poo.observer.Observer;
import utils.Direction;

public class GameEngine implements Observer {
	private static GameEngine INSTANCE;
	
	private List<Room> roomList;
	private Room currentRoom;
	private int lastTickProcessed = 0;
	private long startTime;
	
	private GameEngine() {
		ImageGUI.getInstance().update();
		this.roomList = new ArrayList<Room>();
		
		resetGame();
	}
	
	public int getRunDurationInSeconds() {
		long currentTime = System.currentTimeMillis();
		
		return (int) ((currentTime - this.startTime) / 1000);
	}
	
	public void resetGame() {
		ImageGUI.getInstance().clearImages();
		this.roomList.clear();
		this.startTime = System.currentTimeMillis();
		
		Room room0 = new Room(new File("././rooms/room0.txt"), 0);
		Room room1 = new Room(new File("././rooms/room1.txt"), 1);
		Room room2 = new Room(new File("././rooms/room2.txt"), 2);
		
		this.roomList.add(room0);
		this.roomList.add(room1);
		this.roomList.add(room2);
		
		this.currentRoom = this.roomList.get(0);
		this.currentRoom.drawRoom();
	}
	
	public void setNewRoom(int roomNumber) {
		for (Room room : roomList) {
			if (room.getRoomNumber() == roomNumber) {
				ImageGUI.getInstance().clearImages();
				this.currentRoom = room;
				this.currentRoom.drawRoom();
			}
		}
	}
	
	public static GameEngine getInstance() {
        if (INSTANCE == null)
            INSTANCE = new GameEngine();
        return INSTANCE;
    }
	
	public Room getCurrentRoom() {
		return this.currentRoom;
	}

	@Override
	public void update(Observed source) {
		
		if (ImageGUI.getInstance().wasKeyPressed()) {
			int k = ImageGUI.getInstance().keyPressed();
			//System.out.println("Keypressed " + k);
			if (Direction.isDirection(k)) {
				//System.out.println("Direction! ");
				currentRoom.move(Direction.directionFor(k));
			}
			
			else if (k == KeyEvent.VK_B) {
				this.currentRoom.dropBomb();
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
		currentRoom.updateObjects();
		lastTickProcessed++;
	}



}
