package com.work;

import javax.swing.*;
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
        dialog.pack();
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
    }}
