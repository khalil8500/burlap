package compositeobject;

import burlap.mdp.core.oo.propositional.PropositionalFunction;
import burlap.mdp.core.oo.state.OOState;

import java.util.ArrayList;

/**
 * Created by khalil8500 on 2/6/2017.
 */
public class IsAccessible extends PropositionalFunction {

    public IsAccessible(String name, String[] parameterClasses) {
        super(name, parameterClasses);
    }

    @Override
    public boolean isTrue(OOState s, String... params) {
        CompObjAgent agent = (CompObjAgent) s.object(params[0]);
        ArrayList<Wall> walls = (ArrayList<Wall>)agent.get("Walls");
        AtomicObject [][] map = ((CompObjState)s).getObjectsMap();
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
                    if(x - 1 >= 0 && x + 1 < map.length && map[x-1][y] == null && map[x+1][y] == null)
                        return true;
                }
                else if(dY == 0)
                {
                    if(y - 1 >= 0 && y + 1 < map[0].length && map[x][y-1] == null && map[x][y+1] == null)
                        return true;
                }
                else
                {
                    if(x - 1 >= 0 && x + 1 < map.length && map[x-1][y] == null && map[x+1][y] == null)
                        return true;
                    if(y - 1 >= 0 && y + 1 < map[0].length && map[x][y-1] == null && map[x][y+1] == null)
                        return true;
                }
            }
        }
        return false;
    }
}
