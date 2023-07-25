package com.cloud.study.netty.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.CharsetUtil;


import java.util.Scanner;

public class NettyClient {
    public static void main(String[] args) {

        NioEventLoopGroup eventExecutors = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(eventExecutors)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        socketChannel.pipeline().addLast(new MyClientHandler());
                    }
                });
        System.out.println("client ready......");
        try {
            // connect是异步非阻塞的，扔给了NioEventLoopGroup里的线程进行了执行
            ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 6666).sync();
            Channel channel = channelFuture.channel();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Scanner scanner = new Scanner(System.in);
                    while (scanner.hasNextLine()) {
                        String msg = scanner.nextLine();
                        if ("exit".equals(msg)) {
                            channel.close();
                            break;
                        }
                        channel.writeAndFlush(Unpooled.copiedBuffer(msg, CharsetUtil.UTF_8));
                    }
                }
            }, "input").start();

            // 优雅关闭连接：异步监听
            channelFuture.channel().closeFuture().addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture channelFuture) throws Exception {
                    eventExecutors.shutdownGracefully();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            eventExecutors.shutdownGracefully();
        }
    }
}
