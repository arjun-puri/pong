package me.arjunpuri.pong.utils;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

public class B2DBodyBuilder {
    public static Body createBox(World world, float x, float y, float width, float height) {
        Body body;
        BodyDef bodyDef;

//          body definition
        bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.StaticBody;
        bodyDef.fixedRotation = true;
        bodyDef.position.set(x / B2DConstants.PPM, y / B2DConstants.PPM);

//        creating the body
        body = world.createBody(bodyDef);

//        fixture definition
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(width / 2 / B2DConstants.PPM, height / 2 / B2DConstants.PPM);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 1f;
        body.createFixture(fixtureDef);
//        disposing the shape as its no longer needed
        shape.dispose();

        return body;
    }
}
