import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;

public class LambdaTest {
    public static void main(String[] args) {
        String msg = "aaaaaaaaaaaaaaa";
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byte[] bytes = msg.getBytes(StandardCharsets.UTF_8);
        System.out.println(bytes.length);
        byteBuffer.put(bytes);
        byteBuffer.flip();
        System.out.println(new String(byteBuffer.array()));
        System.out.println(byteBuffer.remaining());
        byte[] tempBytes = new byte[byteBuffer.remaining()];
        int i = 0;
        while (byteBuffer.hasRemaining()) {
            tempBytes[i] = byteBuffer.get();
            i++;
        }
        System.out.println(new String(tempBytes));
    }
}
