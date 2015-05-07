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
        
        x = SpaceJackalGame.playWidth / 2;
        y = SpaceJackalGame.playHeight / 2;
        
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
    public void update()
    {    
        this.findMoveDirection();
        x -= dy;
        y += dx;
        
        if (x > SpaceJackalGame.playWidth + shipW)
            x = 0 - shipW;
        else if (x < 0 - shipW)
            x = SpaceJackalGame.playWidth + shipW;
        else if (y > SpaceJackalGame.playHeight + shipH)
            y = 0 - shipH;
        else if (y < 0 - shipH)
            y = SpaceJackalGame.playHeight + shipH;
        
    }
    
    public void findMoveDirection()
    {
        //first get the direction the entity is pointed
        direction.x = (float)Math.cos(Math.toRadians(rotation));
        direction.y = (float)Math.sin(Math.toRadians(rotation));
        
        if (direction.length() > 0) 
        {
           direction.normalize();
        }
        
        //Then scale it by the current speed to get the velocity
        dx = (float)direction.x * speed;
        dy = (float)direction.y * speed;
    }

    @Override
    public void draw(SpriteBatch batch)
    {
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
    
    private double dx = 3;
    private double dy = 3;
    
    private float rotation;
    private Vector2f direction;
    
    private Texture texture;
    private int imageX;
    private int imageY;
}
