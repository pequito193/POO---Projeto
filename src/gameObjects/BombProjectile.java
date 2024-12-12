package gameObjects;

import java.util.ArrayList;
import java.util.List;

import game.GameEngine;
import pt.iscte.poo.gui.ImageGUI;
import utils.Point2D;

public class BombProjectile extends GameObject {
	private static enum BombState {
		HELD,
		DROPPED_1,
		DROPPED_2,
		DROPPED_3,
		EXPLODE_1,
		EXPLODE_2,
		
		GONE,
	}
	
	private static final int BOMB_DAMAGE = 100;
	private static final int LAYER = 2;
	private static final String NAME = "Red";
	private BombState state;
	private boolean hasBeenUsed;
	private List<Fire> animation;
	
	public BombProjectile(Point2D startPosition) {
		super(NAME, startPosition, LAYER);
		this.state = BombState.HELD;
		this.hasBeenUsed = false;
		this.animation = new ArrayList<Fire>();
	}
	
	public void dropBomb(Point2D position) {
		setPosition(position);
		ImageGUI.getInstance().addImage(this);
		
		this.state = BombState.DROPPED_1;
	}
	
	public boolean getHasBeenUsed() {
		return this.hasBeenUsed;
	}
	
	public void updateState() {
		System.out.println(this.state);
		switch(this.state) {
			case HELD:
				break;
			case DROPPED_1:
				this.state = BombState.DROPPED_2;
				break;
			case DROPPED_2:
				this.state = BombState.DROPPED_3;
				break;
			case DROPPED_3:
				this.state = BombState.EXPLODE_1;
				break;
			case EXPLODE_1:
				this.state = BombState.EXPLODE_2;
				break;
			case EXPLODE_2:
				explodeAnimation(true);
				explode();
				this.state = BombState.GONE;
				break;
			case GONE:
				explodeAnimation(false);
				deleteObject();
				this.hasBeenUsed = true;
				break;
		}
	}
	
	private void explodeAnimation(boolean startAnimation) {
		List<Point2D> radius = getPosition().getNeighbourhoodPoints();
		
		if (startAnimation) {
			for (Point2D position : radius) {
				this.animation.add(new Fire(position));
			}
			
			for (Fire f : this.animation) {
				ImageGUI.getInstance().addImage(f);
			}
		}
		
		else {
			for (Fire f : this.animation) {
				ImageGUI.getInstance().removeImage(f);
			}
			
			this.animation.clear();
		}
	}
	
	private void explode() {
		List<GameObject> room = GameEngine.getInstance().getCurrentRoom().getRoom();
		List<Point2D> radius = getPosition().getNeighbourhoodPoints();
		
		for (int i = 0; i < room.size(); i++) {
			GameObject o = room.get(i);
			
			for (Point2D position : radius) {
				if (!o.getPosition().equals(position)) {
					continue;
				}
				
				if (o.isAttackable()) {
					Character character = (Character) o;
					character.updateHealth(- this.BOMB_DAMAGE);
				}
				
				if (o.isClimbable() || o.isCollectable()) {
					o.deleteObject();
					i--;
				}
			}
		}
	}
}