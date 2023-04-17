package zelda.scenary;

import java.awt.Graphics2D;

import zelda.Zelda;

import com.golden.gamedev.object.PlayField;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
//import java.util.HashMap;
//import java.util.Map;

public class Quest extends PlayField {
    
    private Zelda game;
    
    private Board[][] boards;
    
    private QuestMenu menu;
    private int currentX, currentY;
    //characteres 
    public static final char SOL = '.';
    public static final char OBSTACLE = 'x';
    public static final char BORDURE_SUDEST = '/';
    public static final char BORDURE_SUDOUEST = '\\';
    public static final char BORDURE_NORD = 'M';
  //  public static final char ENNEMI = 'E';
  //  public static final char OBJET = 'O';
    
    //public Map<String, AbstractTile> map;
    
    
    public Quest(Zelda game) {
        super();
        this.game = game;
        this.boards = new Board[2][2];
        this.initRessources();
       //  map = new HashMap<>();
       // map.put(""+SOL, new Floor(this.game, Floor.Color.SAND));
       // map.put(""+OBSTACLE, new Rock(this.game, Rock.Kind.GREEN_PLAIN));
       // map.put(""+BORDURE_SUDEST, new Rock(this.game, Rock.Kind.GREEN_SOUTH_EAST_CORNER)); 
       // map.put(""+BORDURE_SUDOUEST, new Rock(this.game, Rock.Kind.GREEN_SOUTH_WEST_CORNER));
       // map.put(""+BORDURE_NORD, new Rock(this.game, Rock.Kind.GREEN_NORTH_EAST_CORNER)); 
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
        
	        int a = 0;
        //lire les fichiers
	        for (Path path : paths) {
	            Board b = boards[a/2][a%2];
	            a++;
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
	        }
		        
	
        
  
    }
    
    
    public Board getCurrentBoard() {
    	return this.boards[currentX][currentY];
    }
    
    public void add(Board board) {
        //this.addGroup(board.getBackground());
        //this.addGroup(board.getForground());
        this.boards[board.getX()][board.getY()] = board;
    }
        
    public void update(long elapsedTime) {
        super.update(elapsedTime);
        this.boards[currentX][currentY].update(elapsedTime);
        this.menu.update(elapsedTime);
    }
    
    public void render(Graphics2D g) {
        super.render(g);
        this.boards[currentX][currentY].render(g);       
        this.menu.render(g);
    }
}
