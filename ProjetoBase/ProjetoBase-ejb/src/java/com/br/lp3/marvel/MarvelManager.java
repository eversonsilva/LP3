/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.marvel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;

/**
 *
 * @author cacique
 */
@Stateless
public class MarvelManager {
    
    private static String apikey = "5285f3834df822534300603fb75c0a67";
    private static String urlbase = "http://gateway.marvel.com:80/v1/public/characters";
    private static String privatekey = "4425fbc655a1d9f54856e1dddd522fb793abc9aa";
    
    public static List<MarvelCharacter> searchCharacter(String name){
        List<MarvelCharacter> lista = new ArrayList<>();
        
        //Criação de um timestamp
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyyhhmmss");
        String ts = sdf.format(date);
        
        //Criação do HASH
        String hashStr = MD5( ts+privatekey+apikey );
        String uri;
        
        //url de consulta
        uri = urlbase + "?nameStartsWith=" + name + "&ts=" + ts + "&apikey=" + apikey + "&hash=" + hashStr +"&limit=100";
        URL url;
        try {
            url = new URL(uri);
            
            //Conexão HTTP
            //Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("172.16.0.10", 3128));
            //HttpURLConnection conn = (HttpURLConnection) url.openConnection(proxy);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            
            //Leitura dos dados vindos do pedido
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            
            //Criação de uma String com o resultado
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = rd.readLine()) != null) {
              sb.append(line);
            }
            rd.close();

            //Fechamento da conexão
            conn.disconnect();
            
            //Criação da lista de Personagens
            lista = MarvelCharacterJSONParser.parseFeed(sb.toString());
            
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(MarvelManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MarvelManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    /**
     * Método para criptografia de uma String com método MD5
     * @param md5
     * @return 
     */
    public static String MD5(String md5) {
        try {
             java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
             byte[] array = md.digest(md5.getBytes());
             StringBuffer sb = new StringBuffer();
             for (int i = 0; i < array.length; ++i) {
               sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
            }
             return sb.toString();
         } catch (java.security.NoSuchAlgorithmException e) {
         }
         return null;
    }
    
}
