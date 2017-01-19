package compositeobject;

public class Block extends AtomicObject{
	
	public Block()
	{
		x = -1;
		y = -1;
		className = "Block";
	}
	
	public Block(int x, int y)
	{
		this.x = x;
		this.y = y;
		className = "Block";
	}
	

}
