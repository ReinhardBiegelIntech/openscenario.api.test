package de.rac.openscenario.v1_0.parser.xml;

import de.rac.openscenario.v1_0.common.IParserMessageLogger;
import de.rac.openscenario.v1_0.common.OscConstants;
import de.rac.openscenario.v1_0.simple.struct.IndexedElement;
import de.rac.openscenario.v1_0.parser.ParserContext;
import de.rac.openscenario.v1_0.common.FileContentMessage;
import de.rac.xml.indexer.Position;
import de.rac.openscenario.v1_0.common.Textmarker;
import de.rac.openscenario.v1_0.common.ErrorLevel;
import de.rac.openscenario.v1_0.parser.WrappedListParser;
import java.util.List;
import de.rac.openscenario.v1_0.api.ITrafficSignalController;

import de.rac.openscenario.v1_0.impl.TrafficSignalControllerImpl;
import de.rac.openscenario.v1_0.impl.RoadNetworkImpl;
import de.rac.openscenario.v1_0.impl.FileImpl;


import de.rac.openscenario.v1_0.parser.modelgroup.XmlSequenceParser;
import java.util.Map;
import java.util.Hashtable;
import java.util.ArrayList;
import de.rac.openscenario.v1_0.parser.type.XmlComplexTypeParser;


/**
 * This is a automatic generated file according to the OpenSCENARIO specification version 1.0
 * Filling a RoadNetworkImpl instance from an xml tree.
 * 
 * @author RA Consulting OpenSCENARIO generation facility
*/
public class RoadNetworkXmlParser extends XmlComplexTypeParser<RoadNetworkImpl> {

	/**
	 * Constructor
	 * @param messageLogger to log messages during parsing
	 * @param filename to locate the messages in a file
	 */
	public RoadNetworkXmlParser(IParserMessageLogger messageLogger, String filename) {
		super(messageLogger, filename);
		subElementParser = new SubElementParser(messageLogger, filename);
	}
	@Override
	public void parseElement(IndexedElement indexedElement, ParserContext parserContext,RoadNetworkImpl object) {
		messageLogger.logMessage(new FileContentMessage("Start Parsing RoadNetwork", ErrorLevel.DEBUG, new Textmarker(indexedElement.getStartElementLocation().getLine(), indexedElement.getStartElementLocation().getColumn(), filename))); 
		super.parseElement(indexedElement,  parserContext, object);
		messageLogger.logMessage(new FileContentMessage("End Parsing RoadNetwork", ErrorLevel.DEBUG, new Textmarker(indexedElement.getEndElementLocation().getLine(), indexedElement.getEndElementLocation().getColumn(), filename))); 
	
	}			
	
	@Override
	protected  Map<String, IAttributeParser<RoadNetworkImpl>> getAttributeNameToAttributeParserMap()
	{
		Map<String, IAttributeParser<RoadNetworkImpl>> result  = new Hashtable<String, IAttributeParser<RoadNetworkImpl>>();
		return result;
	}

	/**
	 * Parser for all subelements
	 */
	private class SubElementParser extends XmlSequenceParser<RoadNetworkImpl>{
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
		protected  List<IElementParser<RoadNetworkImpl>> createParserList()
		{
			List<IElementParser<RoadNetworkImpl>> result = new ArrayList<IElementParser<RoadNetworkImpl>>();
			result.add(new SubElementLogicFileParser());
			result.add(new SubElementSceneGraphFileParser());
			result.add(new WrappedListParser<RoadNetworkImpl>(messageLogger,filename,new SubElementTrafficSignalsParser(), OscConstants.ELEMENT__TRAFFIC_SIGNALS) );
			return result;
		
		}	
	}
	/**
	 * A parser for subelement logicFile
	 */
	private class SubElementLogicFileParser implements IElementParser<RoadNetworkImpl> {
	
		/**
		 * Constructor
		 */
		public SubElementLogicFileParser()
		{
			super();
			fileXmlParser = new FileXmlParser(messageLogger, filename);
		}
		private FileXmlParser fileXmlParser;
		
		@Override
		public void parse(IndexedElement indexedElement, ParserContext parserContext,RoadNetworkImpl object)
		{
			FileImpl logicFile = new FileImpl();
			// Setting the parent
			logicFile.setParent(object);
			fileXmlParser.parseElement(indexedElement,parserContext, logicFile);

			object.setLogicFile( logicFile);
			
		}

		@Override
		public int getMinOccur()
		{
			return 0;
		}
		
		@Override
		public int getMaxOccur()
		{
			return 1;
		}
		
		@Override
		public boolean doesMatch(String elementName)
		{
			return
				elementName.equals(OscConstants.ELEMENT__LOGIC_FILE) ;
		}
		
		@Override
		public String[] getExpectedTagNames()
		{		 	return new String[]{
				OscConstants.ELEMENT__LOGIC_FILE
					};
		}
	}
	/**
	 * A parser for subelement sceneGraphFile
	 */
	private class SubElementSceneGraphFileParser implements IElementParser<RoadNetworkImpl> {
	
		/**
		 * Constructor
		 */
		public SubElementSceneGraphFileParser()
		{
			super();
			fileXmlParser = new FileXmlParser(messageLogger, filename);
		}
		private FileXmlParser fileXmlParser;
		
		@Override
		public void parse(IndexedElement indexedElement, ParserContext parserContext,RoadNetworkImpl object)
		{
			FileImpl sceneGraphFile = new FileImpl();
			// Setting the parent
			sceneGraphFile.setParent(object);
			fileXmlParser.parseElement(indexedElement,parserContext, sceneGraphFile);

			object.setSceneGraphFile( sceneGraphFile);
			
		}

		@Override
		public int getMinOccur()
		{
			return 0;
		}
		
		@Override
		public int getMaxOccur()
		{
			return 1;
		}
		
		@Override
		public boolean doesMatch(String elementName)
		{
			return
				elementName.equals(OscConstants.ELEMENT__SCENE_GRAPH_FILE) ;
		}
		
		@Override
		public String[] getExpectedTagNames()
		{		 	return new String[]{
				OscConstants.ELEMENT__SCENE_GRAPH_FILE
					};
		}
	}
	/**
	 * A parser for subelement trafficSignals
	 */
	private class SubElementTrafficSignalsParser implements IElementParser<RoadNetworkImpl> {
	
		/**
		 * Constructor
		 */
		public SubElementTrafficSignalsParser()
		{
			super();
			trafficSignalControllerXmlParser = new TrafficSignalControllerXmlParser(messageLogger, filename);
		}
		private TrafficSignalControllerXmlParser trafficSignalControllerXmlParser;
		
		@Override
		public void parse(IndexedElement indexedElement, ParserContext parserContext,RoadNetworkImpl object)
		{
			TrafficSignalControllerImpl trafficSignals = new TrafficSignalControllerImpl();
			// Setting the parent
			trafficSignals.setParent(object);
			trafficSignalControllerXmlParser.parseElement(indexedElement,parserContext, trafficSignals);
			List<ITrafficSignalController> trafficSignalsList = object.getTrafficSignals();
			if (trafficSignalsList == null)
			{
				trafficSignalsList = new ArrayList<ITrafficSignalController>();
				object.setTrafficSignals( trafficSignalsList);
			}
			trafficSignalsList.add(trafficSignals);
			
		}

		@Override
		public int getMinOccur()
		{
			return 0;
		}
		
		@Override
		public int getMaxOccur()
		{
			return -1;
		}
		
		@Override
		public boolean doesMatch(String elementName)
		{
			return elementName.equals(OscConstants.ELEMENT__TRAFFIC_SIGNAL_CONTROLLER);			
		}
		
		@Override
		public String[] getExpectedTagNames()
		{			return new String[]{OscConstants.ELEMENT__TRAFFIC_SIGNAL_CONTROLLER};
		}
	}
}

