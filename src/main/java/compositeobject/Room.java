package compositeobject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by khalil8500 on 2/6/2017.
 */
public class Room {
    public class Point{
        private int x, y;

        public Point()
        {}

        public Point(int x, int y)
        {
            this.x = x;
            this.y = y;
        }

        public int getX()
        {
            return x;
        }

        public int getY()
        {
            return y;
        }

        public void setX(int x)
        {
            this.x = x;
        }

        public void setY(int y)
        {
            this.y = y;
        }
    }

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
