package org.lynn.demo.rpc.transport;

import io.netty.channel.*;
import java.lang.reflect.*;
import org.lynn.demo.rpc.protocol.*;

/**
 * @description:
 * @author: tangxinyi
 * @create: 2020-09-06
 */
public class InvokeRunnable implements Runnable {

    private ChannelHandlerContext ctx;
    private Message<Request> message;

    public InvokeRunnable(Message<Request> message, ChannelHandlerContext ctx) {
        this.message = message;
        this.ctx = ctx;
    }

    @Override
    public void run() {
        Response response = new Response();
        Object result = null;
        try {
            Request request = message.getContent();
            String serviceName = request.getServiceName();
            // 这里提供BeanManager对所有业务Bean进行管理，其底层在内存中维护了
            // 一个业务Bean实例的集合。感兴趣的同学可以尝试接入Spring等容器管
            // 理业务Bean
            Object bean = BeanManager.getBean(serviceName);
            // 下面通过反射调用Bean中的相应方法
            Method method = bean.getClass().getMethod(
                    request.getMethodName(), request.getArgTypes());
            result = method.invoke(bean, request.getArgs());
        } catch (Exception e) { // 省略异常处理
        } finally {
        }
        response.setResult(result); // 设置响应结果
        // 将响应消息返回给客户端
        ctx.writeAndFlush(new Message(message.getHeader(), response));
    }
}
