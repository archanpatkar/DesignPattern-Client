package com.archanpatkar.Client;

import java.io.BufferedReader;
import java.io.PrintWriter;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ParameterForLoginListener {
    public JFrame LOGIN_FRAME_FOR_CLIENT;
    public JLabel BLANK_STRING;
    public JLabel ADVERTISE;
    public JTextField LOGIN_TEXT_FIELD;
    public JPasswordField PASSWORD_TEXT_FIELD;
    public PrintWriter printWRITER;
    public BufferedReader bufferedREADER;
    public int RETRY_LIMIT = 0;
}
