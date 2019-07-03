package com.example.cnccompiler.tools;

import java.text.DecimalFormat;

/**
 * 单例，格式化小数
 */
public class DecimaFormatHundredth {

    private static DecimalFormat df=new DecimalFormat("#.##");

    public static String format(double n)
    {
        return df.format(n);
    }

}