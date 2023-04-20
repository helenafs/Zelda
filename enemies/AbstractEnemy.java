package zelda.enemies;


import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import com.golden.gamedev.object.AnimatedSprite;
import com.golden.gamedev.object.CollisionManager;
import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.SpriteGroup;
import com.golden.gamedev.object.Timer;
import com.golden.gamedev.object.collision.AdvanceCollisionGroup;
import com.golden.gamedev.object.collision.CollisionShape;

import zelda.Link;
import zelda.Orientation;
import zelda.Player;
import zelda.Zelda;
import zelda.scenary.Board;
import zelda.scenary.Tile;

import com.golden.gamedev.Game;
import com.golden.gamedev.object.collision.CollisionBounds;

public abstract class AbstractEnemy extends AnimatedSprite{
	
		private static final long serialVersionUID = 1L;
		private int health;
		private int damage;
		private Direction direction;
		public Zelda game;
		private Timer figth;
		
		private int attackRange;
	    private int points;

		public static final Direction DEFAULT_DIRECTION = Direction.UP;
		
		private Timer changeDirectionTimer;
	    private static final int CHANGE_DIRECTION_INTERVAL = 500; // in milliseconds
		
	    private SpriteGroup objectsGroup;
	    
	    Board board; 
	    
	    protected SpriteGroup enemies_SGroup;


		public void Enemy(Zelda game, int startX, int startY, int startHealth, int startDamage) {
		
		   
		}
		
		//abstract
		protected abstract void initResources();		

		
		public void setObjectsGroup(SpriteGroup objectsGroup) {
		    this.objectsGroup = objectsGroup;
		}

		public void setBoard(Board board) {
			
	    }
		
		// Retourne la board sur laquelle est l'enemi
			public Board getBoard() {
				System.out.println("Enemy sur la board "+this.board.getX()+" "+this.board.getY());
				return this.board;
			}
			
			// Retourne true si l'enemy est sur la board 
			public boolean isOnBoard(Board board) {
				return this.board == board;
			}


		int directionIndex = 0;
	   
		private double previousX;
		private double previousY;

		private void undoMove() {
		    setLocation(previousX, previousY);
		}
		
	    public void update(long elapsedTime) {
	    
	    }

	    public void walk(Direction direction) {
	    	double randomNum = (new Random().nextDouble() * 0.15);
	    	
	    	switch (direction) {
	        case UP:
	            this.setSpeed(0, -randomNum);
	            break;
	        case DOWN:
	            this.setSpeed(0, randomNum);
	            break;
	        case LEFT:
	            this.setSpeed(-randomNum, 0);
	            break;
	        case RIGHT:
	            this.setSpeed(randomNum, 0);
	            break;
	    }
	}		

	    public int getAttackRange() {
	        return attackRange;
	    }

	    public int getPoints() {
	        return points;
	    }

		public void attack() {
		    // Code to handle the enemy's attack
			int damage = this.damage; 
			this.game.getGameLink().takeDamage(damage);
			System.out.println("Link dit: ouch");
		}

		
		public void takeDamage(int damage) {	
		    health -= damage;
		    this.game.playSound("res/sounds/LOZ_Kill.wav"); 
		    if (health <= 0) {
	            setActive(false);
	            System.out.println("Tu as tué l'ennemi");
	            this.game.playSound("res/sounds/LOZ_Kill.wav"); 
		    }
	            
		}
		
		public boolean isAlive() {
			return this.health > 0;
		}

		// new method to detect the player within a certain distance from the enemy
		public boolean detectPlayer(Player player, int distance) {
		    double playerX = player.getX();
		    double playerY = player.getY();
		    double deltaX = playerX - this.getX();
		    double deltaY = playerY - this.getY();
		    double distanceFromPlayer = Math.sqrt(deltaX * deltaX + deltaY * deltaY);
		    return distanceFromPlayer <= distance;
		}
		
		// new method to define the enemy's behavior when attacked
		public void attacked(Player player) {
		    // Make the enemy face the player
		    double playerX = player.getX();
		    double playerY = player.getY();
		    double deltaX = playerX - this.getX();
		    double deltaY = playerY - this.getY();
		    double angle = Math.atan2(deltaY, deltaX);
		    angle = Math.toDegrees(angle);
		    if (angle < 0) {
		        angle += 360;
		    }
		    if (angle >= 45 && angle < 135) {
		        direction = Direction.UP;
		    } else if (angle >= 135 && angle < 225) {
		        direction = Direction.LEFT;
		    } else if (angle >= 225 && angle < 315) {
		        direction = Direction.DOWN;
		    } else {
		        direction = Direction.RIGHT;
		    }

		    // Move the enemy away from the player
		    double moveDistance = 50; // distance to move away from player
		    double moveX = Math.cos(Math.toRadians(angle)) * moveDistance;
		    double moveY = Math.sin(Math.toRadians(angle)) * moveDistance;
		    move(-1 * (int) moveX, -1 * (int) moveY);
		}

		public int getHealth() {
		    return health;
		}

		public int getDamage() {
		    return damage;
		}

		public Direction getDirection() {
		    return direction;
		}


		//abstract
		  public abstract void render(Graphics2D g);
		  
		  
		// Add the following method to change the enemy's direction
	    private void changeDirection() {
	        directionIndex++;
	        directionIndex = directionIndex % Direction.values().length; // increment direction index
	        direction = Direction.values()[directionIndex];
	        this.walk(direction);
	    }
	    
		
	


}
