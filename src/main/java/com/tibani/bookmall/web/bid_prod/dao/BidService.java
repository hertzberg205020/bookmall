package com.tibani.bookmall.web.bid_prod.dao;

import java.sql.Timestamp;
import java.util.List;

import com.tibani.bookmall.web.bid_prod.dao.impl.BidProdDaoImpl;
import com.tibani.bookmall.web.bid_prod.entity.BidProd;

public class BidService {
	
	private BidProdDao dao;
	
	public BidService() {
		dao = new BidProdDaoImpl();
	} 
	
	public BidProd showOneBid(Integer bidID) {
		return dao.selectByPrimaryKey(bidID);
	}
	
	public List<BidProd> showOneStat(Integer bidProdStat) {
		return dao.selectByBidProdStat(bidProdStat);
	}
	
	public List<BidProd> showAll() {
		
		return dao.selectAll();
	}
	
	public BidProd insert(Integer bookID, Integer startPrice, Integer bidDirectPrice, Integer bidProdStat, Timestamp bidStart, Timestamp bidEnd) {
		
		BidProd bidProd = new BidProd();
		
		bidProd.setBookID(bookID);
		bidProd.setStartPrice(startPrice);
		bidProd.setBidDirectPrice(bidDirectPrice);
		bidProd.setBidProdStat(bidProdStat);
		bidProd.setBidStart(bidStart);
		bidProd.setBidEnd(bidEnd);
		dao.insert(bidProd);
		
		return bidProd;
	}

	
	public BidProd update(Integer bidID, Integer bookID, Integer startPrice, Integer bidDirectPrice, Integer bidProdStat, Timestamp bidStart, Timestamp bidEnd) {
		
		BidProd bidProd = new BidProd();
		bidProd.setBidID(bidID);
		bidProd.setBookID(bookID);
		bidProd.setStartPrice(startPrice);
		bidProd.setBidDirectPrice(bidDirectPrice);
		bidProd.setBidProdStat(bidProdStat);
		bidProd.setBidStart(bidStart);
		bidProd.setBidEnd(bidEnd);
		dao.update(bidProd);
		
		return bidProd;
		
	}
	
	public int delete(Integer bidID) {
		return dao.deleteById(bidID);
	}
}
