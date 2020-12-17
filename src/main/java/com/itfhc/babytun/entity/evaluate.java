package com.itfhc.babytun.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author FUHAOCHENG
 * @version 1.0
 * @date 2020/12/15 19:00
 */
public class evaluate implements Serializable{
    private Long evaluateId;
    private String content;
    private Integer stars;
    private Date createTime;
    private Long goodsId;

    public Long getEvaluateId() {
        return evaluateId;
    }

    public void setEvaluateId(Long evaluateId) {
        this.evaluateId = evaluateId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    @Override
    public String toString() {
        return "evaluate{" +
                "evaluateId=" + evaluateId +
                ", content='" + content + '\'' +
                ", stars=" + stars +
                ", createTime=" + createTime +
                ", goodsId=" + goodsId +
                '}';
    }
}
