package com.example.cnccompiler.base;

/**
 * 车直线
 */
public class Line extends CNCInstruction implements Stringable {

    public final static String INSTRUCTION="G01";
    
    private BasePoint p;
    private FeedSpeed f;

    public FeedSpeed getFeedSpeed() {
        return this.f;
    }

    public void setFeedSpeed(FeedSpeed f) {
        this.f = f;
    }

    public BasePoint getPoint() {
        return this.p;
    }

    public void setPoint(BasePoint p) {
        this.p = p;
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
     * 
     * @param p 终点
     */
    public Line(BasePoint p)
    {
        this.p=p;
        this.f=new FeedSpeed();
    }

    /**
     * 构造函数
     * 
     * @param p 终点
     * @param f 进给量
     */
    public Line(BasePoint p, FeedSpeed f)
    {
        this.p=p;
        this.f=f;
    }

    @Override
    public String toString() {
        return getInstruction()+" "+p.toString()+f.toString();
    }

}