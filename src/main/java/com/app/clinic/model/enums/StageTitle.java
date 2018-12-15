package com.app.clinic.model.enums;

/**
 * Product clinicApp
 * Created by artem_000 on 12/15/2018.
 */
public enum StageTitle {

    LOGIN_FRAME("login frame"),
    ;

    private String title;

    StageTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}