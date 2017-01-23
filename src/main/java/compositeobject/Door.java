package compositeobject;

public class Door extends AtomicObject{
	
	public Door()
	{
		super();
		//className = "Door";
		type = 5;
	}
	
	public Door(int x, int y)
	{
		super(x, y);
		className = "Door";
	}
	
	public Door(int x, int y, String name)
	{
		super(x, y, name);
		className = "Door";
	}

}
