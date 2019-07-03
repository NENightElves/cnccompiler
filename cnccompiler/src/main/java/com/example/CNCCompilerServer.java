package com.example;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.example.cnccompiler.language.GClassLanguage;



/**
 * G代码编译服务器
 */
public class CNCCompilerServer {

    private int port;

    public CNCCompilerServer(int port)
    {
        this.port=port;
    }

    /**
     * 开启服务器
     */
    public void start()
    {
        ServerSocket serverSocket;
        Socket socket;
        InputStream in;
        OutputStream out;
        byte[] b=new byte[65535];
        int len;
        String tmp;
        try
        {
            serverSocket=new ServerSocket(port);
            System.out.println("server start");
            while(true)
            {
                socket=serverSocket.accept();
                in=socket.getInputStream();
                out=socket.getOutputStream();
                len=in.read(b);
                if (len<1) continue;
                String s=new String(b,0,len);
                System.out.println(s);
                tmp=GClassLanguage.getGCode(s);
                out.write(tmp.getBytes());
                out.flush();
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

    }

}