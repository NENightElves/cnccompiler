package com.example.cnccompiler.base;

/**
 * 自定义指令
 */
public class NormalInstruction extends CNCInstruction implements Stringable {

    private String instruction;

    public String getInstruction() {
        return this.instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    /**
     * 构造函数
     * 
     * @param s 自定义的指令
     */
    public NormalInstruction(String s)
    {   
        instruction=s;
    }

    @Override
    public String toString() {
        return instruction;
    }
}