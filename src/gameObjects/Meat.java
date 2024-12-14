package gameObjects;

import utils.Point2D;

public class Meat extends Collectable {
	private static final String NAME = "GoodMeat";
	private static final String NAME_ROTTEN = "BadMeat";
	private static final int TICKS_TO_SPOIL = 10;
	private static final int HEALTH_BUFF = 20;
	private static final int HEALTH_BUFF_ROTTEN = -20;
	private boolean isRotten;
	private int currentTick;
	private int healthBuff;
	
	public Meat(Point2D startingPosition) {
		super(NAME, startingPosition);
		this.isRotten= false;
		this.currentTick = 0;
		this.healthBuff = HEALTH_BUFF;
	}
	
	@Override
	public void updateStatsImplementation(Character character) {
		character.updateHealth(this.healthBuff);
	}
	
	public void slowlySpoil() {
		if (this.isRotten) {
			return;
		}
		
		this.currentTick++;
		
		if (this.currentTick >= TICKS_TO_SPOIL) {
			this.isRotten = true;
			this.healthBuff = HEALTH_BUFF_ROTTEN;
			setName(NAME_ROTTEN);
			redrawObject();
		}
	}
}
