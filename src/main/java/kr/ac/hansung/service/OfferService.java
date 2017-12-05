package kr.ac.hansung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.dao.OfferDAO;
import kr.ac.hansung.model.Offer;

@Service
public class OfferService {

	@Autowired
	private OfferDAO offerDao;
	
	public List<Offer> getCurrent() {
		return offerDao.getOffers();
	}

	public void insert(Offer offer) {
		offerDao.insert(offer);
	}
	
	public List<Offer> getYearAndSemesterList() {
		return offerDao.getYearAndSemesterList();
	}
	
	public List<Offer> getOfferBySemester(int take_year, int semester) {
		return offerDao.getOfferBySemester(take_year, semester);
	}
	
	public int getCreditBySemester(int take_year, int semester) {
		return offerDao.getCreditBySemester(take_year, semester);
	}
	
	public List<Offer> getDivideList() {
		return offerDao.getDivideList();
	}
	
	public int getCreditByDivide(String divide) {
		return offerDao.getCreditByDivide(divide);
	}
	
	public int getTotalCredit() {
		return offerDao.getTotalCredit();
	}
	
	public List<Offer> getRegisterOffer() {
		return offerDao.getRegisterOffer();
	}
	
	
}
