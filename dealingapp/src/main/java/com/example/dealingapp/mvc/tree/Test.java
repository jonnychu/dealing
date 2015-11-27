package com.example.dealingapp.mvc.tree;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

public class Test {

	public static void main(String[] args) {
		XStream stream = new XStream(new StaxDriver());
		stream.processAnnotations(new Class[]{Root.class,Item.class});
		Root root = (Root)stream.fromXML(Test.class.getResourceAsStream("/tree.xml"));
		System.out.println(root);
		
		for (Item node : root.getNode()) {
			iterator(node);
		}
	}
	
	public static void iterator(Item node){
		System.out.println(node);
		if(!node.hasChild()){
			return;
		}else{
			for (Item child : node.getChildren()) {
				iterator(child);
			}
		}
	}

}
