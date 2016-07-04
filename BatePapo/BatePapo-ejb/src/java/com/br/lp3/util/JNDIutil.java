package com.br.lp3.util;

import java.util.Properties;
import javax.naming.NamingException;
import javax.naming.Context;
import javax.naming.InitialContext;

/**
 *
 * @author 1147106
 */
public class JNDIutil {
    public static Context getInitialContext() throws NamingException
    {
        Properties jndiProps = new Properties();
        
        jndiProps.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.enterprise.naming.SerialInitContextFactory");
        jndiProps.put(Context.PROVIDER_URL, "iiop://localhost:3920/");
        
        return new InitialContext(jndiProps);
    }
    
    public static Context getCORBAInitialContext() throws NamingException
    {
        Properties jndiProps = new Properties();
        
        jndiProps.put("java.naming.factory.initial","com.sun.enterprise.naming.SerialInitContextFactory");
        jndiProps.put("java.naming.factory.url.pkgs", "com.sun.enterprise.naming");
        jndiProps.put("java.naming.factory.state","com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
        jndiProps.put("org.omg.CORBA.ORBInitialHost", "25.2.152.29");
        jndiProps.put("org.omg.CORBA.ORBInitialPort", "3700");
     
        return new InitialContext(jndiProps);
    }
}
