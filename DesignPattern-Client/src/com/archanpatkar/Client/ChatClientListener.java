package com.archanpatkar.Client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClientListener implements ActionListener {

    JTextArea ta;
    JTextField tf;
    PrintWriter pw;
    JFrame f1;
    static JLabel Advertise;
    private static String LastAD="";

    public ChatClientListener(JTextArea ta, JTextField tf, PrintWriter pw, JFrame f1) {
        this.ta = ta;
        this.tf = tf;
        this.pw = pw;
        this.f1 = f1;
    }

    public static void setAdvertise(JLabel AD) {
        Advertise = AD;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str = tf.getText();
        Advertise.setText(LastAD);
        String str2 = AdvertiseData.AdData.get(str);
        try {
            if (str2 != null) {
                System.out.println("str2 = " + str2);
                LastAD = str2;
                System.out.println("LastAD" + LastAD);
                Advertise.setText(LastAD);
                System.out.println("getting text" + Advertise.getText());
                f1.repaint();
            }
        } catch (Exception EX) {
            System.out.println("str =" + str);
            System.out.println("Not a the word from add");
        }
        tf.setText("");
        ta.append(str + "\n");
        pw.println(str);
        if (str.equals("End")) {
            f1.setVisible(false);
            System.exit(0);
        }
    }

}
