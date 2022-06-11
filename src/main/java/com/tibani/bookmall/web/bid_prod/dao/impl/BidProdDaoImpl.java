package com.tibani.bookmall.web.bid_prod.dao.impl;


import com.tibani.bookmall.core.util.JDBCUtil;
import com.tibani.bookmall.web.bid_prod.dao.BidProdDao;
import com.tibani.bookmall.web.bid_prod.entity.BidProd;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * @Description 競標商品dao
 * @Author Robert
 * @Version
 * @Date 2022-06-06 上午 09:00
 */
public class BidProdDaoImpl implements BidProdDao {

    @Override
    public int insert(BidProd pojo) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        final String sql =
                "insert into bid_prod(book_id, mbr_id, start_price, bid_direct_price, bid_cur_price,\n" +
                "                     bid_prod_stat, `condition`, bid_start, bid_end)\n" +
                "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);";
        try {
            conn = JDBCUtil.getConnection();
            pstmt = conn.prepareStatement(sql);
            setBidProdInfo(pstmt, pojo);
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(conn, pstmt, rs);
        }
        return 0;
    }

    /**
     * 將pojo屬性設置給佔位符
     * @param ps
     * @param pojo
     * @throws SQLException
     */
    private void setBidProdInfo(PreparedStatement ps, BidProd pojo) throws SQLException {
        ps.setInt(1, pojo.getBookID());
        ps.setInt(2, pojo.getMbrID());
        ps.setInt(3, pojo.getStartPrice());
        ps.setInt(4, pojo.getBidDirectPrice());
        ps.setInt(5, pojo.getBidCurPrice());
        ps.setInt(6, pojo.getBidProdStat());
        ps.setString(7, pojo.getCondition());
        ps.setTimestamp(8, pojo.getBidStart());
        ps.setTimestamp(9, pojo.getBidEnd());
    }

    /**
     * 未實現
     * @param id
     * @return
     */
    @Override
    public int deleteById(Integer id) {
        return 0;
    }

    @Override
    public int update(BidProd pojo) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        final String sql =
                "update bid_prod\n" +
                "set book_id = ?, mbr_id = ?, start_price = ?, bid_direct_price = ?, bid_cur_price = ?,\n" +
                "    bid_prod_stat = ?, `condition` = ?, bid_start = ?, bid_end = ?\n" +
                "where bid_id = ?;";
        try {
            conn = JDBCUtil.getConnection();
            pstmt = conn.prepareStatement(sql);
            setBidProdInfo(pstmt, pojo);
            pstmt.setInt(10, pojo.getBidID());
            return pstmt.executeUpdate();
        } catch (SQLException e) {

            e.printStackTrace();
        } finally {
            JDBCUtil.close(conn, pstmt, rs);
        }
        return 0;
    }

    @Override
    public BidProd selectByPrimaryKey(Integer id) {
        BidProd bidProd = new BidProd();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        final String sql =
                "select bid_id, book_id, mbr_id, start_price, bid_direct_price,\n" +
                "       bid_cur_price, bid_prod_stat, `condition`, bid_start, bid_end\n" +
                "from bid_prod\n" +
                "where bid_id = ?;";
        try {
            conn = JDBCUtil.getConnection();
            pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, id);

            rs = pstmt.executeQuery();

            List<BidProd> list = retrieve(rs);
            bidProd = list.get(0);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(conn, pstmt, rs);
        }
        return bidProd;

    }

    /**
     * 未實現
     * @return
     */
    @Override
    public List<BidProd> selectAll() {
        return null;
    }

    /**
     * 查詢全部競標商品，每頁12筆資料
     * @param page
     * @return
     */
    @Override
    public List<BidProd> selectAll(Integer page) {
        List<BidProd> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        final String sql =
                "select bid_id, book_id, mbr_id, start_price, bid_direct_price,\n" +
                "       bid_cur_price, bid_prod_stat, `condition`, bid_start, bid_end\n" +
                "from bid_prod\n" +
                "limit ?, ?;";
        try {
            conn = JDBCUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, pageSize * (page - 1));
            ps.setInt(2, pageSize + 1);
            rs = ps.executeQuery();
            list = retrieve(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(conn, ps, rs);
        }
        return list;
    }

    /**
     * 依賣家編號查詢競標商品，每頁12筆資料
     * @param mbrID
     * @param page
     * @return
     */
    @Override
    public List<BidProd> selectByMbr(Integer mbrID, Integer page) {
        List<BidProd> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        final String sql =
                "select bid_id, book_id, mbr_id, start_price, bid_direct_price,\n" +
                "       bid_cur_price, bid_prod_stat, `condition`, bid_start, bid_end\n" +
                "from bid_prod\n" +
                "where mbr_id = ?\n" +
                "limit ?, ?;";
        try {
            conn = JDBCUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, mbrID);
            ps.setInt(2, pageSize * (page - 1));
            ps.setInt(3, pageSize + 1);
            rs = ps.executeQuery();
            list = retrieve(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(conn, ps, rs);
        }

        return list;
    }

    /**
     * 依競標商品狀態查詢競標商品，每頁12筆資料
     * @param bidProdStat
     * @param page
     * @return
     */
    @Override
    public List<BidProd> selectByBidProdStat(Integer bidProdStat, Integer page) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<BidProd> list = null;
        final String sql =
                "select bid_id, book_id, mbr_id, start_price, bid_direct_price,\n" +
                "       bid_cur_price, bid_prod_stat, `condition`, bid_start, bid_end\n" +
                "from bid_prod\n" +
                "where bid_prod_stat = ?\n" +
                "limit ?, ?;";

        try {
            conn = JDBCUtil.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, bidProdStat);
            pstmt.setInt(2, pageSize * (page - 1));
            pstmt.setInt(3, pageSize + 1);
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
    private List<BidProd> retrieve(ResultSet rs) throws SQLException {
        List<BidProd> list = new ArrayList<>();
        while (rs.next()) {
            BidProd bidProd = new BidProd();
            bidProd.setBidID(rs.getInt("bid_id"));
            bidProd.setBookID(rs.getInt("book_id"));
            bidProd.setMbrID(rs.getInt("mbr_id"));
            bidProd.setStartPrice(rs.getInt("start_price"));
            bidProd.setBidDirectPrice(rs.getInt("bid_direct_price"));
            bidProd.setBidCurPrice(rs.getInt("bid_cur_price"));
            bidProd.setBidProdStat(rs.getInt("bid_prod_stat"));
            bidProd.setCondition(rs.getString("condition"));
            bidProd.setBidStart(rs.getTimestamp("bid_start"));
            bidProd.setBidEnd(rs.getTimestamp("bid_end"));
            list.add(bidProd);
        }
        return list;
    }

    public static void main(String[] args) {
        BidProdDao bidProdDao = new BidProdDaoImpl();
//        BidProd bidProd = bidProdDao.selectByPrimaryKey(1);
//        System.out.println(bidProd);

//        List<BidProd> list = bidProdDao.selectAll(1);
//        System.out.println(list);

//        List<BidProd> list = bidProdDao.selectByMbr(1, 1);
//        System.out.println(list);

//        List<BidProd> list = bidProdDao.selectByBidProdStat(0, 1);
//        System.out.println(list);

        BidProd bidProd = new BidProd();
        bidProd.setBookID(1);
        bidProd.setMbrID(2);
        GregorianCalendar calendar = new GregorianCalendar(2022, Calendar.AUGUST, 15, 9, 0,0);
        Timestamp start = new Timestamp(calendar.getTimeInMillis());
        calendar.add(Calendar.DATE, 1);
        Timestamp end = new Timestamp(calendar.getTimeInMillis());
        bidProd.setBidStart(start);
        bidProd.setBidEnd(end);
        bidProdDao.insert(bidProd);

//        BidProd bidProd = new BidProd();
//        bidProd.setBidID(4);
//        bidProd.setBookID(1);
//        bidProd.setMbrID(2);
//        bidProdDao.update(bidProd);


    }
}
