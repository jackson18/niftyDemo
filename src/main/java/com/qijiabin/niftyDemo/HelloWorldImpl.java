package com.qijiabin.niftyDemo;
 
import org.apache.thrift.TException;
 
public class HelloWorldImpl implements HelloWorldService.Iface {
 
    public HelloWorldImpl() {
    }
 
    @Override
    public String sayHello(String username) throws TException {
        return "hello, " + username;
    }
 
}