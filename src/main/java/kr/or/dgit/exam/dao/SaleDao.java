package kr.or.dgit.exam.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.dgit.exam.dto.Sale;

public interface SaleDao {
	int insertProduct(Sale item) throws SQLException;
	int updateProduct(Sale item) throws SQLException;
	int deleteProduct(Sale item) throws SQLException;
	
	Sale selectSaleByNo(int i);
	
	List<Sale> selectSaleByAll();
	List<Sale> callSaleDetail(Map<String, Boolean> map);
	List<Map<String, Object>> callGetTotal() throws SQLException;
}
