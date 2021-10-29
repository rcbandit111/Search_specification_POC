package org.merchant.database.service.businesscustomers;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

public enum BusinessCustomersStatus {
    A("active", "Active"),
    O("onboarding", "Onboarding"),
    NV("not_verified", "Not Verified"),
    V("verified", "Verified"),
    S("suspended", "Suspended"),
    I("inactive", "Inactive");

    @Getter
    private String shortName;

    @JsonValue
    @Getter
    private String fullName;

    BusinessCustomersStatus(String shortName, String fullName) {
        this.shortName = shortName;
        this.fullName = fullName;
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