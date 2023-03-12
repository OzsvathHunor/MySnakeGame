package com.mygdx.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.GlobalConstant;


public class PlayScreen implements Screen {
    private Texture snake;
    private Sprite sprite;
    private SpriteBatch spriteBatch;
    private Float x = 0f;
    private Float y = 0f;


    @Override
    public void show() {
        spriteBatch = new SpriteBatch();
        snake = new Texture(Gdx.files.internal("snake.png"));
        sprite = new Sprite(snake);
        sprite.setPosition(50,50);
        sprite.setSize(50,50);
        sprite.setRotation(45);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,1,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) if (x + snake.getWidth() < GlobalConstant.WIDTH)x += 20;
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) if (x > 0) x -= 20;
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) if (y + snake.getHeight() < GlobalConstant.HEIGHT) y += 20;
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) if (y > 0) y -= 20;

        spriteBatch.begin();
        spriteBatch.draw(snake,x,y);
        spriteBatch.end();
    }

    @Override
    public void resize(int width, int height) {

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
        spriteBatch.dispose();
    }
}
