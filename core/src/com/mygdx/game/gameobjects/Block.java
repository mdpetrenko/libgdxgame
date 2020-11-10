package com.mygdx.game.gameobjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.mygdx.game.GameObject;

public class Block extends GameObject {

    private boolean active;

    public Block() {
        super("block.png");
        this.scale = 5;
        this.active = true;
        this.width = 20;
        this.height = 20;
        sizeX = width * scale;
        sizeY = height * scale;
        setCoordinates();
    }

    public void setCoordinates() {
        this.x = MathUtils.random(0f, 1280 - sizeX);
        this.y = MathUtils.random(0f, 720 - sizeY);
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
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
}
