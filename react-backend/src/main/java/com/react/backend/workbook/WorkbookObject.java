package com.react.backend.workbook;

/**
 * Created by vasiliy on 05.12.16.
 */
public class WorkbookObject {

    private int id;
    private String workbookText;

    public WorkbookObject(int id, String workbookText) {
        this.id = id;
        this.workbookText = workbookText;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWorkbookText() {
        return workbookText;
    }

    public void setWorkbookText(String workbookText) {
        this.workbookText = workbookText;
    }
}
