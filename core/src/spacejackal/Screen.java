package spacejackal;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface Screen
{
	public void init(SpaceJackalGame game);

	public void update();
	public void render(SpriteBatch sBatch);

	public boolean onKeyDown(int keyCode);
	public boolean onKeyUp(int keyCode);

	public Screen getNextScreen();
}
