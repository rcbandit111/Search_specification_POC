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

    public String getStatus() {
        return status;
    }

    public static BusinessCustomersStatus fromStatus(String status) {
        switch (status) {
            case "active": {
                return ACTIVE;
            }

            case "onboarding": {
                return ONBOARDING;
            }

            case "not_verified": {
                return NOT_VERIFIED;
            }

            case "verified": {
                return VERIFIED;
            }

            case "suspended": {
                return SUSPENDED;
            }

            case "inactive": {
                return INACTIVE;
            }

            default: {
                throw new UnsupportedOperationException(
                        String.format("Unkhown status: '%s'", status)
                );
            }
        }
    }
}