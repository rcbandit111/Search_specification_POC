package org.merchant.database.service.businesscustomers;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum BusinessCustomersStatus {
    A("active", "Active"),
    O("onboarding", "Onboarding"),
    NV("not_verified", "Not Verified"),
    V("verified", "Verified"),
    S("suspended", "Suspended"),
    I("inactive", "Inactive");

    private String shortName;

    private String fullName;

    BusinessCustomersStatus(String shortName, String fullName) {
        this.shortName = shortName;
        this.fullName = fullName;
    }

    // Define the status field as the enum representation by using @JsonValue
    @JsonValue
    public String getShortName() {
        return shortName;
    }

    @JsonValue
    public String getFullName() {
        return fullName;
    }

    // Use the fromStatus method as @JsonCreator
    @JsonCreator
    public static BusinessCustomersStatus fromStatus(String statusText) {
        for (BusinessCustomersStatus status : values()) {
            if (status.getShortName().equalsIgnoreCase(statusText)) {
                return status;
            }
        }

        throw new UnsupportedOperationException(String.format("Unknown status: '%s'", statusText));
    }
}