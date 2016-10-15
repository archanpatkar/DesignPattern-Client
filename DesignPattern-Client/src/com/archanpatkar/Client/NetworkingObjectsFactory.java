package com.archanpatkar.Client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class NetworkingObjectsFactory {
    
    public static NetworkObjects getNetworkObject()
    {
        return new NetworkObjects();
    }
    
   public static Socket getNetworkObjectSocket(String ip,int port) throws IOException
   {
      return new Socket(ip,port);   
   }
   
   public static PrintWriter getNetworkObjectWriters(Socket soc) throws IOException
   {
       return new PrintWriter(new BufferedWriter(new OutputStreamWriter(soc.getOutputStream())), true);
   }
   
   public static BufferedReader getNetworkObjectReaders(Socket soc) throws IOException
   {
       return new BufferedReader(new InputStreamReader(soc.getInputStream()));
   }
}
