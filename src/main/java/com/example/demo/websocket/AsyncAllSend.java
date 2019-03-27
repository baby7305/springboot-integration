package com.example.demo.websocket;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 异步群发websocket，防止方法调用时太耗时
 */
@Component
public class AsyncAllSend {
	/**
	 * 群发自定义消息
	 * */
	@Async
	public void sendInfo(String message) throws IOException {
		for (MyWebSocket item : MyWebSocket.webSocketSet) {
			try {
				item.sendMessage(message);
			} catch (IOException e) {
				continue;
			}
		}
	}
}
