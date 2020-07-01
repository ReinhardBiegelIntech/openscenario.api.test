package de.rac.openscenario.v1_0.impl;

import de.rac.openscenario.v1_0.api.IAxle;
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



/**
 * This is a automatic generated file according to the OpenSCENARIO specification version 1.0
 * <p>
 * Value class that implements IAxle. With setter methods to fill the properties.
 * <ul>
 * <li> getter methods for properties (implemented methods of IAxle)
 * <li> setter methods for properties
 * <li> getChildren method to collect all children
 * <li> clone function to make a deep copy
 * <li> overrides from BaseImpl
 * </ul>
 * 
 * @author RA Consulting OpenSCENARIO generation facility
*/
public class AxleImpl extends BaseImpl implements IAxle, Cloneable{
	
	/**
	 * Filling the property to type map
	 */
	 static{
		propertyToType.put(OscConstants.ATTRIBUTE__MAX_STEERING, Double.class);
		propertyToType.put(OscConstants.ATTRIBUTE__WHEEL_DIAMETER, Double.class);
		propertyToType.put(OscConstants.ATTRIBUTE__TRACK_WIDTH, Double.class);
		propertyToType.put(OscConstants.ATTRIBUTE__POSITION_X, Double.class);
		propertyToType.put(OscConstants.ATTRIBUTE__POSITION_Z, Double.class);
	}
	
	private Double maxSteering;
	private Double wheelDiameter;
	private Double trackWidth;
	private Double positionX;
	private Double positionZ;

	@Override
	public Double getMaxSteering()
	{
		return maxSteering;
	}
	@Override
	public Double getWheelDiameter()
	{
		return wheelDiameter;
	}
	@Override
	public Double getTrackWidth()
	{
		return trackWidth;
	}
	@Override
	public Double getPositionX()
	{
		return positionX;
	}
	@Override
	public Double getPositionZ()
	{
		return positionZ;
	}
	/**
	 * Sets the value of model property maxSteering
	 * @param maxSteering from OpenSCENARIO class model specification: [Maximum steering angle which can be performed by the 
	 * wheels on this axle. Unit: rad; Range: [0;PI], symmetrical.]
	 * 
	*/
	public  void setMaxSteering (Double maxSteering )
	{
		this.maxSteering = maxSteering;
	}
	/**
	 * Sets the value of model property wheelDiameter
	 * @param wheelDiameter from OpenSCENARIO class model specification: [Diameter of the wheels on this axle. Unit: m; Range: 
	 * ]0..inf[.]
	 * 
	*/
	public  void setWheelDiameter (Double wheelDiameter )
	{
		this.wheelDiameter = wheelDiameter;
	}
	/**
	 * Sets the value of model property trackWidth
	 * @param trackWidth from OpenSCENARIO class model specification: [Distance of the wheels center lines at zero steering. 
	 * Unit: m; Range: [0..inf[.]
	 * 
	*/
	public  void setTrackWidth (Double trackWidth )
	{
		this.trackWidth = trackWidth;
	}
	/**
	 * Sets the value of model property positionX
	 * @param positionX from OpenSCENARIO class model specification: [Longitudinal position of the axle with respect to the 
	 * vehicles reference point. Unit: m; Range: [0..inf[.]
	 * 
	*/
	public  void setPositionX (Double positionX )
	{
		this.positionX = positionX;
	}
	/**
	 * Sets the value of model property positionZ
	 * @param positionZ from OpenSCENARIO class model specification: [Z-position of the axle with respect to the vehicles 
	 * reference point. Usually this is half of wheel diameter. Unit:m; , Range:[0..inf[.]
	 * 
	*/
	public  void setPositionZ (Double positionZ )
	{
		this.positionZ = positionZ;
	}

	@Override
	public  void resolveParameterInternal(IParserMessageLogger logger,String attributeKey, String parameterLiteralValue)
	{
		if (attributeKey.equals(OscConstants.ATTRIBUTE__MAX_STEERING))
		{
			// Simple type
			maxSteering = ParserHelper.parseDouble(logger,parameterLiteralValue,getTextmarker(attributeKey));
			removeResolvedParameter(attributeKey);
				
	 	}
		else if (attributeKey.equals(OscConstants.ATTRIBUTE__WHEEL_DIAMETER))
		{
			// Simple type
			wheelDiameter = ParserHelper.parseDouble(logger,parameterLiteralValue,getTextmarker(attributeKey));
			removeResolvedParameter(attributeKey);
				
	 	}
		else if (attributeKey.equals(OscConstants.ATTRIBUTE__TRACK_WIDTH))
		{
			// Simple type
			trackWidth = ParserHelper.parseDouble(logger,parameterLiteralValue,getTextmarker(attributeKey));
			removeResolvedParameter(attributeKey);
				
	 	}
		else if (attributeKey.equals(OscConstants.ATTRIBUTE__POSITION_X))
		{
			// Simple type
			positionX = ParserHelper.parseDouble(logger,parameterLiteralValue,getTextmarker(attributeKey));
			removeResolvedParameter(attributeKey);
				
	 	}
		else if (attributeKey.equals(OscConstants.ATTRIBUTE__POSITION_Z))
		{
			// Simple type
			positionZ = ParserHelper.parseDouble(logger,parameterLiteralValue,getTextmarker(attributeKey));
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
		
		return result;
	}
	
	/**
	 * Making a (deep) clone this object. This is useful and used for importing elements from catalogs.
	 * @return a deep copy of the object.
	 */
	public AxleImpl clone()
	{
		AxleImpl clonedObject = new AxleImpl();
		cloneStartMarker(clonedObject);
		cloneEndMarker(clonedObject);
		cloneAttributeKeyToStartMarker(clonedObject);
		cloneAttributeKeyToEndMarker(clonedObject);
		cloneAttributeKeyToParameterNameMap(clonedObject);
		// clone attributes;
		// Simple type
		clonedObject.setMaxSteering(getMaxSteering());		
		// Simple type
		clonedObject.setWheelDiameter(getWheelDiameter());		
		// Simple type
		clonedObject.setTrackWidth(getTrackWidth());		
		// Simple type
		clonedObject.setPositionX(getPositionX());		
		// Simple type
		clonedObject.setPositionZ(getPositionZ());		
		// clone children
		return clonedObject;
	}
	
	
	
}

