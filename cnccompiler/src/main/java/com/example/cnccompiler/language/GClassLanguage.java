package com.example.cnccompiler.language;

import com.example.cnccompiler.base.PointXZ;
import com.example.cnccompiler.element.Conf;
import com.example.cnccompiler.element.DrawCircleIK;
import com.example.cnccompiler.element.DrawCircleR;
import com.example.cnccompiler.element.DrawLine;
import com.example.cnccompiler.element.StartUp;
import com.example.cnccompiler.program.Instructions;
import com.example.cnccompiler.program.MachiningGroup;
import com.example.cnccompiler.tools.OptimizeGCode;

/**
 * 将GClass语言编译为G代码
 */
public class GClassLanguage {

    public static DrawLine getL(String[] s)
    {
        //L X1 Z1 X2 Z2 T S F L
        //0 1  2  3  4  5 6 7 8
        Conf conf=new Conf();
        if (!s[5].equals("/")) conf.setKnife(s[5]);
        if (!s[6].equals("/")) conf.setSpinSpeed(Integer.parseInt(s[6]));
        if (!s[7].equals("/")) conf.setFeedSpeed(Double.parseDouble(s[7]));
        if (!s[8].equals("/")) conf.setLiquid(Boolean.parseBoolean(s[8]));
        return new DrawLine(new PointXZ(Double.parseDouble(s[1]), Double.parseDouble(s[2])), new PointXZ(Double.parseDouble(s[3]), Double.parseDouble(s[4])), conf);
    }

    public static DrawCircleR getC(String[] s)
    {
        //C X1 Z1 X2 Z2 R CW T S F L
        //0 1  2  3  4  5 6  7 8 9 10
        Conf conf=new Conf();
        if (!s[7].equals("/")) conf.setKnife(s[7]);
        if (!s[8].equals("/")) conf.setSpinSpeed(Integer.parseInt(s[8]));
        if (!s[9].equals("/")) conf.setFeedSpeed(Double.parseDouble(s[9]));
        if (!s[10].equals("/")) conf.setLiquid(Boolean.parseBoolean(s[10]));
        return new DrawCircleR(new PointXZ(Double.parseDouble(s[1]), Double.parseDouble(s[2])), new PointXZ(Double.parseDouble(s[3]), Double.parseDouble(s[4])), Double.parseDouble(s[5]), Boolean.parseBoolean(s[6]), conf);
    }

    public static DrawCircleIK getD(String[] s)
    {
        //D X1 Z1 X2 Z2 X3 Z3 CW T S F  L
        //0 1  2  3  4  5  6  7  8 9 10 11
        Conf conf=new Conf();
        if (!s[8].equals("/")) conf.setKnife(s[8]);
        if (!s[9].equals("/")) conf.setSpinSpeed(Integer.parseInt(s[9]));
        if (!s[10].equals("/")) conf.setFeedSpeed(Double.parseDouble(s[10]));
        if (!s[11].equals("/")) conf.setLiquid(Boolean.parseBoolean(s[11]));
        return new DrawCircleIK(new PointXZ(Double.parseDouble(s[1]), Double.parseDouble(s[2])), new PointXZ(Double.parseDouble(s[3]), Double.parseDouble(s[4])), new PointXZ(Double.parseDouble(s[5]), Double.parseDouble(s[6])), Boolean.parseBoolean(s[7]), conf);
    }

    public static DrawLine getML(String[] s)
    {
        //L X1 Z1 X2 Z2
        //0 1  2  3  4
        return new DrawLine(new PointXZ(Double.parseDouble(s[1]), Double.parseDouble(s[2])), new PointXZ(Double.parseDouble(s[3]), Double.parseDouble(s[4])));
    }

    public static DrawCircleR getMC(String[] s)
    {
        //C X1 Z1 X2 Z2 R CW
        //0 1  2  3  4  5 6
        return new DrawCircleR(new PointXZ(Double.parseDouble(s[1]), Double.parseDouble(s[2])), new PointXZ(Double.parseDouble(s[3]), Double.parseDouble(s[4])), Double.parseDouble(s[5]), Boolean.parseBoolean(s[6]));
    }

    public static DrawCircleIK getMD(String[] s)
    {
        //D X1 Z1 X2 Z2 X3 Z3 CW
        //0 1  2  3  4  5  6  7
        return new DrawCircleIK(new PointXZ(Double.parseDouble(s[1]), Double.parseDouble(s[2])), new PointXZ(Double.parseDouble(s[3]), Double.parseDouble(s[4])), new PointXZ(Double.parseDouble(s[5]), Double.parseDouble(s[6])), Boolean.parseBoolean(s[7]));
    }

    /**
     * 将GClass语言编译为G代码
     * 
     * @param x GClass语言源代码
     * @return 未优化的G代码
     */
    public static String getGCode(String x)
    {
        String[] order;
        String[] orderPart;
        int i;
        Instructions instructions=new Instructions();
        
        order=x.split("\n");

        for(i=0;i<order.length;i++)
        {
            orderPart=order[i].split(" ");

            if (orderPart[0].equals("I"))
            {
                instructions.add(new StartUp(Double.parseDouble(orderPart[1]), Double.parseDouble(orderPart[2]), Integer.parseInt(orderPart[3]), orderPart[4]));
            }

            if (orderPart[0].equals("L"))
            {
                instructions.add(getL(orderPart));
            }

            if (orderPart[0].equals("C"))
            {
                instructions.add(getC(orderPart));
            }

            if (orderPart[0].equals("D"))
            {
                instructions.add(getD(orderPart));
            }

            //M T L1 L2 F1 F2
            //0 1 2  3  4  5
            if (orderPart[0].equals("M"))
            {
                MachiningGroup mg=new MachiningGroup(Integer.parseInt(orderPart[1]), Double.parseDouble(orderPart[2]), Double.parseDouble(orderPart[3]), Double.parseDouble(orderPart[4]), Double.parseDouble(orderPart[5]));
                while(i+1<order.length && !order[i+1].substring(0, 1).equals("S"))
                {
                    i++;
                    orderPart=order[i].split(" ");
                    if (orderPart[0].equals("L"))
                    {
                        mg.add(getML(orderPart));
                    }        
                    if (orderPart[0].equals("C"))
                    {
                        mg.add(getMC(orderPart));
                    }        
                    if (orderPart[0].equals("D"))
                    {
                        mg.add(getMD(orderPart));
                    }
                }
                instructions.add(mg);
                i++;
            }

            //S TIME
            //0 1
            if (orderPart[0].equals("S"))
            {
                Instructions tmp=new Instructions(Integer.parseInt(orderPart[1]));
                while(i+1<order.length && !order[i+1].substring(0, 1).equals("S"))
                {
                    i++;
                    orderPart=order[i].split(" ");
                    if (orderPart[0].equals("L"))
                    {
                        tmp.add(getL(orderPart));
                    }
                    if (orderPart[0].equals("C"))
                    {
                        tmp.add(getC(orderPart));
                    }
                    if (orderPart[0].equals("D"))
                    {
                        tmp.add(getD(orderPart));
                    }
                    if (orderPart[0].equals("M"))
                    {
                        MachiningGroup mg=new MachiningGroup(Integer.parseInt(orderPart[1]), Double.parseDouble(orderPart[2]), Double.parseDouble(orderPart[3]), Double.parseDouble(orderPart[4]), Double.parseDouble(orderPart[5]));
                        while(i+1<order.length && !order[i+1].substring(0, 1).equals("S"))
                        {
                            i++;
                            orderPart=order[i].split(" ");
                            if (orderPart[0].equals("L"))
                            {
                                mg.add(getML(orderPart));
                            }        
                            if (orderPart[0].equals("C"))
                            {
                                mg.add(getMC(orderPart));
                            }        
                            if (orderPart[0].equals("D"))
                            {
                                mg.add(getMD(orderPart));
                            }
                        }
                        tmp.add(mg);
                        i++;
                    }
                }
                instructions.add(tmp);
                i++;
            }
        }

        return OptimizeGCode.optimize(instructions.toString());
    }
}