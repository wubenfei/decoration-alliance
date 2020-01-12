package com.ours.userappservice.controller.from;


import lombok.Data;

@Data
public class ContractFrom {
    private String address;

    private String contractNumber;

    private String contractType;

    private String contractStatus;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    public String getContractStatus() {
        return contractStatus;
    }

    public void setContractStatus(String contractStatus) {
        this.contractStatus = contractStatus;
    }

    public ContractFrom(String address, String contractNumber, String contractType, String contractStatus) {
        this.address = address;
        this.contractNumber = contractNumber;
        this.contractType = contractType;
        this.contractStatus = contractStatus;
    }

    public ContractFrom() {
    }
}
