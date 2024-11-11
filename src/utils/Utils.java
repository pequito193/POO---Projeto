package utils;

public class Utils {
	public static String timeToString(int time) {
	    int hours = (int) (time / 3600);
	    int minutes = (int) ((time % 3600) / 60);
	    int seconds = (int) (time % 60);
	    
	    return String.format("%02d:%02d:%02d", hours, minutes, seconds);
	}
}