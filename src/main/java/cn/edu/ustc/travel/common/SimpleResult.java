package cn.edu.ustc.travel.common;

import lombok.Data;

@Data
public class SimpleResult {

    private int code;
    private String data;

    public SimpleResult(int code, String data) {
        this.code = code;
        this.data = data;
    }
}
