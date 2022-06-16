package tile;

import image.Assets;

import java.awt.image.BufferedImage;

public class wallTile extends Tile{
    public wallTile(int id) {
        super(Assets.wall, id);
    }

    public boolean isSolid(){
        return true;
    }
}
