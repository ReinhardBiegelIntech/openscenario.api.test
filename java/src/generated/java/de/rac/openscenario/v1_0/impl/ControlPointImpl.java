package de.rac.openscenario.v1_0.impl;

import de.rac.openscenario.v1_0.api.IControlPoint;
import de.rac.openscenario.v1_0.impl.BaseImpl;
import de.rac.openscenario.v1_0.common.ILocator;
import de.rac.openscenario.v1_0.common.IParserMessageLogger;
import de.rac.openscenario.v1_0.common.OscConstants;
import de.rac.openscenario.v1_0.common.FileContentMessage;
import de.rac.openscenario.v1_0.api.IOpenScenarioModelElement;
import java.lang.Cloneable;
import de.rac.openscenario.v1_0.parser.ParserHelper;
import java.util.Hashtable;
import java.util.List;
import java.util.ArrayList;

import de.rac.openscenario.v1_0.api.IPosition;


/**
 * This is a automatic generated file according to the OpenSCENARIO specification version 1.0
 * <p>
 * Value class that implements IControlPoint. With setter methods to fill the properties.
 * <ul>
 * <li> getter methods for properties (implemented methods of IControlPoint)
 * <li> setter methods for properties
 * <li> getChildren method to collect all children
 * <li> clone function to make a deep copy
 * <li> overrides from BaseImpl
 * </ul>
 * 
 * @author RA Consulting OpenSCENARIO generation facility
*/
public class ControlPointImpl extends BaseImpl implements IControlPoint, Cloneable{
	
	/**
	 * Filling the property to type map
	 */
	 static{
		propertyToType.put(OscConstants.ATTRIBUTE__TIME, Double.class);
		propertyToType.put(OscConstants.ATTRIBUTE__WEIGHT, Double.class);
	}
	
	private Double time;
	private Double weight;
	private IPosition position;

	@Override
	public Double getTime()
	{
		return time;
	}
	@Override
	public Double getWeight()
	{
		return weight;
	}
	@Override
	public IPosition getPosition()
	{
		return position;
	}
	/**
	 * Sets the value of model property time
	 * @param time from OpenSCENARIO class model specification: [Optional specification of the time dimension of the control 
	 * point. Unit: s;Range [0..inf[.]
	 * 
	*/
	public  void setTime (Double time )
	{
		this.time = time;
	}
	/**
	 * Sets the value of model property weight
	 * @param weight from OpenSCENARIO class model specification: [Optional weight specification of the control point. If 
	 * unspecified, all control points will be equal weighted. Range , ]-inf..inf[.]
	 * 
	*/
	public  void setWeight (Double weight )
	{
		this.weight = weight;
	}
	/**
	 * Sets the value of model property position
	 * @param position from OpenSCENARIO class model specification: [Position of the control point.]
	 * 
	*/
	public  void setPosition (IPosition position )
	{
		this.position = position;
	}

	@Override
	public  void resolveParameterInternal(IParserMessageLogger logger,String attributeKey, String parameterLiteralValue)
	{
		if (attributeKey.equals(OscConstants.ATTRIBUTE__TIME))
		{
			// Simple type
			time = ParserHelper.parseDouble(logger,parameterLiteralValue,getTextmarker(attributeKey));
			removeResolvedParameter(attributeKey);
				
	 	}
		else if (attributeKey.equals(OscConstants.ATTRIBUTE__WEIGHT))
		{
			// Simple type
			weight = ParserHelper.parseDouble(logger,parameterLiteralValue,getTextmarker(attributeKey));
			removeResolvedParameter(attributeKey);
				
	 	}
	}
	
	@Override
	public  Class<?> getTypeFromAttributeName(String attributeKey)
	{
		return propertyToType.get(attributeKey);
	}

	/**
	 * A list of all aggregated children (lists are flattened). This may be used for applying a specific 
	 * method for any child.
	 * @return a list with all children (as BaseImpl)
	 */
	public List<BaseImpl> getChildren()
	{
		List<BaseImpl> result = new ArrayList<BaseImpl>();
		
			IPosition position = null;
			position =  getPosition();
			if (position != null)
			{
				result.add((BaseImpl) position);
			}	
		return result;
	}
	
	/**
	 * Making a (deep) clone this object. This is useful and used for importing elements from catalogs.
	 * @return a deep copy of the object.
	 */
	public ControlPointImpl clone()
	{
		ControlPointImpl clonedObject = new ControlPointImpl();
		cloneStartMarker(clonedObject);
		cloneEndMarker(clonedObject);
		cloneAttributeKeyToStartMarker(clonedObject);
		cloneAttributeKeyToEndMarker(clonedObject);
		cloneAttributeKeyToParameterNameMap(clonedObject);
		// clone attributes;
		// Simple type
		clonedObject.setTime(getTime());		
		// Simple type
		clonedObject.setWeight(getWeight());		
		// clone children
		IPosition position = null;
		position =  getPosition();
		if (position != null)
		{
			PositionImpl clonedChild = ((PositionImpl) position).clone();
			clonedObject.setPosition(clonedChild);
			clonedChild.setParent(clonedObject);
		}	
		return clonedObject;
	}
	
	
	
}

