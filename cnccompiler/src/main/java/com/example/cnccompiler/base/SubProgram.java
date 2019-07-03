package com.example.cnccompiler.base;

/**
 * 子程序
 */
public class SubProgram extends CNCInstruction implements Stringable {

    public final static String M_CALL="M98";
    public final static String M_RETURN="M99";
    
    String number;
    int loop;


    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getLoop() {
        return this.loop;
    }

    public void setLoop(int loop) {
        this.loop = loop;
    }

    /**
     * 构造函数
     * 
     * @param number 子程序编号
     */
    public SubProgram(String number)
    {
        this.number=number;
        this.loop=1;
    }

    /**
     * 构造函数
     * 
     * @param number 子程序编号
     * @param loop 循环次数
     */
    public SubProgram(String number, int loop)
    {
        this.number=number;
        this.loop=loop;
    }

    @Override
    public String toString() {
        return M_CALL+" "+"P"+number+"L"+loop;
    }

}