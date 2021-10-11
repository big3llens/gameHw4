package com.star.app.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.star.app.game.helpers.ObjectPool;
import com.star.app.screen.utils.Assets;

public class FirstAidKitController extends ObjectPool<FirstAidKit> {
    private GameController gc;
    private TextureRegion texture;
    private Vector2 position;

    @Override
    protected FirstAidKit newObject() {
        return new FirstAidKit(gc);
    }

    public FirstAidKitController(GameController gc) {
        this.gc = gc;
        this.position = new Vector2(0,0);
        this.texture = Assets.getInstance().getAtlas().findRegion("heal");
    }

    public void render(SpriteBatch batch) {
        for (int i = 0; i < activeList.size(); i++) {
            FirstAidKit firstAidKit = activeList.get(i);
            batch.draw(texture, firstAidKit.getPosition().x - 16, firstAidKit.getPosition().y - 16);
        }
    }

    public void setup(float x, float y){
        getActiveElement().activate(x, y);
    }

    public void update(float dt) {
        for (int i = 0; i < activeList.size(); i++) {
            activeList.get(i).update(dt);
        }
        checkPool();
    }
}
