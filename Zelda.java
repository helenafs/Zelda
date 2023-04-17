package zelda;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import zelda.scenary.Quest;
import zelda.scenary.Rock;
import zelda.enemies.Enemy;
import com.golden.gamedev.Game;
import com.golden.gamedev.GameLoader;

public class Zelda extends Game {
    
    private Link link;
    private Quest quest;
    private boolean menu;
    private Rock rock;
    private Enemy enemy;
    
    public Zelda() {
        
    }
    
    public void initResources() {
        this.quest = new Quest(this);
        this.link = new Link(this);
        this.link.setBoard(this.quest.getCurrentBoard());    
        this.menu = false;
        createEnemy();
    }
    
    private void createEnemy() {
        this.enemy = new Enemy(100, 100, 10);
        this.enemy.move(1, 0);
        this.enemy.attack();
    }
        
    public void update(long elapsedTime) {
       
       	int currentX = this.quest.currentX;
    	int currentY = this.quest.currentY;
    
        if (this.keyPressed(KeyEvent.VK_ALT)) {
            this.link.fight();
        } else if (this.keyDown(KeyEvent.VK_LEFT)) {
            this.link.walk(Orientation.WEST);
        } else if (this.keyDown(KeyEvent.VK_RIGHT)) {
            this.link.walk(Orientation.EAST);
        } else if (this.keyDown(KeyEvent.VK_UP)) {
            this.link.walk(Orientation.NORTH);
        } else if (this.keyDown(KeyEvent.VK_DOWN)) {
            this.link.walk(Orientation.SOUTH);
        } else if (keyPressed(KeyEvent.VK_ESCAPE)) {
            finish();
        } else {
            this.link.setSpeed(0, 0);
        }
          System.out.println("x: " + link.getX() + "y: " + link.getY());
        if(link.getX() > 640) {
        	link.setLocation(10, link.getY());
        	quest.currentX++;
        }
        else if (link.getY() > 520) {
        	link.setLocation(link.getX(), 1);
        	quest.currentY++;
        } 
        this.quest.update(elapsedTime);
        this.link.update(elapsedTime);
    }

    public void render(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        this.quest.render(g);
        this.link.render(g);
    }
    
    public static void main(String[] args) {
        GameLoader game = new GameLoader();
        game.setup(new Zelda(), new Dimension(672,588), false);
        game.start();
    }
    
}
