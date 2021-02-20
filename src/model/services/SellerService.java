package model.services;

import java.util.ArrayList;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Seller;

public class SellerService {
	private SellerDao dao  = new DaoFactory().createSellerDao();
	
	public List<Seller> findAll(){
		return dao.findAll();
	}
	
	public void saveOrUpdate(Seller obj) {
		if (obj.getId() == null) {
			dao.insert(obj);
		}else {
			dao.update(obj);
		}
	}
	
	public void remove(Seller department) {
		dao.deleteById(department.getId());
	}
}
