package org.merchant.database.service.businesscustomers;

public enum BusinessCustomersStatus {
    ACTIVE("active"),
    ONBOARDING("onboarding"),
    NOT_VERIFIED("not_verified"),
    VERIFIED("verified"),
    SUSPENDED("suspended"),
    INACTIVE("inactive");

    private String status;

    BusinessCustomersStatus(String status)
    {
        this.status = status;
    }
}
