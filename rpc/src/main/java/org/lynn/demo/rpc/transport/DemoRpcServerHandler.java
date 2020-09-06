package org.lynn.demo.rpc.transport;

import io.netty.channel.*;
import java.util.concurrent.*;
import org.lynn.demo.rpc.*;
import org.lynn.demo.rpc.protocol.*;

/**
 * @description:
 * @author: tangxinyi
 * @create: 2020-09-06
 */
public class DemoRpcServerHandler extends SimpleChannelInboundHandler<Message<Request>> {
    // 业务线程池
    static Executor executor = Executors.newCachedThreadPool();

    protected void channelRead0(final ChannelHandlerContext ctx, Message<Request> message) throws Exception {
        byte extraInfo = message.getHeader().getExtraInfo();
        if (Constants.isHeartBeat(extraInfo)) { // 心跳消息，直接返回即可
            ctx.writeAndFlush(message);
            return;
        }
        // 非心跳消息，直接封装成Runnable提交到业务线程
        executor.execute(new InvokeRunnable(message, ctx));
    }
}
