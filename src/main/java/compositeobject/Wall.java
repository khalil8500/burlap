package compositeobject;

import java.util.ArrayList;
import java.util.List;

public class Wall {
	
	private ArrayList<AtomicObject> doors = new ArrayList<AtomicObject>();
	private Point start, end;
	private int length;
	
	public Wall()
	{
		this.start = new Point(-1,-1);
		this.end = new Point(-1,-1);
	}
	
	public Wall(int startX, int startY, int endX, int endY, int length)
	{
		this.start = new Point(startX,startY);
		this.end = new Point(endX,endY);
		this.length = length;
	}
	
	public Wall(int startX, int startY, int endX, int endY, int length, ArrayList<AtomicObject> doors)
	{
		this.start = new Point(startX,startY);
		this.end = new Point(endX,endY);
		this.length = length;
		this.doors = doors;
	}

	public Wall(Point start, Point end, int length)
	{
		this.start = start;
		this.end = end;
		this.length = length;
	}

	public Wall(Point start, Point end, int length, ArrayList<AtomicObject> doors)
	{
		this.start = start;
		this.end = end;
		this.length = length;
		this.doors = doors;
	}

	public Point getPoint(int i)
	{
		if(i == 0)
			return start;
		if(i == 1)
			return end;
		return null;
	}
	public Point getStart(){ return start;}

	public Point getEnd(){
		return end;
	}

	public int getStartX()
	{
		return start.getX();
	}
	
	public int getStartY()
	{
		return start.getY();
	}
	
	public int getEndX()
	{
		return end.getX();
	}
	
	public int getEndY()
	{
		return end.getY();
	}
	
	public int length()
	{
		return length;
	}
	
	public List<AtomicObject> getDoors()
	{
		return doors;
	}
	
	public void setStartX(int x) {	start.setX(x);	}
	
	public void setStartY(int y)
	{
		start.setY(y);
	}
	
	public void setEndX(int x)
	{
		end.setX(x);
	}
	
	public void setEndY(int y)
	{
		end.setY(y);
	}
	
	public void setDoors(ArrayList<AtomicObject> doors)
	{
		this.doors = doors;
	}
	
	public boolean equals(Object o)
	{
		Wall w = (Wall)o;
		if(w.getStartX() == start.getX() && w.getEndX() == end.getX()
				&& w.getStartY() == start.getY() && w.getEndY() == end.getY())
			return true;
		return false;
	}

	public Wall copy() {
		// TODO Auto-generated method stub
		return new Wall(start.getX(), start.getY(), end.getX(), end.getY(), length, (ArrayList<AtomicObject>)doors.clone());
	}

}
