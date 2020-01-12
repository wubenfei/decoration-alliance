package com.ours.entity;

import lombok.Data;

@Data
public class Adjustment extends Wages {
    private String contractName;

    private String contractType;
}
