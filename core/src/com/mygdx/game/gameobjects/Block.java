package com.mygdx.game.gameobjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.mygdx.game.GameObject;

public class Block extends GameObject {

    private boolean active;

    public Block() {
        super("block.png");
        this.scale = 4;
        this.active = true;
        this.width = 20;
        size = width * scale;
        setCoordinates();
    }

    public void setCoordinates() {
        this.x = MathUtils.random(30f, 1280 - size);
        this.y = MathUtils.random(30f, 720 - size);
    }

    public boolean isActive() {
        return active;
    }

    public void activate() {
        active = true;
        setCoordinates();
    }

    public void deactivate() {
        active = false;
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, x - 30, y - 30, 10, 10, 20, 20, scale, scale, 0, 0, 0, 20, 20, false, false);
    }
}
