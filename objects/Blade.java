package zelda.objects;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.golden.gamedev.Game;
import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.SpriteGroup;

import zelda.Zelda;
import zelda.scenary.AbstractTile;
import zelda.scenary.Board;
import zelda.Orientation;

public class Blade extends Sprite {
    
    public enum Kind {
        NONE,
        WOOD,
        SILVER,
        MAGICAL
    }
    
    private Kind kind;
    private Game game;
    public Sprite img;
    int damage;
    
    Board board; 
    
    public Blade(Game game, Kind silver, int damage) {
        this.kind = silver;
        this.game = game;
        this.damage = damage;
      
        // Initialise l'image en fonction du type d'arme
    
        switch (kind) {
            case WOOD:
            	this.setImage(this.game.getImage("res/sprites/Objects/OWBE.gif")); 
            	this.setImage(this.game.getImage("res/sprites/Objects/OWBN.gif"));
            	this.setImage(this.game.getImage("res/sprites/Objects/OWBW.gif"));
            	this.setImage(this.game.getImage("res/sprites/Objects/OWBS.gif"));
                break;
            case SILVER:
            	this.setImage(this.game.getImage("res/sprites/Objects/OSAE.gif"));
            	this.setImage(this.game.getImage("res/sprites/Objects/OSAN.gif"));
            	this.setImage(this.game.getImage("res/sprites/Objects/OSAW.gif"));
            	this.setImage(this.game.getImage("res/sprites/Objects/OSAS.gif"));	
                break;
            case MAGICAL:
            	this.setImage(this.game.getImage("res/sprites/Objects/OYBE.gif"));
            	this.setImage(this.game.getImage("res/sprites/Objects/OYBN.gif"));
            	this.setImage(this.game.getImage("res/sprites/Objects/OYBW.gif"));
            	this.setImage(this.game.getImage("res/sprites/Objects/OYBS.gif"));
                break;
            default:
                // Si le type d'arme n'est pas valide, utilise une image par défaut
            	this.setImage(this.game.getImage("res/sprites/Objects/ORAE.gif"));
            	this.setImage(this.game.getImage("res/sprites/Objects/ORAN.gif"));
            	this.setImage(this.game.getImage("res/sprites/Objects/ORAW.gif"));
            	this.setImage(this.game.getImage("res/sprites/Objects/ORAS.gif"));
                break;
        }
        
     }
    
    
    public void updateImage(Orientation orientation) {
        switch (kind) {
            case WOOD:
                switch (orientation) {
                    case NORTH:
                        setImage(game.getImage("res/sprites/Objects/OWBN.gif"));
                        break;
                    case SOUTH:
                        setImage(game.getImage("res/sprites/Objects/OWBS.gif"));
                        break;
                    case EAST:
                        setImage(game.getImage("res/sprites/Objects/OWBE.gif"));
                        break;
                    case WEST:
                        setImage(game.getImage("res/sprites/Objects/OWBW.gif"));
                        break;
                }
                break;
            case SILVER:
                // Similar to the WOOD case, update images based on orientation
                break;
            case MAGICAL:
                // Similar to the WOOD case, update images based on orientation
                break;
            default:
                // Similar to the WOOD case, update images based on orientation
                break;
        }
    }
	
	public Kind getKind() {
        return kind;
    }
    
    public int getDamage() {
        return damage;
    }
    
    public void setBoard(Board board) {
        SpriteGroup blade = new SpriteGroup("BLADE SPRITE GROUPE");
        blade.add(this);   
    }


	
	
}
