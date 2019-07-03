package com.example.cnccompiler.tools;

import com.example.cnccompiler.base.MInstruction;

/**
 * 优化G代码
 */
public class OptimizeGCode {

    private static String getInstructionWithoutNumber(String s)
    {
        return s.substring(0,1);
    }

    private static String getInstruction(String s)
    {
        if (s.indexOf(" ")==-1) return s.substring(0, s.length());
        return s.substring(0,s.indexOf(" "));
    }

    /**
     * 优化G代码
     * 
     * @param x G代码段
     * @return 优化后的G代码段
     */
    public static String optimize(String x)
    {
        int i;
        String s=new String(x);
        String[] l;
        int n=0;
        String tmpt="",tmps="",tmpm="";
        String tmp="";
        for(i=0;i<s.length()-1;i++)
            if (s.charAt(i)=='\n')
                while(i+1<s.length() && s.charAt(i+1)=='\n') 
                    if (i+2<s.length()) s=s.substring(0, i+1)+s.substring(i+2); else s=s.substring(0, i+1);
        if (s.charAt(s.length()-1)=='\n') s=s.substring(0, s.length()-1);
        l=s.split("\n");

        for(i=0;i<l.length;i++)
        {
            if (getInstructionWithoutNumber(l[i]).equals("T"))
            {
                if (tmpt.equals(l[i])) l[i]=""; else tmpt=l[i];
            }
            if (getInstruction(l[i]).equals("G50"))
            {
                if (l[i].substring(0, 5).equals("G50 S"))
                {
                    if (tmps.equals(l[i])) l[i]=""; else tmps=l[i];
                }
            }
            if (getInstruction(l[i]).equals(MInstruction.M_LIQUID_ON) || getInstruction(l[i]).equals(MInstruction.M_LIQUID_OFF))
            {
                if (tmpm.equals(l[i])) l[i]=""; else tmpm=l[i];
            }
            if (getInstruction(l[i]).equals("G00"))
            {
                tmp=l[i].substring(4,l[i].length());
                if (i-1>-1 && (getInstruction(l[i-1]).equals("G01") || getInstruction(l[i-1]).equals("G02") || getInstruction(l[i-1]).equals("G03")) && tmp.equals(l[i-1].substring(4, 4+tmp.length()))) l[i]="";
            }
        }

        s="";
        for(i=0;i<l.length;i++)
        {
            if (l[i].equals("")) continue;
            s+=l[i]+"\n";
        }

        return s;
    }

}