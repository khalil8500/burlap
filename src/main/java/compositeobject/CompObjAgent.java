package compositeobject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import burlap.mdp.core.oo.state.OOStateUtilities;
import burlap.mdp.core.oo.state.ObjectInstance;
import burlap.mdp.core.state.State;

public class CompObjAgent implements ObjectInstance{
	
	public int x, y;
	protected String name;
	protected ArrayList<AtomicObject> selection;
	protected ArrayList<Wall> walls;
	private final static List<Object> keys = Arrays.<Object>asList(CompObjDomain.VAR_X, CompObjDomain.VAR_Y);
	
	public CompObjAgent()
	{
		name = "agent";
		selection = new ArrayList<AtomicObject>();
		walls = new ArrayList<Wall>();
	}
	
	public CompObjAgent(int x, int y)
	{
		this();
		this.x = x;
		this.y = y;
	}
	
	public CompObjAgent(int x, int y, String name)
	{
		this.x = x;
		this.y = y;
		this.name = name;
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
		else if(key.equals("Walls"))
			return walls;
		else if(key.equals("selection"))
			return selection;

		throw new RuntimeException("Unknown key " + key);
	}

	@Override
	public CompObjAgent copy() {
		return new CompObjAgent(x, y);
	}

	@Override
	public String className() {
		return CompObjDomain.CLASS_AGENT;
	}

	@Override
	public String name() {
		return name;
	}

	@Override
	public CompObjAgent copyWithName(String objectName) {
		return new CompObjAgent(x, y, name);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void addWall(Wall w)
	{
		walls.add(w);
	}
	
	public void clearWalls()
	{
		walls.clear();
	}
	
	public void setSelection(ArrayList<AtomicObject> selection)
	{
		this.selection = selection;
	}

	@Override
	public String toString() {
		return OOStateUtilities.objectInstanceToString(this);
	}

}
