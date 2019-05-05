package com.hxzy.hrsystem.controller;

import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.imageio.ImageIO;
import javax.persistence.metamodel.SetAttribute;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hxzy.hrsystem.util.ImageCode;

@Controller
public class MainController {

	@RequestMapping(value = "userlogin", method = RequestMethod.GET)
	public ModelAndView toLogin(ModelAndView mav, String error) {
		if (null != error) {
			mav.addObject("error", error);
			System.out.println(error);
		}

		System.out.println("登陆页");

		mav.setViewName("userlogin");// 跳转至登录页面
		return mav;
	}

	@RequestMapping(value = "error", method = RequestMethod.GET)
	public ModelAndView toError(ModelAndView mav) {
		mav.setViewName("error");// 跳转至错误页面
		return mav;
	}

	@RequestMapping(value = "403", method = RequestMethod.GET)
	public ModelAndView to403(ModelAndView mav) {
		mav.setViewName("403");// 跳转至403页面
		return mav;
	}

	/**
	 * 生成并返回图形验证码
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/imgcode", method = RequestMethod.GET)
	public void getImgCode(HttpServletRequest request, HttpServletResponse response) {
		OutputStream os = null;
		try {
			ImageCode imageCode = new ImageCode();// 利用图片工具生成图片
			Object[] imgcodes = imageCode.drawImage();// 生成验证码
			String code = (String) imgcodes[0];// 获取验证码
			BufferedImage image = (BufferedImage) imgcodes[1];// 获取图片
			response.setContentType("image/png");// 设置返回的数据类型
			os = response.getOutputStream();
			HttpSession session = request.getSession();
			session.setAttribute("imgKey", code);// 将验证码存入Session
			ImageIO.write(image, "JPEG", os);// 将图片输出给浏览器
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != os) {// 关闭资源
					os.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

//		PrintWriter out;
//		try {
//			String path = request.getSession().getServletContext().getRealPath("");
//			path += "static\\asserts\\img";// 获取项目的绝对路径
//			System.out.println("路径："+path);
//			
//			ImageCode imageCode = new ImageCode();
//			imageCode.drawImage(new FileOutputStream(path + "\\imgCode.jpg")); // 生成图片验证码
//			response.setContentType("text/html;charset=utf-8");
//			out = response.getWriter();//获取输出流
//			out.println("<html>");
//			out.println("<head>");
//			out.println("<title>图形验证码</title>");
//			out.println("</head>");
//			out.println("<body>");
//			out.println("<h1>自动生成图形验证码</h1>");
//			out.println("<img al='图形验证码' src='static/asserts/img/imgCode.jpg'/>");
//			out.println("<span>验证码为："+imageCode.getCode()+"</span>");
//			out.println("</body>");
//			out.println("</html>");
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}

}
