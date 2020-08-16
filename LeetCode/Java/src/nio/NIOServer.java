package nio;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Set;

public class NIOServer {
    public static void main(String[] args) throws Exception{
        //开启服务
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //监听端口
        serverSocketChannel.socket().bind(new InetSocketAddress(9000));
        //设置非阻塞
        serverSocketChannel.configureBlocking(false);
        //得到一个selector对象
        Selector selector = Selector.open();
        //将serverSocketChannel注册到selector上
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while(true){
            if (selector.select(1000) == 0){
                System.out.println("wait for 1s");
                continue;
            }
            //获取key集合
            Set<SelectionKey> keys = selector.selectedKeys();

            Iterator<SelectionKey> iterator = keys.iterator();
            //遍历key
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                if (key.isAcceptable()){
                    SocketChannel accept = serverSocketChannel.accept();
                    accept.configureBlocking(false);
                    accept.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                }
                if (key.isReadable()){
                    //通过key获取channel
                    SocketChannel channel = (SocketChannel) key.channel();
                    //获取buffer
                    ByteBuffer byteBuffer = (ByteBuffer) key.attachment();
                    channel.read(byteBuffer);
                    System.out.println(new String(byteBuffer.array()));
                }
                iterator.remove();
            }

        }


    }
}
