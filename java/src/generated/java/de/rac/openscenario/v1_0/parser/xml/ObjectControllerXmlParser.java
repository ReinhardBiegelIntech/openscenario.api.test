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

import de.rac.openscenario.v1_0.impl.ControllerImpl;
import de.rac.openscenario.v1_0.impl.ObjectControllerImpl;
import de.rac.openscenario.v1_0.impl.CatalogReferenceImpl;


import de.rac.openscenario.v1_0.parser.modelgroup.XmlChoiceParser;
import java.util.Map;
import java.util.Hashtable;
import java.util.ArrayList;
import de.rac.openscenario.v1_0.parser.type.XmlComplexTypeParser;


/**
 * This is a automatic generated file according to the OpenSCENARIO specification version 1.0
 * Filling a ObjectControllerImpl instance from an xml tree.
 * 
 * @author RA Consulting OpenSCENARIO generation facility
*/
public class ObjectControllerXmlParser extends XmlComplexTypeParser<ObjectControllerImpl> {

	/**
	 * Constructor
	 * @param messageLogger to log messages during parsing
	 * @param filename to locate the messages in a file
	 */
	public ObjectControllerXmlParser(IParserMessageLogger messageLogger, String filename) {
		super(messageLogger, filename);
		subElementParser = new SubElementParser(messageLogger, filename);
	}
	@Override
	public void parseElement(IndexedElement indexedElement, ParserContext parserContext,ObjectControllerImpl object) {
		messageLogger.logMessage(new FileContentMessage("Start Parsing ObjectController", ErrorLevel.DEBUG, new Textmarker(indexedElement.getStartElementLocation().getLine(), indexedElement.getStartElementLocation().getColumn(), filename))); 
		super.parseElement(indexedElement,  parserContext, object);
		messageLogger.logMessage(new FileContentMessage("End Parsing ObjectController", ErrorLevel.DEBUG, new Textmarker(indexedElement.getEndElementLocation().getLine(), indexedElement.getEndElementLocation().getColumn(), filename))); 
	
	}			
	
	@Override
	protected  Map<String, IAttributeParser<ObjectControllerImpl>> getAttributeNameToAttributeParserMap()
	{
		Map<String, IAttributeParser<ObjectControllerImpl>> result  = new Hashtable<String, IAttributeParser<ObjectControllerImpl>>();
		return result;
	}

	/**
	 * Parser for all subelements
	 */
	private class SubElementParser extends XmlChoiceParser<ObjectControllerImpl>{
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
		protected  List<IElementParser<ObjectControllerImpl>> createParserList()
		{
			List<IElementParser<ObjectControllerImpl>> result = new ArrayList<IElementParser<ObjectControllerImpl>>();
			result.add(new SubElementCatalogReferenceParser());
			result.add(new SubElementControllerParser());
			return result;
		
		}	
	}
	/**
	 * A parser for subelement catalogReference
	 */
	private class SubElementCatalogReferenceParser implements IElementParser<ObjectControllerImpl> {
	
		/**
		 * Constructor
		 */
		public SubElementCatalogReferenceParser()
		{
			super();
			catalogReferenceXmlParser = new CatalogReferenceXmlParser(messageLogger, filename);
		}
		private CatalogReferenceXmlParser catalogReferenceXmlParser;
		
		@Override
		public void parse(IndexedElement indexedElement, ParserContext parserContext,ObjectControllerImpl object)
		{
			CatalogReferenceImpl catalogReference = new CatalogReferenceImpl();
			// Setting the parent
			catalogReference.setParent(object);
			catalogReferenceXmlParser.parseElement(indexedElement,parserContext, catalogReference);

			object.setCatalogReference( catalogReference);
			parserContext.addCatalogReference(catalogReference);
			
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
				elementName.equals(OscConstants.ELEMENT__CATALOG_REFERENCE) ;
		}
		
		@Override
		public String[] getExpectedTagNames()
		{		 	return new String[]{
				OscConstants.ELEMENT__CATALOG_REFERENCE
					};
		}
	}
	/**
	 * A parser for subelement controller
	 */
	private class SubElementControllerParser implements IElementParser<ObjectControllerImpl> {
	
		/**
		 * Constructor
		 */
		public SubElementControllerParser()
		{
			super();
			controllerXmlParser = new ControllerXmlParser(messageLogger, filename);
		}
		private ControllerXmlParser controllerXmlParser;
		
		@Override
		public void parse(IndexedElement indexedElement, ParserContext parserContext,ObjectControllerImpl object)
		{
			ControllerImpl controller = new ControllerImpl();
			// Setting the parent
			controller.setParent(object);
			controllerXmlParser.parseElement(indexedElement,parserContext, controller);

			object.setController( controller);
			
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
				elementName.equals(OscConstants.ELEMENT__CONTROLLER) ;
		}
		
		@Override
		public String[] getExpectedTagNames()
		{		 	return new String[]{
				OscConstants.ELEMENT__CONTROLLER
					};
		}
	}
}

