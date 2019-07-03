package com.example.cnccompiler.element;

import com.example.cnccompiler.base.Knife;
import com.example.cnccompiler.base.MInstruction;
import com.example.cnccompiler.base.SpinSpeed;
import com.example.cnccompiler.base.Stringable;
import com.example.cnccompiler.exceptions.ConfCannotToString;

/**
 * 设置刀具、转速、进给量、是否用冷却液
 */
public class Conf implements Stringable {

    private String t;
    private int s;
    private double f;
    private boolean l;
    private boolean a,b,c,d;

    public boolean getLiquid() {
        return this.l;
    }

    /**
     * 是否使用冷却液
     * 
     * @param l 是否使用冷却液
     */
    public void setLiquid(boolean l) {
        this.l = l;
        d=true;
    }

    public String getKnife() {
        return this.t;
    }

    /**
     * 使用的刀具编号
     * 
     * @param t 使用的刀具编号
     */
    public void setKnife(String t) {
        this.t = t;
        a=true;
    }

    public int getSpinSpeed() {
        return this.s;
    }

    /**
     * 设置转速
     * 
     * @param s 转速
     */
    public void setSpinSpeed(int s) {
        this.s = s;
        b=true;
    }

    public double getFeedSpeed() {
        return this.f;
    }

    /**
     * 设置进给量
     * 
     * @param f 进给量
     */
    public void setFeedSpeed(double f) {
        this.f = f;
        c=true;
    }

    public Conf()
    {
        a=false;
        b=false;
        c=false;
        d=false;
    }

    public boolean isConfKnife()
    {
        return a;
    }
    public boolean isConfSpinSpeed()
    {
        return b;
    }
    public boolean isConfFeedSpeed()
    {
        return c;
    }
    public boolean isConfLiquid()
    {
        return d;
    }

    @Override
    public String toString() {
        String s="";
        if (isConfFeedSpeed()) throw new ConfCannotToString("Conf cannot to string because feed speed has been configured!");
        if (this.isConfKnife()) s+=new Knife(this.getKnife())+"\n";
        if (this.isConfSpinSpeed()) s+=new SpinSpeed(this.getSpinSpeed())+"\n";
        if (this.isConfLiquid()) { if (this.getLiquid()) s+=MInstruction.M_LIQUID_ON+"\n"; else s+=MInstruction.M_LIQUID_OFF+"\n"; }
        return s;
    }
}