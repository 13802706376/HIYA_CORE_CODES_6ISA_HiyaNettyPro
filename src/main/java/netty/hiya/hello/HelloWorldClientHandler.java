package netty.hiya.hello;

import java.util.Scanner;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class HelloWorldClientHandler extends ChannelInboundHandlerAdapter
{

	@Override
	public void channelActive(ChannelHandlerContext ctx)
	{
		System.out.println("客户建立连接。。。");
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)
	{
		System.out.println( msg);
		
		
		@SuppressWarnings("resource")
		String input = new Scanner(System.in).next();
		ctx.write(input);
		
	}
 
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
	{
		cause.printStackTrace();
		ctx.close();
	}

}