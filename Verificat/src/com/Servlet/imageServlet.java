package com.Servlet;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class imageServlet
 */
@WebServlet("/images")
public class imageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
		//产生随机字体
	private Font getFont() {
		Random random=new Random();
		Font font[]=new Font[5];
		font[0]= new Font("Ravie", Font.PLAIN, 24);
		font[1]= new Font("Antique Olive Compact", Font.PLAIN, 24);
		font[2]= new Font("Forte", Font.PLAIN, 24);
		font[3]= new Font("Wide Latin", Font.PLAIN, 24);
		font[4]= new Font("Gill Sans Ultra Bold", Font.PLAIN, 24);
		
		return font[random.nextInt(5)];
		
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 设置响应头 Content-type类型
		response.setContentType("image/jpeg");
		// 以下三句是用于设置页面不缓存
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "No-cache");
		response.setDateHeader("Expires", 0);
		
		OutputStream os=response.getOutputStream();
		int width=88,height=30;
		
		//建立指定宽高和BufferedImage对象
		BufferedImage image= new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);
		//image获取画笔
		Graphics g=image.getGraphics();
		//保存当前画笔颜色，用完画笔要回复现场
		Color c=g.getColor();
		// 设置画笔的一些属性（比如颜色、字体风格、背景、前景色等等）
		g.fillRect(0, 0, width, height);
		
		//产生随机的字符串
		char[] ch="abcdefghigklmnopqrstuvwxyz".concat("ABCDEFGHIJKLMNOPQRSTUV").concat("WXYZ0123456789").toCharArray();
		int length=ch.length;
		String sRandom="";
		Random random=new Random();
		for (int i = 0; i < 4; i++) {
			g.setFont(getFont());
			//生成随机数字
			String rand=new Character(ch[random.nextInt(length)]).toString();
			sRandom+=rand;
			//设置随机颜色
			g.setColor(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
			g.drawString(rand, 20*i+6,25);
		}
		
		//随机产生干扰点
		for (int i = 0; i < 40; i++) {
			int x1=random.nextInt(width);
			int y1=random.nextInt(height);
			g.drawOval(x1, y1, 2, 2);
		}
		//恢复现场
		g.setColor(c);
		g.dispose();
		
		//记录到session
		request.getSession().setAttribute("safecode", sRandom);
		//输出图像到页面
		ImageIO.write(image, "JPEG", os);
		//request.getRequestDispatcher("/WEB-INF/lib/imges.jsp").forward(request, response);
		//response.sendRedirect("/Verificat/WEB-INF/lib/imges.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
