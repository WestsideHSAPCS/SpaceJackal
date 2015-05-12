package spacejackal;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class SpaceJackalGame extends ApplicationAdapter
{
	public static final int playWidth = 800;
	public static final int playHeight = 600;

	public static enum Tex
	{
		TITLE("titlescreen.png"),
        BACKGROUND("game.png");

		Tex(String filename)
		{
			this.filename = filename;
		}

		public final String filename;
		public Texture texture;
	}

	@Override
	public void create()
	{
		batch = new SpriteBatch();
		loadTextures();

		currScreen = new TitleScreen();
		currScreen.init(this);
        
        InputProcessor ip = new InputAdapter()
		{ 
			@Override
			public boolean keyDown(int keycode)
			{
				return currScreen.onKeyDown(keycode);
			}

			@Override
			public boolean keyUp(int keycode)
			{
				return currScreen.onKeyUp(keycode);
			}
		};
		Gdx.input.setInputProcessor(ip);
        
		nextUpdateTime = System.nanoTime() + nanosPerUpdate;
	}

	@Override
	public void resize(int width, int height)
	{
		// Constrain the minimum size of the projection, even if the window
		// is resized to zero (avoid divide-by-zero errors...)
		if (width < 10)
			width = 10;
		if (height < 10)
			height = 10;

		// Compute projection width and height that maintain the aspect ratio
		// of the actual window, while ensuring that the actual projection fits
		// entirely within the window.
		double actualAspect = (double)width / (double)height;
		double idealAspect = (double)playWidth / (double)playHeight;

		if (actualAspect > idealAspect)
		{
			// The window is too wide.  We'll have to letter-box with free
			// space on the left and right.
			projectionWidth = width * playHeight / height;
			projectionHeight = playHeight;
			projOffsetX = (projectionWidth - playWidth) / 2;
			projOffsetY = 0;

			int playAreaWidth = height * playWidth / playHeight;
			int letterbox = width - playAreaWidth;

			clipX = letterbox / 2;
			clipY = 0;
			clipW = playAreaWidth;
			clipH = height;
		}
		else
		{
			// The window is either too tall or just right.  We'll letter-box,
			// if necessary, on the top and bottom.
			projectionWidth = playWidth;
			projectionHeight = height * playWidth / width;
			projOffsetX = 0;
			projOffsetY = (projectionHeight - playHeight) / 2;

			int playAreaHeight = width * playHeight / playWidth;
			int letterbox = height - playAreaHeight;

			clipX = 0;
			clipY = letterbox / 2;
			clipW = width;
			clipH = playAreaHeight;
		}

		// Now set up the camera based on the computed projection
		camera = new OrthographicCamera();
		camera.setToOrtho(true, projectionWidth, projectionHeight);
		camera.translate(-projOffsetX, -projOffsetY);
	}

	@Override
	public void render()
	{
		// Keep a constant update rate regardless of render rate
		while (System.nanoTime() - nextUpdateTime > 0)
		{
			currScreen.update();
			// Is it time to switch screens yet?

			Screen next = currScreen.getNextScreen();
			if (next != null)
			{
				next.init(this);
				currScreen = next;
			}

			// Update desired time for next frame
			nextUpdateTime += nanosPerUpdate;
		}

		// Now draw.  First fill the background with black...
		Gdx.gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		// Next set up a clip region, if needed
		if (clipX > 0 || clipY > 0)
		{
			Gdx.gl.glEnable(GL20.GL_SCISSOR_TEST);
			Gdx.gl.glScissor(clipX, clipY, clipW, clipH);
		}

		// Then have the current screen do the actual drawing
		camera.update();
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		currScreen.render(batch);
		batch.end();

		// Disable the clip region when we're done drawing
		Gdx.gl.glDisable(GL20.GL_SCISSOR_TEST);
	}

	private void loadTextures()
	{
		for (Tex tex : Tex.values())
			tex.texture = new Texture(Gdx.files.internal(tex.filename));
	}

	// Frame rate controls
	private static final int frameRate = 60;
	private static final long nanosPerUpdate = 1000000000 / frameRate;
	private long nextUpdateTime;

	// Game status information
	private Screen currScreen;

	// Rendering data
	private OrthographicCamera camera;
	private int projectionWidth;
	private int projectionHeight;
	private int projOffsetX;
	private int projOffsetY;
	private int clipX;
	private int clipY;
	private int clipW;
	private int clipH;
	private SpriteBatch batch;
}
