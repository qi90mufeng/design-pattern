package com.remote.rpc;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RpcServer {
    private final ExecutorService executorService = Executors.newCachedThreadPool();

    public void publisher(final Object service, int port){
        try(ServerSocket serverSocket = new ServerSocket(port)){
            while (true){
                Socket socket = serverSocket.accept();
                executorService.execute(new ProcessorHandler(socket,service));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}