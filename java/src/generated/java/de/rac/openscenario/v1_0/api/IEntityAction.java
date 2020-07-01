package de.rac.openscenario.v1_0.api;

import de.rac.openscenario.v1_0.common.INamedReference;
/**
 * This is a automatic generated file according to the OpenSCENARIO specification version 1.0
 * <p>
 * From OpenSCENARIO class model specification:
 * Defines an action that adds
 * 
 * @author RA Consulting OpenSCENARIO generation facility
*/
public interface IEntityAction extends IOpenScenarioModelElement{

	/**
	 * From OpenSCENARIO class model specification:
	 * Name of the reference entity.
	 * 
	 * @return value of model property entityRef
	*/
	public INamedReference<IEntity> getEntityRef();

	/**
	 * From OpenSCENARIO class model specification:
	 * Action that adds the reference entity to the scenario.
	 * 
	 * @return value of model property addEntityAction
	*/
	public IAddEntityAction getAddEntityAction();

	/**
	 * From OpenSCENARIO class model specification:
	 * Action that deletes the reference entity from the scenario.
	 * 
	 * @return value of model property deleteEntityAction
	*/
	public IDeleteEntityAction getDeleteEntityAction();
}
