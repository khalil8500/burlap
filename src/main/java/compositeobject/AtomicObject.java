package compositeobject;

import java.util.List;

import burlap.mdp.core.oo.state.ObjectInstance;
import burlap.mdp.core.state.State;

public class AtomicObject implements ObjectInstance, Comparable{
	
	protected String className;
	protected int x;
	protected int y;
	
	public void setX(int val)
	{
		x = val;
	}
	
	public void setY(int val)
	{
		y = val;
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
	public String className() {
		// TODO Auto-generated method stub
		return className;
	}

	@Override
	public String name() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ObjectInstance copyWithName(String objectName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int compareTo(Object obj) {
		AtomicObject a = (AtomicObject)obj;
		if((Integer)a.get(CompObjDomain.VAR_X) != this.x)
			return ((Integer)x).compareTo((Integer)a.get(CompObjDomain.VAR_X));
		else
			return ((Integer)y).compareTo((Integer)a.get(CompObjDomain.VAR_Y));
	}

}
