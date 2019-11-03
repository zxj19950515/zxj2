package com.qf.domain;

public class Shoper {
    private Integer id;
    private String posName;
    private String posStatus;
    private String posTime;

    public Integer getStartRow() {
        return startRow;
    }

    public void setStartRow(Integer startRow) {
        this.startRow = startRow;
    }

    public Integer getEndRow() {
        return endRow;
    }

    public void setEndRow(Integer endRow) {
        this.endRow = endRow;
    }

    private Integer startRow;
    private Integer endRow;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPosName() {
        return posName;
    }

    public void setPosName(String posName) {
        this.posName = posName;
    }

    public String getPosStatus() {
        return posStatus;
    }

    public void setPosStatus(String posStatus) {
        this.posStatus = posStatus;
    }


    public String getPosTime() {
        return posTime;
    }

    public void setPosTime(String posTime) {
        this.posTime = posTime;
    }

    public Shoper(Integer id, String posName, String posStatus, String posTime) {
        this.id = id;
        this.posName = posName;
        this.posStatus = posStatus;
        this.posTime = posTime;
    }

    public Shoper() {
    }

    @Override
    public String toString() {
        return "Shoper{" +
                "id=" + id +
                ", posName='" + posName + '\'' +
                ", posStatus='" + posStatus + '\'' +
                ", posTime='" + posTime + '\'' +
                ", startRow=" + startRow +
                ", endRow=" + endRow +
                '}';
    }
}
