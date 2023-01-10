package ch19.sec07;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.Collections;

public class ChatServer {
    ServerSocket serverSocket;
    ExecutorService threadPool = Executors.newFixedThreadPool(100);
    Map<String, SocketCkient> chatRoom = Collections.synchronizedMap(new HashMap<>());

//메소드: 서버 시작
    public void start() throws IOException {
        serverSocket = new ServerSocket(50001);
        System.out.println("[서버] 시작됨");

        Thread thread = new Thread(() -> {
            try {
                while(true){
                    Socket socket = serverSocket.accept();
                    SocketCkient sc = new SocketCkient(this, socket);
                }
            } catch(IOException e) {
            }
        });
        thread.start();
    }
    //매소드 : 클라이언트 연결 시 SocketClient 생성 및 추가

}
