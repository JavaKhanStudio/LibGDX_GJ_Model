package jks.amain.test;

import static jks.physic.FVars_Physic.PPM;
import static jks.physic.Gvars_Physic.world;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.Joint;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;

import testing.BoxBodyBuilder;
import testing.RevoluteJoint;

/*
public class Poubelle {

}

Body pivot ; 
    Body spike ; 
    public void testBall()
    {
    	BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(1000/PPM,1000/PPM);
        bodyDef.fixedRotation = true ; 
        bodyDef.gravityScale = 2 ; 
        
        pivot = world.createBody(bodyDef);
       
       
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(200/PPM,100/PPM);
        
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 1f;
        fixtureDef.friction = 0f;
        fixtureDef.restitution = 0.0f;
        
        Fixture fixture_Main = pivot.createFixture(fixtureDef);
    	
        
//    	pivot = bodyFactory.CreateCircleBody(world, BodyType.StaticBody, 200, 200, 30);
    	spike = BoxBodyBuilder.CreateCircleBody(world, BodyType.DynamicBody, 200, 800, 20);
		MakeJoint();
    }
    
    void MakeJoint()
    {
		RevoluteJoint j=new RevoluteJoint(pivot,spike,false);
		j.SetAnchorA(BoxBodyBuilder.ConvertToBox(0), BoxBodyBuilder.ConvertToBox(0));
		j.SetAnchorB(BoxBodyBuilder.ConvertToBox(100), BoxBodyBuilder.ConvertToBox(0));
		j.SetMotor(10, 360);
		Joint joint=j.CreateJoint(world);
	}

 public void buildCube()
    {
    	 img = new Texture("badlogic.jpg");
    	 
         // Center the sprite in the top/middle of the screen
         sprite = new Sprite(img);
//         sprite.setSize(sprite.getWidth()/PPM, sprite.getHeight()/PPM);
         sprite.setPosition(1000, 1000);
         BodyDef bodyDef = new BodyDef();
         bodyDef.type = BodyDef.BodyType.DynamicBody;
         bodyDef.gravityScale = 1 ; 
         bodyDef.position.set(sprite.getX()/PPM, sprite.getY()/PPM);
         cubeBody = world.createBody(bodyDef);
         // Now define the dimensions of the physics shape
         PolygonShape shape = new PolygonShape();
         shape.setAsBox(sprite.getWidth()/2/PPM, sprite.getHeight()/2/PPM);

         FixtureDef fixtureDef = new FixtureDef();
         fixtureDef.shape = shape;
         fixtureDef.density = 1f;
         fixtureDef.friction = 0.4f;

         Fixture fixture = cubeBody.createFixture(fixtureDef);
    }
    




*/
