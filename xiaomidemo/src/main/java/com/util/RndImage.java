package com.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

public class RndImage {
	public static String random(){
        String str="";
        int num=100000+(int)(Math.random()*100000);
        str=str+num;
        str=str.substring(1,str.length());
        return str;
    }


   private static Color getRandomColor(){
        Color col=null;
        Random rnd=new Random();
        col=new Color(rnd.nextInt(255),rnd.nextInt(255),rnd.nextInt(255));
        return col;
    }
   
   public static void imageOut(String num,OutputStream out,int width,int height) throws IOException{
	   BufferedImage rndImg=null; //缓冲区图像
	   rndImg=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
	   Graphics2D g=(Graphics2D)rndImg.getGraphics(); //二维图像类
	   g.setColor(Color.WHITE);
	   g.fillRect(0,0,width,height);
	   Font mFont=new Font("Tahoma",Font.BOLD,height*3/4);
	   g.setFont(mFont);
	 String str1[]=new String[5];
	   for (int i = 0; i < str1.length; i++) {
	       str1[i]=""+num.charAt(i);
	      g.setColor(getRandomColor());
	      g.drawString(str1[i],20*i+10,height*4/5);
	   }
	   g.dispose();
	   ImageIO.write(rndImg,"jpg",out); //将内存图像写出到输出流
	 }
}
