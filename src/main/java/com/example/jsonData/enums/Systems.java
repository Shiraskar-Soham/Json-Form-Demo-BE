package com.example.jsonData.enums;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Systems {

    OASYS("Oasys"),
    ORION("Orion"),
    OXYZO("Oxyzo"),
    OMAT("Omat"),
    SALES_SYSTEM("Sales System"),
    CERES("Ceres"),
    OAGRIFARM("Oagrifarm (Loan)"),
    OCEAN("Ocean"),
    PRISM("Prism"),
    OMAT_FINANCE("Omat Finance");

    private String displayName;

    Systems(String displayName) {
        this.displayName = displayName;
    }

    Systems() {
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public static Map<Systems, String> getAll() {
        return Stream.of(Systems.values())
                .collect(Collectors.toMap(system -> system, Systems::getDisplayName));
    }
}
