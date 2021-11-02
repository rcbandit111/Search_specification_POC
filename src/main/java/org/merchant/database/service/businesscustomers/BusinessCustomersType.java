package org.merchant.database.service.businesscustomers;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.Setter;

public enum BusinessCustomersType {
    M("merchant", "Merchant"),
    O("owner", "Owner");

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

    BusinessCustomersType(String shortName, String fullName) {
        this.shortName = shortName;
        this.fullName = fullName;
    }

    // Use the fromStatus method as @JsonCreator
    @JsonCreator
    public static BusinessCustomersType fromStatus(String statusText) {
        for (BusinessCustomersType type : values()) {
            if (type.getShortName().equalsIgnoreCase(statusText)) {
                return type;
            }
        }

        throw new UnsupportedOperationException(String.format("Unknown status: '%s'", statusText));
    }
}
