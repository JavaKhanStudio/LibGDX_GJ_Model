package jks.amain.test;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;

import static jks.physic.FVars_Physic.* ;  
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

public class Physics1 extends ApplicationAdapter {
    SpriteBatch batch;
    Sprite sprite;
    Texture img;
    World world;
    Body body;
    OrthographicCamera cam ;
    
    @Override
    public void create() {
    	OrthographicCamera cam = new OrthographicCamera() ;
    	cam.setToOrtho(false, 320/PPM, 240/PPM);
        batch = new SpriteBatch();
        img = new Texture("badlogic.jpg");
        world = new World(new Vector2(0, -9.81f), true);
        // Center the sprite in the top/middle of the screen
        sprite = new Sprite(img);
        sprite.setPosition(100/PPM, 100/PPM);
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.gravityScale = 1 ; 
        bodyDef.position.set(sprite.getX()/PPM, sprite.getY()/PPM);
        body = world.createBody(bodyDef);

        // Now define the dimensions of the physics shape
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(sprite.getWidth()/2/PPM, sprite.getHeight()/2/PPM);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 1f;
        fixtureDef.friction = 0.4f;

        Fixture fixture = body.createFixture(fixtureDef);

        // Shape is the only disposable of the lot, so get rid of it
        shape.dispose();
        
    }

    @Override
    public void render() {

        // Advance the world, by the amount of time that has elapsed since the last frame
        // Generally in a real game, dont do this in the render loop, as you are  tying the physics
        // update rate to the frame rate, and vice versa
        world.step(Gdx.graphics.getDeltaTime(), 6, 2);

        // Now update the spritee position accordingly to it's now updated Physics body
        sprite.setPosition(body.getPosition().x, body.getPosition().y);

        // You know the rest...
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(sprite, sprite.getX(), sprite.getY());
        batch.end();
    }

    @Override
    public void dispose() {
        // Hey, I actually did some clean up in a code sample!
        img.dispose();
        world.dispose();
    }
}