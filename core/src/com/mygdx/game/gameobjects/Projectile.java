package com.mygdx.game.gameobjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.mygdx.game.GameObject;

public class Projectile extends GameObject {
    private float vx;
    private float vy;
    private float speed;
    private boolean active;

    public boolean isActive() {
        return active;
    }

    public void deactivate() {
        active = false;
    }

    public Projectile() {
        super("projectile.png");
        this.speed = 600.0f;
        this.width = 16.0f;
        this.scale = 2;
    }

    public void shoot(float x, float y, float angle) {
        this.x = x;
        this.y = y;
        this.vx = speed * MathUtils.cosDeg(angle);
        this.vy = speed * MathUtils.sinDeg(angle);
        this.active = true;
    }

    public void update(float dt) {
        x += vx * dt;
        y += vy * dt;
        if (x < 0 || x > 1280 || y < 0 || y > 720) {
            deactivate();
        } else {
        }
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, x - 8, y - 8, 8, 8, 16, 16, scale, scale, 0, 0, 0, 16, 16, false, false);
    }
}
