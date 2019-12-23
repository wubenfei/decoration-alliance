package com.ours.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 用于向前端传链表查询的值
 * @Auth MrW
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepForm {
    private String depId;
    private String depName;
    private int headCount;
    private List<Staff> staffs;
}
