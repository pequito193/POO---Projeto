package utils;

import gameObjects.GameObject;
import gameObjects.GameObject.GameObjectType;

public class Utils {
	public static String timeToString(int time) {
	    int hours = (int) (time / 3600);
	    int minutes = (int) ((time % 3600) / 60);
	    int seconds = (int) (time % 60);
	    
	    return String.format("%02d:%02d:%02d", hours, minutes, seconds);
	}
	
	public static boolean isMovementHorizontal(Point2D currentPosition, Point2D newPosition) {
		return currentPosition.getX() != newPosition.getX();
	}
	
	public static boolean isMovementUpwards(Point2D currentPosition, Point2D newPosition) {
		return currentPosition.getY() - newPosition.getY() == 1;
	}
	
	public static boolean isOnClimbableObject(GameObject[][] room, Point2D position) {
		return room[position.getX()][position.getY()].getObjectType() == GameObjectType.CLIMBABLE;
	}
}