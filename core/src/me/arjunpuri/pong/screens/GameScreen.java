package me.arjunpuri.pong.screens;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;

import me.arjunpuri.pong.GameMain;
import me.arjunpuri.pong.utils.B2DBodyBuilder;
import me.arjunpuri.pong.utils.B2DConstants;

public class GameScreen extends AbstractScreen {

    OrthographicCamera camera;

//    Box2D variables
    World world;
    Box2DDebugRenderer b2dr;
    Body box;

    public GameScreen(final GameMain game) {
//        using AbstractScreen's constructor here.
        super(game);

        camera = new OrthographicCamera();
        camera.setToOrtho(false, GameMain.V_WIDTH, GameMain.V_HEIGHT);

        game.batch.setProjectionMatrix(camera.combined);
        game.shapeBatch.setProjectionMatrix(camera.combined);

        world = new World(new Vector2(0f, 0f), false);
        b2dr = new Box2DDebugRenderer();
    }

    @Override
    public void show() {
        box = B2DBodyBuilder.createBox(world, camera.viewportWidth / 2, camera.viewportHeight / 2, 8, 8);
    }

    @Override
    public void update(float delta) {
        world.step(1 / GameMain.APP_FPS, 6, 2);
        this.stage.act(delta);
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        b2dr.render(world, camera.combined.cpy().scl(B2DConstants.PPM));
        stage.draw();
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        super.dispose();
        world.dispose();
    }
}
