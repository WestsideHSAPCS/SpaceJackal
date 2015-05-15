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
        return (int)(x + baseW / 2);
    }

    @Override
    public int getCenterY()
    {
        return (int)(y + baseH / 2);
    }

    @Override
    public int getRadius()
    {
        return 50;
    }
    
    @Override
    public void draw(SpriteBatch batch)
    {
        
		batch.draw(texture, 
                (float)x, (float)y,
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
    public void handleCollision(Sprite other) {
        die = true;
    }

    
    @Override
    public void update(double shipXMotion, double shipYMotion)
    {
        super.update(shipXMotion, shipYMotion);
    }
    
}