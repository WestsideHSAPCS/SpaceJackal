/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacejackal;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 *
 * @author Ben
 */
public class Rock extends Enemy{

    public Rock(double x, double y) {
        super(x, y);
        if (texture == null)
            texture = new Texture(Gdx.files.internal("Rock.png"));
    }

    @Override
    public int getCenterX() {
        return (int) (rockW / 2 + x);
    }

    @Override
    public int getCenterY() {
        return (int) (rockH / 2 + y);
    }

    @Override
    public int getRadius() {
        return rockW / 2 - 5;
    }

    @Override
    public void update(double shipXMotion, double shipYMotion) {
        super.update(shipXMotion, shipYMotion); //To change body of generated methods, choose Tools | Templates.
        rotation += 3;
    }
    
    @Override
    public void draw(SpriteBatch batch) {
        
        batch.draw(texture, 
                (float)x, (float)y,
                (rockW / 2), (rockH / 2),
                rockW, rockH,
                1.0f, 1.0f,
                rotation,
                imageX * rockW, imageY * rockH,
                rockW, rockH,
                false, false);
    }

    @Override
    public void handleKey(int keyCode) {
    }

    @Override
    public void handleCollision(Sprite other) {
        die = true;
    }
    
    
    private Texture texture;
    private int imageX;
    private int imageY;
    private float rotation;
    private static final int rockH = 40;
    private static final int rockW = 48;
}
