package spacejackal;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TitleScreen implements Screen
{
	@Override
	public void init(SpaceJackalGame game)
	{
	}

	@Override
	public void update(SpaceJackalGame game)
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
	public Screen getNextScreen()
	{
		return null;
	}
}
