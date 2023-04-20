package zelda.scenary;

import java.awt.Graphics2D;

import zelda.Link; // pour link 
import zelda.Zelda; //le game
import zelda.enemies.Enemy;//pour l'enemi sour la board
import zelda.objects.Blade; // pour la blade

import com.golden.gamedev.object.PlayField;
import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.SpriteGroup;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


import java.util.ArrayList;


public class Quest extends PlayField {
    
    private Zelda game;
    
    private Board[][] boards;
    
    private QuestMenu menu;
    private int currentX, currentY;
    
    private AbstractTile[][] floorTiles;
    
    
    //characteres 
    public static final char SOL = '.';
    public static final char OBSTACLE = 'x';
    public static final char BORDURE_SUDEST = '/';
    public static final char BORDURE_SUDOUEST = '\\';
    public static final char BORDURE_NORD = 'M';
    public static final char Bl = 'B';
    public static final char B2 = 'S';
    public static final char B3 = 'A';
    public static final char B4 = 'N';
    

    ArrayList<Sprite>[][] objets;
    
    public Quest(Zelda game) {
        super();
        this.game = game;
        this.boards = new Board[2][2];
        this.objets = new ArrayList[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                this.objets[i][j] = new ArrayList<Sprite>();
            }
        }
        this.initRessources();
        this.floorTiles = new AbstractTile[2][2]; 
    }
    
  

    private void initRessources() {
        this.menu = new QuestMenu(this.game);
        
        //path vers les fichiers
        Path[] paths = {
            Paths.get("C:\\Users\\helen\\OneDrive\\Documentos\\MIASHS DCISS\\Zelda\\zelda\\zelda\\classes\\zelda\\res\\tableau\\premiertableauhautgauche.txt"),
            Paths.get("C:\\Users\\helen\\OneDrive\\Documentos\\MIASHS DCISS\\Zelda\\zelda\\zelda\\classes\\zelda\\res\\tableau\\deuxiemetableauhautdroite.txt"),
            Paths.get("C:\\Users\\helen\\OneDrive\\Documentos\\MIASHS DCISS\\Zelda\\zelda\\zelda\\classes\\zelda\\res\\tableau\\troisiemetableaubasgauche.txt"),
            Paths.get("C:\\Users\\helen\\OneDrive\\Documentos\\MIASHS DCISS\\Zelda\\zelda\\zelda\\classes\\zelda\\res\\tableau\\quatriemetableabasudroite.txt")
        };
       
        //voir si les fichiers sont regulaires
        for (Path path : paths) {
            if (!Files.isRegularFile(path)) {
                System.err.println("File " + path.toString() + " is not a regular file");
                System.exit(2);
            }
        }
		
				
		// Board (0, 0) - path p1
		   Board b00 = new Board(this.game, 0,0);
		//Board (1,0) - path p2
		   Board b10 = new Board(this.game, 1,0); 
		//Board (0,1) - path p3
		   Board b01 = new Board(this.game, 0,1); 
		//Board (1,1) - path p4
		   Board b11 = new Board(this.game, 1,1); 
		        
		    this.add(b00);
	        this.add(b10);
	        this.add(b01);
	        this.add(b11);
	        
	        b10.setEnemyOnBoard(this.game.enemy, 370, 420);
	   //     b00.setBladeOnBoard(this.game.b, 255, 379);
        
	        int a = 0;
	        
        //lire les fichiers
	        for (Path path : paths) {
	            Board b = boards[a%2][a/2];
//  a++;
	            BufferedReader br = null;
	            try {
	                br = new BufferedReader(new FileReader(path.toFile()));

	                int ch;
	                while ((ch = br.read()) != -1) {
	                    char c = (char) ch;
	                    
	                    // Check if the current character matches any of the characters you are interested in
	                    if (c == SOL) {
	                        // Do something with the 'sol' character
	                        b.add(new Floor(this.game, Floor.Color.SAND));   
	                    } else if (c == OBSTACLE) {
	                        // Do something with the 'obstacle' character
	                        b.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
	                    } else if (c == BORDURE_SUDEST) {
	                        // Do something with the 'bordureSudEst' character
	                        b.add(new Rock(this.game, Rock.Kind.GREEN_SOUTH_EAST_CORNER));;
	                    } else if (c == BORDURE_SUDOUEST) {
	                        // Do something with the 'bordureSudOuest' character
	                        b.add(new Rock(this.game, Rock.Kind.GREEN_SOUTH_WEST_CORNER));
	                    } else if (c == BORDURE_NORD) {
	                        // Do something with the 'bordureNord' character
	                        b.add(new Rock(this.game, Rock.Kind.GREEN_NORTH_EAST_CORNER));
	                    }  else if (c == Bl) {
	                        // Lire les blade
	                    	AbstractTile current = new Floor(this.game, Floor.Color.SAND);
	                    	b.add(current);
	                    	Sprite sp = new zelda.objects.Blade(this.game, Blade.Kind.WOOD, 4);
	                    	sp.setLocation(current.getX(), current.getY());
	                    	objets[a%2][a/2].add(sp);
	                    } 
	                    else if (c == B2) {
	                        // Lire les blade
	                    	AbstractTile current = new Floor(this.game, Floor.Color.SAND);
	                    	b.add(current);
	                    	Sprite sp = new zelda.objects.Blade(this.game, Blade.Kind.SILVER, 4);
	                    	sp.setLocation(current.getX(), current.getY());
	                    	objets[a%2][a/2].add(sp);
	                    } 
	                    else if (c == B3) {
	                        // Lire les blade
	                    	AbstractTile current = new Floor(this.game, Floor.Color.SAND);
	                    	b.add(current);
	                    	Sprite sp = new zelda.objects.Blade(this.game, Blade.Kind.MAGICAL, 4);
	                    	sp.setLocation(current.getX(), current.getY());
	                    	objets[a%2][a/2].add(sp);
	                    } 
	                    else if (c == B4) {
	                        // Lire les blade
	                    	AbstractTile current = new Floor(this.game, Floor.Color.SAND);
	                    	b.add(current);
	                    	Sprite sp = new zelda.objects.Blade(this.game, Blade.Kind.NONE, 4);
	                    	sp.setLocation(current.getX(), current.getY());
	                    	objets[a%2][a/2].add(sp);
	                    } 
	                }
	            } catch (IOException e) {
	                e.printStackTrace();
	            } finally {
	                if (br != null) {
	                    try {
	                        br.close();
	                    } catch (IOException e) {
	                        e.printStackTrace();
	                    }
	                }
	            }
	            
	            a++;
	        }
		         
  
    }
    
    public void changer(Link link, Sprite sprite) {

    	// Get the current position of the blade
        int bladeX = currentX;
        int bladeY = currentY;

        // Check if there's a blade at the current position
        if (objets[bladeX][bladeY].stream().anyMatch(s -> s instanceof Blade)) {
            // Remove the blade from the objets array
            objets[bladeX][bladeY].removeIf(s -> s instanceof Blade);

            // Replace the blade with a floor tile
            AbstractTile floor = new Floor(this.game, Floor.Color.SAND);
            floor.setLocation(bladeX, bladeY);
            floorTiles[bladeX][bladeY] = floor; // Store the floor tile in the floorTiles array

            // Create a new blade for Link
            Blade newBlade = new zelda.objects.Blade(this.game, Blade.Kind.MAGICAL, 4);
            link.takeBlade(newBlade);

            System.out.println("Vous avez pris la blade");
        } else {
            System.out.println("Aucune blade trouvée à la position actuelle");
        }
   }
    
    public Board getCurrentBoard() {
    	 System.out.println("Current board: " + this.boards[this.currentY][this.currentX]); // Add this line
    	return this.boards[getCurrentX()][getCurrentY()];
    }
    
    public Board getBoard(int x, int y) {
        return this.boards[x][y];
    }
    
    public void add(Board board) {
        //this.addGroup(board.getBackground());
        //this.addGroup(board.getForground());
        this.boards[board.getX()][board.getY()] = board;
    }
        
    public void update(long elapsedTime) {
        super.update(elapsedTime);
        this.boards[getCurrentX()][getCurrentY()].update(elapsedTime);
        this.menu.update(elapsedTime);
        
        for(Sprite sp :this.objets[getCurrentX()][getCurrentY()] ) {
        	sp.update(elapsedTime);}
       
    }
    
    public void render(Graphics2D g) {
        super.render(g);
        this.boards[getCurrentX()][getCurrentY()].render(g);       
        this.menu.render(g);
        
     // Draw floor tile if available
        if (floorTiles[getCurrentX()][getCurrentY()] != null) {
            floorTiles[getCurrentX()][getCurrentY()].render(g);
        }

        for (Sprite sp : this.objets[getCurrentX()][getCurrentY()]) {
            sp.render(g);
        }
    
    }

	public int getCurrentX() {
		return currentX;
	}

	public void setCurrentX(int currentX) {
		this.currentX = currentX;
	}

	public int getCurrentY() {
		return currentY;
	}

	public void setCurrentY(int currentY) {
		this.currentY = currentY;
	}
}
