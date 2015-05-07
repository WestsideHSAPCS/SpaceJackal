package spacejackal;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Projectile extends Sprite
{   
    public static enum Projectiles
    {
        LAZER("lazer.png"),
        ROCKETS("");
        
        Projectiles(String filename)
        {
            this.filename = filename;
        }
        
        Projectiles(String filename, int imageX, int imageY)
        {
            this.filename = filename;
            this.imageX = imageX;
            this.imageY = imageY;
        }
        
        public Texture texture;
        
        private final String filename;
        private int imageX;
        private int imageY;
    }
    
    public Projectile(Ship sprite)
    {
        this.sprite = sprite;
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
    public void update()
    {
        sprite.findMoveDirection();
        
        x -= dx;
        y += dx;
    
    }

    @Override
    public void draw(SpriteBatch batch)
    {
        int width = Projectiles.LAZER.texture.getWidth();
        int height = Projectiles.LAZER.texture.getHeight();
        
        batch.draw(Projectiles.LAZER.texture, 
                (float)x, (float)y,
                (width / 2), (height / 2),
                width, height,
                1.0f, 1.0f,
                rotation,
                Projectiles.LAZER.imageX * width, 
                Projectiles.LAZER.imageY * height,
                width, height,
                false, false);
    }

    @Override
    public void handleKey(int keyCode)
    {
    }
    
    private int speed;
    private double dx;
    private double dy;
    
    private Ship sprite;
    private float rotation;
    
}
