package com.example.cnccompiler.base;

/**
 * 设置刀具编号
 */
public class Knife extends CNCInstruction implements Stringable {

    public final static String INSTRUCTION = "T";

    private String k;

    public String getKnife() {
        return this.k;
    }

    public void setKnife(String k) {
        this.k = k;
    }

    public String getInstruction() {
        return INSTRUCTION;
    }

    /**
     * 构造函数
     * 
     * @param k 刀具编号
     */
    public Knife(String k) {
        this.k = k;
    }

    @Override
    public String toString() {
        return getInstruction() + k;
    }

}