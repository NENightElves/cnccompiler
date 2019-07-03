package com.example.cnccompiler.program;

import java.util.ArrayList;
import java.util.List;

import com.example.cnccompiler.base.MInstruction;
import com.example.cnccompiler.base.Stringable;
import com.example.cnccompiler.base.SubProgram;

public class Instructions implements Stringable {

    public static int programNumber=1000;

    private int number=0;

    private int times;

    List<Stringable> l;

    /**
     * 获取程序编号
     * 
     * @return 程序编号
     */
    public int getNumber() {
        return this.number;
    }

    /**
     * 设置程序编号
     * 
     * @param number 程序编号
     */
    public void setNumber(int number) {
        this.number = number;
    }

    public List<Stringable> getL() {
        return this.l;
    }

    public void setL(List<Stringable> l) {
        this.l = l;
    }

    /**
     * 获取循环次数
     * 
     * @return 循环次数
     */
    public int getTimes() {
        return this.times;
    }

    /**
     * 设置循环次数
     * 
     * @param times 循环次数
     */
    public void setTimes(int times) {
        this.times = times;
    }

    /**
     * 添加程序(段)
     * 
     * @param a 程序(段)
     */
    public void add(Stringable a)
    {
        l.add(a);
    }

    /**
     * 移除程序(段)
     * 
     * @param index 程序(段)序号
     */
    public void remove(int index)
    {
        l.remove(index);
    }

    /**
     * 构造函数
     * 0号程序
     * 执行1次
     */
    public Instructions()
    {
        l=new ArrayList<Stringable>();
        number=0;
        times=1;
    }

    /**
     * 构造函数
     * 
     * @param times 执行次数
     */
    public Instructions(int times)
    {
        l=new ArrayList<Stringable>();
        number=0;
        this.times=times;
    }
    
    /**
     * 构造函数
     * 
     * @param number 程序号
     * @param times 执行次数
     */
    public Instructions(int number, int times)
    {
        l=new ArrayList<Stringable>();
        this.number=number;
        this.times=times;
    }

    @Override
    public String toString() {
        String s;
        boolean f=false;
        s="";
        for (Stringable x : l) {
            if (x instanceof Instructions && ((Instructions)x).getTimes()!=1)
            {
                if (((Instructions)x).getNumber()==0) ((Instructions)x).setNumber(programNumber++);
                s+=new SubProgram(((Instructions)x).getNumber()+"", ((Instructions)x).getTimes())+"\n";
                continue;
            }
            s+=x.toString()+"\n";
        }
        for (Stringable x : l) {
            if (!(x instanceof Instructions)) continue;
            if (((Instructions)x).getTimes()==1) continue;
            if (!f)
            {
                s+=MInstruction.M_END+"\n";
                f=true;
            }
            s=s+"%"+((Instructions)x).getNumber()+"\n";
            s+=x.toString();
            s+=SubProgram.M_RETURN+"\n";
        }
        return s;
    }

}