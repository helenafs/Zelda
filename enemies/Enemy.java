package zelda.enemies;

import java.awt.Graphics2D;
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

public class Enemy extends AnimatedSprite{

	private static final long serialVersionUID = 1L;
	private int health;
	private int damage;
	private Direction direction;
	private Zelda game;
	private Timer figth; 
	public static final Direction DEFAULT_DIRECTION = Direction.UP;
	
	private Timer changeDirectionTimer;
    private static final int CHANGE_DIRECTION_INTERVAL = 500; // in milliseconds
	
    private SpriteGroup objectsGroup;
    private BoardCollisionManager boardCollisionManager;


	public Enemy(Zelda game, int startX, int startY, int startHealth, int startDamage) {
	    this.setLocation(startX, startY);
	    health = startHealth;
	    damage = startDamage;
	    this.game = game;
	    this.direction = Enemy.DEFAULT_DIRECTION;
	    this.initResources();
	    boardCollisionManager = new BoardCollisionManager();
	   
	   changeDirectionTimer = new Timer(CHANGE_DIRECTION_INTERVAL);
	   
	}
	
	//abstract
	private void initResources() {
        BufferedImage[] sprites = new BufferedImage[8]; 
        // Walk north
        sprites[0] = game.getImage("res/sprites/Link/GLWN1.gif");
        sprites[1] = game.getImage("res/sprites/Link/GLWN1.gif");
////         sprites[0] = game.getImage("res/sprites/Link/GLWN1.gif");
//        sprites[1] = game.getImage("res/sprites/Link/GLWN1.gif");
//        // Walk south 
//        sprites[2] = game.getImage("res/sprites/enemies/ennemidown.gif");
//        sprites[3] = game.getImage("res/sprites/enemies/ennemidown1.gif");
//        // Walk west
//        sprites[4] = game.getImage("res/sprites/enemies/ennemileft.gif");
//        sprites[5] = game.getImage("res/sprites/enemies/ennemileft1.gif");
//        // Walk east
//        sprites[6] = game.getImage("res/sprites/enemies/ennemiright.gif");
//        sprites[7] = game.getImage("res/sprites/enemies/ennemiright1.gif");

        this.setImages(sprites);
        this.setAnimationFrame(0, 0);

	}
	
	public void setObjectsGroup(SpriteGroup objectsGroup) {
	    this.objectsGroup = objectsGroup;
	}
	
	public void setBoard(Board board) {
	
		SpriteGroup enemy = new SpriteGroup("ENEMY SPRITE GROUP");
	    enemy.add(this);
	 	    boardCollisionManager.setCollisionGroup(enemy, board.getForeground());
    }

	int directionIndex = 0;
   
	private double previousX;
	private double previousY;

	private void undoMove() {
	    setLocation(previousX, previousY);
	}
	
    public void update(long elapsedTime) {
    	super.update(elapsedTime);
    	 previousX = getX();
    	 previousY = getY();

        Direction currentDirection = Direction.UP;
        Direction[] directions = {Direction.UP, Direction.LEFT, Direction.DOWN, Direction.RIGHT};

        if (changeDirectionTimer.action(elapsedTime)) {
            // It's time to change direction
            directionIndex++;
            directionIndex = directionIndex % directions.length; // increment direction index
            currentDirection = directions[directionIndex];
            this.walk(currentDirection);
        }

        
        
        if (objectsGroup != null) {
            EnemyCollisionManager manager = new EnemyCollisionManager(objectsGroup, this);
            Sprite collision = manager.getCollision();
            if (collision != null) {
                // Undo the last move and try changing direction
                undoMove();
                directionIndex++;
                directionIndex = directionIndex % directions.length; // increment direction index
                currentDirection = directions[directionIndex];
                this.walk(currentDirection);
            }
        }
      // Check if the enemy is blocked by a rock tile
        if (this.boardCollisionManager != null) 
            this.boardCollisionManager.checkCollision();
    
    }

    public void walk(Direction direction) {
    	double randomNum = (new Random().nextDouble() * 0.2);
    	
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

 

	public void attack() {
	    // Code to handle the enemy's attack
		int damage = this.damage; 
		this.game.getGameLink().takeDamage(damage);
	}

	
	public void takeDamage(int damage) {	
	    health -= damage;
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

	public void takeDamage(Object damage2) {
		// TODO Auto-generated method stub
		
	}
	
	//abstract
	public void render(Graphics2D g) {
        super.render(g);
    }
	// Add the following method to change the enemy's direction
    private void changeDirection() {
        directionIndex++;
        directionIndex = directionIndex % Direction.values().length; // increment direction index
        direction = Direction.values()[directionIndex];
        this.walk(direction);
    }
	
	private class EnemyCollisionManager extends AdvanceCollisionGroup {

	    private SpriteGroup group;
	    private Sprite sprite;
	    private boolean collisionDetected;

	    public EnemyCollisionManager(SpriteGroup group, Sprite sprite) {
	        this.group = group;
	        this.sprite = sprite;
	        this.collisionDetected = false;
	        this.pixelPerfectCollision = false;
	    }

	    public Sprite getCollision() {
	        collisionDetected = false;
	        checkCollision();
	        if (collisionDetected) {
	            return sprite;
	        } else {
	            return null;
	        }
	    }

	    @Override
	    public void collided(Sprite s1, Sprite s2) {
	    	Enemy.this.undoMove();
            Enemy.this.changeDirection();
	        CollisionShape shape1 = getCollisionShape1(s1);
	        CollisionShape shape2 = getCollisionShape2(s2);
	        if (shape1.intersects(shape2)) {
	            this.revertPosition1();
	            collisionDetected = true;
	        }
	    }
	}
	
	public class BoardCollisionManager extends AdvanceCollisionGroup {



		    public BoardCollisionManager() {
		    
		        this.pixelPerfectCollision = false;
		    }

		    @Override
		    public void collided(Sprite s1, Sprite s2) {
		        Enemy enemy = (Enemy) s1;
		        enemy.undoMove();
		        enemy.changeDirection();

	
	}}}

