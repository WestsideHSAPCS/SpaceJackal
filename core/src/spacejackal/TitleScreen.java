package spacejackal;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TitleScreen implements Screen
{
	@Override
	public void init(SpaceJackalGame game)
	{
	}

	@Override
	public void update()
	{
	}

	@Override
	public void render(SpriteBatch sBatch)
	{
		sBatch.draw(SpaceJackalGame.Tex.TITLE.texture,
				0, 0, SpaceJackalGame.playWidth, SpaceJackalGame.playHeight,
				0, 0, SpaceJackalGame.playWidth, SpaceJackalGame.playHeight,
				false, true);
	}

    @Override
    public boolean onKeyDown(int keyCode)
    {
        if (keyCode == Keys.SPACE)
            next = true;
        
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
        if (next)
            return new GameScreen();
        
		return null;
	}
    
    private boolean next = false;
}
