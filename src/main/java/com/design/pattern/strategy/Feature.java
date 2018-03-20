package com.design.pattern.strategy;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 特征值
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Feature {

    //距离
    private String distance;

    //开销
    private String cost;

    //是否锻炼身体
    private Boolean workout;

    //是否押金
    private Boolean hasCashPledge;

}
