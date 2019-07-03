package com.example.cnccompiler.element;

import com.example.cnccompiler.base.Circle;
import com.example.cnccompiler.base.CircleIK;
import com.example.cnccompiler.base.FastMove;
import com.example.cnccompiler.base.FeedSpeed;
import com.example.cnccompiler.base.Knife;
import com.example.cnccompiler.base.MInstruction;
import com.example.cnccompiler.base.PointXZ;
import com.example.cnccompiler.base.SpinSpeed;

/**
 * 以初始点，中止点，圆心画弧
 */
public class DrawCircleIK extends DrawCircle {

    private PointXZ start,end,center;
    private boolean isCW;
    private Conf conf;


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

    public PointXZ getCenter() {
        return this.center;
    }

    public void setCenter(PointXZ center) {
        this.center = center;
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
     * @param start 起始点
     * @param end 终止点
     * @param center 圆心
     * @param isCW 是否为顺时针
     */
    public DrawCircleIK(PointXZ start, PointXZ end, PointXZ center, boolean isCW)
    {
        this.start=start;
        this.end=end;
        this.center=center;
        this.isCW=isCW;
    }

    /**
     * 构造函数
     * 
     * @param start 起始点
     * @param end 终止点
     * @param center 圆心
     * @param isCW 是否为顺时针
     * @param conf 配置
     */
    public DrawCircleIK(PointXZ start, PointXZ end, PointXZ center, boolean isCW, Conf conf)
    {
        this.start=start;
        this.end=end;
        this.center=center;
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
        if (conf!=null && conf.isConfFeedSpeed()) s+=new Circle(new CircleIK(end, center),new FeedSpeed(conf.getFeedSpeed()),isCW).toString()+"\n"; else s+=new Circle(new CircleIK(end, center),isCW).toString()+"\n";
        // if (s.charAt(s.length()-1)=='\n') s=s.substring(0,s.length()-1);
        return s;
    }

}