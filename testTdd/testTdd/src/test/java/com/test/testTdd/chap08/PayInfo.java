package com.test.testTdd.chap08;

import lombok.Data;

@Data
public class PayInfo {

    private String path1;
    private String path2;
    int parse;

    public PayInfo(String datum, String datum1, int parseInt) {
        this.path1 = datum;
        this.path2 = datum1;
        this.parse = parseInt;
    }
}
