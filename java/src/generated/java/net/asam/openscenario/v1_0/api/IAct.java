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
package net.asam.openscenario.v1_0.api;
import java.util.List;

import net.asam.openscenario.api.IOpenScenarioModelElement;
/**
 * This is a automatic generated file according to the OpenSCENARIO specification version 1.0
 * <p>
 * From OpenSCENARIO class model specification:
 * A container for maneuver groups. Can be executed several times depending on the user provided settings. New executions
 * are only allowed to start when all contained maneuver groups are in the complete state.
 * 
 * @author RA Consulting OpenSCENARIO generation facility
*/
public interface IAct extends IOpenScenarioModelElement,IStoryboardElement{

	/**
	 * From OpenSCENARIO class model specification:
	 * Name of this act.
	 * 
	 * @return value of model property name
	*/
	public String getName();

	/**
	 * From OpenSCENARIO class model specification:
	 * A list of maneuver groups representing the act.
	 * 
	 * @return value of model property maneuverGroups
	*/
	public List<IManeuverGroup> getManeuverGroups();

	/**
	 * From OpenSCENARIO class model specification:
	 * Defines a trigger to that starts the act.
	 * 
	 * @return value of model property startTrigger
	*/
	public ITrigger getStartTrigger();

	/**
	 * From OpenSCENARIO class model specification:
	 * Defines a trigger that stops the act.
	 * 
	 * @return value of model property stopTrigger
	*/
	public ITrigger getStopTrigger();
}
