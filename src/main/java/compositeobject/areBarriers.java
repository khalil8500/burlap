package compositeobject;

import burlap.mdp.core.oo.propositional.PropositionalFunction;
import burlap.mdp.core.oo.state.OOState;
import burlap.mdp.core.oo.state.ObjectInstance;

import java.util.ArrayList;

/**
 * Created by khalil8500 on 2/6/2017.
 */
public class areBarriers extends PropositionalFunction {
    public areBarriers(String name, String[] parameterClasses) {
        super(name, parameterClasses);
    }

    @Override
    public boolean isTrue(OOState s, String... params) {
        ObjectInstance agent = s.object(params[0]);
        ArrayList<AtomicObject> selection = ((CompObjAgent) agent).getSelection();
        for (AtomicObject a : selection) {
            if (a.className() != "Atomic Object")
                return false;
        }
        return true;
    }
}

