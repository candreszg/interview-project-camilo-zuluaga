package com.ninjaone.backendinterviewproject.model.dto;

public class CostOfServiceDto {
    private Double totalCost;

    public CostOfServiceDto() {
    }

    public CostOfServiceDto(Double totalCost) {
        this.totalCost = totalCost;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

}
