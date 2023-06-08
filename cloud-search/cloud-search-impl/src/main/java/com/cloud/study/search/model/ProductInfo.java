package com.cloud.study.search.model;

import java.math.BigDecimal;

/**
 * 名称	类型	是否必须	示例值	描述
 * adWord 	String 	否
 * 广告词
 * isBook 	Boolean 	否
 * 是否为图书
 * canFreeRead 	Boolean 	否
 * 是否免费阅读
 * endRemainTime 	String 	否
 * 秒杀离结束时间
 * imageUrl 	String 	否
 * 商品图片url
 * jdPrice 	Number 	否
 * 京东价
 * martPrice 	Number 	否
 * 市场价
 * startRemainTime 	String 	否
 * 秒杀离开始时间
 * skuId 	String 	否
 * 商品编号
 * wareName 	String 	否
 * 商品名称
 */
public class ProductInfo {


    private int id;
    /**
     * 广告词
     */
    private String adWord;

    /**
     * 商品名称
     */
    private String wareName;

    /**
     * 评价评分
     */
    private double  averageScore;

    /**
     * 市场价
     */
    private BigDecimal martPrice;

    /**
     *秒杀离开始时间
     */
    private long startRemainTime;

    /**
     * 是否促销
     */
    private boolean promotion;

    private boolean loc;
    /**
     * 京东价
     */
    private BigDecimal jdPrice;
    /**
     * 好评率
     */
    private String goodPercentage;
    /**
     * 视频展示
     */
    private int flashSale;
    /**
     * 是否在线
     */
    private boolean onLine;
    /**
     * 库存
     */
    private int totalCount;
    /**
     * 是否为图书
     */
    private boolean book;
    /**
     * 秒杀结束时间
     */
    private long endRemainTime;
    /**
     * 未知
     */
    private long wareId;
    /**
     * 是否免费阅读
     */
    private boolean canFreeRead;
    /**
     * 商品大图片地址
     */
    private String imageUrl;
    /**
     * 不知道是什么价格链接
     */
    private String wmaprice;
    /**
     * 商品分类id
     */
    private long cid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdWord() {
        return adWord;
    }

    public void setAdWord(String adWord) {
        this.adWord = adWord;
    }

    public String getWareName() {
        return wareName;
    }

    public void setWareName(String wareName) {
        this.wareName = wareName;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }

    public BigDecimal getMartPrice() {
        return martPrice;
    }

    public void setMartPrice(BigDecimal martPrice) {
        this.martPrice = martPrice;
    }

    public long getStartRemainTime() {
        return startRemainTime;
    }

    public void setStartRemainTime(long startRemainTime) {
        this.startRemainTime = startRemainTime;
    }

    public boolean isPromotion() {
        return promotion;
    }

    public void setPromotion(boolean promotion) {
        this.promotion = promotion;
    }

    public boolean isLoc() {
        return loc;
    }

    public void setLoc(boolean loc) {
        this.loc = loc;
    }

    public BigDecimal getJdPrice() {
        return jdPrice;
    }

    public void setJdPrice(BigDecimal jdPrice) {
        this.jdPrice = jdPrice;
    }

    public String getGoodPercentage() {
        return goodPercentage;
    }

    public void setGoodPercentage(String goodPercentage) {
        this.goodPercentage = goodPercentage;
    }

    public int getFlashSale() {
        return flashSale;
    }

    public void setFlashSale(int flashSale) {
        this.flashSale = flashSale;
    }

    public boolean isOnLine() {
        return onLine;
    }

    public void setOnLine(boolean onLine) {
        this.onLine = onLine;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public boolean isBook() {
        return book;
    }

    public void setBook(boolean book) {
        this.book = book;
    }

    public long getEndRemainTime() {
        return endRemainTime;
    }

    public void setEndRemainTime(long endRemainTime) {
        this.endRemainTime = endRemainTime;
    }

    public long getWareId() {
        return wareId;
    }

    public void setWareId(long wareId) {
        this.wareId = wareId;
    }

    public boolean isCanFreeRead() {
        return canFreeRead;
    }

    public void setCanFreeRead(boolean canFreeRead) {
        this.canFreeRead = canFreeRead;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getWmaprice() {
        return wmaprice;
    }

    public void setWmaprice(String wmaprice) {
        this.wmaprice = wmaprice;
    }

    public long getCid() {
        return cid;
    }

    public void setCid(long cid) {
        this.cid = cid;
    }
}
