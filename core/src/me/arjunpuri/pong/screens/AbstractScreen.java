package me.arjunpuri.pong.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;

import me.arjunpuri.pong.managers.GameScreenManager;

public abstract class AbstractScreen implements Screen {

    protected final GameScreenManager gsm;
    Stage stage;

    public AbstractScreen(final GameScreenManager gsm) {
        this.gsm = gsm;
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
        ScreenUtils.clear(1, 0, 0, 1);
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
