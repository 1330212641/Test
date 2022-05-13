package com.pojo;

import java.util.List;

public class Goods {

    private long gid;
    private long cid;
    private  String zlanmu;
    private String gname;
    private String color;
    private String size;
    private double price;
    private String description;
    private String fullDescription;
    private String pic;
    private long state;
    private String version;
    private java.sql.Timestamp productDate;
    private List<Comments> commentsList;

    public List<Comments> getCommentsList() {
        return commentsList;
    }

    public void setCommentsList(List<Comments> commentsList) {
        this.commentsList = commentsList;
    }
    public long getGid() {
        return gid;
    }

    public void setGid(long gid) {
        this.gid = gid;
    }


    public long getCid() {
        return cid;
    }

    public void setCid(long cid) {
        this.cid = cid;
    }


    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getFullDescription() {
        return fullDescription;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }


    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }


    public long getState() {
        return state;
    }

    public void setState(long state) {
        this.state = state;
    }


    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getZlanmu() {
        return zlanmu;
    }

    public void setZlanmu(String zlanmu) {
        this.zlanmu = zlanmu;
    }

    public java.sql.Timestamp getProductDate() {
        return productDate;
    }

    public void setProductDate(java.sql.Timestamp productDate) {
        this.productDate = productDate;
    }

}
