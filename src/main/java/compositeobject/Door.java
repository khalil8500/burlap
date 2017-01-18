package compositeobject;

public class Door extends AtomicObject{
	
	public Door()
	{
		x = -1;
		y = -1;
		className = "Door";
	}
	
	public Door(int x, int y)
	{
		this.x = x;
		this.y = y;
		className = "Door";
	}

}
