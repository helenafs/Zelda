package zelda.enemies;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;

import com.golden.gamedev.object.AnimatedSprite;
import com.golden.gamedev.object.SpriteGroup;
import com.golden.gamedev.object.Timer;

import zelda.Link;
import zelda.Orientation;
import zelda.Player;
import zelda.Zelda;
import zelda.scenary.Board;

import com.golden.gamedev.Game;

public class Enemy extends AnimatedSprite{

	private static final long serialVersionUID = 1L;
	private int health;
	private int damage;
	private Direction direction;
	private Zelda game;
	private Timer figth; 
	public static final Direction DEFAULT_DIRECTION = Direction.UP;
	
	

	public Enemy(Zelda game, int startX, int startY, int startHealth, int startDamage) {
	    this.setLocation(startX, startY);
	    health = startHealth;
	    damage = startDamage;
	    this.game = game;
	    this.direction = Enemy.DEFAULT_DIRECTION;
	   this.initResources();
	   
	}
	
	//abstract
	private void initResources() {
        BufferedImage[] sprites = new BufferedImage[8]; 
        // Walk north
        sprites[0] = game.getImage("res/sprites/Link/GLWN1.gif");
        sprites[1] = game.getImage("res/sprites/Link/GLWN1.gif");
//        sprites[1] = game.getImage("enemies/ennemiup1.gif");
//        // Walk south 
//        sprites[2] = game.getImage("C:\\Users\\helen\\OneDrive\\Documentos\\MIASHS DCISS\\Zelda\\zelda\\zelda\\classes\\zelda\\enemies\\ennemidown.gif");
//        sprites[3] = game.getImage("C:\\Users\\helen\\OneDrive\\Documentos\\MIASHS DCISS\\Zelda\\zelda\\zelda\\classes\\zelda\\enemies\\ennemidown1.gif");
//        // Walk west
//        sprites[4] = game.getImage("C:\\Users\\helen\\OneDrive\\Documentos\\MIASHS DCISS\\Zelda\\zelda\\zelda\\classes\\zelda\\enemies\\ennemileft.gif");
//        sprites[5] = game.getImage("C:\\Users\\helen\\OneDrive\\Documentos\\MIASHS DCISS\\Zelda\\zelda\\zelda\\classes\\zelda\\enemies\\ennemileft1.gif");
//        //walk east
//        sprites[6] = game.getImage("C:\\Users\\helen\\OneDrive\\Documentos\\MIASHS DCISS\\Zelda\\zelda\\zelda\\classes\\zelda\\enemies\\ennemiright.gif");
//        sprites[7] = game.getImage("C:\\Users\\helen\\OneDrive\\Documentos\\MIASHS DCISS\\Zelda\\zelda\\zelda\\classes\\zelda\\enemies\\ennemiright1.gif");

        this.setImages(sprites);
//        this.setLocation(256, 380);
        this.setAnimationFrame(0, 0);

	}
	

    
    //abstract
    public void update(long elapsedTime) {
    	 super.update(elapsedTime);
    	 
    }

    //abstract
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
}

