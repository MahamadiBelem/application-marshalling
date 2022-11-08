package com.codeforgeyt.artemisdemo;

import java.io.File;
import java.io.IOException;

import javax.lang.model.element.Element;
import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*************************************************************************************
 * here is the main function to run our spring application throught the decorator
 * Author: Mahamadi BELEM
 *************************************************************************************/
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

@SpringBootApplication
public class ArtemisDemoApplication {

	public static void main(String[] args) {

//Get the Document Builder

DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
try {
	DocumentBuilder builder = factory.newDocumentBuilder();

	// Get Document
	Document document = (Document) builder.parse(new File("index.xml"));

	// Normalize the xml structure
	((Node) document.getDefaultRootElement()).normalize();

	// Get all the element by the tag name

	NodeList laptopList = ((org.w3c.dom.Document) document).getElementsByTagName("laptop");
	for(int i = 0; i <laptopList.getLength(); i++) {
		Node laptop = laptopList.item(i);
		if(laptop.getNodeType() == Node.ELEMENT_NODE) {

			Element laptopElement = (Element) laptop;
			System.out.println("Name: " + ((DocumentBuilderFactory) laptopElement).getAttribute("name"));

		}
	}

} catch (ParserConfigurationException e) {
	e.printStackTrace();
} catch (SAXException e) {
	e.printStackTrace();
} catch (IOException e) {
	e.printStackTrace();
}
		SpringApplication.run(ArtemisDemoApplication.class, args);
	}

}
