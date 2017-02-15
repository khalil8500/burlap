package compositeobject;

import burlap.mdp.core.oo.propositional.PropositionalFunction;
import burlap.mdp.core.oo.state.OOState;

/**
 * Created by khalil8500 on 2/13/2017.
 */
public class HasSizeRoom extends PropositionalFunction{

    int roomSize;

    public HasSizeRoom(String name, String[] parameterClasses, int roomSize) {
        super(name, parameterClasses);
        this.roomSize = roomSize;
    }
    @Override
    public boolean isTrue(OOState s, String... params) {
        CompObjAgent agent = (CompObjAgent) s.object(params[0]);
        return false;
    }
}
