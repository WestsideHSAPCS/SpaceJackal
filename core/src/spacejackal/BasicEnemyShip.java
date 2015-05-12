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
        health = 1;
    }


    @Override
    public int getCenterX()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getCenterY()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getRadius()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(double x, double y)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void draw(SpriteBatch batch)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void handleKey(int keyCode)
    {
    }
    
    public void findMoveDirection()
    {
        if (Math.sqrt((x*x) + (y*y)) > 300)
        {
           rotation = (float) Math.atan2(y, x);          
        }
    }
    
    private static final int shipW = 40;
    private static final int shipH = 35;
    private static final int speed = 5;
    private int health;
    
    private double dx = 3;
    private double dy = 3;

	private double lastXMotion;
	private double lastYMotion;

	private float rotation;
    
    private Texture texture;
    private int imageX;
    private int imageY;
    
}
