package compositeobject;

public abstract class AtomicObject {
	
	protected String className;
	protected int x;
	protected int y;
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public void setX(int val)
	{
		x = val;
	}
	
	public void setY(int val)
	{
		y = val;
	}
	
	public String getClassName()
	{
		return className;
	}

}
