package com.zokala.framework.ioc.reader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
 
import com.zokala.framework.ioc.bean.Bean;
import com.zokala.framework.ioc.bean.Prop;
/**
 * implementation of interface ResourceReader
 * **/
public class XMLResourceReader implements ResourceReader {
	private final static String RESOURCE_PATH="src/zokala.ioc.xml"; 
	private final static String BEAN="bean";
	private final static String ID="id";
	private final static String CLASS="class";
	private final static String PROPERTY="property";
	private final static String NAME="name";
	private final static String REF="ref";

	public Map<String, Bean> read(String resource) {
		String path=((resource==null)?getClass().getResource("/").getPath()+RESOURCE_PATH:resource);
		Map<String, Bean> beans=new HashMap<String, Bean>();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();    
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();    
			Document doc = builder.parse(path);
			NodeList nodes = doc.getElementsByTagName(BEAN); 
			for(int i=0;i<nodes.getLength();i++){ 
				if(nodes.item(i).getNodeType()==Node.ELEMENT_NODE){
					Bean bean=new Bean();
					String beanId=nodes.item(i).getAttributes().getNamedItem(ID).getNodeValue();
					bean.setId(beanId);
					bean.setCls(nodes.item(i).getAttributes().getNamedItem(CLASS).getNodeValue());
					NodeList children=nodes.item(i).getChildNodes();
					List<Prop> props=new ArrayList<Prop>();  
					for(int j=0;j<children.getLength();j++){
						if(children.item(j).getNodeType()==Node.ELEMENT_NODE){
							Prop property=new Prop();
							property.setName(children.item(j).getAttributes().getNamedItem(NAME).getNodeValue());
							property.setRef(children.item(j).getAttributes().getNamedItem(REF).getNodeValue());
							props.add(property);
						}
					}
					bean.setProps(props);
					beans.put(beanId, bean);
				}	
			}
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    
		// TODO Auto-generated method stub
		return beans;
	}

}
