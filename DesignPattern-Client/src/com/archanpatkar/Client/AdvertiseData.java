package com.archanpatkar.Client;

import java.util.HashMap;


public class AdvertiseData {
    static HashMap<String,String> AdData = new HashMap<>();
    
    public static void putAdData(String Word,String Ad)
    {
         AdvertiseData.AdData.put(Word,Ad);
    }
}
