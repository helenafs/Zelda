package zelda;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import zelda.scenary.Board;
import zelda.scenary.Quest;
import zelda.scenary.Rock;
import zelda.enemies.Direction;
import zelda.enemies.Enemy;
import zelda.objects.Blade;
import zelda.objects.LinkCollisionManagerBlade;
import zelda.objects.Shield;
import zelda.objects.Shield.Kind;

import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.SpriteGroup;

import com.golden.gamedev.Game;
import com.golden.gamedev.GameLoader;



public class Zelda extends Game {
	
	private LinkCollisionManagerBlade linkBladeCollision;
	private SpriteGroup objectsGroup;

    private Link link;
    private Quest quest;
    private boolean menu;
    
    private int max_X = 16 * 42;
	private int max_Y = 11 * 42 + 126;
	private int min_X = 0;
	private int min_Y = 126;
	
    private Rock rock;
    public Enemy enemy;
    public  Blade b; 
    public Shield shield; 
    
    private SpriteGroup[][] objets;  // Add this line to define the objets variable

    
    public Zelda() {
        
    }
    
    public void initResources() {
    	 
        this.quest = new Quest(this);
        objets = new SpriteGroup[2][2]; // Initialize the objets array with some size
        for (int i = 0; i < objets.length; i++) {
            for (int j = 0; j < objets[i].length; j++) {
                objets[i][j] = new SpriteGroup("Objects at (" + i + ", " + j + ")");
            }
        }
    //    createEnemy();
        this.link = new Link(this);
        this.link.setBoard(this.quest.getCurrentBoard());    
        this.menu = false;
        b = new Blade(this,Blade.Kind.WOOD,4); 
        
        // Initialize the objectsGroup and add objects (e.g., trees) to it
        objectsGroup = new SpriteGroup("Objects");
        // Add objects to the group
        objectsGroup.add(b);
       // objectsGroup.add(shield);
  
    }
    
//    private void createEnemy() {
//    	this.enemy = new Enemy(this, 370, 420, 10, 4);
//    	this.enemy.walk(Direction.UP);
//    	this.enemy.setObjectsGroup(objectsGroup);
//
//    }
        
    public void update(long elapsedTime) {
       
    	int currentX = this.quest.getCurrentX();
    	int currentY = this.quest.getCurrentY();
    	

        if (this.keyPressed(KeyEvent.VK_Q)) {
         playSound("res/sounds/LOZ_Get_Item.wav");
         this.quest.changer(link, b);
        }
        if (this.keyPressed(KeyEvent.VK_ALT)) {
        	playSound("res/sounds/LOZ_Sword.wav");
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
        if(link.getX() > max_X) {
        	link.setLocation(10, link.getY());
        	quest.setCurrentX(quest.getCurrentX() + 1);
        }
        else if (link.getY() > max_Y) {
        	link.setLocation(link.getX(), 136);
        	quest.setCurrentY(quest.getCurrentY() + 1);
        } 
        if(link.getX() < 0) {
        	link.setLocation(max_X - 10, link.getY());
       	quest.setCurrentX(quest.getCurrentX() - 1);
        }
        if(link.getY() < min_Y) {
        	link.setLocation( link.getX(), max_Y - 10);
        	quest.setCurrentY(quest.getCurrentY() - 1);
        }
        
        link.setBoard(quest.getCurrentBoard());//mettre a jour le colision
        
        this.quest.update(elapsedTime);
        this.link.update(elapsedTime);
       
        //b.setLocation(255, 379);
        this.b.update(elapsedTime);
       
        // Update the Link object
        link.update(elapsedTime);
        
    //    this.enemy.update(elapsedTime);

    }

    public void render(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        this.quest.render(g);
        this.link.render(g);
        this.b.render(g);
        objectsGroup.render(g);
 
        //mettre l'enemi juste si il est active 
       // if(this.enemy.isActive() && this.enemy.isAlive()) {
         //  this.enemy.render(g);
            
       // }
           
    }
    
    //pour utiliser dans l'attaque de l'enemi
    public Link getGameLink() {
        // return the Link object
        return this.link;
    }
    
    public static void main(String[] args) {
        GameLoader game = new GameLoader();
        game.setup(new Zelda(), new Dimension(672,588), false);
        game.start();
    }

	public Player getLink() {
		// TODO Auto-generated method stub
		return null;
	}
    
}