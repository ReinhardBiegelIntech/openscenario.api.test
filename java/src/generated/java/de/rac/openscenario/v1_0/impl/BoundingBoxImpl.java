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

import de.rac.openscenario.v1_0.api.IBoundingBox;
import de.rac.openscenario.v1_0.impl.BaseImpl;
import de.rac.openscenario.v1_0.common.ILocator;
import de.rac.openscenario.v1_0.common.IParserMessageLogger;
import de.rac.openscenario.v1_0.common.OscConstants;
import de.rac.openscenario.v1_0.common.FileContentMessage;
import de.rac.openscenario.v1_0.api.IOpenScenarioModelElement;
import java.lang.Cloneable;
import java.util.Hashtable;
import java.util.List;
import java.util.ArrayList;

import de.rac.openscenario.v1_0.api.IDimensions;
import de.rac.openscenario.v1_0.api.ICenter;


/**
 * This is a automatic generated file according to the OpenSCENARIO specification version 1.0
 * <p>
 * Value class that implements IBoundingBox. With setter methods to fill the properties.
 * <ul>
 * <li> getter methods for properties (implemented methods of IBoundingBox)
 * <li> setter methods for properties
 * <li> getChildren method to collect all children
 * <li> clone function to make a deep copy
 * <li> overrides from BaseImpl
 * </ul>
 * 
 * @author RA Consulting OpenSCENARIO generation facility
*/
public class BoundingBoxImpl extends BaseImpl implements IBoundingBox, Cloneable{
	
	/**
	 * Filling the property to type map
	 */
	 static{
	}
	
	private ICenter center;
	private IDimensions dimensions;

	@Override
	public ICenter getCenter()
	{
		return center;
	}
	@Override
	public IDimensions getDimensions()
	{
		return dimensions;
	}
	/**
	 * Sets the value of model property center
	 * @param center from OpenSCENARIO class model specification: [Represents the geometrical center of the bounding box 
	 * expressed in coordinates that refer to the coordinate system of , the entity (e.g. the vehicle coordinate system).]
	 * 
	*/
	public  void setCenter (ICenter center )
	{
		this.center = center;
	}
	/**
	 * Sets the value of model property dimensions
	 * @param dimensions from OpenSCENARIO class model specification: [Width, length and height of the bounding box.]
	 * 
	*/
	public  void setDimensions (IDimensions dimensions )
	{
		this.dimensions = dimensions;
	}

	@Override
	public  void resolveParameterInternal(IParserMessageLogger logger,String attributeKey, String parameterLiteralValue)
	{
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
		
			ICenter center = null;
			center =  getCenter();
			if (center != null)
			{
				result.add((BaseImpl) center);
			}	
			IDimensions dimensions = null;
			dimensions =  getDimensions();
			if (dimensions != null)
			{
				result.add((BaseImpl) dimensions);
			}	
		return result;
	}
	
	/**
	 * Making a (deep) clone this object. This is useful and used for importing elements from catalogs.
	 * @return a deep copy of the object.
	 */
	public BoundingBoxImpl clone()
	{
		BoundingBoxImpl clonedObject = new BoundingBoxImpl();
		cloneStartMarker(clonedObject);
		cloneEndMarker(clonedObject);
		cloneAttributeKeyToStartMarker(clonedObject);
		cloneAttributeKeyToEndMarker(clonedObject);
		cloneAttributeKeyToParameterNameMap(clonedObject);
		// clone attributes;
		// clone children
		ICenter center = null;
		center =  getCenter();
		if (center != null)
		{
			CenterImpl clonedChild = ((CenterImpl) center).clone();
			clonedObject.setCenter(clonedChild);
			clonedChild.setParent(clonedObject);
		}	
		IDimensions dimensions = null;
		dimensions =  getDimensions();
		if (dimensions != null)
		{
			DimensionsImpl clonedChild = ((DimensionsImpl) dimensions).clone();
			clonedObject.setDimensions(clonedChild);
			clonedChild.setParent(clonedObject);
		}	
		return clonedObject;
	}
	
	
	
}
