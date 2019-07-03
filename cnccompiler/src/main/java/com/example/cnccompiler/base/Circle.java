package com.example.cnccompiler.base;

/**
 * 画圆弧
 * G02 X_Y_R_F_
 * G02 X_Y_I_K_F_
 * G03 X_Y_R_F_
 * G03 X_Y_I_K_F_
 */
public class Circle extends CNCInstruction implements Stringable {

    public final static String INSTRUCTION_CW="G02";
    public final static String INSTRUCTION_CCW="G03";

    private CircleParameter cp;
    private FeedSpeed f;
    private boolean isCW;

    public boolean getIsCW() {
        return this.isCW;
    }

    public void setIsCW(boolean isCW) {
        this.isCW = isCW;
    }

    public CircleParameter getCircleParameter() {
        return this.cp;
    }

    public void setCircleParameter(CircleParameter cp) {
        this.cp = cp;
    }

    public FeedSpeed getFeedSpeed() {
        return this.f;
    }

    public void setFeedSpeed(FeedSpeed f) {
        this.f = f;
    }
    
    public String getInstruction() {
        return (isCW)?INSTRUCTION_CW:INSTRUCTION_CCW;
    }

    // public Line()
    // {
    //     X=0;
    //     Z=0;
    // }

    /**
     * 构造函数
     * 默认顺时针
     * 默认进给量
     * 
     * @param cp 画圆参数
     */
    public Circle(CircleParameter cp)
    {
        this.cp=cp;
        this.f=new FeedSpeed();
        this.isCW=true;
    }

    /**
     * 构造函数
     * 默认进给量
     * 
     * @param cp 画圆参数
     * @param isCW 是否为顺时针
     */
    public Circle(CircleParameter cp, boolean isCW)
    {
        this.cp=cp;
        this.f=new FeedSpeed();
        this.isCW=isCW;
    }

    /**
     * 构造函数
     * 默认顺时针
     * 
     * @param cp 画圆参数
     * @param f 进给量
     */
    public Circle(CircleParameter cp, FeedSpeed f)
    {
        this.cp=cp;
        this.f=f;
        this.isCW=true;
    }

    /**
     * 构造函数
     * 
     * @param cp 花园参数
     * @param f 进给量
     * @param isCW 是否为顺时针
     */
    public Circle(CircleParameter cp, FeedSpeed f, boolean isCW)
    {
        this.cp=cp;
        this.f=f;
        this.isCW=isCW;
    }

    @Override
    public String toString() {
        return getInstruction()+" "+cp.toString()+f.toString();
    }

}