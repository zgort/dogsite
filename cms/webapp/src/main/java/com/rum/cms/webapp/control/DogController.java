package com.rum.cms.webapp.control;

import javax.websocket.server.PathParam;

import org.rum.service.ServiceFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.tags.form.FormTag;

import com.rum.cms.webapp.editors.DogEditor;
import com.rum.modules.pojo.Dog;

/**
 * @author Hikmat
 *
 */
@Controller("employeeController")
@RequestMapping("admin/dogs")
public class DogController {

	@Autowired
	private ServiceFactory serviceFactory;
	@Autowired
	private DogEditor dogEditor;
	private static final String[] IGNORE_PROPERTIES = { "id" };

	/**
	 * @param binder
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Dog.class, dogEditor);
	}

	/**
	 * @param dog
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ModelAndView crateNewDog(Dog dog) {
		serviceFactory.getDogService().save(dog);
		return new ModelAndView("redirect:dogs");
	}

	/**
	 * @param transientDog
	 * @param persistentDog
	 * @return
	 */
	@RequestMapping(value = "/{dogId}", method = RequestMethod.PUT)
	public ModelAndView updateDog(@RequestBody Dog transientDog, @PathParam("dogId") Dog persistentDog) {
		if (persistentDog == null) {
			persistentDog = transientDog;
		} else {
			BeanUtils.copyProperties(transientDog, persistentDog, IGNORE_PROPERTIES);
		}
		serviceFactory.getDogService().save(persistentDog);
		return new ModelAndView("redirect:dogs");
	}

	/**
	 * @param persistentDog
	 * @return
	 */
	@RequestMapping(value = "/{dogId}", method = RequestMethod.GET)
	public ModelAndView getDog(@PathParam("dogId") Dog persistentDog) {
		if (persistentDog == null) {
			persistentDog = new Dog();
		}
		return getDogModelAndView(persistentDog);
	}
	
	/**
	 * @param dog
	 * @return
	 */
	@RequestMapping(value = "/{dogId}", method = RequestMethod.DELETE)
	public ModelAndView removeDog(@PathParam("dogId") Dog dog) {
		serviceFactory.getDogService().delete(dog);
		return new ModelAndView("redirect:dogs");
	}

	/**
	 * @param persistentDog
	 * @return
	 */
	private ModelAndView getDogModelAndView(Dog persistentDog) {
		ModelAndView modelAndView = new ModelAndView("admin/dog", FormTag.DEFAULT_COMMAND_NAME, persistentDog);
		return modelAndView;
	}
}