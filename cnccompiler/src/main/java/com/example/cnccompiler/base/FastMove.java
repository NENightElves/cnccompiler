package com.example.cnccompiler.base;

/**
 * 快速移动
 */
public class FastMove extends CNCInstruction implements Stringable {

    public final static String INSTRUCTION="G00";

    private BasePoint p;


    public BasePoint getPoint() {
        return this.p;
    }

    public void setPoint(BasePoint p) {
        this.p = p;
    }    

    public String getInstruction() {
        return INSTRUCTION;
    }

    /**
     * 构造函数，快速移动到X0Z0
     */
    public FastMove()
    {
        p=new PointXZ();
    }

    /**
     * 构造函数
     * 
     * @param p 移动到的点
     */
    public FastMove(BasePoint p)
    {
        this.p=p;
    }

    @Override
    public String toString() {
        return getInstruction()+" "+p.toString();
    }

}