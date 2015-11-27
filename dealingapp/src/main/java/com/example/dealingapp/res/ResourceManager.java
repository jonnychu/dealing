package com.example.dealingapp.res;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResourceManager {

	private static final Logger LOGGER = LoggerFactory.getLogger(ResourceManager.class);
	private static final ConcurrentHashMap<String, Icon> iconCache = new ConcurrentHashMap<>(1024);
	
	//
	public enum ImageEnum {
		IMAGE_SPLASH("img/splash.jpg"),
		ARROW_UP("img/arrow-up.png"),
		ARROW_DOWN("img/arrow-down.png");
		
		ImageEnum(String path){
			this.path = path;
		}
		
		private String path;
		
		@Override
		public String toString() {
			return path;
		}
	}

	/**
	 * 
	 */
	private static URL getImageUrl(String path) {
		URL url = null;
		try {
			url = ResourceManager.class.getResource(path);
			if (url == null)
				throw new FileNotFoundException();
		} catch (Exception e) {
			LOGGER.error("cannot find image , path :" + path);
		}
		return url;
	}

	/**
	 */
	public static Icon getImageIcon(ImageEnum imageEnum) {
		return getImageIcon(imageEnum.toString());
	}
	
	/**
	 */
	public static Icon getImageIcon(String path) {
		if (path != null) {
			ImageIcon icon = (ImageIcon) iconCache.get(path);
			if (icon != null) {
				return (Icon) iconCache.get(path);
			} else {
				URL url = getImageUrl(path);
				if (url == null)
					return new ImageIcon();
				iconCache.put(path, new ImageIcon(url));
				return iconCache.get(path);
			}
		}
		return null;
	}
}
