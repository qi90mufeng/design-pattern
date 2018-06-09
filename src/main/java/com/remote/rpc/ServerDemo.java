package com.remote.rpc;

public class ServerDemo {
    public static void main(String[] args) {
        IGpHello iGpHello = new IGpHelloImpl();
        RpcServer rpcServer = new RpcServer();
        rpcServer.publisher(iGpHello, 8888);
    }
}
