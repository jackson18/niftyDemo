package com.qijiabin.niftyDemo;

import org.apache.thrift.TProcessor;

import com.facebook.nifty.core.NettyServerTransport;
import com.facebook.nifty.core.ThriftServerDef;
import com.facebook.nifty.core.ThriftServerDefBuilder;

/**
 * ========================================================
 * 日 期：2016年6月24日 下午12:11:02
 * 作 者：qijiabin
 * 版 本：1.0.0
 * 类说明：
 * TODO
 * ========================================================
 * 修订日期     修订人    描述
 */
public class Server {

	public static void main(String[] args) {
		// 设置处理器
		TProcessor processor = new HelloWorldService.Processor<HelloWorldService.Iface>(new HelloWorldImpl());

		// 设置服务器配置
		ThriftServerDef serverDef = new ThriftServerDefBuilder().listen(7790).withProcessor(processor).build();

		// 设置服务器通道
		final NettyServerTransport server = new NettyServerTransport(serverDef);
		
		// 开启服务
		server.start();

		// 安排在关机时停止服务器
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				try {
					server.stop();
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			}
		});

		System.out.println("服务器启动成功...");
	}

}

