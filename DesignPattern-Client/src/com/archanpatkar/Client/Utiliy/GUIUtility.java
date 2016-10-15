package com.archanpatkar.Client.Utiliy;

import com.archanpatkar.Client.ChatClientListener;
import com.archanpatkar.Client.LoginListener;
import com.archanpatkar.Client.NODependancies;
import com.archanpatkar.Client.NetworkObjects;
import com.archanpatkar.Client.ParameterForLoginListener;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.PrintWriter;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUIUtility {
    

    public static void LoginGUIPrinterAndAssembler(NetworkObjects NO) {
        final JFrame LOGIN_FRAME_FOR_CLIENT = new JFrame("Login");
        LOGIN_FRAME_FOR_CLIENT.setSize(300, 300);
        LOGIN_FRAME_FOR_CLIENT.setResizable(false);
        final JPanel MAIN_LABEL = new JPanel();
        final GridBagLayout GRID_BAG_LAYOUT_FOR_LOGIN = new GridBagLayout();
        MAIN_LABEL.setLayout(GRID_BAG_LAYOUT_FOR_LOGIN);
        final GridBagConstraints GRID_BAG_CONSTRAINTS_FOR_LOGIN = new GridBagConstraints();
        final JPanel USERNAME_PANEL = new JPanel();
        final JPanel PASSWORD_PANEL = new JPanel();
        final JPanel LOGIN_PANEL = new JPanel();
        final JButton LOGIN_BUTTON = new JButton("Login");
        final JLabel USERNAME_TEXT_LABEL = new JLabel("Username");
        final JLabel BLANK_STRING = new JLabel("");
        final JTextField USERNAME_TEXT_FIELD = new JTextField(15);
        final JLabel PASSWORD_TEXT_LABEL = new JLabel("Password");
        final JPasswordField PASSWORD_TEXT_FIELD = new JPasswordField(15);
        USERNAME_PANEL.add(USERNAME_TEXT_LABEL);
        USERNAME_PANEL.add(USERNAME_TEXT_FIELD);
        PASSWORD_PANEL.add(PASSWORD_TEXT_LABEL);
        PASSWORD_PANEL.add(PASSWORD_TEXT_FIELD);
        LOGIN_PANEL.add(LOGIN_BUTTON);
        GRID_BAG_CONSTRAINTS_FOR_LOGIN.gridx = 0;
        GRID_BAG_CONSTRAINTS_FOR_LOGIN.gridy = 0;
        MAIN_LABEL.add(USERNAME_PANEL, GRID_BAG_CONSTRAINTS_FOR_LOGIN);
        GRID_BAG_CONSTRAINTS_FOR_LOGIN.gridx = 0;
        GRID_BAG_CONSTRAINTS_FOR_LOGIN.gridy = 1;
        MAIN_LABEL.add(PASSWORD_PANEL, GRID_BAG_CONSTRAINTS_FOR_LOGIN);
        GRID_BAG_CONSTRAINTS_FOR_LOGIN.gridx = 0;
        GRID_BAG_CONSTRAINTS_FOR_LOGIN.gridy = 2;
        MAIN_LABEL.add(LOGIN_PANEL, GRID_BAG_CONSTRAINTS_FOR_LOGIN);
        ParameterForLoginListener CONSTRUCT_INJECTION_PARA = new ParameterForLoginListener();
        CONSTRUCT_INJECTION_PARA.LOGIN_TEXT_FIELD = USERNAME_TEXT_FIELD;
        CONSTRUCT_INJECTION_PARA.PASSWORD_TEXT_FIELD = PASSWORD_TEXT_FIELD;
        CONSTRUCT_INJECTION_PARA.RETRY_LIMIT = 3;
        CONSTRUCT_INJECTION_PARA.LOGIN_FRAME_FOR_CLIENT = LOGIN_FRAME_FOR_CLIENT;
        CONSTRUCT_INJECTION_PARA.BLANK_STRING = BLANK_STRING;
        CONSTRUCT_INJECTION_PARA.printWRITER = NO.NETWORK_printWRITER_SERIES;
        CONSTRUCT_INJECTION_PARA.bufferedREADER = NO.NETWORK_bufferedREADER_SERIES;
        LoginListener LISTENER_FOR_BUTTON = new LoginListener(CONSTRUCT_INJECTION_PARA);
        LOGIN_BUTTON.addActionListener(LISTENER_FOR_BUTTON);
        PASSWORD_TEXT_FIELD.addActionListener(LISTENER_FOR_BUTTON);
        LOGIN_FRAME_FOR_CLIENT.add(MAIN_LABEL);
        LOGIN_FRAME_FOR_CLIENT.setVisible(true);
        LOGIN_FRAME_FOR_CLIENT.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static JLabel ClientGUIPrinter(PrintWriter pw,String FrameName)
    {
        System.out.println("Client says connection established");
        final JFrame CHAT_FRAME_FOR_CLIENT = new JFrame(FrameName+"'s" + "  Chat");
        final JTextArea TEXT_AREA = new JTextArea();
        final JPanel ASSEMBLE_TA_DT = new JPanel();
        final JTextField DATA_TAKER = new JTextField(20);
        final JButton DATA_SENDER = new JButton("Send");
        final JLabel ADVERTISE = new JLabel("");
        ASSEMBLE_TA_DT.add(DATA_TAKER);
        ASSEMBLE_TA_DT.add(DATA_SENDER);
        ASSEMBLE_TA_DT.add(ADVERTISE);
        CHAT_FRAME_FOR_CLIENT.add(TEXT_AREA);
        CHAT_FRAME_FOR_CLIENT.add(ASSEMBLE_TA_DT, BorderLayout.SOUTH);
        final ChatClientListener LISTENER_FOR_BUTTON_AND_DT = new ChatClientListener(TEXT_AREA, DATA_TAKER, pw, CHAT_FRAME_FOR_CLIENT);
        DATA_SENDER.addActionListener(LISTENER_FOR_BUTTON_AND_DT);
        DATA_TAKER.addActionListener(LISTENER_FOR_BUTTON_AND_DT);
        CHAT_FRAME_FOR_CLIENT.setSize(800,800);
        CHAT_FRAME_FOR_CLIENT.setVisible(true);
        CHAT_FRAME_FOR_CLIENT.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return ADVERTISE;
    }
   
    public static NODependancies GetIPnPortsendtoNO()
    {  
        return NetworkingUtility.NODepend( JOptionPane.showInputDialog("Enter IP"),Integer.parseInt(JOptionPane.showInputDialog("Enter port")));
    }
    
}
