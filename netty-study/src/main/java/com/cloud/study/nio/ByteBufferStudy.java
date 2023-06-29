package com.cloud.study.nio;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class ByteBufferStudy {

    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);

        byteBuffer.put("msg".getBytes(StandardCharsets.UTF_8));

        char c = '\n';

        System.out.println(charToByte(c)[1]);
    }

    public static byte[] charToByte(char c) {
        byte[] bytes = new byte[2];
        bytes[0] = (byte) ((c & 0xFF00) >> 8);
        bytes[1] = (byte) (c & 0xFF);
        return bytes;
    }

    private static void extracted() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(256);
        byteBuffer.put("hello world!\njava\nhow are ".getBytes(StandardCharsets.UTF_8));
        spilt(byteBuffer);
        byteBuffer.put("you\n".getBytes(StandardCharsets.UTF_8));
        spilt(byteBuffer);
    }

    /**
     * 粘包和拆包处理
     *
     * @param byteBuffer
     */
    public static void spilt(ByteBuffer byteBuffer) {
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
