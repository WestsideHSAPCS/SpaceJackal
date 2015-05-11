package spacejackal;

public abstract class Enemy extends Sprite{

	public Enemy() {
	}

	public Enemy(double x, double y)
    {
        this.x = x;
        this.y = y;
    }
	
	@Override
	public void handleCollision(Sprite other) {
		super.handleCollision(other); //To change body of generated methods, choose Tools | Templates.
	}
	
	
	
}
