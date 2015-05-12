package spacejackal;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class GameScreen implements Screen
{
    @Override
    public void init(SpaceJackalGame game)
    {
        othersprites = new ArrayList<>();
        newSprites = new ArrayList<>();
        
        ship = new Ship();
    }

    @Override
    public void update()
    {
		// First update the ship.  It doesn't _move_, but it computes its motion
		// and all the other sprites move relative to it.
		ship.update(0, 0);

		double shipXMove = ship.getLastXMotion();
		double shipYMove = ship.getLastYMotion();

		// Now update the other sprites, relative to the ship.
		for (Sprite s : othersprites)
            s.update(shipXMove, shipYMove);
        
       // checkCollisions();
        
       // removeDeadSprites();
        
        othersprites.addAll(newSprites);
        newSprites.clear();
    }
    
    public void addSprite(Sprite s)
    {
        newSprites.add(s);
    }
    
    private void checkCollisions()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void removeDeadSprites()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void render(SpriteBatch sBatch)
    {
        sBatch.draw(SpaceJackalGame.Tex.BACKGROUND.texture, 0, 0, 
                SpaceJackalGame.playWidth, 
                SpaceJackalGame.playHeight);
        
		ship.draw(sBatch);
        for (Sprite s : othersprites)
            s.draw(sBatch);
    }

    @Override
    public boolean onKeyDown(int keyCode)
    {
		ship.handleKey(keyCode);
        for (Sprite s : othersprites)
            s.handleKey(keyCode);
        
        if (keyCode == Keys.ESCAPE)
            Gdx.app.exit();
        if (keyCode == Keys.R)
            othersprites.add(new Rock(50,50));
        if (keyCode == Keys.E)
            othersprites.add(new EnemyBaseShip(50, 50));
        if (keyCode == Keys.C)
            othersprites.add(new EnemyCosmicMine(50, 50));
        return true;
    }

	@Override
	public boolean onKeyUp(int keyCode)
	{
		return true;
	}

	@Override
    public Screen getNextScreen()
    {
        return null;
    }

	private Ship ship;
    private ArrayList<Sprite> othersprites;
    private ArrayList<Sprite> newSprites;
}
