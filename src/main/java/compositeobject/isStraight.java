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
public class isStraight extends PropositionalFunction
{

    public isStraight(String name, String[] parameterClasses) {
        super(name, parameterClasses);
    }

    @Override
    public boolean isTrue(OOState s, String... params) {
        ObjectInstance agent = s.object(params[0]);
        ArrayList<AtomicObject> selection = (ArrayList<AtomicObject>) agent.get("selection");
        Collections.sort(selection);
        if(selection.size() <= 1)
            return true;
        //double slope = Math.abs(((Double)selection.get(1).get(VAR_X) - (Double)selection.get(0).get(VAR_X))/((Double)selection.get(1).get(VAR_Y) - (Double)selection.get(0).get(VAR_Y)));
        double initialX = (Integer)selection.get(0).get(VAR_X);
        double initialY = (Integer)selection.get(0).get(VAR_Y);
        double dx = (Integer)selection.get(1).get(VAR_X) - initialX;
        double dy = (Integer)selection.get(1).get(VAR_Y) - initialY;
        for(AtomicObject a:selection)
        {
            if((Integer)a.get(VAR_X) != initialX && (Integer)a.get(VAR_Y) != initialY)
            {
                double tempDx = (Integer)a.get(VAR_X)-initialX;
                double tempDy = (Integer)a.get(VAR_Y)-initialY;
                if(dx != 0)
                {
                    double slope = dy/dx;
                    if(tempDx != 0)
                    {
                        double compSlope = tempDy/tempDx;
                        if(compSlope != slope)
                            return false;
                    }
                    else
                        return false;
                }
                else
                {
                    if(tempDx != 0)
                        return false;
                }
            }
        }
        return true;
    }

}
