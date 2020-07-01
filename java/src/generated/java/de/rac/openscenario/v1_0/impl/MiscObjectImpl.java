package de.rac.openscenario.v1_0.impl;

import de.rac.openscenario.v1_0.api.IMiscObject;
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
import de.rac.openscenario.v1_0.common.ErrorLevel;
import de.rac.openscenario.v1_0.parameter.ParameterValue;

import de.rac.openscenario.v1_0.api.MiscObjectCategory;
import de.rac.openscenario.v1_0.api.IProperties;
import de.rac.openscenario.v1_0.api.IBoundingBox;
import de.rac.openscenario.v1_0.api.IParameterDeclaration;


/**
 * This is a automatic generated file according to the OpenSCENARIO specification version 1.0
 * <p>
 * Value class that implements IMiscObject. With setter methods to fill the properties.
 * <ul>
 * <li> getter methods for properties (implemented methods of IMiscObject)
 * <li> setter methods for properties
 * <li> getChildren method to collect all children
 * <li> clone function to make a deep copy
 * <li> overrides from BaseImpl
 * </ul>
 * 
 * @author RA Consulting OpenSCENARIO generation facility
*/
public class MiscObjectImpl extends BaseImpl implements IMiscObject, Cloneable{
	
	/**
	 * Filling the property to type map
	 */
	 static{
		propertyToType.put(OscConstants.ATTRIBUTE__MISC_OBJECT_CATEGORY, String.class);
		propertyToType.put(OscConstants.ATTRIBUTE__MASS, Double.class);
		propertyToType.put(OscConstants.ATTRIBUTE__NAME, String.class);
	}
	
	private MiscObjectCategory miscObjectCategory;
	private Double mass;
	private String name;
	private List<IParameterDeclaration> parameterDeclarations;
	private IBoundingBox boundingBox;
	private IProperties properties;

	@Override
	public MiscObjectCategory getMiscObjectCategory()
	{
		return miscObjectCategory;
	}
	@Override
	public Double getMass()
	{
		return mass;
	}
	@Override
	public String getName()
	{
		return name;
	}
	@Override
	public List<IParameterDeclaration> getParameterDeclarations()
	{
		return parameterDeclarations;
	}
	@Override
	public IBoundingBox getBoundingBox()
	{
		return boundingBox;
	}
	@Override
	public IProperties getProperties()
	{
		return properties;
	}
	/**
	 * Sets the value of model property miscObjectCategory
	 * @param miscObjectCategory from OpenSCENARIO class model specification: [Categorization of the miscellaneous object.]
	 * 
	*/
	public  void setMiscObjectCategory (MiscObjectCategory miscObjectCategory )
	{
		this.miscObjectCategory = miscObjectCategory;
	}
	/**
	 * Sets the value of model property mass
	 * @param mass from OpenSCENARIO class model specification: [Mass of the miscellaneous object. Unit: kg; Range: [0..inf[.]
	 * 
	*/
	public  void setMass (Double mass )
	{
		this.mass = mass;
	}
	/**
	 * Sets the value of model property name
	 * @param name from OpenSCENARIO class model specification: [Name of the miscellaneous object type.]
	 * 
	*/
	public  void setName (String name )
	{
		this.name = name;
	}
	/**
	 * Sets the value of model property parameterDeclarations
	 * @param parameterDeclarations from OpenSCENARIO class model specification: [Definition of additional parameters.]
	 * 
	*/
	public void setParameterDeclarations(List<IParameterDeclaration> parameterDeclarations)
	{
		this.parameterDeclarations = parameterDeclarations;
	}
	/**
	 * Sets the value of model property boundingBox
	 * @param boundingBox from OpenSCENARIO class model specification: [Bounding box definition for the miscellaneous object.]
	 * 
	*/
	public  void setBoundingBox (IBoundingBox boundingBox )
	{
		this.boundingBox = boundingBox;
	}
	/**
	 * Sets the value of model property properties
	 * @param properties from OpenSCENARIO class model specification: [Property definitions for the miscellaneous object.]
	 * 
	*/
	public  void setProperties (IProperties properties )
	{
		this.properties = properties;
	}

	@Override
	public  void resolveParameterInternal(IParserMessageLogger logger,String attributeKey, String parameterLiteralValue)
	{
		if (attributeKey.equals(OscConstants.ATTRIBUTE__MISC_OBJECT_CATEGORY))
		{
			// Enumeration Type
			MiscObjectCategory result = MiscObjectCategory.getFromLiteral(parameterLiteralValue);
			if (result != null)
			{
				miscObjectCategory = result;
				removeResolvedParameter(attributeKey);
			}else
			{
				logger.logMessage(new FileContentMessage( "Value '" + parameterLiteralValue + "' is not allowed.",ErrorLevel.ERROR, getTextmarker(attributeKey)));
			}
				
	 	}
		else if (attributeKey.equals(OscConstants.ATTRIBUTE__MASS))
		{
			// Simple type
			mass = ParserHelper.parseDouble(logger,parameterLiteralValue,getTextmarker(attributeKey));
			removeResolvedParameter(attributeKey);
				
	 	}
		else if (attributeKey.equals(OscConstants.ATTRIBUTE__NAME))
		{
			// Simple type
			name = ParserHelper.parseString(logger,parameterLiteralValue,getTextmarker(attributeKey));
			removeResolvedParameter(attributeKey);
				
	 	}
	}
	
	@Override
	public  Class<?> getTypeFromAttributeName(String attributeKey)
	{
		return propertyToType.get(attributeKey);
	}

	@Override
	public boolean hasParameterDefinitions() {
		return true;
	}
	
	@Override
	public List<ParameterValue> getParameterDefinitions() {
		List<ParameterValue> result = new java.util.ArrayList<ParameterValue>();
		if (parameterDeclarations != null)
		{
			for (IParameterDeclaration parameterDeclaration :parameterDeclarations)
			{
				ParameterValue parameterValue = new ParameterValue(parameterDeclaration.getName(), getParameterType(parameterDeclaration.getParameterType().getLiteral()),parameterDeclaration.getValue());
				result.add(parameterValue);
			}
		}
		return result;
	}

	/**
	 * A list of all aggregated children (lists are flattened). This may be used for applying a specific 
	 * method for any child.
	 * @return a list with all children (as BaseImpl)
	 */
	public List<BaseImpl> getChildren()
	{
		List<BaseImpl> result = new ArrayList<BaseImpl>();
		
			List<IParameterDeclaration> parameterDeclarations = null;
			parameterDeclarations =  getParameterDeclarations();
			if (parameterDeclarations != null)
			{
				for(IParameterDeclaration item : parameterDeclarations)
				{
					result.add((BaseImpl) item);
				}
			}
			IBoundingBox boundingBox = null;
			boundingBox =  getBoundingBox();
			if (boundingBox != null)
			{
				result.add((BaseImpl) boundingBox);
			}	
			IProperties properties = null;
			properties =  getProperties();
			if (properties != null)
			{
				result.add((BaseImpl) properties);
			}	
		return result;
	}
	
	/**
	 * Making a (deep) clone this object. This is useful and used for importing elements from catalogs.
	 * @return a deep copy of the object.
	 */
	public MiscObjectImpl clone()
	{
		MiscObjectImpl clonedObject = new MiscObjectImpl();
		cloneStartMarker(clonedObject);
		cloneEndMarker(clonedObject);
		cloneAttributeKeyToStartMarker(clonedObject);
		cloneAttributeKeyToEndMarker(clonedObject);
		cloneAttributeKeyToParameterNameMap(clonedObject);
		// clone attributes;
		// Enumeration Type
		MiscObjectCategory miscObjectCategory = getMiscObjectCategory();
		if (miscObjectCategory != null)
		{
			clonedObject.setMiscObjectCategory(MiscObjectCategory.getFromLiteral(miscObjectCategory.getLiteral()));
		}
		// Simple type
		clonedObject.setMass(getMass());		
		// Simple type
		clonedObject.setName(getName());		
		// clone children
		List<IParameterDeclaration> parameterDeclarations = null;
			parameterDeclarations =  getParameterDeclarations();
		if (parameterDeclarations != null)
		{
			List<IParameterDeclaration> clonedList = new ArrayList<IParameterDeclaration>();
			for(IParameterDeclaration item : parameterDeclarations)
			{
				ParameterDeclarationImpl clonedChild = ((ParameterDeclarationImpl) item).clone();
				clonedList.add(clonedChild);
				clonedChild.setParent(clonedObject);
			}
			clonedObject.setParameterDeclarations(clonedList);
		}
		IBoundingBox boundingBox = null;
		boundingBox =  getBoundingBox();
		if (boundingBox != null)
		{
			BoundingBoxImpl clonedChild = ((BoundingBoxImpl) boundingBox).clone();
			clonedObject.setBoundingBox(clonedChild);
			clonedChild.setParent(clonedObject);
		}	
		IProperties properties = null;
		properties =  getProperties();
		if (properties != null)
		{
			PropertiesImpl clonedChild = ((PropertiesImpl) properties).clone();
			clonedObject.setProperties(clonedChild);
			clonedChild.setParent(clonedObject);
		}	
		return clonedObject;
	}
	
	
	
}

