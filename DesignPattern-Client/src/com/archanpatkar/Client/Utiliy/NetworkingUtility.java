
package com.archanpatkar.Client.Utiliy;

import com.archanpatkar.Client.NODependancies;
import com.archanpatkar.Client.NetworkObjects;
import com.archanpatkar.Client.NetworkingObjectsFactory;
import java.io.IOException;


public class NetworkingUtility {
     public static NODependancies NODepend(String IP,int port) {
        NODependancies NOD = new NODependancies();
        NOD.IP = IP;
        NOD.port = port;
        return NOD;
    }
    
    public static NetworkObjects Initialize() throws IOException
    {
        NetworkObjects NO = NetworkingObjectsFactory.getNetworkObject();
        NODependancies NOD = GUIUtility.GetIPnPortsendtoNO();
        NO.NETWORK_SOCKET = NetworkingObjectsFactory.getNetworkObjectSocket(NOD.IP, NOD.port);
        NO.NETWORK_bufferedREADER_SERIES = NetworkingObjectsFactory.getNetworkObjectReaders(NO.NETWORK_SOCKET);
        NO.NETWORK_printWRITER_SERIES = NetworkingObjectsFactory.getNetworkObjectWriters(NO.NETWORK_SOCKET);
        return NO;
    }
}
