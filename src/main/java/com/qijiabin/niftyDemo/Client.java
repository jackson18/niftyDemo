package com.qijiabin.niftyDemo;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

/**
 * ========================================================
 * 日 期：2016年6月24日 下午12:11:58
 * 作 者：qijiabin
 * 版 本：1.0.0
 * 类说明：
 * TODO
 * ========================================================
 * 修订日期     修订人    描述
 */
public class Client {  
  
    public static void main(String[] args) throws Exception {  
    	// 设置通道
        TTransport transport = new TSocket("localhost", 7790);  
        
        // 设置协议
        TProtocol protocol = new TBinaryProtocol(transport);  
        
        // 创建客户端
        HelloWorldService.Client client = new HelloWorldService.Client(protocol);  
        
        // 开启通道
        transport.open();  
        
        // 客户端调用
        System.out.println(client.sayHello("aa"));  
        
        //关闭通道
        transport.close();  
    }  
  
} 

