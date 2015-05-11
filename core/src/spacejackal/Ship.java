package spacejackal;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import javax.vecmath.Vector2f;


public class Ship extends Sprite
{

    public Ship()
    {
        if (texture == null)
            texture = new Texture(Gdx.files.internal("spritesheet.png"));
        
        x = 0 - shipW / 2;
        y = 0 - shipH / 2;
        
        rotation = 180;
        direction = new Vector2f();
    }
    
    public float getRotation()
    {
        return rotation;
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
	public void update(double shipXMotion, double shipYMotion)
	{
        this.findMoveDirection();
		// The ship does not actually move - instead, it remembers its "motion"
		// to communicate to all the other sprites.

		lastXMotion = dx;
		lastYMotion = dy;
    }

	public double getLastXMotion()
	{
		return lastXMotion;
	}

	public double getLastYMotion()
	{
		return lastYMotion;
	}

	public void findMoveDirection()
    {
        //first get the direction the entity is pointed
        direction.x = -(float)Math.sin(Math.toRadians(rotation));
        direction.y = (float)Math.cos(Math.toRadians(rotation));
        
        //Then scale it by the current speed to get the velocity
        dx = (float)direction.x * speed;
        dy = (float)direction.y * speed;
    }

    @Override
    public void draw(SpriteBatch batch)
    {
		// Offset location by half the window size (because (0, 0) is considered
		// the center of the window)

		float drawX = (float)(x + SpaceJackalGame.playWidth / 2);
		float drawY = (float)(y + SpaceJackalGame.playHeight / 2);
		batch.draw(texture, 
                drawX, drawY,
                (shipW / 2), (shipH / 2),
                shipW, shipH,
                1.0f, 1.0f,
                rotation,
                imageX * shipW, imageY * shipH,
                shipW, shipH,
                false, false);
    }

    @Override
    public void handleKey(int keyCode)
    {
        if (keyCode == Keys.LEFT)
            rotation -= 22.5;
        
        if (keyCode == Keys.RIGHT)
            rotation += 22.5; 
        
//        if (keyCode == Keys.SPACE)
//            screen.addSprite(new Projectile(this));
    }
    
    
    private static String shipImage = "spritesheet.png";
    private static int shipW = 40;
    private static int shipH = 35;
    private static int speed = 5;
    
    private double dx = 3;
    private double dy = 3;

	private double lastXMotion;
	private double lastYMotion;

	private float rotation;
    private Vector2f direction;
    
    private Texture texture;
    private int imageX;
    private int imageY;
}
