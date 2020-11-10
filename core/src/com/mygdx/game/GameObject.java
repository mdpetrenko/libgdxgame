package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class GameObject {
    protected Texture texture;
    protected float x;
    protected float y;
    protected float width;
    protected float height;
    protected float scale;
    protected float sizeX;
    protected float sizeY;

    public GameObject(String texture) {
        this.texture = new Texture(texture);
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, x, y, sizeX, sizeY);
    }

    public void dispose() {
        texture.dispose();
    }

    public boolean isIntersect(GameObject o) {
        return this.x <= o.x + o.sizeX
                && this.x + this.sizeX >= o.x
                && this.y <= o.y + o.sizeY
                && this.y + this.sizeY >= o.y;
    }
}
