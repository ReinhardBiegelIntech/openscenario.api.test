package de.rac.openscenario.v1_0.impl;

import de.rac.openscenario.v1_0.api.IRelativeWorldPosition;
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
import de.rac.openscenario.v1_0.impl.NamedReferenceProxy;
import de.rac.openscenario.v1_0.common.INamedReference;
import de.rac.openscenario.v1_0.api.IOrientation;
import de.rac.openscenario.v1_0.api.IEntity;


/**
 * This is a automatic generated file according to the OpenSCENARIO specification version 1.0
 * <p>
 * Value class that implements IRelativeWorldPosition. With setter methods to fill the properties.
 * <ul>
 * <li> getter methods for properties (implemented methods of IRelativeWorldPosition)
 * <li> setter methods for properties
 * <li> getChildren method to collect all children
 * <li> clone function to make a deep copy
 * <li> overrides from BaseImpl
 * </ul>
 * 
 * @author RA Consulting OpenSCENARIO generation facility
*/
public class RelativeWorldPositionImpl extends BaseImpl implements IRelativeWorldPosition, Cloneable{
	
	/**
	 * Filling the property to type map
	 */
	 static{
		propertyToType.put(OscConstants.ATTRIBUTE__ENTITY_REF, String.class);
		propertyToType.put(OscConstants.ATTRIBUTE__DX, Double.class);
		propertyToType.put(OscConstants.ATTRIBUTE__DY, Double.class);
		propertyToType.put(OscConstants.ATTRIBUTE__DZ, Double.class);
	}
	
	private NamedReferenceProxy<IEntity> entityRef;
	private Double dx;
	private Double dy;
	private Double dz;
	private IOrientation orientation;

	@Override
	public INamedReference<IEntity> getEntityRef()
	{
		return entityRef;
	}
	@Override
	public Double getDx()
	{
		return dx;
	}
	@Override
	public Double getDy()
	{
		return dy;
	}
	@Override
	public Double getDz()
	{
		return dz;
	}
	@Override
	public IOrientation getOrientation()
	{
		return orientation;
	}
	/**
	 * Sets the value of model property entityRef
	 * @param entityRef from OpenSCENARIO class model specification: [Reference entity from which the relative world position 
	 * is measured.]
	 * 
	*/
	public  void setEntityRef (NamedReferenceProxy<IEntity> entityRef )
	{
		this.entityRef = entityRef;
	}
	/**
	 * Sets the value of model property dx
	 * @param dx from OpenSCENARIO class model specification: [Relative x coordinate in the world coordinate system.]
	 * 
	*/
	public  void setDx (Double dx )
	{
		this.dx = dx;
	}
	/**
	 * Sets the value of model property dy
	 * @param dy from OpenSCENARIO class model specification: [Relative y coordinate in the world coordinate system.]
	 * 
	*/
	public  void setDy (Double dy )
	{
		this.dy = dy;
	}
	/**
	 * Sets the value of model property dz
	 * @param dz from OpenSCENARIO class model specification: [Relative z coordinate in the world coordinate system.]
	 * 
	*/
	public  void setDz (Double dz )
	{
		this.dz = dz;
	}
	/**
	 * Sets the value of model property orientation
	 * @param orientation from OpenSCENARIO class model specification: [Orientation. The relative reference context refers to 
	 * the reference entity's orientation.]
	 * 
	*/
	public  void setOrientation (IOrientation orientation )
	{
		this.orientation = orientation;
	}

	@Override
	public  void resolveParameterInternal(IParserMessageLogger logger,String attributeKey, String parameterLiteralValue)
	{
		if (attributeKey.equals(OscConstants.ATTRIBUTE__ENTITY_REF))
		{
			// Proxy
			NamedReferenceProxy<IEntity> proxy = new NamedReferenceProxy<IEntity> (parameterLiteralValue);
			entityRef = proxy;
			removeResolvedParameter(attributeKey);
				
	 	}
		else if (attributeKey.equals(OscConstants.ATTRIBUTE__DX))
		{
			// Simple type
			dx = ParserHelper.parseDouble(logger,parameterLiteralValue,getTextmarker(attributeKey));
			removeResolvedParameter(attributeKey);
				
	 	}
		else if (attributeKey.equals(OscConstants.ATTRIBUTE__DY))
		{
			// Simple type
			dy = ParserHelper.parseDouble(logger,parameterLiteralValue,getTextmarker(attributeKey));
			removeResolvedParameter(attributeKey);
				
	 	}
		else if (attributeKey.equals(OscConstants.ATTRIBUTE__DZ))
		{
			// Simple type
			dz = ParserHelper.parseDouble(logger,parameterLiteralValue,getTextmarker(attributeKey));
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
		
			IOrientation orientation = null;
			orientation =  getOrientation();
			if (orientation != null)
			{
				result.add((BaseImpl) orientation);
			}	
		return result;
	}
	
	/**
	 * Making a (deep) clone this object. This is useful and used for importing elements from catalogs.
	 * @return a deep copy of the object.
	 */
	public RelativeWorldPositionImpl clone()
	{
		RelativeWorldPositionImpl clonedObject = new RelativeWorldPositionImpl();
		cloneStartMarker(clonedObject);
		cloneEndMarker(clonedObject);
		cloneAttributeKeyToStartMarker(clonedObject);
		cloneAttributeKeyToEndMarker(clonedObject);
		cloneAttributeKeyToParameterNameMap(clonedObject);
		// clone attributes;
		// Proxy
		NamedReferenceProxy<IEntity> proxy = ((NamedReferenceProxy<IEntity>)getEntityRef()).clone();
		clonedObject.setEntityRef(proxy);
		proxy.setParent(clonedObject);
		// Simple type
		clonedObject.setDx(getDx());		
		// Simple type
		clonedObject.setDy(getDy());		
		// Simple type
		clonedObject.setDz(getDz());		
		// clone children
		IOrientation orientation = null;
		orientation =  getOrientation();
		if (orientation != null)
		{
			OrientationImpl clonedChild = ((OrientationImpl) orientation).clone();
			clonedObject.setOrientation(clonedChild);
			clonedChild.setParent(clonedObject);
		}	
		return clonedObject;
	}
	
	
	
}

