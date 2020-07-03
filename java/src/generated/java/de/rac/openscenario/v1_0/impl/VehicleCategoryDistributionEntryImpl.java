/*
 * Copyright 2020 RA Consulting
 *
 * RA Consulting GmbH licenses this file under the Apache License, 
 * Version 2.0 (the "License"); you may not use this file except 
 * in compliance with the License. 
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
 
package de.rac.openscenario.v1_0.impl;

import de.rac.openscenario.v1_0.api.IVehicleCategoryDistributionEntry;
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

import de.rac.openscenario.v1_0.api.VehicleCategory;


/**
 * This is a automatic generated file according to the OpenSCENARIO specification version 1.0
 * <p>
 * Value class that implements IVehicleCategoryDistributionEntry. With setter methods to fill the properties.
 * <ul>
 * <li> getter methods for properties (implemented methods of IVehicleCategoryDistributionEntry)
 * <li> setter methods for properties
 * <li> getChildren method to collect all children
 * <li> clone function to make a deep copy
 * <li> overrides from BaseImpl
 * </ul>
 * 
 * @author RA Consulting OpenSCENARIO generation facility
*/
public class VehicleCategoryDistributionEntryImpl extends BaseImpl implements IVehicleCategoryDistributionEntry, Cloneable{
	
	/**
	 * Filling the property to type map
	 */
	 static{
		propertyToType.put(OscConstants.ATTRIBUTE__CATEGORY, String.class);
		propertyToType.put(OscConstants.ATTRIBUTE__WEIGHT, Double.class);
	}
	
	private VehicleCategory category;
	private Double weight;

	@Override
	public VehicleCategory getCategory()
	{
		return category;
	}
	@Override
	public Double getWeight()
	{
		return weight;
	}
	/**
	 * Sets the value of model property category
	 * @param category from OpenSCENARIO class model specification: [The category of the vehicles that appear in traffic.]
	 * 
	*/
	public  void setCategory (VehicleCategory category )
	{
		this.category = category;
	}
	/**
	 * Sets the value of model property weight
	 * @param weight from OpenSCENARIO class model specification: [The weight of a vehicle category within a traffic 
	 * distribution. Range: [0..inf[.]
	 * 
	*/
	public  void setWeight (Double weight )
	{
		this.weight = weight;
	}

	@Override
	public  void resolveParameterInternal(IParserMessageLogger logger,String attributeKey, String parameterLiteralValue)
	{
		if (attributeKey.equals(OscConstants.ATTRIBUTE__CATEGORY))
		{
			// Enumeration Type
			VehicleCategory result = VehicleCategory.getFromLiteral(parameterLiteralValue);
			if (result != null)
			{
				category = result;
				removeResolvedParameter(attributeKey);
			}else
			{
				logger.logMessage(new FileContentMessage( "Value '" + parameterLiteralValue + "' is not allowed.",ErrorLevel.ERROR, getTextmarker(attributeKey)));
			}
				
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
		
		return result;
	}
	
	/**
	 * Making a (deep) clone this object. This is useful and used for importing elements from catalogs.
	 * @return a deep copy of the object.
	 */
	public VehicleCategoryDistributionEntryImpl clone()
	{
		VehicleCategoryDistributionEntryImpl clonedObject = new VehicleCategoryDistributionEntryImpl();
		cloneStartMarker(clonedObject);
		cloneEndMarker(clonedObject);
		cloneAttributeKeyToStartMarker(clonedObject);
		cloneAttributeKeyToEndMarker(clonedObject);
		cloneAttributeKeyToParameterNameMap(clonedObject);
		// clone attributes;
		// Enumeration Type
		VehicleCategory category = getCategory();
		if (category != null)
		{
			clonedObject.setCategory(VehicleCategory.getFromLiteral(category.getLiteral()));
		}
		// Simple type
		clonedObject.setWeight(getWeight());		
		// clone children
		return clonedObject;
	}
	
	
	
}
