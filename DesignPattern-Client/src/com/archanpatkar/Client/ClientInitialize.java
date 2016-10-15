package com.archanpatkar.Client;

import com.archanpatkar.Client.Utiliy.AdUtility;
import com.archanpatkar.Client.Utiliy.GUIUtility;
import com.archanpatkar.Client.Utiliy.NetworkingUtility;
import java.io.IOException;


public class ClientInitialize 
{
    static void Initialze() throws IOException
    {
        
        GUIUtility.LoginGUIPrinterAndAssembler(NetworkingUtility.Initialize()); 
        AdUtility.Initialize();
    }
}