package org.lynn.demo.rpc.transport;

import io.netty.channel.*;
import io.netty.util.concurrent.*;
import org.lynn.demo.rpc.protocol.*;

/**
 * @description:
 * @author: tangxinyi
 * @create: 2020-09-06
 */
public class NettyResponseFuture<T> {

    private long createTime;
    private long timeOut;
    private Message message;
    private Channel channel;
    private Promise promise;

    public NettyResponseFuture(long createTime, long timeOut, Message<Request> message, Channel channel, Promise promise) {
        this.createTime = createTime;
        this.timeOut =timeOut;
        this.message = message;
        this.channel = channel;
        this.promise = promise;
    }

    public Promise getPromise() {
        return promise;
    }
}
