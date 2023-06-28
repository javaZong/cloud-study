package com.cloud.study.nio;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class ByteBufferStudy {

    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(256);
        byteBuffer.put("hello world!\njava\nhow are ".getBytes(StandardCharsets.UTF_8));
        readMsg(byteBuffer);
        byteBuffer.put("you\n".getBytes(StandardCharsets.UTF_8));
        readMsg(byteBuffer);
    }

    /**
     * 粘包和拆包处理
     * @param byteBuffer
     */
    private static void readMsg(ByteBuffer byteBuffer) {
        byteBuffer.flip();
        int readLimit = byteBuffer.limit();
        for (int i = 0; i < readLimit; i++) {
            if (byteBuffer.get(i) == '\n') {
                // 当条消息结束
                int length = i - byteBuffer.position() + 1;
                byte[] bytes = new byte[length];
                // 会改变position位置
                byteBuffer.get(bytes);
                System.out.println(new String(bytes));
            }
        }
        // 改为写模式，并将已读取的内容清除掉，未读取的内容移动到数组头部
        byteBuffer.compact();
    }
}
