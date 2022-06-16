package map;
import theGame.gameLoading.Loading;
import tile.Tile;
import java.awt.*;


public class Map {
    private int width,height;
    private static int [][] tiles;
    private  int x_axis,y_axis;
    public Map(String path){
        loadWorld(path);
    }

    public void upDate(){

    }

    /**
     *
     *
     * @param g reference
     */
    public void render(Graphics g){
        for (int y=0; y<height;y++){
            for (int x=0;x<width;x++){
                getTile(x,y).render(g,x*Tile.TILEWIDTH,y*Tile.TILEHIGHT);

            }
        }
    }

    /**
     *
     * @param x x-axis
     * @param y y-axis
     * @return the tile type plan to place
     */
    public static Tile getTile(int x ,int y){
        Tile t = Tile.tiles[tiles[x][y]];
        if(t == null)
            return Tile.FloorTile;
        return t;
    }

    /**
     * identified the map design from a txt file
     * @param path the location of txt file
     */
    private  void loadWorld(String path){
        String file = Loading.switchToString(path);
        String[] tokens =file.split("\\s+");
        width = Loading.switchToInt(tokens[0]);
        height = Loading.switchToInt(tokens[1]);
        x_axis = Loading.switchToInt(tokens[2]);
        y_axis = Loading.switchToInt(tokens[3]);

        tiles = new int[width][height];
        for (int x=0; x < width; x++){
            for(int y =0 ; y < height;y++)
                tiles[x][y] = Loading.switchToInt(tokens[(x + y * width)+4]);
        }

    }
}
