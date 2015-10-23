package kr.ac.doowon.control;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.ac.doowon.model.Calculator;
import kr.ac.doowon.model.beans.Person;
import kr.ac.doowon.model.dao.PersonDAO;

@Controller
public class MyController {
	
	@Autowired
	private PersonDAO dao;
	
	@RequestMapping("hello")//1.요청분석
	public ModelAndView hello(){
	   ModelAndView mav = new ModelAndView();
	      //mav.addObject("키값", 데이터);
	      // mav.setViewName(뷰명);
	      mav.addObject("k1","김주원");//3.영역저장
	      mav.setViewName("hello");//4.페이지 지정
	   return mav;
	}
//-------------------------------------------------------------	
	//단순페이지 이동
	@RequestMapping("/a/gildong")
	public String hello2(){
	  return "hello2";	
	}
	
	
	//모델호출후 결과를 출력할 페이지로 이동
	@RequestMapping("/print") //URL요청 SpringMVC/print요청
	public String print(Model model){
	   Calculator c = new Calculator(123, 456, "+");//3.	
	   model.addAttribute("key", c.getResult());//3.	   
	   return "print";	
	}
	
	//계산기폼
	@RequestMapping("/calcForm")
	public String calcForm(){
	  return "calcForm";	
	}
	
	//계산
	@RequestMapping("/calc")
	public String calc(HttpServletRequest request,
			           HttpSession session,
			           @RequestParam int su1,
			           @RequestParam int su2,
			           @RequestParam String oper,
			           Model model){
	  //사용자가 입력한 데이터 얻어오기
//	  int num1 = Integer.parseInt(request.getParameter("su1"));
	  
//	  System.out.println("num1: "+ num1);
//	  System.out.println("su1: "+ su1);
		Calculator c = new Calculator(su1, su2, oper);
		model.addAttribute("key", c.getResult());
	  return "calcForm";	
	}
	
	/*
	 사용자가 입력한 데이터 얻어오기
	 case1)
	    public String m1(HttpServletRequest request){
	      String name = request.getParameter("name");
	    }
	 case2)
	    public String m1(@RequestParam String name){}
	                                   ----> 폼내의 이름과 일치하는 변수명
	 */
	
	 @RequestMapping("/form")		
	 public String form(){
		return "form";
	 }
	
	
	 @RequestMapping(value="/submitName",method=RequestMethod.GET)
	 public String getName1(Model model){//GET요청
	    model.addAttribute("key", "GET요청!!");
	   return "print";
	 }
	 
	 @RequestMapping(value="/submitName",method=RequestMethod.POST)
	 public String getName2(Model model,HttpSession session){//POST요청
		 model.addAttribute("key", "POST요청!!");
		 session.setAttribute("key", "세션에 저장된 데이터!!");
	   //return "redirect:print";	//@RequestMapping("/print")호출 
	   return "redirect:/view1/t1.jsp";
	 }

	 @RequestMapping("/inputForm")//요청URL
	 public String inputForm(){
		return "input_form";//실제 페이지 정보 /WEB-INF/view/input_form.jsp 
	 }
	 
	 
	 
	 @RequestMapping("/insert")
	 public String insert(Person p, Model m){
		//DB입력		
		try {
			if(dao.insert(p)){
				m.addAttribute("msg","가입을 축하합니다!!^^*");
				return "result";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 
		return "redirect:inputForm";
	 }
	 
	 @RequestMapping("/list")
	 public String list(Model model){
		List<Person> list = dao.selectAll(); 
		  //model영역 == request영역
		 model.addAttribute("list", list); 		
		return "1023/list"; 
	 }
	 
	 @RequestMapping("/updateForm")//수정폼요청이 들어온다면
	 public String updateForm(@RequestParam String name,Model model){
	          //(@RequestParam(name="nas",required=false,defaultValue="무명") 
	           //                   String userName){//수정폼: 데이터출력한 상태
		  //System.out.println("수정 이름: "+ userName);		 
		model.addAttribute("person", dao.select(name)); 		 
		return "1023/update_form"; 
	 }
	 
	 @RequestMapping("/update")//수정요청이 들어온다면
	 public String update(Person person){
		if(dao.update(person)) return "redirect:/list";
		 else return "1023/update_form";
	 }
	 
}















