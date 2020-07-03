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

import de.rac.openscenario.v1_0.impl.CatalogDefinitionImpl;
import de.rac.openscenario.v1_0.impl.CatalogImpl;


import de.rac.openscenario.v1_0.parser.modelgroup.XmlSequenceParser;
import java.util.ArrayList;
import de.rac.openscenario.v1_0.parser.type.XmlGroupParser;

/**
 * This is a automatic generated file according to the OpenSCENARIO specification version 1.0
 * Filling a CatalogDefinitionImpl instance from an xml tree.
 * 
 * @author RA Consulting OpenSCENARIO generation facility
*/
public class CatalogDefinitionXmlParser extends XmlGroupParser<CatalogDefinitionImpl> {

	/**
	 * Constructor
	 * @param messageLogger to log messages during parsing
	 * @param filename to locate the messages in a file
	 */
	public CatalogDefinitionXmlParser(IParserMessageLogger messageLogger, String filename) {
		super(messageLogger, filename);
		subElementParser = new SubElementParser(messageLogger, filename);
	}
	@Override
	public void parseElement(IndexedElement indexedElement, ParserContext parserContext,CatalogDefinitionImpl object) {
		messageLogger.logMessage(new FileContentMessage("Start Parsing CatalogDefinition", ErrorLevel.DEBUG, new Textmarker(indexedElement.getStartElementLocation().getLine(), indexedElement.getStartElementLocation().getColumn(), filename))); 
		super.parseElement(indexedElement,  parserContext, object);
		messageLogger.logMessage(new FileContentMessage("End Parsing CatalogDefinition", ErrorLevel.DEBUG, new Textmarker(indexedElement.getEndElementLocation().getLine(), indexedElement.getEndElementLocation().getColumn(), filename))); 
	
	}			
	

	/**
	 * Parser for all subelements
	 */
	private class SubElementParser extends XmlSequenceParser<CatalogDefinitionImpl>{
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
		protected  List<IElementParser<CatalogDefinitionImpl>> createParserList()
		{
			List<IElementParser<CatalogDefinitionImpl>> result = new ArrayList<IElementParser<CatalogDefinitionImpl>>();
			result.add(new SubElementCatalogParser());
			return result;
		
		}	
	}
	/**
	 * A parser for subelement catalog
	 */
	private class SubElementCatalogParser implements IElementParser<CatalogDefinitionImpl> {
	
		/**
		 * Constructor
		 */
		public SubElementCatalogParser()
		{
			super();
			catalogXmlParser = new CatalogXmlParser(messageLogger, filename);
		}
		private CatalogXmlParser catalogXmlParser;
		
		@Override
		public void parse(IndexedElement indexedElement, ParserContext parserContext,CatalogDefinitionImpl object)
		{
			CatalogImpl catalog = new CatalogImpl();
			// Setting the parent
			catalog.setParent(object);
			catalogXmlParser.parseElement(indexedElement,parserContext, catalog);

			object.setCatalog( catalog);
			
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
				elementName.equals(OscConstants.ELEMENT__CATALOG) ;
		}
		
		@Override
		public String[] getExpectedTagNames()
		{		 	return new String[]{
				OscConstants.ELEMENT__CATALOG
					};
		}
	}
}
