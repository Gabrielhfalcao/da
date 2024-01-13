package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== Test 1: seller findById ===");
		Seller sellerFindById = sellerDao.findById(1);
		System.out.println(sellerFindById);
		
		System.out.println("\n=== Test 2: seller findByDepartment ===");
		Department department = new Department(2, null);
		List<Seller> listFindByDepartment = sellerDao.findByDepartment(department);
		
		for(Seller s : listFindByDepartment) {
			System.out.println(s);
		}
		
		System.out.println("\n=== Test 3: seller findAll ===");
		List<Seller> listFindAll = sellerDao.findAll();
		
		for(Seller s : listFindAll) {
			System.out.println(s);
		}
		
		System.out.println("\n=== Test 4: seller insert ===");
		Department dep = new Department(1, null);
		Seller seller = new Seller(null, "Gabriel Falcao", "gabriel@gmail.com", new Date(), 3000.0, dep);
		sellerDao.insert(seller);
		
		List<Seller> listFindAll2 = sellerDao.findAll();
		for(Seller s : listFindAll2) {
			System.out.println(s);
		}
		
		System.out.println();
		System.out.println("Iserted! New Id = " + seller.getId());
		
		System.out.println("\n=== Test 5: seller update ===");
		Seller sellerUpdate = sellerDao.findById(1);
		sellerUpdate.setName("Gabriel Honorato");
		sellerDao.update(sellerUpdate);
		System.out.println("Update complete!");
	}

}
