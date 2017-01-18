package compositeobject;

import java.util.ArrayList;
import java.util.List;

public class MapToWallComp {
	
	public WallComp Map(List<AtomicObject> components)
	{
		int startX, startY, endX, endY;
		List<AtomicObject> doors = new ArrayList<AtomicObject>();
		startX = startY = endX = endY = -1;
		for(AtomicObject a: components)
		{
			int x = a.getX();
			int y = a.getY();
			if(startX == -1)
			{
				startX = x;
				startY = x;
				endX = x;
				endY = x;
			}
			else{
				if(startX == x)
				{
					if(startY > y)
					{
						startY = y;
					}
				}
				else if(startX > x)
				{
					startX = x;
					startY = y;
				}
				
				if(endX == x)
				{
					if(endY < y)
					{
						endY = y;
					}
				}
				else if(endX < x)
				{
					endX = x;
					endY = y;
				}
			}
			
			if(a.getClassName() == "Door")
			{
				doors.add(a);
			}
		}
		return new WallComp(startX, startY, endX, endY, doors);
	}

}
