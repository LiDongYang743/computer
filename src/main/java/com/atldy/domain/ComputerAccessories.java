package com.atldy.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 唐多山
 * @create 2020-09-30 8:07
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComputerAccessories implements Serializable {
    
    private Integer componentId;
    private String  componentName;
    private String  capacity;
    private Integer price;
    private Integer typeId;
}
