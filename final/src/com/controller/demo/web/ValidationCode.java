package com.controller.demo.web;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/ValidationCode")

public class ValidationCode extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private  static String codeChars =
	        "23456789abcdefghijkmnpqrstuvwxyz" ; 
	 //    返回一個隨機顏色
	    private  static Color getRandomColor( int minColor , int maxColor)
	    {
	        Random random = new Random() ;
	         if (minColor > 255 )
	            minColor = 255 ; 
	         if (maxColor > 255 )
	            maxColor = 255 ; 
	 //        獲取顏色的隨機值
	        int red = minColor + random.nextInt(maxColor - minColor) ; 
	         int green = minColor + random.nextInt(maxColor - minColor) ; 
	         int blue = minColor + random.nextInt(maxColor - minColor) ; 
	         return  new Color(red,green,blue) ;  
	    }  
  
    public ValidationCode() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int charsLength = codeChars.length() ; 
		 //        關閉瀏覽器緩衝區
		        response.setHeader("ragma", "No-cache" ) ;
		        response.setHeader( "Cache-Control", "no-cache" ) ;
		        response.setDateHeader( "Expires", 0 ) ; 
		 //        設置圖片傳送的格式。
		        response.setContentType("image/jpeg" );
		        
//		        設置圖形驗證碼的長和寬度
		        int width = 90 ;
		         int height = 20 ;
		 //        建立圖形緩衝區
		        BufferedImage image = new BufferedImage(width , height,
		                BufferedImage.TYPE_INT_RGB) ; 
//		        獲取用於輸出文字的Graphics對象
		        Graphics graphics = image.getGraphics() ;
		        
		        Random random = new Random() ;
		        
//		        設置要填充的顏色
		        graphics.setColor(getRandomColor(180 , 250 )) ; 
		 //        填充圖形背景
		        graphics.fillRect(0, 0 , width, height) ; 
		 //        設置初始字體和顏色
		        graphics.setFont( new Font ("Time New Roman" , Font.ITALIC, height)) ;
		        graphics.setColor(getRandomColor( 120,180 )) ;
		        
//		        保存驗證碼
		        StringBuilder validationCode = new StringBuilder() ; 
		 //        驗證碼的隨機字體
		        String[] fontNames = {"Times New Roman" , "Book antiqua" , "Arial" } ;
		 //        隨機生成驗證碼
		        for ( int i = 0 ; i < 4 ; ++ i)
		        {
//		            設置當前驗證碼字符的字體
		            graphics.setFont( new Font(fontNames[random.nextInt(3 )] , Font.ITALIC ,
		                    height)) ; 
//		            隨機獲得驗證碼的字符
		            char codeChar = codeChars.charAt(random.nextInt(charsLength)) ;
		            validationCode.append(codeChar) ; 
		            graphics.setColor(getRandomColor( 20,120 )) ; 
		 //            在圖形上輸出驗證碼字符
		            graphics.drawString(String.valueOf(codeChar), 16*i+random.nextInt(7 ),
		                    height - random.nextInt(6 ) ) ;
		        } 
//		        獲得Session對象，並設置Session對象為3分鐘
		        HttpSession session = request.getSession();
		        session.setMaxInactiveInterval( 5*60 ) ; 
		 //        將驗證碼放入session對像中. 
		        session.setAttribute("validationCode" ,validationCode.toString() ) ;
		        
		        
//		        關閉graphics對象。
		        graphics.dispose() ;  
		 //        向客戶端發送圖形驗證碼
		        ImageIO.write(image,"JPEG" ,response.getOutputStream()) ;
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
