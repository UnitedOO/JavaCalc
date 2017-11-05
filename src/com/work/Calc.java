package com.work;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Calc extends JDialog {
    private JPanel contentPane;
    private JButton btn0;
    private JButton btn1;
    private JButton btn2;
    private JButton btn3;
    private JButton op_plus;
    private JButton op_minus;
    private JButton btn4;
    private JButton btn5;
    private JButton btn6;
    private JButton op_mul;
    private JButton btn7;
    private JButton btn8;
    private JButton btn9;
    private JButton op_div;
    private JButton btn_equal;
    private JTextField txtres;

    private boolean last_number = false;
    private Calculator calc = new Calculator();

    public Calc() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(btn_equal);

        btn0.addActionListener(this::actionPerformedNumber);
        btn1.addActionListener(this::actionPerformedNumber);
        btn2.addActionListener(this::actionPerformedNumber);
        btn3.addActionListener(this::actionPerformedNumber);
        btn4.addActionListener(this::actionPerformedNumber);
        btn5.addActionListener(this::actionPerformedNumber);
        btn6.addActionListener(this::actionPerformedNumber);
        btn7.addActionListener(this::actionPerformedNumber);
        btn8.addActionListener(this::actionPerformedNumber);
        btn9.addActionListener(this::actionPerformedNumber);

        op_div.addActionListener(this::actionPerformedOp);
        op_minus.addActionListener(this::actionPerformedOp);
        op_mul.addActionListener(this::actionPerformedOp);
        op_plus.addActionListener(this::actionPerformedOp);

        btn_equal.addActionListener(this::actionPerformedEq);
    }

    public static void main(String[] args) {
        Calc dialog = new Calc();
        dialog.setBounds(0,0,450,280);
        dialog.setVisible(true);
        System.exit(0);
    }

    public void actionPerformedNumber(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        if (last_number)
            txtres.setText(txtres.getText() + button.getText());
        else
            txtres.setText(button.getText());

        last_number = true;
    }

    public void actionPerformedOp(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        char op = button.getText().charAt(0);
        calc.calculate(Integer.parseInt(txtres.getText()));
        calc.set_last_operator(op);
        last_number = false;
    }

    public void actionPerformedEq(ActionEvent e) {
        calc.calculate(Integer.parseInt(txtres.getText()));
        txtres.setText("" + calc.get_result());
        last_number = false;
    }

    {
        setupUI();
    }

    private void setupUI() {
        contentPane = new JPanel();
        contentPane.setLayout(null);
        contentPane.setBounds(0, 0, 500, 500);
        contentPane.setEnabled(true);
        btn0 = new JButton();
        btn0.setText("0");
        contentPane.add(btn0);
        btn0.setBounds(10, 200, 80, 30);
        btn1 = new JButton();
        btn1.setText("1");
        contentPane.add(btn1);
        btn1.setBounds(10, 170, 80, 30);
        btn2 = new JButton();
        btn2.setText("2");
        contentPane.add(btn2);
        btn2.setBounds(90, 170, 80, 30);
        btn3 = new JButton();
        btn3.setText("3");
        contentPane.add(btn3);
        btn3.setBounds(170, 170, 80, 30);
        op_plus = new JButton();
        op_plus.setText("+");
        contentPane.add(op_plus);
        op_plus.setBounds(250, 200, 80, 30);
        op_minus = new JButton();
        op_minus.setText("-");
        contentPane.add(op_minus);
        op_minus.setBounds(250, 170, 80, 30);
        btn4 = new JButton();
        btn4.setText("4");
        contentPane.add(btn4);
        btn4.setBounds(10, 140, 80, 30);
        btn5 = new JButton();
        btn5.setText("5");
        contentPane.add(btn5);
        btn5.setBounds(90, 140, 80, 30);
        btn6 = new JButton();
        btn6.setText("6");
        contentPane.add(btn6);
        btn6.setBounds(170, 140, 80, 30);
        op_mul = new JButton();
        op_mul.setText("*");
        contentPane.add(op_mul);
        op_mul.setBounds(250, 140, 80, 30);
        btn7 = new JButton();
        btn7.setEnabled(true);
        btn7.setText("7");
        contentPane.add(btn7);
        btn7.setBounds(10, 110, 80, 30);
        btn8 = new JButton();
        btn8.setEnabled(true);
        btn8.setText("8");
        contentPane.add(btn8);
        btn8.setBounds(90, 110, 80, 30);
        btn9 = new JButton();
        btn9.setEnabled(true);
        btn9.setText("9");
        contentPane.add(btn9);
        btn9.setBounds(170, 110, 80, 30);
        op_div = new JButton();
        op_div.setEnabled(true);
        op_div.setText("/");
        contentPane.add(op_div);
        op_div.setBounds(250, 110, 80, 30);
        btn_equal = new JButton();
        btn_equal.setText("=");
        contentPane.add(btn_equal);
        btn_equal.setBounds(330, 110, 80, 120);
        txtres = new JTextField();
        contentPane.add(txtres);
        txtres.setBounds(10, 40, 400, 60);
    }
}
