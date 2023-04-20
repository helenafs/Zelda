package zelda.enemies;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import zelda.Zelda;

public class GhostEnemy extends AbstractEnemy{

	public GhostEnemy(Zelda game, int startX, int startY, int startHealth, int startDamage) {
		super();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 
	protected void initResources() {
	        BufferedImage[] sprites = new BufferedImage[4];
	        sprites[0] = game.getImage("res/sprites/Ennemies/ghost1.gif");
	        sprites[1] = game.getImage("res/sprites/Ennemies/ghost2.gif");
	        sprites[2] = game.getImage("res/sprites/Ennemies/ghost3.gif");
	        sprites[3] = game.getImage("res/sprites/Ennemies/ghost4.gif");

	        this.setImages(sprites);
	        this.setAnimationFrame(0, 0);
	    }

	@Override
	public void render(Graphics2D g) {
		// TODO Auto-generated method stub
		
	}
}
