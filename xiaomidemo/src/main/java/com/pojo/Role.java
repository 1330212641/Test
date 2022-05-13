package com.pojo;


import java.io.Serializable;

public class Role implements Serializable {

  private long rid;
  private String rname;
  private String rnamezh;


  public long getRid() {
    return rid;
  }

  public void setRid(long rid) {
    this.rid = rid;
  }


  public String getRname() {
    return rname;
  }

  public void setRname(String rname) {
    this.rname = rname;
  }


  public String getRnamezh() {
    return rnamezh;
  }

  public void setRnamezh(String rnamezh) {
    this.rnamezh = rnamezh;
  }

}
