package kr.ac.hansung.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.hansung.model.Offer;
import kr.ac.hansung.service.OfferService;

@Controller
public class OfferController {

	@Autowired
	private OfferService offerService;

	@RequestMapping("/offers")
	public String showGradeSemesterTotalCredit(Model model) {
		List<Offer> offers = offerService.getYearAndSemesterList();
		
		model.addAttribute("offers", offers);

		System.out.println("OfferController");
		return "offers";
	}
	
	@RequestMapping("/courseListbySemester")
	public String getCourseList(Model model, @RequestParam(value="take_year") String take_year, @RequestParam(value="semester") String semester) {
		
		System.out.println("진입");
		List<Offer> courseListPrints = offerService.getOfferBySemester(Integer.parseInt(take_year), Integer.parseInt(semester));
		
		model.addAttribute("courseListPrints", courseListPrints);
		System.out.println("courseListPrints = " + courseListPrints.get(0).getCode());
		
		return "courseListPrint";
	}
	
	@RequestMapping("/showCreditbyDivide")
	public String getCreditbyDivide(Model model) {
		
		List<Offer> creditbydivides = offerService.getDivideList();
		
		for(int i=0; i<creditbydivides.size(); i++) {
			creditbydivides.get(i).setCredit(offerService.getCreditByDivide(creditbydivides.get(i).getDivide()));
		}
		
		int totalCredit = offerService.getTotalCredit();
		
		model.addAttribute("totalCredit", totalCredit);
		model.addAttribute("creditbydivides", creditbydivides);
		
		return "showCreditbyDivide";
	}
	
	@RequestMapping("/enrollment")
	public String createIffer(Model model) {
		
		model.addAttribute("offer", new Offer());
		
		return "enrollment";
	}
	
	@RequestMapping(value = "/createEnrollment", method = RequestMethod.POST)
	public String createEnrollment(Model model, @Valid Offer offer, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println("===Form data does not validated");
			List<ObjectError> errors = result.getAllErrors();
			for(ObjectError error:errors) {
				System.out.println(error.getDefaultMessage());
			}
			
			return "enrollment";
		}
		
		offerService.insert(offer);
		
		return "enrollmentcreated";
	}
	
	@RequestMapping("/enrollmentRead")
	public String enrollmentRead(Model model) {
		
		List<Offer> enrollmentoffers = offerService.getRegisterOffer();
		
		model.addAttribute("enrollmentoffers", enrollmentoffers);
		
		return "enrollmentRead";
	}
}
