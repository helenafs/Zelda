package zelda.enemies;

import com.golden.gamedev.object.AnimatedSprite;
import zelda.Orientation;
import zelda.Player;

public class Enemy extends AnimatedSprite {
private static final long serialVersionUID = 1L;
private int x;
private int y;
private int health;
private int damage;
private Direction direction;
public static final Direction DEFAULT_DIRECTION = Direction.UP;
public Enemy(int startX, int startY, int startHealth, int startDamage) {
    x = startX;
    y = startY;
    health = startHealth;
    damage = startDamage;
    this.direction = Enemy.DEFAULT_DIRECTION;
}

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

// new method to detect the player within a certain distance from the enemy
public boolean detectPlayer(Player player, int distance) {
    double playerX = player.getX();
    double playerY = player.getY();
    double deltaX = playerX - x;
    double deltaY = playerY - y;
    double distanceFromPlayer = Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    return distanceFromPlayer <= distance;
}

// new method to define the enemy's behavior when attacked
public void attacked(Player player) {
    // Make the enemy face the player
    double playerX = player.getX();
    double playerY = player.getY();
    double deltaX = playerX - x;
    double deltaY = playerY - y;
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

public Direction getDirection() {
    return direction;
}

public void takeDamage(Object damage2) {
	// TODO Auto-generated method stub
	
}

}
