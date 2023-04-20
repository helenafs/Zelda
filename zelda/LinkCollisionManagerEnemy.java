package zelda;

import java.awt.Rectangle;
import java.awt.Shape;

import com.golden.gamedev.Game;
import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.SpriteGroup;
import com.golden.gamedev.object.collision.AdvanceCollisionGroup;
import com.golden.gamedev.object.collision.CollisionBounds;

import zelda.enemies.Direction;
import zelda.enemies.Enemy;
import zelda.objects.Blade; 
import zelda.objects.Shield; 

public class LinkCollisionManagerEnemy extends AdvanceCollisionGroup {
	private SpriteGroup enemyGroup;
    private Link link;
    private int linkLife;
    private Zelda game;
    private SpriteGroup linkGroup;


    public LinkCollisionManagerEnemy(Zelda game, SpriteGroup enemyGroup, Link link) {
        this.game = game;
        this.enemyGroup = enemyGroup;
        this.link = link;
        linkLife = 50;
        pixelPerfectCollision = true;
        this.linkGroup = new SpriteGroup("LinkGroup");
        this.linkGroup.add(link);
        this.setCollisionGroup(enemyGroup, linkGroup);
    }

    public void update(long elapsedTime) {
        checkCollision(); // Add this line to handle collision updates

        // check if the Link's health has reached zero
        if (link.getLife() <= 0) {
            game.finish();
            System.out.println("tu as perdu!");
        }
    }
		
		public boolean linkattacked(Link link, Enemy enemy) {
			Rectangle linkRect = link.getBounds();
		   	Rectangle enemyRect = enemy.getBounds();
		    if (linkRect.intersects(enemyRect)) {
		        if (link.getOrientation() == Orientation.NORTH && link.getY() - enemy.getY() <= link.getAttackRange()) {
		            // damage the enemy and update the score
		            enemy.takeDamage(link.getDamage());
		            link.incrementScore(enemy.getPoints());
		            System.out.println("link a attaqué");
		            return true;
		        } else if (link.getOrientation() == Orientation.SOUTH && enemy.getY() - link.getY() <= link.getAttackRange()) {
		            enemy.takeDamage(link.getDamage());
		            link.incrementScore(enemy.getPoints());
		            System.out.println("link a attaqué");
		            return true;
		        } else if (link.getOrientation() == Orientation.WEST && link.getX() - enemy.getX() <= link.getAttackRange()) {
		            enemy.takeDamage(link.getDamage());
		            link.incrementScore(enemy.getPoints());
		            System.out.println("link a attaqué");
		            return true;
		        } else if (link.getOrientation() == Orientation.EAST && enemy.getX() - link.getX() <= link.getAttackRange()) {
		            enemy.takeDamage(link.getDamage());
		            link.incrementScore(enemy.getPoints());
		            System.out.println("link a attaqué");
		            return true;
		        }
		    }
		    return false;
	    }

	    public void enemyAttacks(Enemy enemy, Link link) {
	        // check if the enemy is facing the Link and close enough to attack
	        if (enemy.getDirection() == Direction.DOWN && link.getY() - enemy.getY() <= enemy.getAttackRange()) {
	            // damage the Link and decrement the health
	            link.takeDamage(enemy.getDamage());
	            linkLife -= enemy.getDamage();
	        }

		}

		
		@Override
		public void collided(Sprite s1, Sprite s2) {

			if (s1 instanceof Enemy && s2 instanceof Link) {
				Enemy enemy = (Enemy)s1; 
				Link link = (Link) s2;
				if (linkattacked(link, enemy)) {
					enemy.takeDamage(link.getDamage());
				}else {
				enemy.attack();
				}			
			}else if(s1 instanceof Link && s2 instanceof Enemy) {
				Link link = (Link) s1; 
				Enemy enemy = (Enemy)s2; 
				if (linkattacked(link, enemy)) {
					enemy.takeDamage(link.getDamage());
				}else {
				enemy.attack();}
			}
			

}


	









}



