package com.spring.SpringRest.ex02;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class RestController {
@RequestMapping(value="/res1")
@ResponseBody //@ResponseBody를 사용하면 반환값(JSON, 텍스트)을 브라우저의 데이터로 보낼수있다.
public Map<String, Object> res1(){
	Map<String, Object> map = new HashMap<String, Object>();
	map.put("name", "사용자");
	map.put("pwd", "1234");
	return map;	
}


@RequestMapping(value="/res2")
public ModelAndView res2() {
	return new ModelAndView("home");
}

@RequestMapping("/res3")
@ResponseBody 
public String res3() {
	return "String OK";
}

}
