package compositeobject;

import burlap.mdp.core.oo.propositional.PropositionalFunction;
import burlap.mdp.core.oo.state.OOState;
import burlap.mdp.core.oo.state.ObjectInstance;

import java.util.List;

/**
 * Created by khalil8500 on 2/6/2017.
 */
public class hasSizeWall extends PropositionalFunction
{
    int wallSize;

    public hasSizeWall(String name, String[] parameterClasses, int size) {
        super(name, parameterClasses);
        wallSize = size;
    }

    @Override
    public boolean isTrue(OOState s, String... params) {
        ObjectInstance agent = s.object(params[0]);
        List<Wall> walls = (List<Wall>) agent.get("Walls");

        for(Wall w: walls)
        {
            if(w.length() >= wallSize)
                return true;
        }

        return false;
    }



}

