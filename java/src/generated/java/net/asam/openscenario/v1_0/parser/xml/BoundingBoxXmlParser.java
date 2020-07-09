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
package net.asam.openscenario.v1_0.parser.xml;

import net.asam.openscenario.common.IParserMessageLogger;
import net.asam.openscenario.v1_0.common.OscConstants;
import net.asam.openscenario.simple.struct.IndexedElement;
import net.asam.openscenario.parser.ParserContext;
import net.asam.openscenario.v1_0.parser.CatalogReferenceParserContext;
import net.asam.openscenario.common.FileContentMessage;
import net.asam.xml.indexer.Position;
import net.asam.openscenario.common.Textmarker;
import net.asam.openscenario.common.ErrorLevel;
import java.util.List;

import net.asam.openscenario.v1_0.impl.BoundingBoxImpl;
import net.asam.openscenario.v1_0.impl.DimensionsImpl;
import net.asam.openscenario.v1_0.impl.CenterImpl;


import net.asam.openscenario.parser.modelgroup.XmlAllParser;
import java.util.Map;
import java.util.Hashtable;
import java.util.ArrayList;
import net.asam.openscenario.parser.type.XmlComplexTypeParser;


/**
 * This is a automatic generated file according to the OpenSCENARIO specification version 1.0
 * Filling a BoundingBoxImpl instance from an xml tree.
 * 
 * @author RA Consulting OpenSCENARIO generation facility
*/
public class BoundingBoxXmlParser extends XmlComplexTypeParser<BoundingBoxImpl> {

	/**
	 * Constructor
	 * @param messageLogger to log messages during parsing
	 * @param filename to locate the messages in a file
	 */
	public BoundingBoxXmlParser(IParserMessageLogger messageLogger, String filename) {
		super(messageLogger, filename);
		subElementParser = new SubElementParser(messageLogger, filename);
	}
	@Override
	public void parseElement(IndexedElement indexedElement, ParserContext parserContext,BoundingBoxImpl object) {
		messageLogger.logMessage(new FileContentMessage("Start Parsing BoundingBox", ErrorLevel.DEBUG, new Textmarker(indexedElement.getStartElementLocation().getLine(), indexedElement.getStartElementLocation().getColumn(), filename))); 
		super.parseElement(indexedElement,  parserContext, object);
		messageLogger.logMessage(new FileContentMessage("End Parsing BoundingBox", ErrorLevel.DEBUG, new Textmarker(indexedElement.getEndElementLocation().getLine(), indexedElement.getEndElementLocation().getColumn(), filename))); 
	
	}			
	
	@Override
	protected  Map<String, IAttributeParser<BoundingBoxImpl>> getAttributeNameToAttributeParserMap()
	{
		Map<String, IAttributeParser<BoundingBoxImpl>> result  = new Hashtable<String, IAttributeParser<BoundingBoxImpl>>();
		return result;
	}

	/**
	 * Parser for all subelements
	 */
	private class SubElementParser extends XmlAllParser<BoundingBoxImpl>{
		/**
		 * Constructor
		 * @param messageLogger to log messages during parsing
		 * @param filename to locate the messages in a file
		 */
		public SubElementParser (IParserMessageLogger messageLogger, String filename) {
			super(messageLogger,filename);	
		}
		/*
		 * Creates a list of parser
		 */
		protected  List<IElementParser<BoundingBoxImpl>> createParserList()
		{
			List<IElementParser<BoundingBoxImpl>> result = new ArrayList<IElementParser<BoundingBoxImpl>>();
			result.add(new SubElementCenterParser());
			result.add(new SubElementDimensionsParser());
			return result;
		
		}	
	}
	/**
	 * A parser for subelement center
	 */
	private class SubElementCenterParser implements IElementParser<BoundingBoxImpl> {
	
		/**
		 * Constructor
		 */
		public SubElementCenterParser()
		{
			super();
			centerXmlParser = new CenterXmlParser(messageLogger, filename);
		}
		private CenterXmlParser centerXmlParser;
		
		@Override
		public void parse(IndexedElement indexedElement, ParserContext parserContext,BoundingBoxImpl object)
		{
			CenterImpl center = new CenterImpl();
			// Setting the parent
			center.setParent(object);
			centerXmlParser.parseElement(indexedElement,parserContext, center);

			object.setCenter( center);
			
		}

		@Override
		public int getMinOccur()
		{
			return 1;
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
				elementName.equals(OscConstants.ELEMENT__CENTER) ;
		}
		
		@Override
		public String[] getExpectedTagNames()
		{		 	return new String[]{
				OscConstants.ELEMENT__CENTER
					};
		}
	}
	/**
	 * A parser for subelement dimensions
	 */
	private class SubElementDimensionsParser implements IElementParser<BoundingBoxImpl> {
	
		/**
		 * Constructor
		 */
		public SubElementDimensionsParser()
		{
			super();
			dimensionsXmlParser = new DimensionsXmlParser(messageLogger, filename);
		}
		private DimensionsXmlParser dimensionsXmlParser;
		
		@Override
		public void parse(IndexedElement indexedElement, ParserContext parserContext,BoundingBoxImpl object)
		{
			DimensionsImpl dimensions = new DimensionsImpl();
			// Setting the parent
			dimensions.setParent(object);
			dimensionsXmlParser.parseElement(indexedElement,parserContext, dimensions);

			object.setDimensions( dimensions);
			
		}

		@Override
		public int getMinOccur()
		{
			return 1;
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
				elementName.equals(OscConstants.ELEMENT__DIMENSIONS) ;
		}
		
		@Override
		public String[] getExpectedTagNames()
		{		 	return new String[]{
				OscConstants.ELEMENT__DIMENSIONS
					};
		}
	}
}

