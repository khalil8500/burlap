package compositeobject;

import burlap.mdp.core.oo.propositional.PropositionalFunction;
import burlap.mdp.core.oo.state.OOState;
import burlap.mdp.core.oo.state.ObjectInstance;

import java.util.ArrayList;

/**
 * Created by khalil8500 on 2/6/2017.
 */
public class IsConnected extends PropositionalFunction {

    public IsConnected(String name, String[] parameterClasses) {
        super(name, parameterClasses);
    }

    @Override
    public boolean isTrue(OOState s, String... params) {
        CompObjAgent agent = (CompObjAgent) s.object(params[0]);
        ArrayList<Wall> walls = (ArrayList<Wall>)agent.get("Walls");
        Wall cur = walls.get(0);
        int wallNum = 0;
        int lastCorner, traversed;
        traversed = 0;
        lastCorner = 0;
        Point initCorner = cur.getPoint(lastCorner);
        boolean changed;
        do{
            changed = false;
            for(int i = 0;i < walls.size();i++) {
                if (i != wallNum) {
                    Wall next = walls.get(i);
                    if (next.getPoint(0).equals(cur.getPoint(1 - lastCorner))) {
                        lastCorner = 0;
                        traversed++;
                        cur = next;
                        changed = true;
                        break;
                    } else if (next.getPoint(1).equals(cur.getPoint(1 - lastCorner))) {
                        lastCorner = 1;
                        traversed++;
                        cur = next;
                        changed = true;
                        break;
                    }
                }
            }
            if(!changed)
                return false;
        }while(cur.getPoint(lastCorner).equals(initCorner));

        if(traversed == walls.size())
        {
            return true;
        }
        return false;
    }
}
