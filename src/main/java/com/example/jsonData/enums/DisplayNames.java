package com.example.jsonData.enums;

public enum DisplayNames {
    SubDepartment("Sub-Department"),
    CompanyName("Company Name"),
    EmployeeName("Employee Name"),
    DateCreated("Date Created"),
    EmailId("Email Id"),
    ManagerStatus("Manager Status"),
    ControlTowerStatus("Control Tower Status"),
    DateApproved("Date Approved"),
    ApprovingRemarks("Approving Remarks"),
    DateCompleted("Date Completed"),
    CTRemarks("Review Remarks");
    private final String displayName;

    DisplayNames(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}

