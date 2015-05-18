package com.rum.cms.webapp.control.admin;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.tags.form.FormTag;

import com.rum.cms.modules.pojo.Dog;
import com.rum.cms.service.IDogService;
import com.rum.cms.service.ServiceFactory;
import com.rum.cms.webapp.editors.DogEditor;

/**
 * @author Hikmat
 *
 */
@Controller("adminDogController")
@RequestMapping("admin/dogs")
public class AdminDogController {

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
		return new ModelAndView("redirect:/admin/dogs/");
	}

	/**
	 * @param transientDog
	 * @param persistentDog
	 * @return
	 */
	@RequestMapping(value = "/{dogId}", method = RequestMethod.PUT)
	public ModelAndView updateDog(@ModelAttribute Dog transientDog, @PathVariable("dogId") Dog persistentDog) {
		if (persistentDog.getId() == null) {
			persistentDog = transientDog;
		} else {
			BeanUtils.copyProperties(transientDog, persistentDog, IGNORE_PROPERTIES);
		}
		serviceFactory.getDogService().save(transientDog);
		return new ModelAndView("redirect:/admin/dogs/");
	}

	/**
	 * @param persistentDog
	 * @return
	 */
	@RequestMapping(value = "/{dogId}", method = RequestMethod.GET)
	public ModelAndView getDog(@PathVariable("dogId") Dog persistentDog) {
		return getDogModelAndView(persistentDog);
	}

	/**
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView loadDogPage() {
		ModelAndView modelAndView = new ModelAndView("admin/dogs");
		IDogService dogService = serviceFactory.getDogService();
		List<Dog> findAll = dogService.findAll();
		modelAndView.addObject("dogs", findAll);
		return modelAndView;
	}

	/**
	 * @param dog
	 * @return
	 */
	@RequestMapping(value = "/{dogId}", method = RequestMethod.DELETE)
	public ModelAndView removeDog(@PathVariable("dogId") Dog dog) {
		serviceFactory.getDogService().delete(dog);
		return new ModelAndView("redirect:/admin/dogs/");
	}

	/**
	 * @param persistentDog
	 * @return
	 */
	private ModelAndView getDogModelAndView(Dog persistentDog) {
		ModelAndView modelAndView = new ModelAndView("admin/dog");
		modelAndView.addObject(FormTag.DEFAULT_COMMAND_NAME, persistentDog);
		String formMethod = persistentDog.getId() == null ? "POST" : "PUT";
		String dogId = persistentDog.getId() == null ? StringUtils.EMPTY : persistentDog.getId().toString();
		modelAndView.addObject("formMethod", formMethod);
		modelAndView.addObject("dogId", dogId);
		return modelAndView;
	}
	
}