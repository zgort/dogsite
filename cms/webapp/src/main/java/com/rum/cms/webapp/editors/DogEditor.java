/**
 * 
 */
package com.rum.cms.webapp.editors;

import java.beans.PropertyEditorSupport;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.rum.cms.modules.pojo.Dog;
import com.rum.cms.service.ServiceFactory;

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
		Dog dog;
		if (StringUtils.isEmpty(idStr) || !NumberUtils.isNumber(idStr)) {
			dog = new Dog();
		}else{
			Integer id = Integer.parseInt(idStr);
			dog = serviceFactory.getDogService().findOne(id);
			if(dog == null){
				dog = new Dog();
			}
		}
		
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
