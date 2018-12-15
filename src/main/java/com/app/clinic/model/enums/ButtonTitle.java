package com.app.clinic.model.enums;

/**
 * Product clinicApp
 * Created by artem_000 on 12/15/2018.
 */
public enum ButtonTitle {

    LOGIN("Войти"),
    CANCEL("Отмена"),

    ;

    private String title;

    ButtonTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}