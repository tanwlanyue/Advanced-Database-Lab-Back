package cn.edu.ustc.travel.model.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class HotelQuery implements Serializable {
    private String name;
    private String location;
}
