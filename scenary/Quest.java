package zelda.scenary;

import java.awt.Graphics2D;

import zelda.Zelda;

import com.golden.gamedev.object.PlayField;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Quest extends PlayField {
    
    private Zelda game;
    
    private Board[][] boards;
    
    private QuestMenu menu;
    
    public Quest(Zelda game) {
        super();
        this.game = game;
        this.boards = new Board[2][2];
        this.initRessources();
    }

    private void initRessources() {
        this.menu = new QuestMenu(this.game);
        
        //lire les fichiers
        String fileName = "myfile.txt"; // replace with your file name
        int charIndex = 10; // replace with the index of the character you want

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            int c;
            int currentIndex = 0;
            while ((c = br.read()) != -1) {
                if (currentIndex == charIndex) {
                    char myChar = (char) c;
                    System.out.println("The character at index " + charIndex + " is " + myChar);
                    break; // exit loop once character is found
                }
                currentIndex++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        // Board (0, 0)
        Board b00 = new Board(this.game, 0, 0);
        
        //b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN_BORDER));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN_BORDER));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_SOUTH_EAST_CORNER));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        
        
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_SOUTH_EAST_CORNER));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
            
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_SOUTH_EAST_CORNER));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
            
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN_BORDER));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_SOUTH_EAST_CORNER));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_SOUTH_WEST_CORNER));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN_BORDER));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN_BORDER));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN_BORDER));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN_BORDER));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN_BORDER));
        
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        
        b00.add(new Rock(this.game, Rock.Kind.GREEN_INDENTED));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_NORTH_EAST_CORNER));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_INDENTED));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_INDENTED));
        
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));

        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_INDENTED));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_INDENTED));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_INDENTED));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_INDENTED));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_INDENTED));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_INDENTED));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_INDENTED));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_INDENTED));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_INDENTED));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_INDENTED));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_INDENTED));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_INDENTED));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        

        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        
        this.add(b00);
        
    }
    
    
    public Board getCurrentBoard() {
        return this.boards[0][0];
    }
    
    public void add(Board board) {
        //this.addGroup(board.getBackground());
        //this.addGroup(board.getForground());
        this.boards[board.getX()][board.getY()] = board;
    }
        
    public void update(long elapsedTime) {
        super.update(elapsedTime);
        this.boards[0][0].update(elapsedTime);
        this.menu.update(elapsedTime);
    }
    
    public void render(Graphics2D g) {
        super.render(g);
        this.boards[0][0].render(g);        
        this.menu.render(g);
    }
}
