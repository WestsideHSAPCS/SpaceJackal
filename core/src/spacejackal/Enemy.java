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
                
                if(x < -virtualWidth / 2){
                    x = -x;
                }
				else if(x > virtualWidth / 2){
                    x = -x;
                }
                if(y > virtualHeight / 2){
                    y = -y;
                }
				else if(y < -virtualHeight / 2){
                    y = -y;
                }
	}
	
	
	
	@Override
	public void handleCollision(Sprite other) {
		super.handleCollision(other); //To change body of generated methods, choose Tools | Templates.
	}
	
	static final int virtualWidth = 2000;
	static final int virtualHeight = 2000;
}
