package com.algorithm.drill.day6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * Java版计算器
 *
 * @author Luo
 */
@SuppressWarnings("serial")
public class Calculator extends JFrame {

    final int WIN_W = 250, WIN_H = 250;
    JPanel myPanel, panelSuper;

    public Calculator() {

        // 主面板
        panelSuper = new JPanel();
        panelSuper.setLayout(null);

        // 设置窗口位置
        double width = Toolkit.getDefaultToolkit().getScreenSize().width;
        double height = Toolkit.getDefaultToolkit().getScreenSize().height;
        this.setBounds((int) (width - WIN_W) / 2, (int) (height - WIN_H) / 2, WIN_W, WIN_H);

        // 窗口配置
        this.setTitle("java版计算器");
        this.validate();
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // 添加计算器按钮面板
        myPanel = new MyPanel();
        this.add(myPanel, BorderLayout.CENTER);

    }

    public static void main(String[] args) {
        new Calculator();
    }

    /**
     * 计算器按钮面板类
     */
    class MyPanel extends JPanel implements ActionListener {
        JButton button1, button2, button3, button4, button5, button6, button7,
                button8, button9, button0, buttonJia, buttonJian, buttonCheng,
                buttonChu, buttonDeng, buttonDian, buttonC, buttonDel,
                buttonZF, buttonGH;
        JTextField jTextField; // 计算器显示屏
        char oper; // 操作符
        String key, allKey = "1234567890.±del", jjccKey = "+-*/";
        BigDecimal d1, d2;
        boolean first;

        public MyPanel() {

            // 设置布局
            this.setLayout(new FlowLayout(FlowLayout.LEFT, 4, 5));

            // 计算器显示屏
            jTextField = new JTextField(21);
            jTextField.setHorizontalAlignment(JTextField.RIGHT);
            jTextField.setEditable(false);
            jTextField.setBackground(new Color(255, 255, 255));
            jTextField.setText("0");
            this.add(jTextField);

            // 计算器按钮
            button1 = new JButton("1");
            button2 = new JButton("2");
            button3 = new JButton("3");
            button4 = new JButton("4");
            button5 = new JButton("5");
            button6 = new JButton("6");
            button7 = new JButton("7");
            button8 = new JButton("8");
            button9 = new JButton("9");
            button0 = new JButton("0");
            buttonJia = new JButton("+");
            buttonJian = new JButton("-");
            buttonCheng = new JButton("*");
            buttonChu = new JButton("/");
            buttonDeng = new JButton("=");
            buttonDian = new JButton(".");
            buttonDel = new JButton("del");
            buttonC = new JButton("c");
            buttonZF = new JButton("±");
            buttonGH = new JButton("√");
            button1.setPreferredSize(new Dimension(55, 30));
            button2.setPreferredSize(new Dimension(55, 30));
            button3.setPreferredSize(new Dimension(55, 30));
            button4.setPreferredSize(new Dimension(55, 30));
            button5.setPreferredSize(new Dimension(55, 30));
            button6.setPreferredSize(new Dimension(55, 30));
            button7.setPreferredSize(new Dimension(55, 30));
            button8.setPreferredSize(new Dimension(55, 30));
            button9.setPreferredSize(new Dimension(55, 30));
            button0.setPreferredSize(new Dimension(55, 30));
            buttonJia.setPreferredSize(new Dimension(55, 30));
            buttonJian.setPreferredSize(new Dimension(55, 30));
            buttonCheng.setPreferredSize(new Dimension(55, 30));
            buttonChu.setPreferredSize(new Dimension(55, 30));
            buttonDeng.setPreferredSize(new Dimension(55, 30));
            buttonDian.setPreferredSize(new Dimension(55, 30));
            buttonDel.setPreferredSize(new Dimension(55, 30));
            buttonC.setPreferredSize(new Dimension(55, 30));
            buttonZF.setPreferredSize(new Dimension(55, 30));
            buttonGH.setPreferredSize(new Dimension(55, 30));
            this.add(buttonDel);
            this.add(buttonC);
            this.add(buttonZF);
            this.add(buttonGH);
            this.add(button1);
            this.add(button2);
            this.add(button3);
            this.add(buttonJia);
            this.add(button4);
            this.add(button5);
            this.add(button6);
            this.add(buttonJian);
            this.add(button7);
            this.add(button8);
            this.add(button9);
            this.add(buttonCheng);
            this.add(button0);
            this.add(buttonDian);
            this.add(buttonDeng);
            this.add(buttonChu);
            buttonDel.addActionListener(this);
            buttonC.addActionListener(this);
            buttonZF.addActionListener(this);
            buttonGH.addActionListener(this);
            button1.addActionListener(this);
            button2.addActionListener(this);
            button3.addActionListener(this);
            button4.addActionListener(this);
            button5.addActionListener(this);
            button6.addActionListener(this);
            button7.addActionListener(this);
            button8.addActionListener(this);
            button9.addActionListener(this);
            button0.addActionListener(this);
            buttonJia.addActionListener(this);
            buttonJian.addActionListener(this);
            buttonCheng.addActionListener(this);
            buttonChu.addActionListener(this);
            buttonDeng.addActionListener(this);
            buttonDian.addActionListener(this);

            // 计算器初始化
            init();
        }

        /**
         * 计算器初始化
         */
        public void init() {
            d1 = new BigDecimal("0");
            d1 = new BigDecimal("0");
            key = "=";
            oper = '=';
            jTextField.setText("0");
            first = true; // 用于标记是否进行连续操作（例如按键顺序为“9*9====”，第一次等于first由true变为false，如果!first，按等号相当于用上一次的结果与第二个操作数相乘）
        }

        /**
         * 按钮监听
         */
        public void actionPerformed(ActionEvent e) {
            JButton b = (JButton) e.getSource();
            if (b == buttonDian) { // 按下.

                jTextField.setText(jTextField.getText() + ".");
                if (first) {
                    d2 = d1 = getNum();
                } else {
                    d2 = getNum();
                }
            } else if (b == buttonZF) {// 按下±
                BigDecimal d = getNum();
                d = new BigDecimal("0").subtract(d);
                setFormatNum(d);
                if (first) {
                    d2 = d1 = getNum();
                } else {
                    d2 = getNum();
                }
            } else if (b == buttonDel) {// 按下del
                if (jTextField.getText().length() == 1
                        || jTextField.getText().length() == 2
                        && jTextField.getText().startsWith("-")) {
                    jTextField.setText("0");

                } else {
                    String s = jTextField.getText();
                    s = s.substring(0, s.length() - 1);
                    if (s.endsWith("E+") || s.endsWith("E-"))
                        s = s.substring(0, s.length() - 2);
                    jTextField.setText(s);
                    if (first) {
                        d2 = d1 = getNum();
                    } else {
                        d2 = getNum();
                    }
                }
            } else if (b == buttonC) {// 按下c
                init();
            } else if (b == buttonJia) {// 按下+
                BigDecimal s;
                if (!first && allKey.indexOf(key) >= 0) {
                    if (oper == '-' || oper == '/') {
                        s = operate(d1, oper, d2);
                    } else {
                        s = operate(d2, oper, d1);
                    }
                    setFormatNum(s);
                }// 如果不是第一次，且上一次操作是对数字进行操作
                else {

                    first = false;
                }
                d2 = d1 = getNum();
                // System.out.print("111我执行啦\n");
                oper = '+';
            } else if (b == buttonJian) {// 按下-
                BigDecimal s;
                if (!first && allKey.indexOf(key) >= 0) {
                    s = operate(d1, oper, d2);
                    setFormatNum(s);
                }// 如果不是第一次，且上一次操作是对数字进行操作
                else {
                    first = false;
                }
                d2 = d1 = getNum();
                oper = '-';
            } else if (b == buttonCheng) {// 按下*
                BigDecimal s;
                if (!first && allKey.indexOf(key) >= 0) {
                    if (oper == '-' || oper == '/') {
                        s = operate(d1, oper, d2);
                    } else {
                        s = operate(d2, oper, d1);
                    }
                    setFormatNum(s);
                }// 如果不是第一次，且上一次操作是对数字进行操作
                else {
                    first = false;
                }
                d2 = d1 = getNum();
                oper = '*';
            } else if (b == buttonChu) {// 按下/
                BigDecimal s;
                if (!first && allKey.indexOf(key) >= 0) {
                    s = operate(d1, oper, d2);
                    setFormatNum(s);
                }// 如果不是第一次，且上一次操作是对数字进行操作
                else {
                    first = false;
                }
                d2 = d1 = getNum();
                oper = '/';
            } else if (b == buttonGH) {// 按下平方根
                if (jTextField.getText().startsWith("-")) {
                    init();
                    return;
                }
                BigDecimal d = getNum();
                MathContext mc = new MathContext(10, RoundingMode.HALF_DOWN);
                d = new BigDecimal(Math.sqrt(d.doubleValue()), mc);
                setFormatNum(d);
                if (first) {
                    d2 = d1 = getNum();
                } else {
                    d2 = getNum();
                }
            } else if (b == buttonDeng) {// 按下=
                BigDecimal s = null;
                d2 = getNum();
                if (!key.equals("=")) {
                    s = operate(d1, oper, d2);
                } else {
                    s = operate(d2, oper, d1);
                }
                if (oper != '=' && !key.equals("=")) {// 上一次操作为 +-*/
                    d1 = getNum();

                }
                setFormatNum(s);
                first = true;
            } else { // 按下其他按钮
                if (this.jTextField.getText().equals("0")
                        || allKey.indexOf(key) == -1) {
                    this.jTextField.setText(b.getText());
                } else {
                    this.jTextField.setText(jTextField.getText() + b.getText());
                }
                if (first) {
                    d2 = d1 = getNum();
                } else {
                    d2 = getNum();
                }// d2作被加数:d2+d1
            }
            key = b.getText();
        }

        /**
         * 获取操作数
         *
         * @return 操作数
         */
        public BigDecimal getNum() {
            BigDecimal d = new BigDecimal(jTextField.getText());
            return d;
        }

        public void setFormatNum(BigDecimal dd) {
            MathContext mc = new MathContext(18, RoundingMode.HALF_DOWN);

            BigDecimal d = new BigDecimal(dd.toString(), mc);
            String num = d.toString();
            if (num.endsWith(".0"))
                num = num.replaceAll("\\.0", "");
            this.jTextField.setText(num);
        }

        /**
         * 计算
         *
         * @param a1 操作数1
         * @param c  操作符
         * @param a2 操作数2
         * @return
         */
        public BigDecimal operate(BigDecimal a1, char c, BigDecimal a2) {
            MathContext mc = new MathContext(10, RoundingMode.HALF_DOWN);
            switch (c) {
                case '+':
                    return a1.add(a2);
                case '-':
                    return a1.subtract(a2);
                case '*':
                    return a1.multiply(a2);
                case '/':
                    if (a2.compareTo(new BigDecimal("0")) == 0) {
                        init();
                        return new BigDecimal("0");
                    }
                    return a1.divide(a2, mc);
                default:
                    return a2;
            }
        }
    }
}
