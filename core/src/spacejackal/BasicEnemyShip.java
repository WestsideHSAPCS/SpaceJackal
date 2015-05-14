package spacejackal;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

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
        return (int) Math.sqrt((x*x)+(y*y));
    }

    @Override
    public void update(double dx, double dy)
    {
        findMoveDirection();
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
				rotation, imageX * shipW,imageY * shipH, shipW, shipH, false, false);
    }

    @Override
    public void handleKey(int keyCode)
    {
    }
    
    public void findMoveDirection()
    {
           rotation = (float) Math.toDegrees(Math.atan2(y - GameScreen.getShipY(), x - GameScreen.getShipX()));  
           System.out.println(rotation);
    }
    
    private static final int shipW = 32;
    private static final int shipH = 32;
    private static final int speed = 5;


	private double lastXMotion;
	private double lastYMotion;

	private float rotation;
    
    private Texture texture;
    private int imageX;
    private int imageY;
    
}
