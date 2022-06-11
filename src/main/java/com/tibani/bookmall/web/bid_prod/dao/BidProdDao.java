package com.tibani.bookmall.web.bid_prod.dao;

import com.tibani.bookmall.core.dao.CoreDao;
import com.tibani.bookmall.web.bid_prod.entity.BidProd;

import java.util.List;

/**
 * @Description
 * @Author Robert
 * @Version
 * @Date 2022-06-06 上午 08:55
 */
public interface BidProdDao extends CoreDao<BidProd, Integer> {
    List<BidProd> selectByMbr(Integer mbrID, Integer page);
    List<BidProd> selectByBidProdStat(Integer bidProdStat, Integer page);
    List<BidProd> selectAll(Integer page);
}
