package zelda.enemies;

import com.golden.gamedev.object.AnimatedSprite;

import zelda.Orientation;

public class Enemy extends AnimatedSprite{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Variables to represent the state of the enemy
    private int x;
    private int y;
    private int health;
    private int damage;
    private Direction direction;
    public static final Direction DEFAULT_DIRECTION = Direction.UP;

    // Constructor to initialize the state of the enemy
    public Enemy(int startX, int startY, int startHealth, int startDamage) {
        x = startX;
        y = startY;
        health = startHealth;
        damage = startDamage;
        this.direction = Enemy.DEFAULT_DIRECTION; 
    }

    // Methods to control the behavior of the enemy
    public void move(int dx, int dy) {
        x += dx;
        y += dy;
    }

    public void attack() {
        // Code to handle the enemy's attack
    }

    public void takeDamage(int damage) {
        health -= damage;
    }

    // Other methods for other actions of the enemy

    // Methods to access the variables of the enemy
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }

	public Object getDirection() {
		return direction; 
	}
}

