package pt.iscte.poo.game;

import objects.Manel;
import objects.Wall;
import pt.iscte.poo.gui.ImageGUI;
import pt.iscte.poo.utils.Point2D;

public class Room {
	public static final int MIN_POSITION = 1;
	public static final int MAX_POSITION = 10;
	
	private Point2D heroStartingPosition = new Point2D(1, 1);
	private Manel manel;
	
	public Room() {
		manel = new Manel(heroStartingPosition);
		ImageGUI.getInstance().addImage(manel);
		ImageGUI.getInstance().addImage(new Wall());

	}

	public void moveManel() {
		manel.move();
	}
	
}