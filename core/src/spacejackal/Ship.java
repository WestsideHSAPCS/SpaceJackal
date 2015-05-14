package spacejackal;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class Ship extends Sprite
{

    public Ship()
    {
        if (texture == null)
            texture = new Texture(Gdx.files.internal("spritesheet.png"));
        
        x = SpaceJackalGame.playWidth/2 - shipW / 2;
        y = SpaceJackalGame.playHeight/2 - shipH / 2;
        
        rotation = 180;
    }
    public double getX()
    {
       return (float)(x + SpaceJackalGame.playWidth / 2);
    }
    
    public double getY()
    {
        return (y + SpaceJackalGame.playHeight / 2);
    }
    
    public float getRotation()
    {
        return rotation;
    }

    @Override
    public int getCenterX()
    {
        return (int) (shipW / 2 + x);
    }

    @Override
    public int getCenterY()
    {
        return (int) (shipH / 2 + y);
    }

    @Override
    public int getRadius()
    {
        return shipW / 2  - 4;
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
        float xDir = -(float)Math.sin(Math.toRadians(rotation));
        float yDir = (float)Math.cos(Math.toRadians(rotation));
        
        //Then scale it by the current speed to get the velocity
        dx = (float)xDir * speed;
        dy = (float)yDir * speed;
    }

    @Override
    public void draw(SpriteBatch batch)
    {
		// Offset location by half the window size (because (0, 0) is considered
		// the center of the window)

		batch.draw(texture, 
                (float)x, (float)y,
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
    
    private static int tempX;
    private static int tempY;
    
    private double dx = 3;
    private double dy = 3;

	private double lastXMotion;
	private double lastYMotion;

	private float rotation;
    
    private Texture texture;
    private int imageX;
    private int imageY;
}
