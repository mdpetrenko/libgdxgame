package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class GameObject {
    protected Texture texture;
    protected float x;
    protected float y;
    protected float width;
    protected float scale;
    protected float size;

    public GameObject(String texture) {
        this.texture = new Texture(texture);
        this.size = width * scale;
    }

    public void dispose() {
        texture.dispose();
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}
