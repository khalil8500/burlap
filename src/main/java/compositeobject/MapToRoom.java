package compositeobject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by khalil8500 on 2/6/2017.
 */
public class MapToRoom {

    public static Room Map(List<Wall> components)
    {
        ArrayList<Point> corners = new ArrayList<Point>();
        ArrayList<Door> doors = new ArrayList<Door>();
        for(Wall w:components){
            if(!corners.contains(w.getStart())){
                corners.add(w.getStart());
            }
            if(!corners.contains(w.getEnd())){
                corners.add(w.getEnd());
            }
            for(AtomicObject d:w.getDoors()){
                doors.add((Door)d);
            }
        }

        return new Room(corners, doors);
    }
}
