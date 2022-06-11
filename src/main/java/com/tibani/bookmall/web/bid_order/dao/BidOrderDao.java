package com.tibani.bookmall.web.bid_order.dao;



import com.tibani.bookmall.core.dao.CoreDao;
import com.tibani.bookmall.web.bid_order.entity.BidOrder;

import java.util.List;

/**
 * @Description
 * @Author Robert
 * @Version
 * @Date 2022-06-11 上午 11:31
 */
public interface BidOrderDao extends CoreDao<BidOrder, Integer> {
    List<BidOrder> selectByMbrID(Integer mbrID, Integer page);
    List<BidOrder> selectByPaySeller(Boolean paySeller, Integer page);
    List<BidOrder> selectAll(Integer page);
}
