package compositeobject;

public class Wall extends AtomicObject{
	
	public Wall()
	{
		x = -1;
		y = -1;
		className = "Wall";
	}
	
	public Wall(int x, int y)
	{
		this.x = x;
		this.y = y;
		className = "Wall";
	}
	

}
