package me.arjunpuri.pong;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;

import me.arjunpuri.pong.managers.GameScreenManager;

public class GameMain extends Game {

//	Application variables
	public static String APP_TITLE = "Pong game";
	public static int APP_DESKTOP_WIDTH = 720;
	public static int APP_DESKTOP_HEIGHT = 420;
	public static int APP_FPS = 60;

//	Game variables
	public static int V_WIDTH = 720;
	public static int V_HEIGHT = 420;

//	Managers
	public AssetManager assets;
	public GameScreenManager gsm;

//	Batches
	public SpriteBatch batch;
	public ShapeRenderer shapeBatch;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		shapeBatch = new ShapeRenderer();

//		setup managers
		assets = new AssetManager();
		gsm = new GameScreenManager(this);
	}

	@Override
	public void render () {
		super.render();

		if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
			Gdx.app.exit();
		}
	}
	
	@Override
	public void dispose () {
		super.dispose();
		batch.dispose();
		shapeBatch.dispose();
		assets.dispose();
		gsm.dispose();
	}
}
