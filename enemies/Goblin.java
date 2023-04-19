package zelda.enemies;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.Timer;

import zelda.Orientation;
import zelda.Zelda;

public class Goblin extends AbstractEnemy {

    private static final long serialVersionUID = 1L;
    private Timer attackTimer;
    private Sprite sword;

    public Goblin(Zelda game, int startX, int startY, int startHealth, int startDamage) {
        super(game, startX, startY, startHealth, startDamage);
        attackTimer = new Timer(500);
        sword = new Sprite(game.getImage("sword.png"), this.getX(), this.getY());
        sword.setActive(false);
    }

    protected void initResources() {
        this.setImage(game.getImage("goblin.png"));
    }

    public void update(long elapsedTime) {
        // Le comportement de l'ennemi Goblin lors de la mise à jour du jeu :
        if (this.getHealth() <= 0) {
            this.setActive(false);
            this.sword.setActive(false);
        }
        if (detectPlayer(game.getPlayer(), 100)) {
            if (attackTimer.action(elapsedTime)) {
                this.attack();
            }
        } else {
            this.walk(AbstractEnemy.DEFAULT_DIRECTION);
        }
        sword.setX(this.getX());
        sword.setY(this.getY());
    }

    public void walk(Orientation direction) {
        // Le comportement de l'ennemi Goblin lors du déplacement :
        switch (direction) {
        case UP:
            this.move(0, -1);
            break;
        case DOWN:
            this.move(0, 1);
            break;
        case LEFT:
            this.move(-1, 0);
            break;
        case RIGHT:
            this.move(1, 0);
            break;
        }
    }

    public void attack() {
        // Le comportement de l'ennemi Goblin lors de l'attaque :
        sword.setActive(true);
        if (sword.collidesWith(game.getPlayer())) {
            game.getPlayer().takeDamage(this.getDamage());
        }
        sword.setActive(false);
    }

    public void render(Graphics2D g) {
        // Le comportement de l'ennemi Goblin lors de l'affichage :
        if (this.isActive()) {
            g.drawImage(this.getImage(), (int) this.getX(), (int) this.getY(), null);
        }
        if (sword.isActive()) {
            sword.render(g);
        }
    }

}
