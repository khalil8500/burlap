package compositeobject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import burlap.mdp.core.oo.state.MutableOOState;
import burlap.mdp.core.oo.state.OOStateUtilities;
import burlap.mdp.core.oo.state.OOVariableKey;
import burlap.mdp.core.oo.state.ObjectInstance;
import burlap.mdp.core.state.MutableState;
import burlap.mdp.core.state.State;
import burlap.mdp.core.state.StateUtilities;

public class CompObjState implements MutableOOState {
	
	public CompObjAgent agent;
	public List<AtomicObject> objects;
	
	public CompObjState()
	{
		
	}
	
	public CompObjState(int x, int y, AtomicObject...objects)
	{
		this(new CompObjAgent(x, y), objects);
	}
	
	public CompObjState(CompObjAgent agent, AtomicObject...objects)
	{
		this.agent = agent;
		if(objects.length == 0){
			this.objects = new ArrayList<AtomicObject>();
		}
		else {
			this.objects = Arrays.asList(objects);
		}
	}
	
	public CompObjState(CompObjAgent agent, List<AtomicObject> objects)
	{
		this.agent = agent;
		this.objects = objects;
	}

	@Override
	public int numObjects() {
		return objects.size() + 1;
	}

	@Override
	public ObjectInstance object(String oname) {
		if(oname.equals(agent.name())){
			return agent;
		}
		int ind = this.objectInd(oname);
		if(ind != -1){
			return objects.get(ind);
		}
		return null;
	}
	
	protected int objectInd(String oname){
		int ind = -1;
		for(int i = 0; i < objects.size(); i++){
			if(objects.get(i).name().equals(oname)){
				ind = i;
				break;
			}
		}
		return ind;
	}

	@Override
	public List<ObjectInstance> objects() {
		List<ObjectInstance> obs = new ArrayList<ObjectInstance>(1+objects.size());
		obs.add(agent);
		obs.addAll(objects);
		return obs;
	}

	@Override
	public List<ObjectInstance> objectsOfClass(String oclass) {
		if(oclass.equals("agent")){
			return Arrays.<ObjectInstance>asList(agent);
		}
		else if(oclass.equals("Door") || oclass.equals("Wall")){
			return new ArrayList<ObjectInstance>(objects);
		}
		throw new RuntimeException("Unknown class type " + oclass);
	}

	@Override
	public List<Object> variableKeys() {
		return OOStateUtilities.flatStateKeys(this);
	}

	@Override
	public Object get(Object variableKey) {
		OOVariableKey key = OOStateUtilities.generateKey(variableKey);
		if(key.obName.equals(agent.name())){
			return agent.get(key.obVarKey);
		}
		int ind = this.objectInd(key.obName);
		if(ind == -1){
			throw new RuntimeException("Cannot find object " + key.obName);
		}
		return objects.get(ind).get(key.obVarKey);
	}

	@Override
	public State copy() {
		return new CompObjState(agent, objects);
	}

	@Override
	public MutableState set(Object variableKey, Object value) {
		OOVariableKey key = OOStateUtilities.generateKey(variableKey);
		int iv = StateUtilities.stringOrNumber(value).intValue();
		if(key.obName.equals(agent.name())){
			if(key.obVarKey.equals(CompObjDomain.VAR_X)){
				touchAgent().x = iv;
			}
			else if(key.obVarKey.equals(CompObjDomain.VAR_Y)){
				touchAgent().y = iv;
			}
			else{
				throw new RuntimeException("Unknown variable key " + variableKey);
			}
			return this;
		}
		int ind = objectInd(key.obName);
		if(ind != -1){
			if(key.obVarKey.equals(CompObjDomain.VAR_X)){
				touchObject(ind).x = iv;
			}
			else if(key.obVarKey.equals(CompObjDomain.VAR_Y)){
				touchObject(ind).y = iv;
			}
			else if(key.obVarKey.equals(CompObjDomain.VAR_TYPE)){
				touchObject(ind).type = iv;
			}
			else{
				throw new RuntimeException("Unknown variable key " + variableKey);
			}

			return this;
		}

		throw new RuntimeException("Unknown variable key " + variableKey);
	}

	public CompObjAgent touchAgent(){
		this.agent = agent.copy();
		return agent;
	}

	public List<AtomicObject> touchObjects(){
		this.objects = new ArrayList<AtomicObject>(objects);
		return objects;
	}
	
	public List<AtomicObject> deepTouchObjects(){
		List<AtomicObject> nlocs = new ArrayList<AtomicObject>(objects.size());
		for(AtomicObject loc : objects){
			nlocs.add(loc.copy());
		}
		objects = nlocs;
		return objects;
	}

	public AtomicObject touchObject(int ind){
		AtomicObject n = objects.get(ind).copy();
		touchObjects().remove(ind);
		objects.add(ind, n);
		return n;
	}
	@Override
	public MutableOOState addObject(ObjectInstance o) {
		if(!(o instanceof AtomicObject)){
			throw new RuntimeException("Can only add AtomicObject objects to a GridWorldState.");
		}
		AtomicObject obj = (AtomicObject)o;

		//copy on write
		touchObjects().add(obj);

		return this;
	}

	@Override
	public MutableOOState removeObject(String oname) {
		if(oname.equals(agent.name())){
			throw new RuntimeException("Cannot remove agent object from state");
		}
		int ind = this.objectInd(oname);
		if(ind == -1){
			throw new RuntimeException("Cannot find object " + oname);
		}

		//copy on write
		touchObjects().remove(ind);

		return this;
	}

	@Override
	public MutableOOState renameObject(String objectName, String newName) {
		if(objectName.equals(agent.name())){
			CompObjAgent nagent = agent.copyWithName(newName);
			this.agent = nagent;
		}
		else{
			int ind = this.objectInd(objectName);
			if(ind == -1){
				throw new RuntimeException("Cannot find object " + objectName);
			}

			//copy on write
			AtomicObject obj = this.objects.get(ind).copyWithName(newName);
			touchObjects().remove(ind);
			objects.add(ind, obj);

		}

		return this;
	}
	
	public String toString()
	{
		return OOStateUtilities.ooStateToString(this);
	}

}
