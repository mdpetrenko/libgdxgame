package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.gameobjects.Block;
import com.mygdx.game.gameobjects.Tank;

import java.util.ArrayList;
import java.util.List;

public class MyGdxGame extends ApplicationAdapter {
    private SpriteBatch batch;
    private Tank tank;
    private List<Block> blocks;

    // Домашнее задание:
    // 1. Не дайте танку уехать за пределы экрана
    // 2. * Попробуйте добавить мишень и попадание по ней

    @Override
    public void create() {
        batch = new SpriteBatch();
        tank = new Tank();
        blocks = new ArrayList<>();
        blocks.add(new Block());
    }

    @Override
    public void render() {
        float dt = Gdx.graphics.getDeltaTime();
        update(dt);
        Gdx.gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        tank.render(batch);
        for (Block block : blocks) {
            block.render(batch);
        }
        batch.end();
    }

    public void update(float dt) {
        tank.update(dt);
//        if (Gdx.input.justTouched()) {
//            System.out.println(Gdx.input.getX());
//            System.out.println(Gdx.graphics.getHeight() - Gdx.input.getY());
//        }
    }

    @Override
    public void dispose() {
        batch.dispose();
        tank.dispose();
        for (Block block : blocks) {
            block.dispose();
        }
    }
}
