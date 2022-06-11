package com.tibani.bookmall.web.bid_pic.dao.impl;

import com.tibani.bookmall.core.util.JDBCUtil;
import com.tibani.bookmall.web.bid_pic.dao.BidPicDao;
import com.tibani.bookmall.web.bid_pic.entity.BidPic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author Robert
 * @Version
 * @Date 2022-06-11 下午 02:26
 */
public class BidPicDaoImpl implements BidPicDao {
    @Override
    public int insert(BidPic pojo) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        final String sql = "insert into bid_pic(bid_id) values (?);";
        int res = 0;

        try {
            conn = JDBCUtil.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, pojo.getBidID());
            res = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(conn, pstmt, rs);
        }
        return res;
    }

    /**
     * 無實現
     * @param id
     * @return
     */
    @Override
    public int deleteById(Integer id) {
        return 0;
    }

    /**
     * 變更競標商品照片狀態
     * @param pojo
     * @return
     */
    @Override
    public int update(BidPic pojo) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        final String sql =
                "update bid_pic set bid_pic_stat = ?\n" +
                "where bid_pic_id =?";
        int res = 0;

        try {
            conn = JDBCUtil.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setBoolean(1, pojo.getBidPicStat());
            pstmt.setInt(2, pojo.getBidPicID());
            res = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(conn, pstmt, rs);
        }
        return res;
    }

    @Override
    public BidPic selectByPrimaryKey(Integer id) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        BidPic bidPic = null;
        final String sql =
                "select bid_pic_id, bid_id, bid_pic_stat\n" +
                "from bid_pic\n" +
                "where bid_id = ?;";
        try {
            conn = JDBCUtil.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            bidPic = retrieve(rs).get(0);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(conn, pstmt, rs);
        }
        return bidPic;
    }

    @Override
    public List<BidPic> selectAll() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<BidPic> list = null;
        final String sql =
                "select bid_pic_id, bid_id, bid_pic_stat\n" +
                "from bid_pic";
        try {
            conn = JDBCUtil.getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            list = retrieve(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(conn, pstmt, rs);
        }

        return list;
    }


    @Override
    public List<BidPic> selectByBidID(Integer bidID) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<BidPic> list = null;
        final String sql =
                "select bid_pic_id, bid_id, bid_pic_stat\n" +
                "from bid_pic\n" +
                "where bid_id = ?;";
        try {
            conn = JDBCUtil.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, bidID);
            rs = pstmt.executeQuery();
            list = retrieve(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(conn, pstmt, rs);
        }

        return list;
    }

    /**
     * 將查詢結果放入list中，並返回
     * @param rs
     * @return
     * @throws SQLException
     */
    private List<BidPic> retrieve(ResultSet rs) throws SQLException {
        List<BidPic> list = new ArrayList<>();
        while (rs.next()) {
            BidPic bidPic = new BidPic();
            bidPic.setBidPicID(rs.getInt("bid_pic_id"));
            bidPic.setBidID(rs.getInt("bid_ID"));
            bidPic.setBidPicStat(rs.getBoolean("bid_pic_stat"));
            list.add(bidPic);
        }

        return list;
    }

    public static void main(String[] args) {

//        BidPicDao bidPicDao = new BidPicDaoImpl();
//        BidPic bidPic = bidPicDao.selectByPrimaryKey(1);
//        System.out.println(bidPic);

//        BidPicDao bidPicDao = new BidPicDaoImpl();
//        List<BidPic> list = bidPicDao.selectByBidID(1);
//        System.out.println(list);

//        BidPicDao bidPicDao = new BidPicDaoImpl();
//        List<BidPic> list = bidPicDao.selectAll();
//        System.out.println(list);

//        BidPicDao bidPicDao = new BidPicDaoImpl();
//        BidPic bidPic = new BidPic();
//        bidPic.setBidID(2);
//        bidPicDao.insert(bidPic);

//        BidPicDao bidPicDao = new BidPicDaoImpl();
//        BidPic bidPic = new BidPic();
//        bidPic.setBidPicID(2);
//        bidPic.setBidPicStat(false);
//        bidPicDao.update(bidPic);

    }
}
