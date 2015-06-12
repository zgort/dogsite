/**
 * 
 */
package com.rum.cms.webapp.editors;

import java.beans.PropertyEditorSupport;

import org.springframework.stereotype.Component;

import com.rum.modules.pojo.FileType;

/**
 * @author Hikmat
 *
 */
@Component
public class FileTypeEditor extends PropertyEditorSupport {

	public FileTypeEditor() {
	}

	public FileTypeEditor(Object source) {
		super(source);
	}

	@Override
	public void setAsText(String idStr) throws IllegalArgumentException {
		Integer id = Integer.parseInt(idStr);
		FileType fileType = FileType.getFileType(id);
		setValue(fileType);
	}
	
}
