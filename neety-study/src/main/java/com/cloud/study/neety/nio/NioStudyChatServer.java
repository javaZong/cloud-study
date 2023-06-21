package com.cloud.study.neety.nio;

import java.io.IOException;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

/**
 * nio 服务端
 * @author zongchao
 */
public class NioStudyChatServer {
    private Selector selector;
    private ServerSocketChannel serverSocketChannel;

    public NioStudyChatServer(){
        // 打开一个选择器
        try {
            selector=Selector.open();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
