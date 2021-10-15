package org.merchant.database.service.businesscustomers;

public enum BusinessCustomersStatus {
    A("active"),
    O("onboarding"),
    NV("not_verified"),
    V("verified"),
    S("suspended"),
    I("inactive");

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
                return A;
            }

            case "onboarding": {
                return O;
            }

            case "not_verified": {
                return NV;
            }

            case "verified": {
                return V;
            }

            case "suspended": {
                return S;
            }

            case "inactive": {
                return I;
            }

            default: {
                throw new UnsupportedOperationException(
                        String.format("Unkhown status: '%s'", status)
                );
            }
        }
    }
}