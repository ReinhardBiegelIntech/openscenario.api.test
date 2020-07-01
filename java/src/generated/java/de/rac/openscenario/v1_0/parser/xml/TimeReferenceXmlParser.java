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

import de.rac.openscenario.v1_0.impl.TimingImpl;
import de.rac.openscenario.v1_0.impl.NoneImpl;
import de.rac.openscenario.v1_0.impl.TimeReferenceImpl;


import de.rac.openscenario.v1_0.parser.modelgroup.XmlChoiceParser;
import java.util.Map;
import java.util.Hashtable;
import java.util.ArrayList;
import de.rac.openscenario.v1_0.parser.type.XmlComplexTypeParser;


/**
 * This is a automatic generated file according to the OpenSCENARIO specification version 1.0
 * Filling a TimeReferenceImpl instance from an xml tree.
 * 
 * @author RA Consulting OpenSCENARIO generation facility
*/
public class TimeReferenceXmlParser extends XmlComplexTypeParser<TimeReferenceImpl> {

	/**
	 * Constructor
	 * @param messageLogger to log messages during parsing
	 * @param filename to locate the messages in a file
	 */
	public TimeReferenceXmlParser(IParserMessageLogger messageLogger, String filename) {
		super(messageLogger, filename);
		subElementParser = new SubElementParser(messageLogger, filename);
	}
	@Override
	public void parseElement(IndexedElement indexedElement, ParserContext parserContext,TimeReferenceImpl object) {
		messageLogger.logMessage(new FileContentMessage("Start Parsing TimeReference", ErrorLevel.DEBUG, new Textmarker(indexedElement.getStartElementLocation().getLine(), indexedElement.getStartElementLocation().getColumn(), filename))); 
		super.parseElement(indexedElement,  parserContext, object);
		messageLogger.logMessage(new FileContentMessage("End Parsing TimeReference", ErrorLevel.DEBUG, new Textmarker(indexedElement.getEndElementLocation().getLine(), indexedElement.getEndElementLocation().getColumn(), filename))); 
	
	}			
	
	@Override
	protected  Map<String, IAttributeParser<TimeReferenceImpl>> getAttributeNameToAttributeParserMap()
	{
		Map<String, IAttributeParser<TimeReferenceImpl>> result  = new Hashtable<String, IAttributeParser<TimeReferenceImpl>>();
		return result;
	}

	/**
	 * Parser for all subelements
	 */
	private class SubElementParser extends XmlChoiceParser<TimeReferenceImpl>{
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
		protected  List<IElementParser<TimeReferenceImpl>> createParserList()
		{
			List<IElementParser<TimeReferenceImpl>> result = new ArrayList<IElementParser<TimeReferenceImpl>>();
			result.add(new SubElementNoneParser());
			result.add(new SubElementTimingParser());
			return result;
		
		}	
	}
	/**
	 * A parser for subelement none
	 */
	private class SubElementNoneParser implements IElementParser<TimeReferenceImpl> {
	
		/**
		 * Constructor
		 */
		public SubElementNoneParser()
		{
			super();
			noneXmlParser = new NoneXmlParser(messageLogger, filename);
		}
		private NoneXmlParser noneXmlParser;
		
		@Override
		public void parse(IndexedElement indexedElement, ParserContext parserContext,TimeReferenceImpl object)
		{
			NoneImpl none = new NoneImpl();
			// Setting the parent
			none.setParent(object);
			noneXmlParser.parseElement(indexedElement,parserContext, none);

			object.setNone( none);
			
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
				elementName.equals(OscConstants.ELEMENT__NONE) ;
		}
		
		@Override
		public String[] getExpectedTagNames()
		{		 	return new String[]{
				OscConstants.ELEMENT__NONE
					};
		}
	}
	/**
	 * A parser for subelement timing
	 */
	private class SubElementTimingParser implements IElementParser<TimeReferenceImpl> {
	
		/**
		 * Constructor
		 */
		public SubElementTimingParser()
		{
			super();
			timingXmlParser = new TimingXmlParser(messageLogger, filename);
		}
		private TimingXmlParser timingXmlParser;
		
		@Override
		public void parse(IndexedElement indexedElement, ParserContext parserContext,TimeReferenceImpl object)
		{
			TimingImpl timing = new TimingImpl();
			// Setting the parent
			timing.setParent(object);
			timingXmlParser.parseElement(indexedElement,parserContext, timing);

			object.setTiming( timing);
			
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
				elementName.equals(OscConstants.ELEMENT__TIMING) ;
		}
		
		@Override
		public String[] getExpectedTagNames()
		{		 	return new String[]{
				OscConstants.ELEMENT__TIMING
					};
		}
	}
}

