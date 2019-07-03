package com.example.cnccompiler.base;

import com.example.cnccompiler.exceptions.CNCChamferException;
import com.example.cnccompiler.tools.DecimaFormatHundredth;

/**
 * 车倒角或圆角
 * G01 X_Z_C_
 * G01 X_Z_R_
 * 可以使用车直线代替
 */
@Deprecated
public class Chamfer extends CNCInstruction implements Stringable {

    public final static String INSTRUCTION="G01";

    private BasePoint p;
    private double C;
    private boolean isCircle;


    public BasePoint getPoint() {
        return this.p;
    }

    public void setPoint(BasePoint p) {
        this.p = p;
    }

    public boolean getIsCircle() {
        return this.isCircle;
    }

    public double getC() {
        if (isCircle) throw new CNCChamferException("Chamfer is circle!");
        return this.C;
    }

    public void setC(double C) {
        if (isCircle) throw new CNCChamferException("Chamfer is circle!");
        this.C = C;
    }

    public double getR() {
        if (!isCircle) throw new CNCChamferException("Chamfer is not circle!");
        return getC();
    }

    public void setR(double R) {
        if (!isCircle) throw new CNCChamferException("Chamfer is not circle!");
        setC(R);
    }


    public String getInstruction() {
        return INSTRUCTION;
    }

    // public Line()
    // {
    //     X=0;
    //     Z=0;
    // }

    /**
     * 构造函数
     * 默认为倒角
     * 
     * @param p 倒角结束点位置
     * @param c 倒角边长
     */
    public Chamfer(BasePoint p, double c)
    {
        this.p=p;
        C=c;
        this.isCircle=false;
    }

    /**
     * 构造函数
     * 
     * @param p 倒角结束位置
     * @param c 倒角边长或半径
     * @param isCircle 参数c为半径则为true
     */
    public Chamfer(BasePoint p, double c, boolean isCircle)
    {
        this.p=p;
        C=c;
        this.isCircle=isCircle;
    }

    @Override
    public String toString() {
        return getInstruction()+" "+p.toString()+((isCircle)?"R":"C")+DecimaFormatHundredth.format(C);
    }

}