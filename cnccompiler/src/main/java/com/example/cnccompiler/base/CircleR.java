package com.example.cnccompiler.base;

/**
 * 画圆参数
 * G02 X_Y_R_F_
 * G03 X_Y_R_F_
 */
public class CircleR extends CircleParameter {

    private BasePoint p;
    private double r;

    public BasePoint getPoint() {
        return this.p;
    }

    public void setPoint(BasePoint p) {
        this.p = p;
    }

    public double getR() {
        return this.r;
    }

    public void setR(double r) {
        this.r = r;
    }

    /**
     * 构造函数
     * 
     * @param p 画圆终点
     * @param r 半径
     */
    public CircleR(BasePoint p, double r)
    {
        this.p=p;
        this.r=r;
    }

    @Override
    public String toString() {
        return p.toString()+"R"+r;
    }

}