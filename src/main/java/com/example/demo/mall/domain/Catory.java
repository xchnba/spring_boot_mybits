package com.example.demo.mall.domain;

public class Catory {
    private Long id;
    private Long parentid;
    private String text;
    private String lb;
    private int isparent;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentid() {
        return parentid;
    }

    public void setParentid(Long parentid) {
        this.parentid = parentid;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getLb() {
        return lb;
    }

    public void setLb(String lb) {
        this.lb = lb;
    }

    public int getIsparent() {
        return isparent;
    }

    public void setIsparent(int isparent) {
        this.isparent = isparent;
    }

    @Override
    public String toString() {
        return "Catory{" +
                "id=" + id +
                ", parentid=" + parentid +
                ", text='" + text + '\'' +
                ", lb='" + lb + '\'' +
                ", isparent=" + isparent +
                '}';
    }
}
