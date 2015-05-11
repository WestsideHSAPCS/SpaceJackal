package spacejackal;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class Sprite
{
    public Sprite()
    {
        
    }

    public Sprite(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    public static void setScreen(GameScreen screen)
    {
        Sprite.screen = screen;
    }
    
    public static boolean checkCollision(Sprite s1, Sprite s2)
    {
        int xDiff = s1.getCenterX() - s2.getCenterX();
        int yDiff = s1.getCenterY() - s2.getCenterY();
        int radSum = s1.getRadius() + s2.getRadius();
        
        return (xDiff * xDiff + yDiff * yDiff) < (radSum * radSum);
    }
    
    public void handleCollision(Sprite other)
    {
    }
    
    public boolean isDead()
    {
        return die;
    }
    
    // Collision detection info
    public abstract int getCenterX();
    public abstract int getCenterY();
    public abstract int getRadius();
    
    public abstract void update(double shipXMotion, double shipYMotion);
    public abstract void draw(SpriteBatch batch);
    public abstract void handleKey(int keyCode);

    protected double x;
    protected double y;
    protected boolean die;
    
    protected static GameScreen screen;
}
