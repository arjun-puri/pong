package me.arjunpuri.pong.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;

import me.arjunpuri.pong.GameMain;

public abstract class AbstractScreen implements Screen {

    protected final GameMain game;
    Stage stage;

    public AbstractScreen(final GameMain game) {
        this.game = game;
        this.stage = new Stage();
    }

    public abstract void update(float delta);


    /**
     * Called when the screen should render itself.
     *
     * @param delta The time in seconds since the last render.
     */
    @Override
    public void render(float delta) {
        update(delta);

//        keeping this here for now as per the tutorial
        ScreenUtils.clear(0, 0, 0, 1);
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    /**
     * Called when this screen should release all resources.
     */
    @Override
    public void dispose() {
        stage.dispose();
    }
}
