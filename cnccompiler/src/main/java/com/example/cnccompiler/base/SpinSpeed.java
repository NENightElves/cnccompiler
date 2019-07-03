package com.example.cnccompiler.base;

/**
 * 设置主轴转速
 */
public class SpinSpeed extends CNCInstruction implements Stringable {

    public final static String INSTRUCTION="G50";

    private int speed;

    public int getSpeed() {
        return this.speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getInstruction() {
        return INSTRUCTION;
    }

    /**
     * 构造函数
     * 
     * @param speed 主轴转速
     */
    public SpinSpeed(int speed)
    {
        this.speed=speed;
    }

    @Override
    public String toString() {
        return getInstruction()+" S"+speed;
    }

}