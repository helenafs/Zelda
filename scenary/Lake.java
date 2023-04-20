package zelda.scenary;

import com.golden.gamedev.object.Sprite;


import zelda.Zelda;
import zelda.scenary.Floor.Color;


public class Lake extends AbstractTile {
    public enum Wave {
        GREEN_NORTH,
        GREEN_CENTER,
        GREEN_SOUTH,
        GREEN
        
    }
    private Wave color;

    public Lake(Zelda game, Wave wave) {
        super(game, 1, 1, 42, 42);
        this.color = wave;
        switch(wave) {
        case  GREEN_NORTH:
        	this.add("res/sprites/scenary/BGGNWS.gif", 1);
        	break;//1
        case GREEN_CENTER:
        	this.add("res/sprites/scenary/BGGWS.gif", 1);//2
        	break; 
        case GREEN_SOUTH: 
        	this.add("res/sprites/scenary/BGGSWS.gif", 1);//3
        	break; 
        case GREEN:
            this.add("res/sprites/scenary/BGGCS.gif", 1); //4          
            break;
     
        }
    }

  
//    public void update(long elapsedTime) {
//    	super.update(elapsedTime);
//        switch(color) {
//            case GREEN:
//                break;
//            case WHITE:
//                // Remove the old sprite
//                this.getGroup().remove(this.getSprite(0));
//                // Add the new sprite
//                this.add(new Sprite(this.game.getImage("res/sprites/scenery/BGGNES.gif")), -1);
//                color = Wave.GREEN;
//                break;
//        }
//    }

  //  public Point getTilePosition() {
    //    return new Point((int) (x / 42), (int) (y / 42));
    }
