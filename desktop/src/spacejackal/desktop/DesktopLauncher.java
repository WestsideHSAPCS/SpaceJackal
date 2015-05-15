package spacejackal.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import spacejackal.SpaceJackalGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = SpaceJackalGame.playWidth;
		config.height = SpaceJackalGame.playHeight;
		config.title = "Space Jackal";
		new LwjglApplication(new SpaceJackalGame(), config);
}
}
