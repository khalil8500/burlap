package compositeobject;

import java.util.Arrays;
import java.util.List;

import burlap.mdp.core.oo.state.ObjectInstance;
import burlap.mdp.core.state.State;

public class AtomicObject implements ObjectInstance, Comparable<AtomicObject>{
	
	protected String className;
	protected String name;
	protected int x;
	protected int y;
	
	protected final static List<Object> keys = Arrays.<Object>asList(CompObjDomain.VAR_X, CompObjDomain.VAR_Y);
	
	public AtomicObject()
	{
		className = "object";
	}
	
	public AtomicObject(int x, int y)
	{
		this();
		this.x = x;
		this.y = y;
	}
	
	public AtomicObject(int x, int y, String name)
	{
		this(x, y);
		this.name = name;
	}
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
		return keys;
	}

	@Override
	public Object get(Object variableKey) {
		if(!(variableKey instanceof String)){
			throw new RuntimeException("GridAgent variable key must be a string");
		}

		String key = (String)variableKey;
		if(key.equals(CompObjDomain.VAR_X)){
			return x;
		}
		else if(key.equals(CompObjDomain.VAR_Y)){
			return y;
		}

		throw new RuntimeException("Unknown key " + key);
	}

	@Override
	public AtomicObject copy() {
		return new AtomicObject(x, y);
	}

	@Override
	public String className() {
		return className;
	}

	@Override
	public String name() {
		return name;
	}

	@Override
	public ObjectInstance copyWithName(String objectName) {
		return new AtomicObject(x, y, objectName);
	}

	@Override
	public int compareTo(AtomicObject a) {
		if((Integer)a.get(CompObjDomain.VAR_X) != this.x)
			return ((Integer)x).compareTo((Integer)a.get(CompObjDomain.VAR_X));
		else
			return ((Integer)y).compareTo((Integer)a.get(CompObjDomain.VAR_Y));
	}

}
