package com.atldy.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 唐多山
 * @create 2020-09-29 20:08
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ComputerType implements Serializable {
    private Integer typeId;
    private String typename;
}
