package com.star.app.game;


import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.star.app.game.helpers.Poolable;
import com.star.app.screen.ScreenManager;
import com.star.app.screen.utils.Assets;

public class FirstAidKit implements Poolable {
    private GameController gc;
    private boolean active;
    private Vector2 position;
    private Circle hitArea;

    @Override
    public boolean isActive() {
        return active;
    }

    public FirstAidKit(GameController gc) {
        this.gc = gc;
        this.position = new Vector2(0,0);
        this.active = false;
        this.hitArea = new Circle(position, 45);
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
