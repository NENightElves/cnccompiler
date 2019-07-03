package com.example.cnccompiler.base;

import com.example.cnccompiler.tools.DecimaFormatHundredth;

/**
 * 相对点
 */
public class PointUW extends BasePoint {

    private double U;
    private double W;


    public double getU() {
        return this.U;
    }

    public void setU(double U) {
        this.U = U;
    }

    public double getW() {
        return this.W;
    }

    public void setW(double W) {
        this.W = W;
    }
    
    /**
     * 构造函数
     * 相对点为U0W0
     */
    public PointUW() {
        U=0;
        W=0;
    }
    
    /**
     * 构造函数
     * 
     * @param u 相对点的U坐标
     * @param w 相对点的W坐标
     */
    public PointUW(double u, double w) {
        U=u;
        W=w;
    }

    @Override
    public String toString() {
        return "U"+DecimaFormatHundredth.format(U)+"W"+DecimaFormatHundredth.format(W);
    }

}