package compositeobject;

import java.util.List;

import burlap.mdp.core.oo.state.MutableOOState;
import burlap.mdp.core.oo.state.ObjectInstance;
import burlap.mdp.core.state.MutableState;
import burlap.mdp.core.state.State;

public class CompObjState implements MutableOOState {
	
	

	@Override
	public int numObjects() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ObjectInstance object(String oname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ObjectInstance> objects() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ObjectInstance> objectsOfClass(String oclass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> variableKeys() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object get(Object variableKey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public State copy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MutableState set(Object variableKey, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MutableOOState addObject(ObjectInstance o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MutableOOState removeObject(String oname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MutableOOState renameObject(String objectName, String newName) {
		// TODO Auto-generated method stub
		return null;
	}

}
