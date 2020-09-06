package org.lynn.demo.rpc.transport;

import io.netty.channel.*;
import org.lynn.demo.rpc.*;
import org.lynn.demo.rpc.protocol.*;

/**
 * @description:
 * @author: tangxinyi
 * @create: 2020-09-06
 */
public class DemoRpcClientHandler extends SimpleChannelInboundHandler<Message<Response>> {
    protected void channelRead0(ChannelHandlerContext ctx, Message<Response> message) throws Exception {
        NettyResponseFuture responseFuture = Connection.IN_FLIGHT_REQUEST_MAP.remove(message.getHeader().getMessageId());
        Response response = message.getContent();
        // 心跳消息特殊处理
        if (response == null && Constants.isHeartBeat(message.getHeader().getExtraInfo())) {
            response = new Response();
            response.setCode(Constants.HEARTBEAT_CODE);
        }
        responseFuture.getPromise().setSuccess(response);
    }
}
