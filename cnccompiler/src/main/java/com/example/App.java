package com.example;

import com.example.cnccompiler.base.*;
import com.example.cnccompiler.element.DrawLine;
import com.example.cnccompiler.language.GClassLanguage;
import com.example.cnccompiler.program.Instructions;
import com.example.cnccompiler.program.MachiningGroup;
import com.example.cnccompiler.tools.OptimizeGCode;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // MachiningGroup s=new MachiningGroup(2,2,1,0.25,0.1);
        // Instructions ss=new Instructions();
        // s.add(new DrawLine(new PointXZ(1,2),new PointXZ(2,3)));
        // s.add(new DrawLine(new PointXZ(2,3),new PointXZ(6,7)));
        // // s.add(new DrawLine(new PointXZ(3,5),new PointXZ(6,7)));
        // ss.add(s);
        // System.out.println(OptimizeGCode.optimize(ss.toString()));

        // String s="";

        // s+="I 0 0 600 0101\n";
        // s+="L 3 0 3 10 1010 600 0.25 true\n";
        // s+="S 10\n";
        // s+="M 1 2 1 0.25 0.1\n";
        // s+="L 1 1 2 2\n";
        // s+="C 2 2 3 3 1 true\n";
        // s+="C 3 3 4 4 3 4 true\n";
        // s+="M\n";
        // s+="S";
        
        // System.out.println(GClassLanguage.getGCode(s));
        new CNCCompilerServer(16666).start();
    }
}
