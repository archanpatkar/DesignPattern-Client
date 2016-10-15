package com.archanpatkar.Client;

import com.archanpatkar.Client.Utiliy.GUIUtility;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class LoginListener implements ActionListener {

    static private ParameterForLoginListener PARA_LOGIN_LISTENER = new ParameterForLoginListener();
    static private String VALIDATION_INFORMATION_FROM_SERVER = "";
    static private String CLIENT_NAME_FROM_SERVER = "";
    static private int HOW_MANY_TIMES_RETRY = 0;

    public LoginListener(ParameterForLoginListener CONSTRUCTER_INJECTION_PARA) {
        this.PARA_LOGIN_LISTENER.LOGIN_TEXT_FIELD = CONSTRUCTER_INJECTION_PARA.LOGIN_TEXT_FIELD;
        this.PARA_LOGIN_LISTENER.PASSWORD_TEXT_FIELD = CONSTRUCTER_INJECTION_PARA.PASSWORD_TEXT_FIELD;
        this.PARA_LOGIN_LISTENER.RETRY_LIMIT = CONSTRUCTER_INJECTION_PARA.RETRY_LIMIT;
        this.PARA_LOGIN_LISTENER.LOGIN_FRAME_FOR_CLIENT = CONSTRUCTER_INJECTION_PARA.LOGIN_FRAME_FOR_CLIENT;
        this.PARA_LOGIN_LISTENER.BLANK_STRING = CONSTRUCTER_INJECTION_PARA.BLANK_STRING;
        this.PARA_LOGIN_LISTENER.printWRITER = CONSTRUCTER_INJECTION_PARA.printWRITER;
        this.PARA_LOGIN_LISTENER.bufferedREADER = CONSTRUCTER_INJECTION_PARA.bufferedREADER;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        UPTakeSend();
        System.out.println("Valid recived||||> Valid = " + VALIDATION_INFORMATION_FROM_SERVER);
        String Check = afterUPTakeSend();
        if(Check == null && HOW_MANY_TIMES_RETRY < PARA_LOGIN_LISTENER.RETRY_LIMIT)
        {           
            System.out.println("Getting retries");
            HOW_MANY_TIMES_RETRY++;
            JOptionPane.showMessageDialog(PARA_LOGIN_LISTENER.LOGIN_FRAME_FOR_CLIENT,"This is Attempt " + HOW_MANY_TIMES_RETRY);
            PARA_LOGIN_LISTENER.LOGIN_TEXT_FIELD.setText("");
            PARA_LOGIN_LISTENER.PASSWORD_TEXT_FIELD.setText("");
        }
        
        if (HOW_MANY_TIMES_RETRY == 3)
        {
            JOptionPane.showMessageDialog(PARA_LOGIN_LISTENER.LOGIN_FRAME_FOR_CLIENT,"Tried 3 times but INVALID Username or Password");
            System.exit(HOW_MANY_TIMES_RETRY);
        }
        
    }

    void UPTakeSend() {
            String USERNAME_TO_BE_CHECKED = PARA_LOGIN_LISTENER.LOGIN_TEXT_FIELD.getText();
            String PASSWORD_TO_BE_CHECKED = new String(PARA_LOGIN_LISTENER.PASSWORD_TEXT_FIELD.getPassword());
            PARA_LOGIN_LISTENER.LOGIN_TEXT_FIELD.setText("");
            PARA_LOGIN_LISTENER.PASSWORD_TEXT_FIELD.setText("");
            PARA_LOGIN_LISTENER.printWRITER.println(USERNAME_TO_BE_CHECKED);
            PARA_LOGIN_LISTENER.printWRITER.println(PASSWORD_TO_BE_CHECKED);
            try {
                System.out.println("Waiting for true or false");
                VALIDATION_INFORMATION_FROM_SERVER = PARA_LOGIN_LISTENER.bufferedREADER.readLine();
                CLIENT_NAME_FROM_SERVER = PARA_LOGIN_LISTENER.bufferedREADER.readLine();
            } catch (Exception SERVER_NOT_RESPONDING) {
                System.out.println("Server Not Responding Error");
                System.exit(100);
            }
    }

    String afterUPTakeSend() {
        if (VALIDATION_INFORMATION_FROM_SERVER.equals("true")) {
            System.out.println(CLIENT_NAME_FROM_SERVER);
            PARA_LOGIN_LISTENER.LOGIN_FRAME_FOR_CLIENT.setVisible(false);
            ChatClientListener.setAdvertise(GUIUtility.ClientGUIPrinter(PARA_LOGIN_LISTENER.printWRITER, CLIENT_NAME_FROM_SERVER));
            return "yes";
            //PARA_LOGIN_LISTENER.printWRITER.println("yes");
           }
        return null;
    }

}
