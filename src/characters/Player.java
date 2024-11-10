package characters;

public class Player extends Character {
	private int startX;
	private int startY;
	
	public Player(int posX, int posY, int health, int damage) {
		super(posX, posY, health, damage);
		
		this.startX = posX;
		this.startY = posY;
	}
}