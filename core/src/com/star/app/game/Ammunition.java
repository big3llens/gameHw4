package com.star.app.game;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.star.app.game.helpers.Poolable;

public class Ammunition implements Poolable {

    private GameController gc;
    private boolean active;
    private Vector2 position;
    private Circle hitArea;

    @Override
    public boolean isActive() {
        return active;
    }

    public Ammunition(GameController gc) {
        this.gc = gc;
        this.position = new Vector2(0,0);
        this.active = false;
        this.hitArea = new Circle(position, 60);
    }

    public Vector2 getPosition() {
        return position;
    }

    public Circle getHitArea() {
        return hitArea;
    }

    public void activate(float x, float y) {
        position.set(x, y);
        active = true;
    }

    public void deactivate() {
        active = false;
    }

    public void update(float dt) {
        position.y -= 50 * dt;
        hitArea.setPosition(position);
        if (position.y < - 100) deactivate();
    }
}
