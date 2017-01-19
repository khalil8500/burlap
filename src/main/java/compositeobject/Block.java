package compositeobject;

public class Block extends AtomicObject{
	
	public Block()
	{
		super();
		className = "Block";
	}
	
	public Block(int x, int y)
	{
		super(x, y);
		className = "Block";
	}
	
	public Block(int x, int y, String name)
	{
		super(x, y, name);
		className = "Block";
	}
	

}
