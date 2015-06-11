/**
 * 
 */
package com.rum.cms.webapp.editors;

import java.beans.PropertyEditorSupport;

import org.rum.service.ServiceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.rum.modules.pojo.Litters;

/**
 * @author Hikmat
 *
 */
@Component
public class LittersEditor extends PropertyEditorSupport {

	@Autowired
	private ServiceFactory serviceFactory;

	/**
	 * 
	 */
	public LittersEditor() {
	}

	/**
	 * @param source
	 */
	public LittersEditor(Object source) {
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
		Litters litters = serviceFactory.getLittersService().findOne(id);
		setValue(litters);
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
		Litters litters = (Litters) value;
		return litters.getId().toString();
	}
	
}
