using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace cnccompileGUI
{
    public partial class Form1 : Form
    {
        double X=0, Y=0;
        double XX=1, YY=1;

        public int getPointX(String x)
        {
            return Convert.ToInt32((Convert.ToDouble(x) + X) * XX);
        }
        public int getPointY(String y)
        {
            return Convert.ToInt32((Convert.ToDouble(y) + Y) * YY);
        }
        public Form1()
        {
            InitializeComponent();
        }

        private class SendCallback : ISendCallback
        {
            public void callback(String s)
            {
                Console.WriteLine(s);
            }
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            //string s = "";

            //s += "I 0 0 600 0101\n";
            //s += "L 3 0 3 10 1010 600 0.25 true\n";
            //s += "S 10\n";
            //s += "M 1 2 1 0.25 0.1\n";
            //s += "L 1 1 2 2\n";
            //s += "C 2 2 3 3 1 true\n";
            //s += "C 3 3 4 4 3 4 true\n";
            //s += "M\n";
            //s += "S";
            //Console.WriteLine(s);

            //Send send =new Send("127.0.0.1", 16666);
            //send.setCallback(new SendCallback());
            //send.start(s);
        }

        private void Button1_Click(object sender, EventArgs e)
        {
            String s;
            if (checkBox11.Checked) s = "true"; else s = "false";
            listBox1.Items.Add($"L {textBox11.Text} {textBox12.Text} {textBox13.Text} {textBox14.Text} {textBox15.Text} {textBox16.Text} {textBox17.Text} {s}");

            int x1, y1, x2, y2;
            x1 = getPointX(textBox11.Text);
            y1 = getPointX(textBox12.Text);
            x2 = getPointX(textBox13.Text);
            y2 = getPointX(textBox14.Text);
            Graphics g = pictureBox1.CreateGraphics();
            Pen p = new Pen(Color.Black, 1f);
            g.DrawLine(p, new Point(x1, y1), new Point(x2, y2));
        }

        private void Button2_Click(object sender, EventArgs e)
        {
            listBox1.Items.Add($"L {textBox11.Text} {textBox12.Text} {textBox13.Text} {textBox14.Text}");
            int x1, y1, x2, y2;
            x1 = getPointX(textBox11.Text);
            y1 = getPointX(textBox12.Text);
            x2 = getPointX(textBox13.Text);
            y2 = getPointX(textBox14.Text);
            Graphics g = pictureBox1.CreateGraphics();
            Pen p = new Pen(Color.Black, 1f);
            g.DrawLine(p, new Point(x1, y1), new Point(x2, y2));
        }

        private void Button6_Click(object sender, EventArgs e)
        {
            String s1, s2;
            if (checkBox31.Checked) s1 = "true"; else s1 = "false";
            if (checkBox32.Checked) s2 = "false"; else s2 = "true";
            listBox1.Items.Add($"D {textBox31.Text} {textBox32.Text} {textBox33.Text} {textBox34.Text} {textBox35.Text} {textBox36.Text} {s2} {textBox37.Text} {textBox38.Text} {textBox39.Text} {s1}");
            int x1, y1, x2, y2, x3, y3;
            x1 = getPointX(textBox31.Text);
            y1 = getPointX(textBox32.Text);
            x2 = getPointX(textBox33.Text);
            y2 = getPointX(textBox34.Text);
            x3 = getPointX(textBox35.Text);
            y3 = getPointX(textBox36.Text);
            Graphics g = pictureBox1.CreateGraphics();
            Pen p = new Pen(Color.Red, 1f);
            g.DrawArc(p, x1, y1, x2, y2, x3, y3);
        }

        private void Button4_Click(object sender, EventArgs e)
        {
            String s1, s2;
            if (checkBox21.Checked) s1 = "true"; else s1 = "false";
            if (checkBox22.Checked) s2 = "false"; else s2 = "true";
            listBox1.Items.Add($"C {textBox21.Text} {textBox22.Text} {textBox23.Text} {textBox24.Text} {textBox25.Text} {s2} {textBox26.Text} {textBox27.Text} {textBox28.Text} {s1}");
        }

        private void Button3_Click(object sender, EventArgs e)
        {
            String s2;
            if (checkBox22.Checked) s2 = "false"; else s2 = "true";
            listBox1.Items.Add($"C {textBox21.Text} {textBox22.Text} {textBox23.Text} {textBox24.Text} {textBox25.Text} {s2}");
        }

        private void Button5_Click(object sender, EventArgs e)
        {
            String s2;
            if (checkBox32.Checked) s2 = "false"; else s2 = "true";
            listBox1.Items.Add($"D {textBox31.Text} {textBox32.Text} {textBox33.Text} {textBox34.Text} {textBox35.Text} {textBox36.Text} {s2}");
        }

        private void Button8_Click(object sender, EventArgs e)
        {
            listBox1.Items.Add($"M {textBox1.Text} {textBox2.Text} {textBox3.Text} {textBox4.Text} {textBox5.Text}");
        }

        private void Button7_Click(object sender, EventArgs e)
        {
            listBox1.Items.Add("M");
        }

        private void Button11_Click(object sender, EventArgs e)
        {
            pictureBox1.Refresh();
        }

        private void Button12_Click(object sender, EventArgs e)
        {
            X = Convert.ToDouble(textBox101.Text);
            Y = Convert.ToDouble(textBox102.Text);
            XX = Convert.ToDouble(textBox103.Text);
            YY = Convert.ToDouble(textBox104.Text);
        }

        private void Button9_Click(object sender, EventArgs e)
        {
            for (int i = listBox1.SelectedItems.Count - 1; i >= 0; i--)
            {
                listBox1.Items.Remove(listBox1.SelectedItems[i]);
            }
        }

        private void Button10_Click(object sender, EventArgs e)
        {
            String s;
            s = "";
            s += $"I {textBox201.Text} {textBox202.Text} {textBox203.Text} {textBox204.Text}\n";
            for (int i = 0; i < listBox1.Items.Count; i++)
            {
                s += $"{listBox1.Items[i].ToString()}\n";
            }
            Console.WriteLine(s);
            Send send = new Send("127.0.0.1", 16666);
            send.setCallback(new SendCallback());
            send.start(s);
        }
    }
}
