package org.lynn.demo.rpc.transport;

import io.netty.channel.*;
import io.netty.util.concurrent.*;
import java.io.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import org.lynn.demo.rpc.protocol.*;

/**
 * @description:
 * @author: tangxinyi
 * @create: 2020-09-06
 */
public class Connection implements Closeable {

    private static AtomicLong ID_GENERATOR = new AtomicLong(0);
    public static Map<Long, NettyResponseFuture<Response>>
            IN_FLIGHT_REQUEST_MAP = new ConcurrentHashMap<>();
    private ChannelFuture future;
    private AtomicBoolean isConnected = new AtomicBoolean();
    public Connection(ChannelFuture future, boolean isConnected) {
        this.future = future;
        this.isConnected.set(isConnected);
    }

    public NettyResponseFuture<Response> request(Message<Request> message, long timeOut) {
        // 生成并设置消息ID
        long messageId = ID_GENERATOR.incrementAndGet();
        message.getHeader().setMessageId(messageId);
        // 创建消息关联的Future
        NettyResponseFuture responseFuture = new NettyResponseFuture(System.currentTimeMillis(),
                timeOut, message, future.channel(), new DefaultPromise(new DefaultEventLoop()));
        // 将消息ID和关联的Future记录到IN_FLIGHT_REQUEST_MAP集合中
        IN_FLIGHT_REQUEST_MAP.put(messageId, responseFuture);
        try {
            future.channel().writeAndFlush(message); // 发送请求
        } catch (Exception e) {
            // 发送请求异常时，删除对应的Future
            IN_FLIGHT_REQUEST_MAP.remove(messageId);
            throw e;
        }
        return responseFuture;
    }

    @Override
    public void close() throws IOException {

    }
    // 省略getter/setter以及close()方法
}
