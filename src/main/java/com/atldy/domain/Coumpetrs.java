package com.atldy.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 唐多山
 * @create 2020-09-30 8:11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Coumpetrs implements Serializable {
    private Integer computerId;
    private String computerName;
    private Integer memory;
    private Integer cpu;
    private Integer videocard;
    private Integer display;
    private Integer hdd;
    private Integer price;
}
