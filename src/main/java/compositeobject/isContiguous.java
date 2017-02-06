package compositeobject;

import burlap.mdp.core.oo.propositional.PropositionalFunction;
import burlap.mdp.core.oo.state.OOState;
import burlap.mdp.core.oo.state.ObjectInstance;

import java.util.ArrayList;
import java.util.Collections;

import static compositeobject.CompObjDomain.VAR_X;
import static compositeobject.CompObjDomain.VAR_Y;

/**
 * Created by khalil8500 on 2/6/2017.
 */
public class isContiguous extends PropositionalFunction
{

    public isContiguous(String name, String[] parameterClasses) {
        super(name, parameterClasses);
    }

    @Override
    public boolean isTrue(OOState s, String... params) {
        ObjectInstance agent = s.object(params[0]);
        ArrayList<AtomicObject> selection = (ArrayList<AtomicObject>) agent.get("selection");
        if(selection.size() <= 1)
            return true;
        Collections.sort(selection);
        boolean checkX = (((Integer)selection.get(0).get(VAR_X) + 1) == (Integer)selection.get(1).get(VAR_X));
        for(int i = 0; i < selection.size() - 1; i++)
        {
            if(checkX && ((Integer)selection.get(i).get(VAR_X) + 1) != (Integer)selection.get(i+1).get(VAR_X))
            {
                return false;
            }
            if(!checkX && ((Integer)selection.get(i).get(VAR_Y) + 1) != (Integer)selection.get(i+1).get(VAR_Y))
            {
                return false;
            }
        }
        return true;
    }
}
