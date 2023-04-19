package zelda;

import java.awt.Rectangle;
import java.awt.Shape;

import com.golden.gamedev.Game;
import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.SpriteGroup;
import com.golden.gamedev.object.collision.AdvanceCollisionGroup;

import zelda.enemies.Direction;
import zelda.enemies.Enemy;
import zelda.objects.Blade; 
import zelda.objects.Shield; 

public class LinkCollisionManagerEnemy extends AdvanceCollisionGroup {
	private SpriteGroup enemyGroup;
	private Game game;

		public LinkCollisionManagerEnemy(SpriteGroup enemyGroup, Link link) {
			this.enemyGroup = enemyGroup;
			pixelPerfectCollision = true;
			SpriteGroup linkSprites = new SpriteGroup("LINK SPRITE GROUPE");
	        linkSprites.add(link);
			this.setCollisionGroup(enemyGroup, linkSprites);
		}

		
		public boolean linkattacked(Link s1, Enemy s2) {
			return false; 
		}
		
		@Override
		public void collided(Sprite s1, Sprite s2) {

			if (s1 instanceof Enemy && s2 instanceof Link) {
				Enemy enemy = (Enemy)s1; 
				Link link = (Link) s2;
				if (linkattacked(link, enemy)) {
					enemy.takeDamage(link.getDamage());
				}else {
				enemy.attack();}
				
			}else if(s1 instanceof Link && s2 instanceof Enemy) {
				Link link = (Link) s1; 
				Enemy enemy = (Enemy)s2; 
				if (linkattacked(link, enemy)) {
					enemy.takeDamage(link.getDamage());
				}else {
				enemy.attack();}
			}
			

}

	public Enemy getLink() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getEnemyGroup() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isCollisionOccurred(Enemy enemy, Enemy link) {
		// TODO Auto-generated method stub
		return false;
	}}



