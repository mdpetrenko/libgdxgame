package com.mygdx.game.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.mygdx.game.GameObject;

public class Tank extends GameObject {
    private Texture textureWeapon;
    private float speed;
    private float angle;
    private float angleWeapon;
    private Projectile projectile;

    public Tank() {
        super("tank.png");
        this.textureWeapon = new Texture("weapon.png");
        this.projectile = new Projectile();
        this.speed = 240.0f;
        this.scale = 3.0f;
        this.width = 40;
        this.x = 60;
        this.y = 60;
    }

    public void update(float dt) {
        float dx = speed * MathUtils.cosDeg(angle) * dt;
        float dy = speed * MathUtils.sinDeg(angle) * dt;
        float df = 90.0f * dt;
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
                angle -= df;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
                angle += df;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.W) && positionIsValid(x + dx, y + dy)) {
                x += dx;
                y += dy;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S) && positionIsValid(x + dx, y + dy)) {
                x -= dx * 0.2f;
                y -= dy * 0.2f;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.Q)) {
            angleWeapon += 90.0f * dt;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.E)) {
            angleWeapon -= 90.0f * dt;
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE) && !projectile.isActive()) {
            projectile.shoot(x + 16 * scale * MathUtils.cosDeg(angle), y + 16 * scale * MathUtils.sinDeg(angle), angle + angleWeapon);
        }
        if (projectile.isActive()) {
            projectile.update(dt);
        }
    }

    public Projectile getProjectile() {
        return projectile;
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, x - 20, y - 20, 20, 20, 40, 40, scale, scale, angle, 0, 0, 40, 40, false, false);
        batch.draw(textureWeapon, x - 20, y - 20, 20, 20, 40, 40, scale, scale, angle + angleWeapon, 0, 0, 40, 40, false, false);
        if (projectile.isActive()) {
            projectile.render(batch);
        }
    }

    @Override
    public void dispose() {
        super.dispose();
        projectile.dispose();
    }

    private boolean positionIsValid(float x, float y) {
        return !(x < 60) && !(y < 60) && !(x > 1220) && !(y > 660);
    }
}
