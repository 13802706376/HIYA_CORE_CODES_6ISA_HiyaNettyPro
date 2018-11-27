package netty.hiya.hello;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Scanner;

public class HelloWorldServerHandler extends ChannelInboundHandlerAdapter
{

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception
	{
		System.out.println("�������ӵ�ַ"+ctx.channel().remoteAddress() + "�յ���Ϣ:" + msg.toString());
		//ctx.write("������д����" + "���Τ�� ");
		
		@SuppressWarnings("resource")
		String input = new Scanner(System.in).next();
		ctx.write(input);
		
		ctx.flush();
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception
	{
		cause.printStackTrace();
		ctx.close();
	}

}