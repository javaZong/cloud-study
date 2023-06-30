package com.cloud.study.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;

/**
 * nio 服务端
 *
 * @author zongchao
 */
public class NioStudyChatServer {
    private Selector selector;
    private ServerSocketChannel serverSocketChannel;
    public static final int PORT = 6667;

    public NioStudyChatServer() {

        try {
            //打开一个选择器
            this.selector = Selector.open();
            //打开serverSocketChannel
            this.serverSocketChannel = ServerSocketChannel.open();
            //绑定地址，端口号
            this.serverSocketChannel.bind(new InetSocketAddress("127.0.0.1", PORT));
            //设置为非阻塞
            serverSocketChannel.configureBlocking(false);
            //serverSocketChannel注册到选择器中,监听连接事件
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 监听接收客户端消息，并转发到其他客户端
     */
    public void listen() {
        try {
            do {
                // 获取监听的事件总数
                int count = selector.select(2000);
                if (count > 0) {
                    // 获取selectionKey集合
                    Set<SelectionKey> selectionKeys = selector.selectedKeys();
                    Iterator<SelectionKey> it = selectionKeys.iterator();
                    while (it.hasNext()) {
                        SelectionKey key = it.next();
                        if (key.isAcceptable()) {
                            // 连接事件
                            SocketChannel socketChannel = serverSocketChannel.accept();
                            // 设置为非阻塞
                            socketChannel.configureBlocking(false);
                            // 注册到选择器中
                            // 创建缓冲区
                            ByteBuffer byteBuffer = ByteBuffer.allocate(10);
                            socketChannel.register(selector, SelectionKey.OP_READ, byteBuffer);
                            System.out.println(socketChannel.getRemoteAddress() + "上线了~");
                        }
                        if (key.isReadable()) {
                            // 读事件
                            readData(key);
                        }
                        it.remove();
                    }
                } else {
                    System.out.println("等待......");
                }
            } while (true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readData(SelectionKey selectionKey) {
        SocketChannel socketChannel = null;
        try {
            // 从selectionKey中获取channel
            socketChannel = (SocketChannel) selectionKey.channel();

            while (true) {
                //把通道的数据写入到缓冲区,判断返回的count是否大于0，大于0表示读取到了数据
                ByteBuffer byteBuffer = (ByteBuffer) selectionKey.attachment();
                int count = socketChannel.read(byteBuffer);
                if (count < 1) {
                    // 如果关闭了，就无法监听到这个channel下的读事件了
//                    selectionKey.cancel();
                    // 相当于断开了与客户端的连接
//                    socketChannel.close();
                    break;
                }
                // 切换为读模式

                String msg = ByteBufferStudy.spilt(byteBuffer);
                System.out.println(msg);
                if (byteBuffer.position() == byteBuffer.limit()) {
                    ByteBuffer newByteBuffer = ByteBuffer.allocate(byteBuffer.capacity() << 1);
                    byteBuffer.flip();
                    newByteBuffer.put(byteBuffer);
                    selectionKey.attach(newByteBuffer);
                }
                notifyAllClient(msg, socketChannel);
            }
        } catch (Exception e) {
            e.printStackTrace();
            try {
                if (socketChannel == null) {
                    return;
                }
                System.out.println(socketChannel.getRemoteAddress() + "离线了");
                selectionKey.cancel();
                socketChannel.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * 转发消息到其他客户端
     * msg 消息
     * noNotifyChannel 不需要通知的Channel
     */
    private void notifyAllClient(String msg, SocketChannel noNotifyChannel) throws Exception {
        System.out.println("服务器转发消息~");
        for (SelectionKey selectionKey : selector.keys()) {
            Channel channel = selectionKey.channel();
            //channel的类型实际类型是SocketChannel，并且排除不需要通知的通道
            if (channel instanceof SocketChannel && channel != noNotifyChannel) {
                //强转成SocketChannel类型
                SocketChannel socketChannel = (SocketChannel) channel;
                //通过消息，包裹获取一个缓冲区
                ByteBuffer byteBuffer = ByteBuffer.wrap(msg.getBytes());
                socketChannel.write(byteBuffer);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        NioStudyChatServer chatServer = new NioStudyChatServer();
        //启动服务器，监听
        chatServer.listen();
    }
}
