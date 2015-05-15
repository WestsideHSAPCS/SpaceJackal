package spacejackal;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Projectile extends Enemy
{
	public Projectile(double x, double y, double dir)
	{
		super(x, y);

		texture = new Texture(Gdx.files.internal(projectileImg));
		
		        //first get the direction the entity is pointed
        float xDir = -(float)Math.sin(Math.toRadians(dir));
        float yDir = (float)Math.cos(Math.toRadians(dir));
        
        //Then scale it by the current speed to get the velocity
        dx = (float)xDir * speed;
        dy = (float)yDir * speed;
		
		rotation = (float) dir;
		
		timer = 30;
	}

	@Override
	public int getCenterX()
	{
		return (int) (x + lazerW / 2);
	}

	@Override
	public int getCenterY()
	{
		return (int) (x + lazerH / 2);
	}

	@Override
	public int getRadius()
	{
		return (int) (lazerW / 2);
	}

	@Override
	public void update(double shipXMotion, double shipYMotion)
	{		
		x += dx;
		y += dy;
		
		timer--;
		
		if (timer == 0)
			die = true;
	}
	
	
	@Override
	public void draw(SpriteBatch batch)
	{		
		float drawX = (float) (x + SpaceJackalGame.playWidth / 2);
		float drawY = (float) (y + SpaceJackalGame.playHeight / 2);
		
		batch.draw(texture,
				drawX, drawY,
				(lazerW / 2), (lazerH / 2),
				lazerW, lazerH,
				1.0f, 1.0f,
				rotation,
				imageX * lazerW, imageY * lazerH,
				lazerW, lazerH,
				false, false);
		
	}
	
	@Override
	public void handleCollision(Sprite other) 
	{
		if (other instanceof Rock)
			die = true;
		if (other instanceof EnemyBaseShip)
			die = true;
		if (other instanceof EnemyCosmicMine)
			die = true;
		if (other instanceof BasicEnemyShip)
			die = true;
	}

	@Override
	public void handleKey(int keyCode)
	{
	}

	protected double x;
	protected double y;

	private double dx;
	private double dy;
	
	private float rotation;
	
	private int imageX;
	private int imageY;
	
	private int timer;

	private static final String projectileImg = "lazer.png";
	private static final double speed = 15;
	private static final int lazerW = 7;
	private static final int lazerH = 22;

	private static Texture texture;
	
}
