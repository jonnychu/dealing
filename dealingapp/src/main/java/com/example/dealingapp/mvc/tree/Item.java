package com.example.dealingapp.mvc.tree;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("node")
public class Item{
	
	@XStreamAsAttribute
	private String id; 
	@XStreamAsAttribute
	private String icon;
	@XStreamAsAttribute
	private String text;
	@XStreamAsAttribute
	private String clazz;
	@XStreamAsAttribute
	private String accelerated;
	
	@XStreamImplicit(itemFieldName="node")
	@XStreamAlias("node")
	private List<Item> children;
	
	@Override  
    public String toString() {  
        return "Item [id=" + id + ", icon=" + icon +  ", text=" + text + ", class=" + clazz + ", accelerated=" + accelerated +"]";  
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getClazz() {
		return clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

	public String getAccelerated() {
		return accelerated;
	}

	public void setAccelerated(String accelerated) {
		this.accelerated = accelerated;
	}

	public List<Item> getChildren() {
		return children;
	}

	public void setChildren(List<Item> children) {
		this.children = children;
	}
	
	public boolean hasChild() {
		if (this.children == null || this.children.isEmpty())
			return false;
		else
			return true;
	}
}
