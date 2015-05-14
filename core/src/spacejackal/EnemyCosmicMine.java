package spacejackal;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class EnemyCosmicMine extends Enemy
{
    private static String shipImage = "Bosconian_Enemy_Cosmic_Mine.png";
    private static int mineW = 126;
    private static int mineH = 119;
    
    private double dx = 3;
    private double dy = 3;
    
    private float rotation;

    
    private Texture texture;
    private int imageX;
    private int imageY;
    
    public EnemyCosmicMine(double x, double y)
    {
        super(x, y);
        if (texture == null)
            texture = new Texture(Gdx.files.internal("Bosconian_Enemy_Cosmic_Mine.png"));
        
    }

     @Override
    public int getCenterX() {
        return (int) (mineW / 2 + x);
    }

    @Override
    public int getCenterY() {
        return (int) (mineH / 2 + y);
    }

    @Override
    public int getRadius() {
        return mineW / 2 - 5;
    }
    
    @Override
    public void draw(SpriteBatch batch)
    {
        float drawX = (float)(x + mineW / 2);
		float drawY = (float)(y + mineH / 2);
		batch.draw(texture, 
                drawX, drawY,
                (mineW / 2), (mineH / 2),
                mineW, mineH,
                1.0f, 1.0f,
                rotation,
                imageX * mineW, imageY * mineH,
                mineW, mineH,
                false, false);    
    }

    @Override
    public void handleKey(int keyCode)
    {
        
    }

    @Override
    public void update(double shipXMotion, double shipYMotion)
    {
        super.update(shipXMotion, shipYMotion);
    }
    
}