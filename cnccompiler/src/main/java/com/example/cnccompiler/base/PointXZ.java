package com.example.cnccompiler.base;

import com.example.cnccompiler.tools.DecimaFormatHundredth;

/**
 * 绝对点
 */
public class PointXZ extends BasePoint {

    private double X;
    private double Z;

    public double getX() {
        return this.X;
    }

    public void setX(double X) {
        this.X = X;
    }

    public double getZ() {
        return this.Z;
    }

    public void setY(double Z) {
        this.Z = Z;
    }

    /**
     * 构造函数
     * 坐标为X0Z0
     */
    public PointXZ() {
        X=0;
        Z=0;
    }
    
    /**
     * 构造函数
     * @param x 绝对点的X坐标
     * @param z 绝对点的Z坐标
     */
    public PointXZ(double x, double z) {
        X=x;
        Z=z;
    }

    @Override
    public String toString() {
        return "X"+DecimaFormatHundredth.format(X)+"Z"+DecimaFormatHundredth.format(Z);
    }

}