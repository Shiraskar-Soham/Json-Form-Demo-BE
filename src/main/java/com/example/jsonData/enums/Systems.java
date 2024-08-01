package com.example.jsonData.enums;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Systems {

    OASYS("Oasys", new ArrayList<>(List.of(
        "RFQ",
        "Order",
        "Dispatch",
        "Shipment",
        "Invoice",
        "Supplier PO Verification",
        "Report",
        "Receipt",
        "Payment Request",
        "Ledger",
        "Voucher",
        "Invoice Verification",
        "Warehouse",
        "Supplier Verification",
        "Accounts - Supplier",
        "Accounts - LSP",
        "Accounts - Vendor",
        "Accounts - Agent",
        "Other"
    ))),
    ORION("Orion", new ArrayList<>(List.of(
        "Module1",
        "Module2",
        "Module3",
        "Module4",
        "Other"
    ))),
    OXYZO("Oxyzo", new ArrayList<>(List.of(
        "Module1",
        "Module2",
        "Module3",
        "Module4",
        "Other"
    ))),
    OMAT("Omat", new ArrayList<>(List.of(
        "RFQ",
        "Order",
        "Dispatch",
        "Shipment",
        "Invoice",
        "Supplier PO Verification",
        "Report",
        "Receipt",
        "Payment Request",
        "Ledger",
        "Voucher",
        "Invoice Verification",
        "Warehouse",
        "Supplier Verification",
        "Accounts - Supplier",
        "Accounts - LSP",
        "Accounts - Vendor",
        "Accounts - Agent",
        "Other"
    ))),
    SALES_SYSTEM("Sales System", new ArrayList<>(List.of(
        "Lead",
        "Collection",
        "Disbursal Status",
        "Interest Collection",
        "Check In/ Check Out"
    ))),
    CERES("Ceres", new ArrayList<>(List.of(
        "RFQ",
        "Order",
        "Dispatch",
        "Shipment",
        "Invoice",
        "Supplier PO Verification",
        "Report",
        "Receipt",
        "Payment Request",
        "Ledger",
        "Voucher",
        "Invoice Verification",
        "Warehouse",
        "Supplier Verification",
        "Accounts - Supplier",
        "Accounts - LSP",
        "Accounts - Vendor",
        "Accounts - Agent",
        "Other"
    ))),
    OAGRIFARM("Oagrifarm (Loan)", new ArrayList<>(List.of(
        "Module1",
        "Module2",
        "Module3",
        "Module4",
        "Other"
    ))),
    OCEAN("Ocean", new ArrayList<>(List.of(
        "RFQ",
        "Order",
        "Dispatch",
        "Shipment",
        "Invoice",
        "Supplier PO Verification",
        "Report",
        "Receipt",
        "Payment Request",
        "Ledger",
        "Voucher",
        "Invoice Verification",
        "Warehouse",
        "Supplier Verification",
        "Accounts - Supplier",
        "Accounts - LSP",
        "Accounts - Vendor",
        "Accounts - Agent",
        "Other"
    ))),
    PRISM("Prism", new ArrayList<>(List.of(
        "Module1",
        "Module2",
        "Module3",
        "Module4",
        "Other"
    ))),
    OMAT_FINANCE("Omat Finance", new ArrayList<>(List.of(
        "Module1",
        "Module2",
        "Module3",
        "Module4",
        "Other"
    )));

    private String displayName;

    private List<String> modules;

    Systems(String displayName, List<String> modules) {
        this.displayName = displayName;
        this.modules = modules;
    }

    Systems() {
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public List<String> getModules() {
        return modules;
    }

    public void setModules(List<String> modules) {
        this.modules = modules;
    }

    public static Map<Systems, String> getAll() {
        return Stream.of(Systems.values())
                .collect(Collectors.toMap(system -> system, Systems::getDisplayName));
    }
}
