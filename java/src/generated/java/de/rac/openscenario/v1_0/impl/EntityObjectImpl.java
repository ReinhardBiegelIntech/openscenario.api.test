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

import de.rac.openscenario.v1_0.api.IEntityObject;
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

import de.rac.openscenario.v1_0.api.IVehicle;
import de.rac.openscenario.v1_0.api.IMiscObject;
import de.rac.openscenario.v1_0.api.IPedestrian;
import de.rac.openscenario.v1_0.api.ICatalogReference;


/**
 * This is a automatic generated file according to the OpenSCENARIO specification version 1.0
 * <p>
 * Value class that implements IEntityObject. With setter methods to fill the properties.
 * <ul>
 * <li> getter methods for properties (implemented methods of IEntityObject)
 * <li> setter methods for properties
 * <li> getChildren method to collect all children
 * <li> clone function to make a deep copy
 * <li> overrides from BaseImpl
 * </ul>
 * 
 * @author RA Consulting OpenSCENARIO generation facility
*/
public class EntityObjectImpl extends BaseImpl implements IEntityObject, Cloneable{
	
	/**
	 * Filling the property to type map
	 */
	 static{
	}
	
	private ICatalogReference catalogReference;
	private IVehicle vehicle;
	private IPedestrian pedestrian;
	private IMiscObject miscObject;

	@Override
	public ICatalogReference getCatalogReference()
	{
		return catalogReference;
	}
	@Override
	public IVehicle getVehicle()
	{
		return vehicle;
	}
	@Override
	public IPedestrian getPedestrian()
	{
		return pedestrian;
	}
	@Override
	public IMiscObject getMiscObject()
	{
		return miscObject;
	}
	/**
	 * Sets the value of model property catalogReference
	 * @param catalogReference from OpenSCENARIO class model specification: [Reference to a catalog entry of type MiscObject, 
	 * Vehicle or Pedestrian.]
	 * 
	*/
	public  void setCatalogReference (ICatalogReference catalogReference )
	{
		this.catalogReference = catalogReference;
	}
	/**
	 * Sets the value of model property vehicle
	 * @param vehicle from OpenSCENARIO class model specification: [Vehicle definition.]
	 * 
	*/
	public  void setVehicle (IVehicle vehicle )
	{
		this.vehicle = vehicle;
	}
	/**
	 * Sets the value of model property pedestrian
	 * @param pedestrian from OpenSCENARIO class model specification: [Pedestrian definition.]
	 * 
	*/
	public  void setPedestrian (IPedestrian pedestrian )
	{
		this.pedestrian = pedestrian;
	}
	/**
	 * Sets the value of model property miscObject
	 * @param miscObject from OpenSCENARIO class model specification: [Definition of a MiscObject.]
	 * 
	*/
	public  void setMiscObject (IMiscObject miscObject )
	{
		this.miscObject = miscObject;
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
		
			ICatalogReference catalogReference = null;
			catalogReference =  getCatalogReference();
			if (catalogReference != null)
			{
				result.add((BaseImpl) catalogReference);
			}	
			IVehicle vehicle = null;
			vehicle =  getVehicle();
			if (vehicle != null)
			{
				result.add((BaseImpl) vehicle);
			}	
			IPedestrian pedestrian = null;
			pedestrian =  getPedestrian();
			if (pedestrian != null)
			{
				result.add((BaseImpl) pedestrian);
			}	
			IMiscObject miscObject = null;
			miscObject =  getMiscObject();
			if (miscObject != null)
			{
				result.add((BaseImpl) miscObject);
			}	
		return result;
	}
	
	/**
	 * Making a (deep) clone this object. This is useful and used for importing elements from catalogs.
	 * @return a deep copy of the object.
	 */
	public EntityObjectImpl clone()
	{
		EntityObjectImpl clonedObject = new EntityObjectImpl();
		cloneStartMarker(clonedObject);
		cloneEndMarker(clonedObject);
		cloneAttributeKeyToStartMarker(clonedObject);
		cloneAttributeKeyToEndMarker(clonedObject);
		cloneAttributeKeyToParameterNameMap(clonedObject);
		// clone attributes;
		// clone children
		ICatalogReference catalogReference = null;
		catalogReference =  getCatalogReference();
		if (catalogReference != null)
		{
			CatalogReferenceImpl clonedChild = ((CatalogReferenceImpl) catalogReference).clone();
			clonedObject.setCatalogReference(clonedChild);
			clonedChild.setParent(clonedObject);
		}	
		IVehicle vehicle = null;
		vehicle =  getVehicle();
		if (vehicle != null)
		{
			VehicleImpl clonedChild = ((VehicleImpl) vehicle).clone();
			clonedObject.setVehicle(clonedChild);
			clonedChild.setParent(clonedObject);
		}	
		IPedestrian pedestrian = null;
		pedestrian =  getPedestrian();
		if (pedestrian != null)
		{
			PedestrianImpl clonedChild = ((PedestrianImpl) pedestrian).clone();
			clonedObject.setPedestrian(clonedChild);
			clonedChild.setParent(clonedObject);
		}	
		IMiscObject miscObject = null;
		miscObject =  getMiscObject();
		if (miscObject != null)
		{
			MiscObjectImpl clonedChild = ((MiscObjectImpl) miscObject).clone();
			clonedObject.setMiscObject(clonedChild);
			clonedChild.setParent(clonedObject);
		}	
		return clonedObject;
	}
	
	
	
}
