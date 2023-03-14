package com.mygdx.game.screen;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;

import com.mygdx.game.MySnakeGame;



public class MenuScreen implements Screen {

    private Stage stage;
    private final MySnakeGame game;


    public MenuScreen(MySnakeGame game) {
        this.game = game;
    }


    @Override
    public void show() {
        stage = new Stage();
        TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("skin/dark-hdpi/Holo-dark-hdpi.atlas"));
        Skin skin = new Skin(Gdx.files.internal("skin/dark-hdpi/Holo-dark-hdpi.json"), atlas);
        Texture snakeImg = new Texture(Gdx.files.internal("littleSnake.png"));
        Image image = new Image(snakeImg);

        Button startButton = new Button(skin);
        startButton.add("Start");
        startButton.setSize(540,240);
        startButton.setPosition(600,480);
        startButton.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent ev, float x, float y, int p, int b){
                game.setScreen(new PlayScreen());
                return true;
            }
        });



        stage.addActor(startButton);
        stage.addActor(image);
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
            Gdx.gl.glClearColor(1,1,1,1);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
            update();

            stage.act(Gdx.graphics.getDeltaTime());
            stage.draw();
    }

    public void update(){
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) game.setScreen(new PlayScreen());
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
        stage.dispose();
    }
}