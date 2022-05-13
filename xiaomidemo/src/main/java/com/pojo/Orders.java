package com.pojo;


public class Orders {

  private String ordersNumber;
  private long uid;
  private double sumPrice;
  private long state;
  private java.sql.Timestamp createTime;
  private long countNumber;
  private long id;


  public String getOrdersNumber() {
    return ordersNumber;
  }

  public void setOrdersNumber(String ordersNumber) {
    this.ordersNumber = ordersNumber;
  }


  public long getUid() {
    return uid;
  }

  public void setUid(long uid) {
    this.uid = uid;
  }


  public double getSumPrice() {
    return sumPrice;
  }

  public void setSumPrice(double sumPrice) {
    this.sumPrice = sumPrice;
  }


  public long getState() {
    return state;
  }

  public void setState(long state) {
    this.state = state;
  }


  public java.sql.Timestamp getCreateTime() {
    return createTime;
  }

  public void setCreateTime(java.sql.Timestamp createTime) {
    this.createTime = createTime;
  }


  public long getCountNumber() {
    return countNumber;
  }

  public void setCountNumber(long countNumber) {
    this.countNumber = countNumber;
  }


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

}
