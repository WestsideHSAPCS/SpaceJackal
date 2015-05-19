package spacejackal;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.Random;

public class BasicEnemyShip extends Enemy
{

    public BasicEnemyShip(double x, double y)
    {
        super(x, y);
        if (texture == null)
            texture = new Texture(Gdx.files.internal("BasicEnemyShip.png"));
    }


    @Override
    public int getCenterX()
    {
        return (int)(x + shipW / 2);
    }

    @Override
    public int getCenterY()
    {
        return (int)(y + shipH / 2);
    }

    @Override
    public int getRadius()
    {
        return shipW;
    }

    @Override
    public void update(double dx, double dy)
    {
        findMoveDirection();
        x += xMove;
        y += yMove;
        int fireVar = (int) (Math.random() * 1000);
        if (fireVar > 950)
            fireProjectile();
        super.update(dx, dy);
        
    }

    @Override
    public void draw(SpriteBatch batch)
    {
        float drawX = (float)(x + shipW / 2);
        float drawY = (float)(y + shipH / 2);
        batch.draw(texture,
				drawX, drawY, (shipW/2), (shipH/2),
				shipW, shipH, 2.0f, 2.0f,
				pRotation, imageX * shipW,imageY * shipH, shipW, shipH, false, false);
    }

    @Override
    public void handleKey(int keyCode)
    {
    }
    
    public void findMoveDirection()
    {
        double playerY = y - GameScreen.getShipY();
        double playerX = x - GameScreen.getShipX();
        pRotation = (float)Math.toDegrees(Math.atan2(playerY, playerX));
        float xDir = -(float)Math.cos(Math.toRadians(pRotation));
        float yDir = -(float)Math.sin(Math.toRadians(pRotation));
        xMove = (float)xDir * speed;
        yMove = (float)yDir * speed; 
    }
    
    public void fireProjectile()
    {
        float drawX = (float)(x + shipW / 2);
        float drawY = (float)(y + shipH / 2);
        GameScreen.addSprite(new Projectile(drawX,drawY,pRotation - 90));
    }
    
    @Override
    public void handleCollision(Sprite other) {
        if (other instanceof Projectile)
            die = true;
    }
    
    private static final int shipW = 32;
    private static final int shipH = 32;
    private static final int speed = 4;


	private double lastXMotion;
	private double lastYMotion;
    private double xMove;
    private double yMove;
    private double goalY;
    private double goalX;

	private float pRotation;
    private float mRotation;
    
    private Texture texture;
    private int imageX;
    private int imageY;
    
}
