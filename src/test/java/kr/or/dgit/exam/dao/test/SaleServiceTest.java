package kr.or.dgit.exam.dao.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.dgit.exam.dto.Product;
import kr.or.dgit.exam.dto.Sale;
import kr.or.dgit.exam.service.SaleService;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SaleServiceTest {
	private static SaleService service;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		service = SaleService.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		service = null;
	}

	//@Test
	public void test1insertProduct() {
		Sale sale = new Sale();
		sale.setProduct(new Product("A002"));
		sale.setPrice(3000);
		sale.setSaleCnt(50);
		sale.setMarginRate(13);
		int result = service.insertProduct(sale);
		Assert.assertSame(1, result);
		
		System.out.println(sale);
	}
	
	@Test
	public void test2callSaleDetail() {
		Map<String, Boolean> map = new HashMap<>();
		map.put("isSalePrice", true);
		List<Sale> list = service.callSaleDetail(map);
		Assert.assertNotEquals(0, list.size());
		System.out.println(list.size());
	}
	
	@Test
	public void test3callGetTotal() {
		List<Map<String, Object>> maps = service.callGetTotal();
		Assert.assertNotEquals(0, maps.get(0).size());
	}
	
	@Test
	public void test4selectSaleByAll() {
		List<Sale> saleLists = service.selectSaleByAll();
		Assert.assertNotEquals(0, saleLists.size());
	}
	
	//@Test
	public void test5selectSaleByNo() {
		Sale sale = service.selectSaleByNo(1);
		Assert.assertNotEquals(0, sale.getSaleCnt());
	}
	
	//@Test
	public void test6updateProduct() {
		Sale newSale = new Sale(1, new Product("A001"), 4500, 150, 10);
		int res = service.updateProduct(newSale);
		Assert.assertEquals(1, res);
	}
	
	//@Test
	public void test7deleteProduct() {
		Sale newSale = new Sale(1);
		int res = service.deleteProduct(newSale);
		Assert.assertEquals(1, res);
	}
}
