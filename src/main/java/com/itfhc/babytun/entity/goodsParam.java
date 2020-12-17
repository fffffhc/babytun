package com.itfhc.babytun.entity;

import java.io.Serializable;

/**
 * @author FUHAOCHENG
 * @version 1.0
 * @date 2020/12/10 18:22
 */
public class goodsParam implements Serializable{
    private Long gpId;
    private String gpParamName;
    private String gpParamValue;
    private Long goodsId;
    private Long gpOrder;

    public Long getGpId() {
        return gpId;
    }

    public void setGpId(Long gpId) {
        this.gpId = gpId;
    }

    public String getGpParamName() {
        return gpParamName;
    }

    public void setGpParamName(String gpParamName) {
        this.gpParamName = gpParamName;
    }

    public String getGpParamValue() {
        return gpParamValue;
    }

    public void setGpParamValue(String gpParamValue) {
        this.gpParamValue = gpParamValue;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Long getGpOrder() {
        return gpOrder;
    }

    public void setGpOrder(Long gpOrder) {
        this.gpOrder = gpOrder;
    }

    @Override
    public String toString() {
        return "goodsParam{" +
                "gpId=" + gpId +
                ", gpParamName='" + gpParamName + '\'' +
                ", gpParamValue='" + gpParamValue + '\'' +
                ", goodsId=" + goodsId +
                ", gpOrder=" + gpOrder +
                '}';
    }
}
