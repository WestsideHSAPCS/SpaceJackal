package spacejackal;

public abstract class Enemy extends Sprite{

	public Enemy(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

	@Override
	public void update(double shipXMotion, double shipYMotion){
		x -= shipXMotion;
		y -= shipYMotion;
	}
	
	
	
	@Override
	public void handleCollision(Sprite other) {
		super.handleCollision(other); //To change body of generated methods, choose Tools | Templates.
	}
	
	
	
}
