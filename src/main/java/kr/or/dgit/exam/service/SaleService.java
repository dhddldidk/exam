package kr.or.dgit.exam.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.exam.dto.Sale;
import kr.or.dgit.exam.util.MyBatisSqlSessionFactory;

public class SaleService {
	private static final SaleService instance = new SaleService();
	private static final Log log = LogFactory.getLog(SaleService.class);
	private final String namespace = "kr.or.dgit.exam.dao.SaleDao.";

	public static SaleService getInstance() {
		return instance;
	}

	private SaleService() {

	}
	
	public int insertProduct(Sale item) {
		log.debug("insertProduct()");
		int res=1;
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			res = sqlSession.insert(namespace+"insertProduct",item);
			sqlSession.commit();
		}
		return res;
	}
	
	public List<Sale> selectSaleByAll() {
		log.debug("selectSaleByAll()");
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			return sqlSession.selectList(namespace+"selectSaleByAll");
		}
		
	}
	
	public Sale selectSaleByNo(int i) {
		log.debug("selectSaleByNo()");
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			return sqlSession.selectOne(namespace+"selectSaleByNo", i);
		}
	}
	
	public List<Map<String, Object>> callGetTotal(){
		log.debug("callGetTotal()");
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			return sqlSession.selectList(namespace+"callGetTotal");
		}
	}
	
	public List<Sale> callSaleDetail(Map<String, Boolean> map){
		log.debug("callSaleDetail()");
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			return sqlSession.selectList(namespace+"callSaleDetail", map);
		}
	}
	
	public int updateProduct(Sale sale) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			int res = sqlSession.update(namespace+"updateProduct", sale);
			sqlSession.commit();
			return res;
		}
	}
	
	public int deleteProduct(Sale sale) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			int res = sqlSession.delete(namespace+"deleteProduct", sale);
			sqlSession.commit();
			return res;
		}
	}
}
