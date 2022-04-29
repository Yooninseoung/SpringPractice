package spring.ex01;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

//<context:component-scan> 태그의 기능 중 @Controller - component-scan에 의해 지정된 클래스를 컨트롤 빈으로 자동 변환.
@Controller("mainContoller") //mainController라는 빈이 만들어짐

//클래스 레벨에서 @RequestMapping - /test로 시작하는 경로를 매핑함
@RequestMapping("/test")
public class MainController {
	
	//메소드 레벨에서 @RequestMapping - 그중 main1.do를 찾아서 매핑 해줌.  
	@RequestMapping(value="/main1.do" , method=RequestMethod.GET)
	public ModelAndView main1(HttpServletRequest request, HttpServletRequest response) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg","main1");
		mav.setViewName("main");
		return mav;
	}
	
	@RequestMapping(value="/main2.do" , method=RequestMethod.GET)
	public ModelAndView main2(HttpServletRequest request, HttpServletRequest response) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg","main2");
		mav.setViewName("main");
		return mav;
	}

}
