package zelda;

import java.awt.Rectangle;
import java.awt.Shape;

import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.SpriteGroup;
import com.golden.gamedev.object.collision.AdvanceCollisionGroup;

import zelda.enemies.Direction;
import zelda.enemies.Enemy;
import zelda.objects.Blade; 
import zelda.objects.Shield; 

public class LinkCollisionManager extends AdvanceCollisionGroup {
	private SpriteGroup enemyGroup;

	public LinkCollisionManager(SpriteGroup enemyGroup) {
		this.enemyGroup = enemyGroup;
		pixelPerfectCollision = true;
	}

	@Override
	public void collided(Sprite s1, Sprite s2) {
		// Vérifier si la collision est entre Link et l'ennemi
		 if ((s1 instanceof Enemy && s2 instanceof Link) || (s1 instanceof Link && s2 instanceof Enemy)) {

		        // Get the bounds of each sprite
		        Rectangle bounds1 = ((Shape) s1).getBounds();
		        Rectangle bounds2 = ((Shape) s2).getBounds();

		        // Check if the bounds overlap
		        if (bounds1.intersects(bounds2)) {

		            // Handle the collision
		            Link link = (s1 instanceof Link) ? (Link) s1 : (Link) s2;
		            Enemy enemy = (s1 instanceof Enemy) ? (Enemy) s1 : (Enemy) s2;
		            link.takeDamage(enemy.getDamage());
		            enemy.takeDamage(link.getDamage());

		            // If the enemy is dead, remove it from the sprite group
		            if (enemy.getHealth() <= 0) {
		                enemyGroup.remove(enemy);
		            }
		        }
		    }

		    // Check if the player was hit by an enemy attack
		    if (s2 instanceof Blade) {
		        Blade blade = (Blade) s2;
		        int damage = blade.getDamage().getValue() - shield.getDefense().getValue();
		        if (damage > 0) {
		            // Determine the orientation of the attack
		            boolean attackFromLeft = false;
		            if (s1 instanceof Enemy) {
		                Enemy enemy = (Enemy) s1;
		                if (enemy.getDirection() == Direction.LEFT) {
		                    attackFromLeft = true;
		                }
		            } else if (s1 instanceof Link) {
		                Link link = (Link) s1;
		                if (link.getOrientation() == Orientation.WEST) {
		                    attackFromLeft = true;
		                }
		            }
		            // Check if the attack hit the player from the correct direction
		            if (attackFromLeft == (((Link) s1).getOrientation() == Orientation.WEST)) {
		                life -= damage;
		                if (life <= 0) {
		                    game.finish();
		                }
		            }
		        }
		    }
			


}}



