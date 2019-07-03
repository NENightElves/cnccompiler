package com.example.cnccompiler.element;

import com.example.cnccompiler.base.Circle;
import com.example.cnccompiler.base.CircleR;
import com.example.cnccompiler.base.FastMove;
import com.example.cnccompiler.base.FeedSpeed;
import com.example.cnccompiler.base.Knife;
import com.example.cnccompiler.base.MInstruction;
import com.example.cnccompiler.base.PointXZ;
import com.example.cnccompiler.base.SpinSpeed;

/**
 * 以初始点，中止点，半径画弧
 */
public class DrawCircleR extends DrawCircle {

    private PointXZ start,end;
    private double r;
    private boolean isCW;
    private Conf conf;


    public PointXZ getStart() {
        return this.start;
    }

    public void setStart(PointXZ start) {
        this.start = start;
    }

    public PointXZ getEnd() {
        return this.end;
    }

    public void setEnd(PointXZ end) {
        this.end = end;
    }

    public boolean isIsCW() {
        return this.isCW;
    }

    public boolean getIsCW() {
        return this.isCW;
    }

    public void setIsCW(boolean isCW) {
        this.isCW = isCW;
    }


    public PointXZ getStartPoint() {
        return this.start;
    }

    public void setStartPoint(PointXZ start) {
        this.start = start;
    }

    public PointXZ getEndPoint() {
        return this.end;
    }

    public void setEndPoint(PointXZ end) {
        this.end = end;
    }

    public double getR() {
        return this.r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public Conf getConf() {
        return this.conf;
    }

    public void setConf(Conf conf) {
        this.conf = conf;
    }

    /**
     * 构造函数
     * 
     * @param start 初始点
     * @param end 终止点
     * @param r 半径
     * @param isCW 是否为顺时针
     */
    public DrawCircleR(PointXZ start, PointXZ end, double r, boolean isCW)
    {
        this.start=start;
        this.end=end;
        this.r=r;
        this.isCW=isCW;
    }

    /**
     * 构造函数
     * 
     * @param start 初始点
     * @param end 终止点
     * @param r 半径
     * @param isCW 是否为顺时针
     * @param conf 配置
     */
    public DrawCircleR(PointXZ start, PointXZ end, double r, boolean isCW, Conf conf)
    {
        this.start=start;
        this.end=end;
        this.r=r;
        this.isCW=isCW;
        this.conf=conf;
    }

    @Override
    public String toString() {
        String s;
        s="";
        if (conf!=null)
        {
            if (conf.isConfKnife()) s+=new Knife(conf.getKnife())+"\n";
            if (conf.isConfSpinSpeed()) s+=new SpinSpeed(conf.getSpinSpeed())+"\n";
            if (conf.isConfLiquid()) { if (conf.getLiquid()) s+=MInstruction.M_LIQUID_ON+"\n"; else s+=MInstruction.M_LIQUID_OFF+"\n";}
        }
        s=new FastMove(start).toString()+"\n";
        if (conf!=null && conf.isConfFeedSpeed()) s+=new Circle(new CircleR(end, r),new FeedSpeed(conf.getFeedSpeed()),isCW).toString()+"\n"; else s+=new Circle(new CircleR(end, r),isCW).toString()+"\n";
        // if (s.charAt(s.length()-1)=='\n') s=s.substring(0,s.length()-1);
        return s;
    }

}