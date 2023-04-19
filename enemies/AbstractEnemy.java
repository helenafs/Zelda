package zelda.enemies;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.golden.gamedev.object.AnimatedSprite;
import com.golden.gamedev.object.SpriteGroup;

import zelda.Orientation;
import zelda.Player;
import zelda.Zelda;
import zelda.scenary.Board;

import com.golden.gamedev.Game;


public abstract class AbstractEnemy extends AnimatedSprite {

    private static final long serialVersionUID = 1L;
    private int health;
    private int damage;
    private Direction direction;
    private Zelda game;
    public static final Direction DEFAULT_DIRECTION = Direction.UP;

    public Enemy(Zelda game, int startX, int startY, int startHealth, int startDamage) {
        this.setLocation(startX, startY);
        health = startHealth;
        damage = startDamage;
        this.game = game;
        this.direction = Enemy.DEFAULT_DIRECTION;
        this.initResources();
    }

    // La méthode initResources() est une méthode abstraite car chaque ennemi devra charger
    // ses propres images de ressources.
    protected abstract void initResources();

    public void setBoard(Board board) {
        SpriteGroup link = new SpriteGroup("LINK SPRITE GROUPE");
        link.add(this);
        this.manager.setCollisionGroup(link, board.getForeground());
    }

    // La méthode update() est une méthode abstraite car chaque ennemi aura son propre comportement
    // de mise à jour.
    public abstract void update(long elapsedTime);

    // La méthode walk() est une méthode abstraite car chaque ennemi aura son propre comportement
    // de déplacement.
    public abstract void walk(Orientation direction);

    public void attack() {
        // Code pour gérer l'attaque de l'ennemi
    }

    public void takeDamage(int damage) {
        health -= damage;
    }

    public boolean detectPlayer(Player player, int distance) {
        double playerX = player.getX();
        double playerY = player.getY();
        double deltaX = playerX - this.getX();
        double deltaY = playerY - this.getY();
        double distanceFromPlayer = Math.sqrt(deltaX * deltaX + deltaY * deltaY);
        return distanceFromPlayer <= distance;
    }

    public void attacked(Player player) {
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
        double moveDistance = 50;
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

    // La méthode render() est une méthode abstraite car chaque ennemi aura son propre
    // comportement d'affichage.
    public abstract void render(Graphics2D g);
}
