
package compositeobject;

import java.util.Comparator;

/**
 * Created by birdm on 2/8/2017.
 */
public class Point {
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

    public boolean equals(Object o){
        if(o instanceof Point){
            Point x = (Point)o;
            if(this.getX()==x.getX() && this.getY()==x.getY()){
                return true;
            }
        }
        return false;
    }

}
