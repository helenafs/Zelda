package zelda.scenary;

import java.awt.Graphics2D;

import zelda.Zelda;

import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.SpriteGroup;

public class QuestMenu {
    
    private SpriteGroup sprites;
    
    private Zelda game;
    
    private boolean gameFinished;
    private Sprite gameOverImage;
    
    public QuestMenu(Zelda game) {
        this.game = game;
        this.sprites = new SpriteGroup("");
        this.sprites.add(new Sprite(this.game.getImage("res/sprites/B_CASE.GIF"), 330, 30));
        this.sprites.add(new Sprite(this.game.getImage("res/sprites/A_CASE.GIF"), 400, 30));
        this.sprites.add(new Sprite(this.game.getImage("res/sprites/LIFE.GIF"), 500, 30));
        this.sprites.add(new Sprite(this.game.getImage("res/sprites/BOMB.GIF"), 230, 79));
        this.sprites.add(new Sprite(this.game.getImage("res/sprites/X.GIF"), 250, 80));
        this.sprites.add(new Sprite(this.game.getImage("res/sprites/KEY.GIF"), 230, 60));
        this.sprites.add(new Sprite(this.game.getImage("res/sprites/X.GIF"), 250, 60));
        this.sprites.add(new Sprite(this.game.getImage("res/sprites/PIECE.GIF"), 230, 30));
        this.sprites.add(new Sprite(this.game.getImage("res/sprites/X.GIF"), 250, 30));
        
        this.gameOverImage = new Sprite(this.game.getImage("res/sprites/gameover.gif"), 320, 240); 
        this.sprites.add(gameOverImage);
    }
    
    public void setGameFinished(boolean gameFinished) {
        this.gameFinished = gameFinished;
    }
    
    
    public void move(long elapsedTime, boolean flag) {
        Sprite[] s = this.sprites.getSprites();
        for (int i = 0; i < this.sprites.getSize(); i++) {
            if (flag) 
                s[i].moveTo(elapsedTime, s[i].getX(), s[i].getY() + 300, 1);
            else 
                s[i].moveTo(elapsedTime, s[i].getX(), s[i].getY() - 300, 1);
        }
        
    }
    
    public void update(long elapsedTime) {
        this.sprites.update(elapsedTime);
    }
    
    public void render(Graphics2D g) {
        // Render all the sprites except the game over image
        for (Sprite sprite : this.sprites.getSprites()) {
            if (sprite != null && sprite != gameOverImage) {
                sprite.render(g);
            }
        }
        
        // Render the game over image if the game is finished
        if (gameFinished) {
            gameOverImage.render(g);
        }
    }
}

