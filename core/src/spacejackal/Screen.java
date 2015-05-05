package spacejackal;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface Screen
{
	public void init(SpaceJackalGame game);

	public void update(SpaceJackalGame game);
	public void render(SpriteBatch sBatch);

	public Screen getNextScreen();
}
