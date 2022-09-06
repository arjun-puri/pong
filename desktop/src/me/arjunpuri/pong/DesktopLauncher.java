package me.arjunpuri.pong;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(GameMain.APP_FPS);
		config.setTitle(GameMain.APP_TITLE);
		config.setWindowedMode(GameMain.APP_DESKTOP_WIDTH, GameMain.APP_DESKTOP_HEIGHT);
		new Lwjgl3Application(new GameMain(), config);
	}
}
