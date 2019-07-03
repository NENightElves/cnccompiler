using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Net.Sockets;
using System.Threading;
using System.Threading.Tasks;

namespace cnccompileGUI
{
    public interface ISendCallback
    {
         void callback(String s);
    }
    class Send
    {
        private int port { get; set; }
        private string ip { get; set; }
        private ISendCallback callback;


        public void setCallback(ISendCallback i)
        {
            callback = i;
        }

        public Send(string s, int x)
        {
            ip = s;
            port = x;
        }

        public void start(String s)
        {
            Socket socket = new Socket(AddressFamily.InterNetwork, SocketType.Stream, ProtocolType.Tcp);
            socket.Connect(ip, port);
            Console.WriteLine("connected");
            byte[] by = Encoding.Default.GetBytes(s);
            new Thread(() =>
            {
                socket.Send(by);
                byte[] bby = new byte[65535];
                int len = socket.Receive(bby);
                callback.callback(Encoding.Default.GetString(bby, 0, len));
                socket.Close();
            }).Start();
        }
    }
}
