package com.rum.cms.webapp.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.rum.cms.modules.pojo.Dog;
import com.rum.cms.service.IDogService;
import com.rum.cms.service.ServiceFactory;
import com.rum.cms.webapp.editors.DogEditor;

@Controller("DogController")
@RequestMapping("dogs")
public class DogContoller {

	@Autowired
	private ServiceFactory serviceFactory;
	@Autowired
	private DogEditor dogEditor;
	
	/**
	 * @param binder
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Dog.class, dogEditor);
	}
	
	/**
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value = "/paginationMales", method = RequestMethod.GET)
	public Page<Dog> getMales(@RequestParam int pageNumber, @RequestParam int pageSize){
		PageRequest pageRequest = new PageRequest(pageNumber, pageSize);
		return serviceFactory.getDogService().getMales(pageRequest);
	}
	
	/**
	 * @return
	 */
	@RequestMapping(value = "/males", method = RequestMethod.GET)
	public ModelAndView getFirstTenMales(){
		ModelAndView modelAndView = new ModelAndView("males");
		PageRequest pageRequest = new PageRequest(0, 10);
		IDogService dogService = serviceFactory.getDogService();
		Page<Dog> findAll = dogService.getMales(pageRequest);
		modelAndView.addObject("dogs", findAll);
		return modelAndView;
		
	}
	
	/**
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value = "/females", method = RequestMethod.GET)
	public Page<Dog> getFemales(@RequestParam int pageNumber, @RequestParam int pageSize){
		PageRequest pageRequest = new PageRequest(pageNumber, pageSize);
		return serviceFactory.getDogService().getMales(pageRequest);
	}
	
	/**
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value = "/forsale", method = RequestMethod.GET)
	public Page<Dog> getDogsForSale(@RequestParam int pageNumber, @RequestParam int pageSize){
		PageRequest pageRequest = new PageRequest(pageNumber, pageSize);
		return serviceFactory.getDogService().getMales(pageRequest);
	}
	
}