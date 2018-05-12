package kr.or.dgit.exam.dao.test;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.dgit.exam.dto.Product;
import kr.or.dgit.exam.service.ProductService;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductServiceTest {
	private static ProductService service;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		service = ProductService.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		service = null;
	}

	//@Test
	public void test1InsertItem() {
		Product product = new Product();
		product.setCode("A001");
		product.setName("바닐라라떼");
		
		int result = service.insertItem(product);
		Assert.assertSame(1, result);
		
		System.out.println(product);
	}
	
	//@Test
	public void test2selectItemByCode() {
		Product product = new Product();
		product.setCode("A001");
		
		Product productFind = service.selectItemByCode(product);
		Assert.assertNotNull(productFind);
	}
}
