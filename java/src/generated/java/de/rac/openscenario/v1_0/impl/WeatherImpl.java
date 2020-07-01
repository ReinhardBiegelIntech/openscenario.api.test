package de.rac.openscenario.v1_0.impl;

import de.rac.openscenario.v1_0.api.IWeather;
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

import de.rac.openscenario.v1_0.api.CloudState;
import de.rac.openscenario.v1_0.api.ISun;
import de.rac.openscenario.v1_0.api.IFog;
import de.rac.openscenario.v1_0.api.IPrecipitation;


/**
 * This is a automatic generated file according to the OpenSCENARIO specification version 1.0
 * <p>
 * Value class that implements IWeather. With setter methods to fill the properties.
 * <ul>
 * <li> getter methods for properties (implemented methods of IWeather)
 * <li> setter methods for properties
 * <li> getChildren method to collect all children
 * <li> clone function to make a deep copy
 * <li> overrides from BaseImpl
 * </ul>
 * 
 * @author RA Consulting OpenSCENARIO generation facility
*/
public class WeatherImpl extends BaseImpl implements IWeather, Cloneable{
	
	/**
	 * Filling the property to type map
	 */
	 static{
		propertyToType.put(OscConstants.ATTRIBUTE__CLOUD_STATE, String.class);
	}
	
	private CloudState cloudState;
	private ISun sun;
	private IFog fog;
	private IPrecipitation precipitation;

	@Override
	public CloudState getCloudState()
	{
		return cloudState;
	}
	@Override
	public ISun getSun()
	{
		return sun;
	}
	@Override
	public IFog getFog()
	{
		return fog;
	}
	@Override
	public IPrecipitation getPrecipitation()
	{
		return precipitation;
	}
	/**
	 * Sets the value of model property cloudState
	 * @param cloudState from OpenSCENARIO class model specification: [Definition of the cloud state, i.e. cloud state and sky 
	 * visualization settings.]
	 * 
	*/
	public  void setCloudState (CloudState cloudState )
	{
		this.cloudState = cloudState;
	}
	/**
	 * Sets the value of model property sun
	 * @param sun from OpenSCENARIO class model specification: [Definition of the sun, i.e. position and intensity.]
	 * 
	*/
	public  void setSun (ISun sun )
	{
		this.sun = sun;
	}
	/**
	 * Sets the value of model property fog
	 * @param fog from OpenSCENARIO class model specification: [Definition of fog, i.e. visual range and bounding box.]
	 * 
	*/
	public  void setFog (IFog fog )
	{
		this.fog = fog;
	}
	/**
	 * Sets the value of model property precipitation
	 * @param precipitation from OpenSCENARIO class model specification: [Definition of precipitation, i.e. type and 
	 * intensity.]
	 * 
	*/
	public  void setPrecipitation (IPrecipitation precipitation )
	{
		this.precipitation = precipitation;
	}

	@Override
	public  void resolveParameterInternal(IParserMessageLogger logger,String attributeKey, String parameterLiteralValue)
	{
		if (attributeKey.equals(OscConstants.ATTRIBUTE__CLOUD_STATE))
		{
			// Enumeration Type
			CloudState result = CloudState.getFromLiteral(parameterLiteralValue);
			if (result != null)
			{
				cloudState = result;
				removeResolvedParameter(attributeKey);
			}else
			{
				logger.logMessage(new FileContentMessage( "Value '" + parameterLiteralValue + "' is not allowed.",ErrorLevel.ERROR, getTextmarker(attributeKey)));
			}
				
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
		
			ISun sun = null;
			sun =  getSun();
			if (sun != null)
			{
				result.add((BaseImpl) sun);
			}	
			IFog fog = null;
			fog =  getFog();
			if (fog != null)
			{
				result.add((BaseImpl) fog);
			}	
			IPrecipitation precipitation = null;
			precipitation =  getPrecipitation();
			if (precipitation != null)
			{
				result.add((BaseImpl) precipitation);
			}	
		return result;
	}
	
	/**
	 * Making a (deep) clone this object. This is useful and used for importing elements from catalogs.
	 * @return a deep copy of the object.
	 */
	public WeatherImpl clone()
	{
		WeatherImpl clonedObject = new WeatherImpl();
		cloneStartMarker(clonedObject);
		cloneEndMarker(clonedObject);
		cloneAttributeKeyToStartMarker(clonedObject);
		cloneAttributeKeyToEndMarker(clonedObject);
		cloneAttributeKeyToParameterNameMap(clonedObject);
		// clone attributes;
		// Enumeration Type
		CloudState cloudState = getCloudState();
		if (cloudState != null)
		{
			clonedObject.setCloudState(CloudState.getFromLiteral(cloudState.getLiteral()));
		}
		// clone children
		ISun sun = null;
		sun =  getSun();
		if (sun != null)
		{
			SunImpl clonedChild = ((SunImpl) sun).clone();
			clonedObject.setSun(clonedChild);
			clonedChild.setParent(clonedObject);
		}	
		IFog fog = null;
		fog =  getFog();
		if (fog != null)
		{
			FogImpl clonedChild = ((FogImpl) fog).clone();
			clonedObject.setFog(clonedChild);
			clonedChild.setParent(clonedObject);
		}	
		IPrecipitation precipitation = null;
		precipitation =  getPrecipitation();
		if (precipitation != null)
		{
			PrecipitationImpl clonedChild = ((PrecipitationImpl) precipitation).clone();
			clonedObject.setPrecipitation(clonedChild);
			clonedChild.setParent(clonedObject);
		}	
		return clonedObject;
	}
	
	
	
}

