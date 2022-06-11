package com.tibani.bookmall.web.bid_pic.dao;

import com.tibani.bookmall.core.dao.CoreDao;
import com.tibani.bookmall.web.bid_pic.entity.BidPic;

import java.util.List;

/**
 * @Description
 * @Author Robert
 * @Version
 * @Date 2022-06-11 下午 02:23
 */
public interface BidPicDao extends CoreDao<BidPic, Integer> {
    List<BidPic> selectByBidID(Integer bidID);
}
