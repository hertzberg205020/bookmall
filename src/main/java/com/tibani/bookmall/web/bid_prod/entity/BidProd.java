package com.tibani.bookmall.web.bid_prod.entity;

import java.sql.Timestamp;

/**
 * @Description
 * @Author Robert
 * @Version
 * @Date 2022-06-05 下午 10:14
 */
public class BidProd {
    private Integer bidID;
    private Integer bookID;
    // 賣家會員編號
    private Integer mbrID;
    private Integer startPrice = 0;
    private Integer bidDirectPrice = 0;
    private Integer bidCurPrice = 0;
    // 0: 審核中, 1: 待上架, 2: 審核未通過, 3: 標案進行中, 4: 結標售出, 5:流標
    private Integer bidProdStat = 0;
    private String condition;
    private Timestamp bidStart;
    private Timestamp bidEnd;

    public Integer getBidID() {
        return bidID;
    }

    public void setBidID(Integer bidID) {
        this.bidID = bidID;
    }

    public Integer getBookID() {
        return bookID;
    }

    public void setBookID(Integer bookID) {
        this.bookID = bookID;
    }

    public Integer getMbrID() {
        return mbrID;
    }

    public void setMbrID(Integer mbrID) {
        this.mbrID = mbrID;
    }

    public Integer getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(Integer startPrice) {
        this.startPrice = startPrice;
    }

    public Integer getBidDirectPrice() {
        return bidDirectPrice;
    }

    public void setBidDirectPrice(Integer bidDirectPrice) {
        this.bidDirectPrice = bidDirectPrice;
    }

    public Integer getBidCurPrice() {
        return bidCurPrice;
    }

    public void setBidCurPrice(Integer bidCurPrice) {
        this.bidCurPrice = bidCurPrice;
    }

    public Integer getBidProdStat() {
        return bidProdStat;
    }

    public void setBidProdStat(Integer bidProdStat) {
        this.bidProdStat = bidProdStat;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public Timestamp getBidStart() {
        return bidStart;
    }

    public void setBidStart(Timestamp bidStart) {
        this.bidStart = bidStart;
    }

    public Timestamp getBidEnd() {
        return bidEnd;
    }

    public void setBidEnd(Timestamp bidEnd) {
        this.bidEnd = bidEnd;
    }

    @Override
    public String toString() {
        return "BidProd{" +
                "bidID=" + bidID +
                ", bookID=" + bookID +
                ", mbrID=" + mbrID +
                ", startPrice=" + startPrice +
                ", bidDirectPrice=" + bidDirectPrice +
                ", bidCurPrice=" + bidCurPrice +
                ", bidProdStat=" + bidProdStat +
                ", condition='" + condition + '\'' +
                ", bidStart=" + bidStart +
                ", bidEnd=" + bidEnd +
                '}';
    }
}
