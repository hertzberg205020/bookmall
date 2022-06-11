package com.tibani.bookmall.web.bid_order.entity;

import java.sql.Timestamp;

/**
 * @Description
 * @Author Robert
 * @Version
 * @Date 2022-06-05 下午 10:14
 */
public class BidOrder {
    private Integer bidOrderID;
    private Integer bidID;
    // 得標會員編號
    private Integer mbrID;
    private Integer bidPrice;
    private Timestamp bidOrderDate;
    // 物流狀態 0: 撿貨中, 1: 配送中, 2: 已送達
    private Integer bidShipStat;
    private Boolean paySeller;

    public Integer getBidOrderID() {
        return bidOrderID;
    }

    public void setBidOrderID(Integer bidOrderID) {
        this.bidOrderID = bidOrderID;
    }

    public Integer getBidID() {
        return bidID;
    }

    public void setBidID(Integer bidID) {
        this.bidID = bidID;
    }

    public Integer getMbrID() {
        return mbrID;
    }

    public void setMbrID(Integer mbrID) {
        this.mbrID = mbrID;
    }

    public Integer getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(Integer bidPrice) {
        this.bidPrice = bidPrice;
    }

    public Timestamp getBidOrderDate() {
        return bidOrderDate;
    }

    public void setBidOrderDate(Timestamp bidOrderDate) {
        this.bidOrderDate = bidOrderDate;
    }

    public Integer getBidShipStat() {
        return bidShipStat;
    }

    public void setBidShipStat(Integer bidShipStat) {
        this.bidShipStat = bidShipStat;
    }

    public Boolean getPaySeller() {
        return paySeller;
    }

    public void setPaySeller(Boolean paySeller) {
        this.paySeller = paySeller;
    }

    @Override
    public String toString() {
        return "BidOrder{" +
                "bidOrderID=" + bidOrderID +
                ", bidID=" + bidID +
                ", mbrID=" + mbrID +
                ", bidPrice=" + bidPrice +
                ", bidOrderDate=" + bidOrderDate +
                ", bidShipStat=" + bidShipStat +
                ", paySeller=" + paySeller +
                '}';
    }
}
