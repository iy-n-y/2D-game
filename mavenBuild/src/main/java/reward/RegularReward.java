package reward;
import java.awt.image.BufferedImage;
import image.Image;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import character.Character;
import character.Collision;
import character.Entity;

public class RegularReward extends Reward{
    private int [] posX;
    private int [] posY;
    private int totalRegularRewardNum;
    // Regular reward position are declared at the beginning
    public RegularReward() {
        image = new Image("/src/main/resources/reward.png");
        totalRegularRewardNum = 15;
        posX = new int[15];
        posY = new int[15];
        posX[0] = 170;
        posY[0] = 500; //1
        posX[1] = 180;
        posY[1] = 560; //1
        posX[2] = 240;
        posY[2] = 750; //1
        posX[3] = 400;
        posY[3] = 810; //1
        posX[4] = 460;
        posY[4] = 780; //1
        posX[5] = 700;
        posY[5] = 820; //1
        posX[6] = 300;
        posY[6] = 280; //1
        posX[7] = 550;
        posY[7] = 490; //1
        posX[8] = 703;
        posY[8] = 700; //1
        posX[9] = 862;
        posY[9] = 212; //1
        posX[10] = 612;
        posY[10] = 640;//1
        posX[11] = 141;
        posY[11] = 500; //1
        posX[12] = 700;
        posY[12] = 132; //1
        posX[13] = 811;
        posY[13] = 500;
        posX[14] = 650;
        posY[14] = 500;//1
    }
    public int[] getX(){ return posX;}
    public int[] getY(){ return posY;}
    public int getTotalRegularRewardNum(){
        return totalRegularRewardNum;
    }
    public void render(Graphics g){
        if(totalRegularRewardNum!=0) {
            for (int i = 0; i < totalRegularRewardNum; i++) {
                g.drawImage(image.getImage(), posX[i] , posY[i],null);
                //Draws hitbox around potion
                //g.drawRect(posX[i]+7 , posY[i], getWidth(), getHeight());
            }
        }
    }
    //public void update(int x,int y)
    public int update(Entity entity){
        if(totalRegularRewardNum!=0){
        	int x = entity.getX();
        	int y = entity.getY();
            for (int i=0; i<totalRegularRewardNum;i++){
            	if(Collision.isColliding(posX[i]+7, posY[i], this, entity)) {
                    this.posX[i] = this.posX[totalRegularRewardNum-1];
                    this.posY[i] = this.posY[totalRegularRewardNum-1];
                    this.posX[totalRegularRewardNum-1]=x;
                    this.posY[totalRegularRewardNum-1]=y;
                    totalRegularRewardNum--;
                    return 10;
                }
            }
        }
        return 0;
    }

}
