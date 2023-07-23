import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.util.NettyRuntime;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class ByteBufTest {

    public static void main(String[] args) {
//        ByteBuf byteBuf= ByteBufAllocator.DEFAULT.buffer();
//        System.out.println("args = " + byteBuf);
//        String s="";
//        for(int i=0;i<300;i++){
//            s=s+"a";
//        }
//        byteBuf.writeBytes(s.getBytes(StandardCharsets.UTF_8));
//        System.out.println("args1 = " + byteBuf);
        System.out.println(NettyRuntime.availableProcessors());
    }
}
