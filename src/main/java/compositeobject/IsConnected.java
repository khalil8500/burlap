package compositeobject;

import burlap.mdp.core.oo.propositional.PropositionalFunction;
import burlap.mdp.core.oo.state.OOState;

/**
 * Created by khalil8500 on 2/6/2017.
 */
public class IsConnected extends PropositionalFunction {

    public IsConnected(String name, String[] parameterClasses) {
        super(name, parameterClasses);
    }

    @Override
    public boolean isTrue(OOState s, String... params) {
        return false;
    }
}
