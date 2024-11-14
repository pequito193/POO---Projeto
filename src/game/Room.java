package game;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import gameObjects.Background;
import gameObjects.DonkeyKong;
import gameObjects.Door;
import gameObjects.GameObject;
import gameObjects.Ladder;
import gameObjects.Meat;
import gameObjects.Player;
import gameObjects.Princess;
import gameObjects.Sword;
import gameObjects.Trap;
import gameObjects.Wall;
import pt.iscte.poo.gui.ImageGUI;
import utils.Direction;
import utils.Point2D;

public class Room {
	public static enum RoomNumber {
		ONE,
		TWO,
		THREE,
	}
	public static final int MIN_POSITION = 0;
	public static final int MAX_POSITION = 9;
	public static final int ROOM_SIZE = 10;
	private GameObject[][] room;
	private RoomNumber roomNumber;
	private Player player;
	
	public Room(String filename) throws IOException {
		this.room = new GameObject[ROOM_SIZE][ROOM_SIZE];
		readRoomFile(filename);
		createObjects();
	}
	
	private void readRoomFile(String filename) throws IOException {
		Scanner scanner = new Scanner(new File(filename));
		
		// TODO: parse first line
		String firstLine = scanner.nextLine();
		//this.roomNumber = 
		
		int i = 0;
		while (scanner.hasNextLine()) {
			readLine(scanner.nextLine(), i);
			i++;
		}
		
		//print();
	}
	
	private void print() {
		for (int i = 0; i < room.length; i++) {
			for (int j = 0; j < room[i].length; j++) {
				System.out.println(room[i][j].toString());
			}
		}
	}
	
	private void readLine(String line, int col) {
		Point2D position;
		for (int row = 0; row < line.length(); row++) {
			position = new Point2D(row, col);
			
			switch (line.charAt(row)) {
				case 'W':
					this.room[row][col] = new Wall(position);
					break;
				case 't':
					this.room[row][col] = new Trap(position);
					break;
				case 'S':
					this.room[row][col] = new Ladder(position);
					break;
				case 'P':
					this.room[row][col] = new Princess(position);
					break;
				case 'G':
					this.room[row][col] = new DonkeyKong(position);
					break;
				case 'H':
					this.player = new Player(position);
					this.room[row][col] = this.player;
					break;
				case 's':
					this.room[row][col] = new Sword(position);
					break;
				case 'm':
					this.room[row][col] = new Meat(position);
					break;
				case '0':
					this.room[row][col] = new Door(position);
					break;
				default:
					this.room[row][col] = new Background(position);
			}
		}
	}
	
	public Player getPlayer() {
		return this.player;
	}
	
	private void createObjects() {
		fillBackground();
		
		for (int i = 0; i < room.length; i++) {
			for (int j = 0; j < room[i].length; j++) {
				GameObject gameObject = this.room[i][j];
				ImageGUI.getInstance().addImage(gameObject);
			}
		}
	}
	
	private void fillBackground() {
		for (int i = 0; i < room.length; i++) {
			for (int j = 0; j < room[i].length; j++) {
				ImageGUI.getInstance().addImage(new Background(new Point2D(i, j)));
			}
		}
	}
}