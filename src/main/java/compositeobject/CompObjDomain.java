package compositeobject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import burlap.mdp.auxiliary.DomainGenerator;
import burlap.mdp.core.Domain;
import burlap.mdp.core.action.UniversalActionType;
import burlap.mdp.core.oo.OODomain;
import burlap.mdp.core.oo.propositional.PropositionalFunction;
import burlap.mdp.core.oo.state.OOState;
import burlap.mdp.core.oo.state.ObjectInstance;
import burlap.mdp.singleagent.oo.OOSADomain;

public class CompObjDomain implements DomainGenerator {

	public static final String VAR_X = "x";
	
	public static final String VAR_Y = "y";
	
	public static final String CLASS_AGENT = "agent";
	
	public static final String CLASS_ATOMICOBJECT = "atomic object";
	
	/**
	 * Constant for the name of the north action
	 */
	public static final String ACTION_NORTH = "north";
	
	/**
	 * Constant for the name of the south action
	 */
	public static final String ACTION_SOUTH = "south";
	
	/**
	 * Constant for the name of the east action
	 */
	public static final String ACTION_EAST = "east";
	
	/**
	 * Constant for the name of the west action
	 */
	public static final String ACTION_WEST = "west";
	
	public static final String ACTION_PLACEBLOCK = "place block";
	
	public static final String ACTION_PLACEDOOR = "place door";
	
	public static final String PF_AreBarriers = "Are Barriers";
	
	public static final String PF_IsStraight = "Is Straight";
	
	public static final String PF_IsContiguous = "Is Contiguous";
	
	protected int height;
	
	protected int width;
	
	protected String [][] map; 
	
	public CompObjDomain(int height, int width)
	{
		this.height = height;
		this.width = width;
		makeEmptyMap();
	}
	
	public CompObjDomain(String [][] map)
	{
		height = map.length;
		width = map[0].length;
		this.map = map.clone();
	}
	
	public void makeEmptyMap()
	{
		this.map = new String[height][width];
		for(int i = 0;i < height;i++)
		{
			for(int j = 0;j < width;j++)
			{
				map[i][j] = "Empty";
			}
		}
	}
	
	public String [][] getMap(){
		String [][] cmap = new String[this.map.length][this.map[0].length];
		for(int i = 0; i < this.map.length; i++){
			for(int j = 0; j < this.map[0].length; j++){
				cmap[i][j] = this.map[i][j];
			}
		}
		return cmap;
	}
	

	/**
	 * Returns this grid world's width
	 * @return this grid world's width
	 */
	public int getWidth() {
		return this.width;
	}

	/**
	 * Returns this grid world's height
	 * @return this grid world's height
	 */
	public int getHeight() {
		return this.height;
	}
	
	public List<PropositionalFunction> generatePfs()
	{
		List<PropositionalFunction> pfs = Arrays.asList(
				new AreBarriers(PF_AreBarriers, new String[]{CLASS_AGENT}),
				new isStraight(PF_IsStraight, new String[]{CLASS_AGENT}),
				new isContiguous(PF_IsContiguous, new String[]{CLASS_AGENT})
				);
		return pfs;
	}
	
	@Override
	public OOSADomain generateDomain() {
		OOSADomain domain = new OOSADomain();

		String [][] cmap = this.getMap();
		
		domain.addActionTypes(
				new UniversalActionType(ACTION_NORTH),
				new UniversalActionType(ACTION_SOUTH),
				new UniversalActionType(ACTION_EAST),
				new UniversalActionType(ACTION_WEST),
				new UniversalActionType(ACTION_PLACEBLOCK),
				new UniversalActionType(ACTION_PLACEDOOR));
		
		OODomain.Helper.addPfsToDomain(domain, this.generatePfs());
		
		return domain;
	}
	public class AreBarriers extends PropositionalFunction
	{		
		public AreBarriers(String name, String[] parameterClasses) {
			super(name, parameterClasses);
		}

		@Override
		public boolean isTrue(OOState s, String... params) {
			ObjectInstance agent = s.object(params[0]);
			ArrayList<AtomicObject> selection = (ArrayList<AtomicObject>) agent.get("selection");
			for(AtomicObject a:selection)
			{
				if(a.className() != "Wall" || a.className() != "Door")
					return false;
			}
			return true;
		}
		
	}
	
	public class isStraight extends PropositionalFunction
	{

		public isStraight(String name, String[] parameterClasses) {
			super(name, parameterClasses);
		}

		@Override
		public boolean isTrue(OOState s, String... params) {
			ObjectInstance agent = s.object(params[0]);
			ArrayList<AtomicObject> selection = (ArrayList<AtomicObject>) agent.get("selection");
			if(selection.size() <= 1)
				return true;
			double slope = Math.abs(((Double)selection.get(1).get(VAR_X) - (Double)selection.get(0).get(VAR_X))/((Double)selection.get(1).get(VAR_Y) - (Double)selection.get(0).get(VAR_Y)));
			double initialX = (Double)selection.get(0).get(VAR_X);
			double initialY = (Double)selection.get(0).get(VAR_Y);
			for(AtomicObject a:selection)
			{
				if((Double)a.get(VAR_X) != initialX && (Double)a.get(VAR_Y) != initialY)
				{
					double compSlope = Math.abs(((Double)a.get(VAR_X)-initialX)/((Double)a.get(VAR_Y)-initialY));
					if(compSlope != slope)
						return false;
				}
			}
			return true;
		}
		
	}
	
	public class isContiguous extends PropositionalFunction
	{

		public isContiguous(String name, String[] parameterClasses) {
			super(name, parameterClasses);
		}

		@Override
		public boolean isTrue(OOState s, String... params) {
			ObjectInstance agent = s.object(params[0]);
			ArrayList<AtomicObject> selection = (ArrayList<AtomicObject>) agent.get("selection");
			if(selection.size() <= 1)
				return true;
			Collections.sort(selection);
			boolean checkX = (((Integer)selection.get(0).get(VAR_X) + 1) != (Integer)selection.get(1).get(VAR_X));
			for(int i = 0; i < selection.size() - 1; i++)
			{
				if(checkX && ((Integer)selection.get(i).get(VAR_X) + 1) != (Integer)selection.get(i+1).get(VAR_X))
				{
					return false;
				}
				if(!checkX && ((Integer)selection.get(i).get(VAR_Y) + 1) != (Integer)selection.get(i+1).get(VAR_Y))
				{
					return false;
				}
			}
			return true;
		}
	}

}
