package reward;

import image.Image;
import java.util.Random;

import character.Collision;
import character.Entity;

import java.awt.Graphics;

public class BonusReward extends Reward {
    private int b_posX;
    private int b_posY;
    private int rand;
    private Random random;
    private RegularReward rw;
    public BonusReward() {
        image = new Image("/src/main/resources/reward2.png");
        random=new Random();
        rand = random.nextInt(14);
        rw= new RegularReward();
        b_posX=rw.getX()[rand]+20;
        b_posY=rw.getY()[rand]-20;

    }
    //public void update(int x,int y)
    public int update(Entity entity) {
        if (Collision.isColliding(b_posX+7,b_posY,this,entity)) {
            rand = random.nextInt(14);
            b_posX = rw.getX()[rand] + 20;
            b_posY = rw.getY()[rand] - 20;
            return 100;
        }
        return 0;
    }


    public void render(Graphics g) {
        g.drawImage(image.getImage(), b_posX, b_posY, null);
        //Draws hitbox around potion
        //g.drawRect(b_posX+7, b_posY, getWidth(), getHeight());
    }
}
