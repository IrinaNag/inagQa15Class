package com.telran.addressbook;

public class Group {
    private String groupName;
    private String groupHeader;
    private String groupFooter;

    public Group() {}

    public Group(String groupName, String groupHeader, String groupFooter) {
        this.groupName = groupName;
        this.groupHeader = groupHeader;
        this.groupFooter = groupFooter;
    }

    public String getGroupName() {
        return groupName;
    }

    public String getGroupHeader() {
        return groupHeader;
    }

    public String getGroupFooter() {
        return groupFooter;
    }

    public Group setGroupName(String groupName) {
        this.groupName = groupName;
        return this;
    }

    public Group setGroupHeader(String groupHeader) {
        this.groupHeader = groupHeader;
        return this;
    }

    public Group setGroupFooter(String groupFooter) {
        this.groupFooter = groupFooter;
        return this;
    }
}
