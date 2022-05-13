package com.pojo;


public class Comments {

  private long commentid;
  private long gid;
  private String commentcontent;
  private java.sql.Timestamp commenttime;
  private String uid;
  private String commentlevel;


  public long getCommentid() {
    return commentid;
  }

  public void setCommentid(long commentid) {
    this.commentid = commentid;
  }


  public long getGid() {
    return gid;
  }

  public void setGid(long gid) {
    this.gid = gid;
  }


  public String getCommentcontent() {
    return commentcontent;
  }

  public void setCommentcontent(String commentcontent) {
    this.commentcontent = commentcontent;
  }


  public java.sql.Timestamp getCommenttime() {
    return commenttime;
  }

  public void setCommenttime(java.sql.Timestamp commenttime) {
    this.commenttime = commenttime;
  }


  public String getUid() {
    return uid;
  }

  public void setUid(String uid) {
    this.uid = uid;
  }


  public String getCommentlevel() {
    return commentlevel;
  }

  public void setCommentlevel(String commentlevel) {
    this.commentlevel = commentlevel;
  }

}
