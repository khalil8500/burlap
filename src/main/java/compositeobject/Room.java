package compositeobject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by khalil8500 on 2/6/2017.
 */
public class Room {


    ArrayList<Point> corners;
    ArrayList<Door> doors;

    public Room()
    {
        corners = new ArrayList<Point>();
        doors = new ArrayList<Door>();
    }

    public Room(ArrayList<Point> corners, ArrayList<Door> doors) {
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

    public ArrayList<Door> getDoors()
    {
        return doors;
    }

    public void setDoors(ArrayList<Door> doors)
    {
        this.doors = doors;
    }

    public Room copy()
    {
        return new Room((ArrayList<Point>)corners.clone(), (ArrayList<Door>)doors.clone());
    }
}
