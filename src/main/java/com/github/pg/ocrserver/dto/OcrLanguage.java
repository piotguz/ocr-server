package com.github.pg.ocrserver.dto;

import lombok.Getter;

public enum OcrLanguage {
    OCR_ENG("eng"),
    OCR_POL("pol");

    @Getter
    private String lang;
    private OcrLanguage(String lang) {
        this.lang = lang;
    }
}
