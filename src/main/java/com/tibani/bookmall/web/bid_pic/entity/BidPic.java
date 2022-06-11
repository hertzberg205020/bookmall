package com.tibani.bookmall.web.bid_pic.entity;

/**
 * @Description
 * @Author Robert
 * @Version
 * @Date 2022-06-05 下午 10:14
 */
public class BidPic {
    private Integer bidPicID;
    private Integer bidID;
    private Boolean bidPicStat;

    public Integer getBidPicID() {
        return bidPicID;
    }

    public void setBidPicID(Integer bidPicID) {
        this.bidPicID = bidPicID;
    }

    public Integer getBidID() {
        return bidID;
    }

    public void setBidID(Integer bidID) {
        this.bidID = bidID;
    }

    public Boolean getBidPicStat() {
        return bidPicStat;
    }

    public void setBidPicStat(Boolean bidPicStat) {
        this.bidPicStat = bidPicStat;
    }

    @Override
    public String toString() {
        return "BidPic{" +
                "bidPicID=" + bidPicID +
                ", bidID=" + bidID +
                ", bidPicStat=" + bidPicStat +
                '}';
    }
}
