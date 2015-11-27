package com.example.dealingapp.mvc.tree;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("root")
public class Root {
	
	@XStreamImplicit(itemFieldName="node")
	private List<Item> node;
	
	
    public List<Item> getNode() {
		return node;
	}

	public void setNode(List<Item> node) {
		this.node = node;
	}

	@Override  
    public String toString() {  
        return "has child " + node ;  
    }  
}
