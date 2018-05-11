package kr.or.dgit.exam.dao;

import java.sql.SQLException;

import kr.or.dgit.exam.dto.Product;

public interface ProductDao {
	int insertItem(Product item) throws SQLException;

	Product selectItemByCode(Product item) throws SQLException;
}
