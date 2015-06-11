/**
 * 
 */
package com.rum.cms.webapp.editors;

import java.beans.PropertyEditorSupport;

import org.rum.service.ServiceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.rum.modules.pojo.Dog;

/**
 * @author Hikmat
 *
 */
@Component
public class DogEditor extends PropertyEditorSupport {

	@Autowired
	private ServiceFactory serviceFactory;

	/**
	 * 
	 */
	public DogEditor() {
	}

	/**
	 * @param source
	 */
	public DogEditor(Object source) {
		super(source);
	}

	/* (non-Javadoc)
	 * @see java.beans.PropertyEditorSupport#setAsText(java.lang.String)
	 */
	@Override
	public void setAsText(String idStr) throws IllegalArgumentException {
		if (StringUtils.isEmpty(idStr)) {
			return;
		}
		Integer id = Integer.parseInt(idStr);
		Dog dog = serviceFactory.getDogService().findOne(id);
		setValue(dog);
	}

	/* (non-Javadoc)
	 * @see java.beans.PropertyEditorSupport#getAsText()
	 */
	@Override
	public String getAsText() {
		Object value = getValue();
		if (value == null) {
			return null;
		}
		Dog dog = (Dog) value;
		return dog.getId().toString();
	}
}
