package game;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import gameObjects.Background;
import gameObjects.Bat;
import gameObjects.BombCollectable;
import gameObjects.DonkeyKong;
import gameObjects.Door;
import gameObjects.GameObject;
import gameObjects.HiddenTrap;
import gameObjects.Ladder;
import gameObjects.Meat;
import gameObjects.NormalTrap;
import gameObjects.Player;
import gameObjects.Princess;
import gameObjects.Sword;
import gameObjects.Trap;
import gameObjects.Wall;
import pt.iscte.poo.gui.ImageGUI;
import utils.Direction;
import utils.Point2D;

public class Room {
	public static final int MIN_POSITION = 0;
	public static final int MAX_POSITION = 9;
	public static final int ROOM_SIZE = 10;
	
	private List<GameObject> room;
	private Player player;
	private int roomNumber;
	
	public Room(File file, int roomNumber) {
		this.room = new ArrayList<GameObject>();
		this.roomNumber = roomNumber;
		
		readRoomFile(file);
	}
	
	public int getRoomNumber() {
		return this.roomNumber;
	}
	
	private void readRoomFile(File file) {
		try {
			Scanner scanner = new Scanner(file);
			
			String firstLine = scanner.nextLine();
			
			int i = 0;
			while (scanner.hasNextLine()) {
				readLine(scanner.nextLine(), i);
				i++;
			}
			
			scanner.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void readLine(String line, int col) {
		Point2D position;
		for (int row = 0; row < line.length(); row++) {
			position = new Point2D(row, col);
			
			switch (line.charAt(row)) {
				case 'W':
					this.room.add(new Wall(position));
					break;
				case 't':
					this.room.add(new NormalTrap(position));
					break;
				case 'T':
					this.room.add(new HiddenTrap(position));
					break;
				case 'S':
					this.room.add(new Ladder(position));
					break;
				case 'P':
					this.room.add(new Princess(position));
					break;
				case 'G':
					this.room.add(new DonkeyKong(position));
					break;
				case 'B':
					this.room.add(new Bat(position));
					break;
				case 'H':
					this.player = new Player(position);
					this.room.add(this.player);
					break;
				case 's':
					this.room.add(new Sword(position));
					break;
				case 'm':
					this.room.add(new Meat(position));
					break;
				case 'b':
					this.room.add(new BombCollectable(position));
					break;
				case '0':
					this.room.add(new Door(position));
					break;
				default:
					break;
			}
		}
	}
	
	public List<GameObject> getRoom() {
		return this.room;
	}
	
	public void move(Direction direction) {
		Point2D newPosition = this.player.getPosition().plus(direction.asVector());
	    if (newPosition.getX() >= MIN_POSITION  && newPosition.getX() <= MAX_POSITION &&
	        newPosition.getY() >= MIN_POSITION && newPosition.getY() <= MAX_POSITION) {

            this.player.move(newPosition);
	    }
	}
	
	public void drawRoom() {
		fillBackground();
		
		for (GameObject o : room) {
			ImageGUI.getInstance().addImage(o);
		}
	}
	
	public void addGameObject(GameObject obj) {
		this.room.add(obj);
	}
	
	public void removeGameObject(GameObject obj) {
		this.room.remove(obj);
	}
	
	private void fillBackground() {
		for (int i = 0; i < Room.ROOM_SIZE; i++) {
			for (int j = 0; j < Room.ROOM_SIZE; j++) {
				ImageGUI.getInstance().addImage(new Background(new Point2D(i, j)));
			}
		}
	}
	
	public void updateObjects() {
		checkFall();
		moveDK();
		updateBombs();
		spoilMeat();
		moveBats();
	}
	
	private void checkFall() {
		Point2D belowPosition = new Point2D(this.player.getPosition().getX(), this.player.getPosition().getY() + 1);
		
        for (GameObject obj : room) {
            if (obj.getPosition().equals(belowPosition)) {
            	if (obj.isFallable()) {
            		this.player.fall();
            		
            		if (obj.isTrap()) {
            			Trap trap = (Trap) obj;
            			trap.activateTrap(this.player);
            		}
            		
            	}
            	
        		return;
        	}
        }
        
        this.player.fall();
	}
	
	private void moveDK() {
		for (GameObject obj : this.room) {
			if (obj.getClass() == DonkeyKong.class) {
				DonkeyKong dk = (DonkeyKong) obj;
				dk.doSomething();
				dk.updateBananas();
			}
		}
	}
	
	private void moveBats() {
		for (GameObject obj : this.room) {
			if (obj.getClass() == Bat.class) {
				Bat bat = (Bat) obj;
				bat.doSomething();
			}
		}
	}
	
	private void updateBombs() {
		this.player.updateBombs();
	}
	
	private void spoilMeat() {
		for (GameObject obj : this.room) {
			if (obj.getClass() == Meat.class) {
				Meat m = (Meat) obj;
				m.slowlySpoil();
			}
		}
	}
	
	public void dropBomb() {
		this.player.dropBomb();
	}
}