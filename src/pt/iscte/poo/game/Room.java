package pt.iscte.poo.game;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import objects.Floor;
import objects.Manel;
import objects.Stairs;
import objects.Trap;
import objects.Wall;
import pt.iscte.poo.gui.ImageGUI;
import pt.iscte.poo.utils.Direction;
import pt.iscte.poo.utils.Point2D;

public class Room {
	public static final int MIN_POSITION = 0;
	public static final int MAX_POSITION = 9;
	
	private Manel manel;
	private char[][] levelChar;
	public Room(String file) throws IOException {
		levelChar = readRoomFile(file);
		createObjects();
		
	}
	
	private char[][] readRoomFile(String fileName) throws IOException {
	    List<String> lines = Files.readAllLines(Paths.get(fileName));
	    char[][] room = new char[lines.size()][];
	    for (int i = 0; i < lines.size(); i++) {
	        room[i] = lines.get(i).toCharArray();
	    }
	    return room;
	}
	
	private void createObjects() {
	    for (int i = 0; i < levelChar.length; i++) {
	        for (int j = 0; j < levelChar[i].length; j++) {
	            char c = levelChar[i][j];
	            Point2D position = new Point2D(j, i - 1);
	            switch (c) {
	                case 'W':
	                    ImageGUI.getInstance().addImage(new Wall(position));
	                    break;
	                case 'H':
	                    manel = new Manel(position);
	                    ImageGUI.getInstance().addImage(new Floor(position));
	                    break;
	                case 'S':
	                	ImageGUI.getInstance().addImage(new Stairs(position));
	                	break;
	                case 't':
	                	ImageGUI.getInstance().addImage(new Trap(position));
	                	break;
	                case 'P':
	                	ImageGUI.getInstance().addImage(new Floor(position));
	                	//TO-DO
	                	break;
	                case 'G':
	                	ImageGUI.getInstance().addImage(new Floor(position));
	                	//TO-DO
	                	break;
	                case 's':
	                	ImageGUI.getInstance().addImage(new Floor(position));
	                	//TO-DO
	                	break;	                
	                default:
	                	ImageGUI.getInstance().addImage(new Floor(position));
	                	break;
	                
	            }
	        }
	    }
	    ImageGUI.getInstance().addImage(manel);
	}
	
	public void moveManel(Direction direction) {
		Point2D newPosition = manel.getPosition().plus(direction.asVector());
	    if (newPosition.getX() >= MIN_POSITION  && newPosition.getX() <= MAX_POSITION - 1 &&
	        newPosition.getY() >= MIN_POSITION && newPosition.getY() <= MAX_POSITION - 1) {
	        manel.move(direction);
	    }
	}
	
}