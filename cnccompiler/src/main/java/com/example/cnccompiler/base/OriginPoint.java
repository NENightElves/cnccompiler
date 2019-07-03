package com.example.cnccompiler.base;

/**
 * 设置原点
 */
public class OriginPoint extends CNCInstruction implements Stringable {

    public final static String INSTRUCTION="G50";

    private PointXZ p;

    public PointXZ getPoint() {
        return this.p;
    }

    public void setPoint(PointXZ p) {
        this.p = p;
    }

    public String getInstruction() {
        return INSTRUCTION;
    }

    /**
     * 原点为X0Z0
     */
    public OriginPoint()
    {
        p=new PointXZ();
    }

    /**
     * 构造函数
     * 
     * @param p 原点
     */
    public OriginPoint(PointXZ p)
    {
        this.p=p;
    }

    @Override
    public String toString() {
        return getInstruction()+" "+p.toString();
    }

}