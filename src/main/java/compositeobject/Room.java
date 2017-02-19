package compositeobject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by khalil8500 on 2/6/2017.
 */
public class Room {


    ArrayList<Point> corners;
    ArrayList<AtomicObject> doors;

    public Room()
    {
        corners = new ArrayList<Point>();
        doors = new ArrayList<AtomicObject>();
    }

    public Room(ArrayList<Point> corners, ArrayList<AtomicObject> doors) {
        this.corners = corners;
        this.doors = doors;
    }

    public ArrayList<Point> getCorners()
    {
        return corners;
    }

    public void setCorners(ArrayList<Point> corners)
    {
        this.corners = corners;
    }

    public ArrayList<AtomicObject> getDoors()
    {
        return doors;
    }

    public void setDoors(ArrayList<AtomicObject> doors)
    {
        this.doors = doors;
    }

    public Room copy()
    {
        return new Room((ArrayList<Point>)corners.clone(), (ArrayList<AtomicObject>)doors.clone());
    }

    @Override
    public boolean equals(Object obj) {
        Room comp = (Room)obj;
        for(Point p: corners)
        {
            boolean found = false;
            for(Point pComp: comp.corners)
            {
                if(p.equals(pComp)) {
                    found = true;
                    break;
                }
            }
            if(!found)
                return false;
        }

        for(AtomicObject d: doors)
        {
            boolean found = false;
            for(AtomicObject dComp: comp.doors)
            {
                if(d.equals(dComp)) {
                    found = true;
                    break;
                }
            }
            if(!found)
                return false;
        }
        return true;
    }
}
