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
    private Game game;

    public LinkCollisionManagerEnemy(SpriteGroup enemyGroup, SpriteGroup link) {
        this.enemyGroup = enemyGroup;
        pixelPerfectCollision = true;
        this.setCollisionGroup(enemyGroup, link);
    }

		
		public boolean linkattacked(Link link, Enemy enemy) {
			
			Orientation linkOrientation = link.getOrientation(); 
			switch (linkOrientation)
			if (link.getY() <= enemy.getY() &&
					
		
					.debut.getLigne() <= n.fin.getLigne() && n.debut.getLigne() <= this.fin.getLigne()
					&& this.debut.getColonne() <= n.fin.getColonne() && n.debut.getColonne() <= this.fin.getColonne()) {
				return true;
			}
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
	}
	









}



