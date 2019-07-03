package com.example.cnccompiler.element;

import com.example.cnccompiler.base.Knife;
import com.example.cnccompiler.base.OriginPoint;
import com.example.cnccompiler.base.PointXZ;
import com.example.cnccompiler.base.SpinSpeed;
import com.example.cnccompiler.base.Stringable;

/**
 * 初始化车床，定义初始用刀，初始转速，初始坐标轴零点
 */
public class StartUp implements Stringable {

    private double x,z;
    private int s;
    private String t;

    /**
     * 构造函数
     * 
     * @param x 原点x坐标
     * @param z 原点z坐标
     * @param s 转速
     * @param t 使用的刀具
     */
    public StartUp(double x, double z, int s, String t)
    {
        this.x=x;
        this.z=z;
        this.s=s;
        this.t=t;
    }

    @Override
    public String toString() {
        String ss="";
        ss+=new OriginPoint(new PointXZ(x,z)).toString()+"\n";
        ss+=new SpinSpeed(s).toString()+"\n";
        ss+=new Knife(t);
        return ss;
    }
    
}