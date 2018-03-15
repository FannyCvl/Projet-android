package com.example.fanny.projetfinal.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;



public class ListSource {
    @SerializedName("status")
    private String status;

    @SerializedName("sources")
    private List<Source> sourceList;

    public ListSource(){}

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Source> getSourceList() {
        return sourceList;
    }

    public void setSourceList(List<Source> sourceList) {
        this.sourceList = sourceList;
    }
}
