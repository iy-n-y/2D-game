package image;

import java.awt.image.BufferedImage;

/**
 * separate graph from a whole graph
 */
public class Assets {
    private static final int width=32,height=32;
    public static BufferedImage floor, wall;
    public static void init(){
        SpriteSheet sheet= new SpriteSheet(Image.imageLoad("/src/main/resources/tiles.png"));
        floor =sheet.crop(0,7*height,width,height);
        wall =sheet.crop(width,5*height,width,height);
    }
}
