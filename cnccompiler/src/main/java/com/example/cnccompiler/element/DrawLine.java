package com.example.cnccompiler.element;

import com.example.cnccompiler.base.FastMove;
import com.example.cnccompiler.base.FeedSpeed;
import com.example.cnccompiler.base.Knife;
import com.example.cnccompiler.base.Line;
import com.example.cnccompiler.base.MInstruction;
import com.example.cnccompiler.base.PointXZ;
import com.example.cnccompiler.base.SpinSpeed;
import com.example.cnccompiler.base.Stringable;

/**
 * 画直线
 */
public class DrawLine implements Stringable {

    private PointXZ start,end;
    private Conf conf;

    public PointXZ getStartPoint() {
        return this.start;
    }

    public void setStartPoint(PointXZ a) {
        this.start = a;
    }

    public PointXZ getEndPoint() {
        return this.end;
    }

    public void setEndPoint(PointXZ b) {
        this.end = b;
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
     */
    public DrawLine(PointXZ start, PointXZ end)
    {
        this.start=start;
        this.end=end;
    }

    /**
     * 构造函数
     * 
     * @param start 初始点
     * @param end 终止点
     * @param conf 配置
     */
    public DrawLine(PointXZ start, PointXZ end, Conf conf)
    {
        this.start=start;
        this.end=end;
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
        if (conf!=null && conf.isConfFeedSpeed()) s+=new Line(end,new FeedSpeed(conf.getFeedSpeed())).toString()+"\n"; else s+=new Line(end).toString()+"\n";
        // if (s.charAt(s.length()-1)=='\n') s=s.substring(0,s.length()-1);
        return s;
    }

}