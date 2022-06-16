package tile;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * determine each tile id
 */
public class Tile {

    public static Tile[] tiles=new Tile[246];
    public static Tile FloorTile=new floorTile(0);
    public static  Tile Wall =new wallTile(1);

        protected BufferedImage surface;
        protected final int id;
        
        public static final int TILEWIDTH=32, TILEHIGHT=32;
    public Tile(BufferedImage surface, int id) {
        this.surface = surface;
        this.id =id;

        tiles[id] = this;
    }
    public void upDate(){

    }

    public void render(Graphics g, int x, int y){
        g.drawImage(surface,x,y,TILEWIDTH,TILEHIGHT,null);
    }

    public boolean isSolid(){
        return false;
    }

    public int getId(){
        return id;
    }
}
