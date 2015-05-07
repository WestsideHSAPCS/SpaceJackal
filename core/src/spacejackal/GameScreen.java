package spacejackal;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class GameScreen implements Screen
{

    @Override
    public void init(SpaceJackalGame game)
    {
        sprites = new ArrayList<>();
        newSprites = new ArrayList<>();
        
        sprites.add(new Ship());
    }

    @Override
    public void update()
    {
        for (Sprite s : sprites)
            s.update();
        
       // checkCollisions();
        
       // removeDeadSprites();
        
        sprites.addAll(newSprites);
        newSprites.clear();
    }
    
    public void addSprite(Sprite s)
    {
        newSprites.add(s);
    }
    
    private void checkCollisions()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void removeDeadSprites()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void render(SpriteBatch sBatch)
    {
        sBatch.draw(SpaceJackalGame.Tex.BACKGROUND.texture, 0, 0, 
                SpaceJackalGame.playWidth, 
                SpaceJackalGame.playHeight);
        
        for (Sprite s : sprites)
            s.draw(sBatch);
    }

    @Override
    public boolean onKeyDown(int keyCode)
    {
        for (Sprite s : sprites)
            s.handleKey(keyCode);
        
        if (keyCode == Keys.ESCAPE)
            Gdx.app.exit();
        
        return true;
    }

	@Override
	public boolean onKeyUp(int keyCode)
	{
		return true;
	}

	@Override
    public Screen getNextScreen()
    {
        return null;
    }
    
    private ArrayList<Sprite> sprites;
    private ArrayList<Sprite> newSprites;
}
