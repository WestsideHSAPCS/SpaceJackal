package spacejackal;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class EnemyBaseShip extends Enemy
{
    private static String shipImage = "Bosconian_Enemy_Base.png";
    private static int baseW = 268;
    private static int baseH = 296;
    
    private double dx = 3;
    private double dy = 3;
    
    private float rotation;

    
    private Texture texture;
    private int imageX;
    private int imageY;
    
    
    public EnemyBaseShip(double x, double y)
    {
        super(x, y);
        if (texture == null)
            texture = new Texture(Gdx.files.internal("Bosconian_Enemy_Base.png"));
        
    }

    @Override
    public int getCenterX()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.    }
    }

    @Override
    public int getCenterY()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.    }
    }

    @Override
    public int getRadius()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.    }
    }
    
    @Override
    public void draw(SpriteBatch batch)
    {
        float drawX = (float)(x + baseW / 2);
		float drawY = (float)(y + baseH / 2);
		batch.draw(texture, 
                drawX, drawY,
                (baseW / 2), (baseH / 2),
                baseW, baseH,
                1.0f, 1.0f,
                rotation,
                imageX * baseW, imageY * baseH,
                baseW, baseH,
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