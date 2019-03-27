package com.example.demo.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

@ServerEndpoint(value = "/hello")
@Component
public class MyWebSocket {
	//静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
	private static int onlineCount = 0;

	//concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。
	public static CopyOnWriteArraySet<MyWebSocket> webSocketSet = new CopyOnWriteArraySet<MyWebSocket>();

	//与某个客户端的连接会话，需要通过它来给客户端发送数据
	private Session session;

	private final Logger log = LoggerFactory.getLogger(MyWebSocket.class);


	/**
	 * 连接建立成功调用的方法
	 */
	@OnOpen
	public void onOpen(Session session) {
		this.session = session;
		webSocketSet.add(this);     //加入set中
		this.onlineCount++;          //在线数加1
		log.info("有新连接加入！当前在线人数为" + this.onlineCount);
	}

	/**
	 * 连接关闭调用的方法
	 */
	@OnClose
	public void onClose() {
		webSocketSet.remove(this);  //从set中删除
		this.onlineCount--;         //在线数减1
		log.info("有一连接关闭！当前在线人数为" + this.onlineCount);
	}

	/**
	 * 收到客户端消息后调用的方法
	 *
	 * @param message 客户端发送过来的消息
	 */
	@OnMessage
	public void onMessage(String message, Session session) {
		this.session = session;
		message = "来自客户端的消息:" + message;
		log.info(message);
		this.sendMessage(message);
	}

	/**
	 * 发送消息需注意方法加锁synchronized，避免阻塞报错
	 * 注意session.getBasicRemote()与session.getAsyncRemote()的区别
	 *
	 * @param message
	 * @throws IOException
	 */
	public synchronized void sendMessage(String message) {
		this.session.getAsyncRemote().sendText(message);
	}
}
