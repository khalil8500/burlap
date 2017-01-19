package compositeobject;

import java.util.ArrayList;
import java.util.List;

public class Wall {
	
	private List<AtomicObject> doors = new ArrayList<AtomicObject>();
	private int startX, startY, endX, endY;
	
	public Wall()
	{
		startX = -1;
		startY = -1;
		endX = -1;
		endY = -1;
	}
	
	public Wall(int startX, int startY, int endX, int endY)
	{
		this.startX = startX;
		this.startY = startY;
		this.endX = endX;
		this.endY = endY;
	}
	
	public Wall(int startX, int startY, int endX, int endY, List<AtomicObject> doors)
	{
		this.startX = startX;
		this.startY = startY;
		this.endX = endX;
		this.endY = endY;
		this.doors = doors;
	}
	
	public int getStartX()
	{
		return startX;
	}
	
	public int getStartY()
	{
		return startY;
	}
	
	public int getEndX()
	{
		return endX;
	}
	
	public int getEndY()
	{
		return endY;
	}
	
	public List<AtomicObject> getDoors()
	{
		return doors;
	}
	
	public void setStartX(int x)
	{
		startX = x;
	}
	
	public void setStartY(int y)
	{
		startY = y;
	}
	
	public void setEndX(int x)
	{
		endX = x;
	}
	
	public void setEndY(int y)
	{
		endY = y;
	}
	
	public void setDoors(List<AtomicObject> doors)
	{
		this.doors = doors;
	}

}
