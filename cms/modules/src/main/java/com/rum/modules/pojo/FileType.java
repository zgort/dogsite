package com.rum.modules.pojo;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Hikmat
 *
 */
public enum FileType {
	IMAGE(1, "Image"), 
	FILE(2, "File");
	
	private final int id;
	private final String label;
	private static final Map<Integer, FileType> MAP = new HashMap<>();

	static {
		FileType[] fileTypes = FileType.values();
		for (FileType fileType : fileTypes) {
			MAP.put(fileType.getId(), fileType);
		}
	}
	
	private FileType(final int id, final String label) {
		this.id = id;
		this.label = label;
	}

	public int getId() {
		return id;
	}

	public String getLabel() {
		return label;
	}
	
	public static FileType getFileType(int id){
		FileType fileType = MAP.get(id);
		return fileType;
	}
	
}
