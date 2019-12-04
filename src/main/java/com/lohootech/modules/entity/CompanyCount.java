package com.lohootech.modules.entity;

public class CompanyCount {
    private String companyName;
    private String count;

    @Override
    public String toString() {
        return "CompanyCount{" +
                "companyName='" + companyName + '\'' +
                ", count='" + count + '\'' +
                '}';
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public CompanyCount() {
    }

    public CompanyCount(String companyName, String count) {
        this.companyName = companyName;
        this.count = count;
    }
}
