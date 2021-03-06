package kr.or.dgit.exam.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.exam.dto.Product;
import kr.or.dgit.exam.util.MyBatisSqlSessionFactory;

public class ProductService {
	private static final ProductService instance = new ProductService();
	private static final Log log = LogFactory.getLog(ProductService.class);
	private final String namespace = "kr.or.dgit.exam.dao.ProductDao.";

	public static ProductService getInstance() {
		return instance;
	}

	private ProductService() {

	}
	
	public int insertItem(Product item) {
		log.debug("insertItem()");
		int res=1;
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			res = sqlSession.insert(namespace+"insertItem",item);
			sqlSession.commit();
		}
		return res;
	}
	
	public Product selectItemByCode(Product item) {
		log.debug("selectItemByCode()");
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			return sqlSession.selectOne(namespace+"selectItemByCode", item);
		}
		
	}
}
