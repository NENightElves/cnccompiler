package com.example.cnccompiler.base;

import com.example.cnccompiler.tools.DecimaFormatHundredth;

/**
 * 设置给进速率
 */
public class FeedSpeed {

    public final static double DEFAULT_FEEDSPEED=0.25;
    private double f;

    public void setFeedSpeed(double f)
    {
        this.f=f;
    }

    public double getFeedSpeed()
    {
        return f;
    }

    /**
     * 构造函数，默认进给速率为0.25
     */
    public FeedSpeed()
    {
        f=DEFAULT_FEEDSPEED;
    }

    /**
     * 构造函数，设置进给速率
     * 
     * @param f 进给速率
     */
    public FeedSpeed(double f)
    {
        this.f=f;
    }

    @Override
    public String toString() {
        return "F"+DecimaFormatHundredth.format(f);
    }

}