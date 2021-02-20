package cn.edu.ustc.travel.common;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Data
public class Result implements Serializable {
    private static final long serialVersionUID = 1L;
    private int code;
    private String msg;
    private Map<String, Object> data = new HashMap<String, Object>();

    private Result() {}

    public Result put(String key, Object value){
        this.data.put(key, value);
        return this;
    }

    public Result put(Map<String, Object> map){
        this.setData(map);
        return this;
    }

    public static Result ok() {
        Result result=new Result();
        result.setCode(20000);
        result.setMsg("操作成功");
        return result;
    }

    public static Result error() {
        Result result=new Result();
        result.setCode(20001);
        result.setMsg("操作失败");
        return result;
    }
}
