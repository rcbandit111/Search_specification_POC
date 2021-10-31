package org.merchant.database.service.businesscustomers;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.Setter;

public enum BusinessCustomersStatus {
    A("active", "Active"),
    O("onboarding", "Onboarding"),
    NV("not_verified", "Not Verified"),
    V("verified", "Verified"),
    S("suspended", "Suspended"),
    I("inactive", "Inactive");

    @Getter
    private String shortName;

    @Getter
    private String fullName;

    @Setter
    private boolean useShortFormat;

    @JsonValue
    public String getJsonValue() {
        if(useShortFormat) return shortName;
        return fullName;
    }

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
