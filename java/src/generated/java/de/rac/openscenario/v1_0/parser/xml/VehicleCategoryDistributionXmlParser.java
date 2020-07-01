package de.rac.openscenario.v1_0.parser.xml;

import de.rac.openscenario.v1_0.common.IParserMessageLogger;
import de.rac.openscenario.v1_0.common.OscConstants;
import de.rac.openscenario.v1_0.simple.struct.IndexedElement;
import de.rac.openscenario.v1_0.parser.ParserContext;
import de.rac.openscenario.v1_0.common.FileContentMessage;
import de.rac.xml.indexer.Position;
import de.rac.openscenario.v1_0.common.Textmarker;
import de.rac.openscenario.v1_0.common.ErrorLevel;
import java.util.List;
import de.rac.openscenario.v1_0.api.IVehicleCategoryDistributionEntry;

import de.rac.openscenario.v1_0.impl.VehicleCategoryDistributionImpl;
import de.rac.openscenario.v1_0.impl.VehicleCategoryDistributionEntryImpl;


import de.rac.openscenario.v1_0.parser.modelgroup.XmlSequenceParser;
import java.util.Map;
import java.util.Hashtable;
import java.util.ArrayList;
import de.rac.openscenario.v1_0.parser.type.XmlComplexTypeParser;


/**
 * This is a automatic generated file according to the OpenSCENARIO specification version 1.0
 * Filling a VehicleCategoryDistributionImpl instance from an xml tree.
 * 
 * @author RA Consulting OpenSCENARIO generation facility
*/
public class VehicleCategoryDistributionXmlParser extends XmlComplexTypeParser<VehicleCategoryDistributionImpl> {

	/**
	 * Constructor
	 * @param messageLogger to log messages during parsing
	 * @param filename to locate the messages in a file
	 */
	public VehicleCategoryDistributionXmlParser(IParserMessageLogger messageLogger, String filename) {
		super(messageLogger, filename);
		subElementParser = new SubElementParser(messageLogger, filename);
	}
	@Override
	public void parseElement(IndexedElement indexedElement, ParserContext parserContext,VehicleCategoryDistributionImpl object) {
		messageLogger.logMessage(new FileContentMessage("Start Parsing VehicleCategoryDistribution", ErrorLevel.DEBUG, new Textmarker(indexedElement.getStartElementLocation().getLine(), indexedElement.getStartElementLocation().getColumn(), filename))); 
		super.parseElement(indexedElement,  parserContext, object);
		messageLogger.logMessage(new FileContentMessage("End Parsing VehicleCategoryDistribution", ErrorLevel.DEBUG, new Textmarker(indexedElement.getEndElementLocation().getLine(), indexedElement.getEndElementLocation().getColumn(), filename))); 
	
	}			
	
	@Override
	protected  Map<String, IAttributeParser<VehicleCategoryDistributionImpl>> getAttributeNameToAttributeParserMap()
	{
		Map<String, IAttributeParser<VehicleCategoryDistributionImpl>> result  = new Hashtable<String, IAttributeParser<VehicleCategoryDistributionImpl>>();
		return result;
	}

	/**
	 * Parser for all subelements
	 */
	private class SubElementParser extends XmlSequenceParser<VehicleCategoryDistributionImpl>{
		/**
		 * Constructor
		 * @param messageLogger to log messages during parsing
		 * @param filename to locate the messages in a file
		 */
		public SubElementParser (IParserMessageLogger messageLogger, String filename) {
			super( messageLogger, filename);	
		}
		/*
		 * Creates a list of parser
		 */
		protected  List<IElementParser<VehicleCategoryDistributionImpl>> createParserList()
		{
			List<IElementParser<VehicleCategoryDistributionImpl>> result = new ArrayList<IElementParser<VehicleCategoryDistributionImpl>>();
			result.add(new SubElementVehicleCategoryDistributionEntriesParser());
			return result;
		
		}	
	}
	/**
	 * A parser for subelement vehicleCategoryDistributionEntries
	 */
	private class SubElementVehicleCategoryDistributionEntriesParser implements IElementParser<VehicleCategoryDistributionImpl> {
	
		/**
		 * Constructor
		 */
		public SubElementVehicleCategoryDistributionEntriesParser()
		{
			super();
			vehicleCategoryDistributionEntryXmlParser = new VehicleCategoryDistributionEntryXmlParser(messageLogger, filename);
		}
		private VehicleCategoryDistributionEntryXmlParser vehicleCategoryDistributionEntryXmlParser;
		
		@Override
		public void parse(IndexedElement indexedElement, ParserContext parserContext,VehicleCategoryDistributionImpl object)
		{
			VehicleCategoryDistributionEntryImpl vehicleCategoryDistributionEntries = new VehicleCategoryDistributionEntryImpl();
			// Setting the parent
			vehicleCategoryDistributionEntries.setParent(object);
			vehicleCategoryDistributionEntryXmlParser.parseElement(indexedElement,parserContext, vehicleCategoryDistributionEntries);
			List<IVehicleCategoryDistributionEntry> vehicleCategoryDistributionEntriesList = object.getVehicleCategoryDistributionEntries();
			if (vehicleCategoryDistributionEntriesList == null)
			{
				vehicleCategoryDistributionEntriesList = new ArrayList<IVehicleCategoryDistributionEntry>();
				object.setVehicleCategoryDistributionEntries( vehicleCategoryDistributionEntriesList);
			}
			vehicleCategoryDistributionEntriesList.add(vehicleCategoryDistributionEntries);
			
		}

		@Override
		public int getMinOccur()
		{
			return 1;
		}
		
		@Override
		public int getMaxOccur()
		{
			return -1;
		}
		
		@Override
		public boolean doesMatch(String elementName)
		{
			return
				elementName.equals(OscConstants.ELEMENT__VEHICLE_CATEGORY_DISTRIBUTION_ENTRY) ;
		}
		
		@Override
		public String[] getExpectedTagNames()
		{		 	return new String[]{
				OscConstants.ELEMENT__VEHICLE_CATEGORY_DISTRIBUTION_ENTRY
					};
		}
	}
}

