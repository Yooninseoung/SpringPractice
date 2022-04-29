package spring.ex02;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller("loginController")

public class LoginController {
@RequestMapping(value={ "/test/loginForm.do", "/test/loginForm2.do" }, method=RequestMethod.GET)
public ModelAndView loginForm(HttpServletRequest request, HttpServletRequest response) throws Exception {
	ModelAndView mav = new ModelAndView();
	mav.setViewName("loginForm");
	return mav;
}

@RequestMapping(value="/test/login.do", method= {RequestMethod.GET,RequestMethod.POST})
public ModelAndView login(@RequestParam Map<String, String> info, @ModelAttribute("infoEX") LoginVO loginVO, HttpServletRequest request, HttpServletRequest response) throws Exception {
	request.setCharacterEncoding("utf-8");
	ModelAndView mav = new ModelAndView();
	mav.setViewName("result");
	String userID = info.get("userID");
	System.out.println("userID = "+userID);
	System.out.println("userName = "+loginVO.getUserName());
	return mav;
}


}
