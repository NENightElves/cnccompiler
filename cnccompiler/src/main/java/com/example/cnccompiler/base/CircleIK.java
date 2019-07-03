package com.example.cnccompiler.base;

import com.example.cnccompiler.tools.DecimaFormatHundredth;

/**
 * 画圆参数
 * G02 X_Y_I_K_F_
 * G03 X_Y_I_K_F_
 */
public class CircleIK extends CircleParameter {

    private BasePoint p;
    private PointXZ ik;

    public BasePoint getPoint() {
        return this.p;
    }

    public void setPoint(BasePoint p) {
        this.p = p;
    }

    public PointXZ getIK() {
        return this.ik;
    }

    public void setIK(PointXZ ik) {
        this.ik = ik;
    }    

    /**
     * 构造函数
     * 
     * @param p 画圆终点
     * @param ik 圆心
     */
    public CircleIK(BasePoint p, PointXZ ik)
    {
        this.p=p;
        this.ik=ik;
    }

    @Override
    public String toString() {
        return p.toString()+"I"+DecimaFormatHundredth.format(ik.getX())+"K"+DecimaFormatHundredth.format(ik.getZ());
    }

}