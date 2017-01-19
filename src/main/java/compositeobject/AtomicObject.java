package compositeobject;

import java.util.List;

import burlap.mdp.core.oo.state.ObjectInstance;
import burlap.mdp.core.state.State;

public class AtomicObject implements ObjectInstance {
	
	protected String className;
	protected int x;
	protected int y;
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public void setX(int val)
	{
		x = val;
	}
	
	public void setY(int val)
	{
		y = val;
	}
	
	public String getClassName()
	{
		return className;
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
		return null;
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

}
