package utils;

import java.util.List;

import game.GameEngine;
import gameObjects.GameObject;
import pt.iscte.poo.gui.ImageGUI;

public class Utils {
	public static void deleteGameObject(GameObject object) {
		ImageGUI.getInstance().removeImage(object);
		GameEngine.getInstance().deleteGameObject(object);
	}
	public static String timeToString(int time) {
	    int hours = (int) (time / 3600);
	    int minutes = (int) ((time % 3600) / 60);
	    int seconds = (int) (time % 60);
	    
	    return String.format("%02d:%02d:%02d", hours, minutes, seconds);
	}
	
	public static boolean arePositionsEqual(Point2D pos1, Point2D pos2) {
		return pos1.getX() == pos2.getX() && pos1.getY() == pos2.getY();
	}
	
	public static boolean isMovementHorizontal(Point2D currentPosition, Point2D newPosition) {
		return currentPosition.getX() != newPosition.getX();
	}
	
	public static boolean isMovementUpwards(Point2D currentPosition, Point2D newPosition) {
		return currentPosition.getY() == newPosition.getY() + 1;
	}
	
	public static boolean isOnClimbableObject(Point2D position, List<GameObject> room) {
		int curX = position.getX();
		int curY = position.getY();
		
		for (GameObject o : room) {
			int objX = o.getPosition().getX();
			int objY = o.getPosition().getY();
			if (curX == objX && curY == objY - 1) {
				return o.isClimbable();
			}
		}
		
		return false;
	}
}