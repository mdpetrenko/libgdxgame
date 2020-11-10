package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.gameobjects.Block;
import com.mygdx.game.gameobjects.Projectile;
import com.mygdx.game.gameobjects.Tank;

import java.util.List;

public class MyGdxGame extends ApplicationAdapter {
    private SpriteBatch batch;
    private Tank tank;
    private static Block block;

    // Домашнее задание:
    // 1. Не дайте танку уехать за пределы экрана
    // 2. * Попробуйте добавить мишень и попадание по ней

    @Override
    public void create() {
        batch = new SpriteBatch();
        tank = new Tank();
        block = new Block();
    }

    @Override
    public void render() {
        float dt = Gdx.graphics.getDeltaTime();
        update(dt);
        Gdx.gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        tank.render(batch);
        if (!block.isActive() || isIntersect(block, tank)) {
            block.activate();
        }
        block.render(batch);
        batch.end();
    }

    public void update(float dt) {
        tank.update(dt);
        Projectile projectile = tank.getProjectile();
        if (block.isActive() && isIntersect(block, projectile)) {
            block.deactivate();
            projectile.deactivate();
        }
    }

    // Для простоты расчета в данной задаче все объекты считаем окружностями
    // Сравниваем расстояние между центрами с суммой радиусов двух объектов
    public static boolean isIntersect(GameObject o1, GameObject o2) {
        return Math.sqrt((o1.getX() - o2.getX()) * (o1.getX() - o2.getX())
                + (o1.getY() - o2.getY()) * (o1.getY() - o2.getY())) < (o1.size + o2.size) / 2;
    }

    public static Block getBlock() {
        return block;
    }

    @Override
    public void dispose() {
        batch.dispose();
        tank.dispose();
        block.dispose();
    }
}
