package com.example.cnccompiler.program;

import java.util.ArrayList;
import java.util.List;

import com.example.cnccompiler.base.PointXZ;
import com.example.cnccompiler.base.Stringable;
import com.example.cnccompiler.element.Conf;
import com.example.cnccompiler.element.DrawCircleIK;
import com.example.cnccompiler.element.DrawCircleR;
import com.example.cnccompiler.element.DrawLine;

/**
 * 先粗车，再精车
 * 会忽略组中的conf
 */
public class MachiningGroup implements Stringable {

    private List<Stringable> l;

    private int times;
    private double fstart,fend;
    private double lstart,lend;
    private Conf confstart,confend;

    public int getTimes() {
        return this.times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public double getFstart() {
        return this.fstart;
    }

    public void setFstart(double fstart) {
        this.fstart = fstart;
    }

    public double getFend() {
        return this.fend;
    }

    public void setFend(double fend) {
        this.fend = fend;
    }

    /**
     * 构造函数
     * 
     * @param times 粗车次数
     * @param lstart 粗车厚度
     * @param lend 精车厚度
     * @param fstart 粗车进给量
     * @param fend 精车进给量
     */
    public MachiningGroup(int times, double lstart, double lend, double fstart, double fend)
    {
        l=new ArrayList<Stringable>();
        this.times=times;
        this.fstart=fstart;
        this.fend=fend;
        this.lstart=lstart;
        this.lend=lend;
        confstart=new Conf();
        confstart.setFeedSpeed(fstart);
        confend=new Conf();
        confend.setFeedSpeed(fend);
    }

    /**
     * 添加粗车精车组程序
     * 
     * @param a 程序(段)
     */
    public void add(Stringable a)
    {
        l.add(a);
    }

    /**
     * 移除粗车精车组程序
     * 
     * @param index 程序(段)编号
     */
    public void remove(int index)
    {
        l.remove(index);
    }

    @Override
    public String toString() {
        String s="";
        int i;
        for(i=times;i>-1;i--)
        {
            for (Stringable x : l) {
                if (x instanceof DrawLine)
                {
                    DrawLine tmpdl=(DrawLine)x;
                    s+=new DrawLine(new PointXZ(tmpdl.getStartPoint().getX()+i*lstart+lend,tmpdl.getStartPoint().getZ()),new PointXZ(tmpdl.getEndPoint().getX()+i*lstart+lend,tmpdl.getEndPoint().getZ()),confstart).toString()+"\n";
                }
                if (x instanceof DrawCircleR)
                {
                    DrawCircleR tmpcr=(DrawCircleR)x;
                    s+=new DrawCircleR(new PointXZ(tmpcr.getStartPoint().getX()+i*lstart+lend,tmpcr.getStartPoint().getZ()),new PointXZ(tmpcr.getEndPoint().getX()+i*lstart+lend,tmpcr.getEndPoint().getZ()), tmpcr.getR(), tmpcr.getIsCW(), confstart).toString()+"\n";
                }
                if (x instanceof DrawCircleIK)
                {
                    DrawCircleIK tmpcik=(DrawCircleIK)x;
                    s+=new DrawCircleIK(new PointXZ(tmpcik.getStartPoint().getX()+i*lstart+lend,tmpcik.getStartPoint().getZ()),new PointXZ(tmpcik.getEndPoint().getX()+i*lstart+lend,tmpcik.getEndPoint().getZ()), new PointXZ(tmpcik.getCenter().getX()+i*lstart+lend, tmpcik.getCenter().getZ()), tmpcik.getIsCW(), confstart).toString()+"\n";
                }
            }
        }
        for (Stringable x : l) {
            if (x instanceof DrawLine)
            {
                DrawLine tmpdl=(DrawLine)x;
                s+=new DrawLine(new PointXZ(tmpdl.getStartPoint().getX(),tmpdl.getStartPoint().getZ()),new PointXZ(tmpdl.getEndPoint().getX(),tmpdl.getEndPoint().getZ()),confend).toString()+"\n";
            }
            if (x instanceof DrawCircleR)
            {
                DrawCircleR tmpcr=(DrawCircleR)x;
                s+=new DrawCircleR(new PointXZ(tmpcr.getStartPoint().getX(),tmpcr.getStartPoint().getZ()),new PointXZ(tmpcr.getEndPoint().getX(),tmpcr.getEndPoint().getZ()), tmpcr.getR(), tmpcr.getIsCW(), confend).toString()+"\n";
            }
            if (x instanceof DrawCircleIK)
            {
                DrawCircleIK tmpcik=(DrawCircleIK)x;
                s+=new DrawCircleIK(new PointXZ(tmpcik.getStartPoint().getX(),tmpcik.getStartPoint().getZ()),new PointXZ(tmpcik.getEndPoint().getX(),tmpcik.getEndPoint().getZ()), new PointXZ(tmpcik.getCenter().getX(), tmpcik.getCenter().getZ()), tmpcik.getIsCW(), confend).toString()+"\n";
            }
        }
        return s;
    }

}