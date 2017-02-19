package compositeobject;

import burlap.mdp.core.oo.propositional.PropositionalFunction;
import burlap.mdp.core.oo.state.OOState;

import java.util.ArrayList;

/**
 * Created by khalil8500 on 2/6/2017.
 */
public class IsAccessible extends PropositionalFunction {

    ArrayList<Wall> walls;

    public IsAccessible(String name, String[] parameterClasses, ArrayList<Wall> walls) {
        super(name, parameterClasses);
        this.walls = walls;
    }

    @Override
    public boolean isTrue(OOState s, String... params) {
        //CompObjAgent agent = (CompObjAgent) s.object(params[0]);
        int [][] map = ((CompObjState)s).getMap();
        for(Wall w: walls)
        {
            ArrayList<AtomicObject> doors = (ArrayList<AtomicObject>) w.getDoors();
            int dX = w.getEndX() - w.getStartX();
            int dY = w.getEndY() - w.getStartY();
            for(AtomicObject d:doors)
            {
                int x = (Integer)d.get(CompObjDomain.VAR_X);
                int y = (Integer)d.get(CompObjDomain.VAR_Y);
                if(dX == 0)
                {
                    if(x - 1 >= 0 && x + 1 < map.length && map[x-1][y] == 0 && map[x+1][y] == 0)
                        return true;
                }
                else if(dY == 0)
                {
                    if(y - 1 >= 0 && y + 1 < map[0].length && map[x][y-1] == 0 && map[x][y+1] == 0)
                        return true;
                }
                else
                {
                    if(x - 1 >= 0 && x + 1 < map.length && map[x-1][y] == 0 && map[x+1][y] == 0)
                        return true;
                    if(y - 1 >= 0 && y + 1 < map[0].length && map[x][y-1] == 0 && map[x][y+1] == 0)
                        return true;
                }
            }
        }
        return false;
    }
}
