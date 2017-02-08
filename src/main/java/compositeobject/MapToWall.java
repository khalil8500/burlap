package compositeobject;

import java.util.ArrayList;
import java.util.List;


public class MapToWall {
	
	public static Wall Map(List<AtomicObject> components)
	{
		Point start, end;
		start = new Point(-1,-1);
		end = new Point(-1,-1);
		ArrayList<AtomicObject> doors = new ArrayList<AtomicObject>();

		for(AtomicObject a: components)
		{
			int x = (Integer) a.get(CompObjDomain.VAR_X);
			int y = (Integer) a.get(CompObjDomain.VAR_Y);
			if(start.getX() == -1)
			{
				start.setX(x);
				start.setY(y);
				end.setX(x);
				end.setY(y);
			}
			else{
				if(start.getX() == x)
				{
					if(start.getY() > y)
					{
						start.setY(y);
					}
				}
				else if(start.getX() > x)
				{
					start.setX(x);
					start.setY(y);
				}
				
				if(end.getX() == x)
				{
					if(end.getY() < y)
					{
						end.setY(y);
					}
				}
				else if(end.getX() < x)
				{
					end.setX(x);
					end.setY(y);
				}
			}
			
			if(a.className() == "Door")
			{
				doors.add(a);
			}
		}
		return new Wall(start, end, components.size(), doors);
	}

}
