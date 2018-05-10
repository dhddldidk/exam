package kr.or.dgit.exam.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import kr.or.dgit.exam.dto.Product;

public interface ProductDao {
	int insertItem(Product item) throws SQLException;

	int updateItem(Product item) throws SQLException;

	int deleteItem() throws SQLException;

	List<Product> selectItemByAll() throws SQLException;

	Product getCoffee(ResultSet rs) throws SQLException;

	Product selectItemByCode(Product item) throws SQLException;
}
