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
	
	@RequestMapping("hello")//1.��û�м�
	public ModelAndView hello(){
	   ModelAndView mav = new ModelAndView();
	      //mav.addObject("Ű��", ������);
	      // mav.setViewName(���);
	      mav.addObject("k1","���ֿ�");//3.��������
	      mav.setViewName("hello");//4.������ ����
	   return mav;
	}
//-------------------------------------------------------------	
	//�ܼ������� �̵�
	@RequestMapping("/a/gildong")
	public String hello2(){
	  return "hello2";	
	}
	
	
	//��ȣ���� ����� ����� �������� �̵�
	@RequestMapping("/print") //URL��û SpringMVC/print��û
	public String print(Model model){
	   Calculator c = new Calculator(123, 456, "+");//3.	
	   model.addAttribute("key", c.getResult());//3.	   
	   return "print";	
	}
	
	//������
	@RequestMapping("/calcForm")
	public String calcForm(){
	  return "calcForm";	
	}
	
	//���
	@RequestMapping("/calc")
	public String calc(HttpServletRequest request,
			           HttpSession session,
			           @RequestParam int su1,
			           @RequestParam int su2,
			           @RequestParam String oper,
			           Model model){
	  //����ڰ� �Է��� ������ ������
//	  int num1 = Integer.parseInt(request.getParameter("su1"));
	  
//	  System.out.println("num1: "+ num1);
//	  System.out.println("su1: "+ su1);
		Calculator c = new Calculator(su1, su2, oper);
		model.addAttribute("key", c.getResult());
	  return "calcForm";	
	}
	
	/*
	 ����ڰ� �Է��� ������ ������
	 case1)
	    public String m1(HttpServletRequest request){
	      String name = request.getParameter("name");
	    }
	 case2)
	    public String m1(@RequestParam String name){}
	                                   ----> ������ �̸��� ��ġ�ϴ� ������
	 */
	
	 @RequestMapping("/form")		
	 public String form(){
		return "form";
	 }
	
	
	 @RequestMapping(value="/submitName",method=RequestMethod.GET)
	 public String getName1(Model model){//GET��û
	    model.addAttribute("key", "GET��û!!");
	   return "print";
	 }
	 
	 @RequestMapping(value="/submitName",method=RequestMethod.POST)
	 public String getName2(Model model,HttpSession session){//POST��û
		 model.addAttribute("key", "POST��û!!");
		 session.setAttribute("key", "���ǿ� ����� ������!!");
	   //return "redirect:print";	//@RequestMapping("/print")ȣ�� 
	   return "redirect:/view1/t1.jsp";
	 }

	 @RequestMapping("/inputForm")//��ûURL
	 public String inputForm(){
		return "input_form";//���� ������ ���� /WEB-INF/view/input_form.jsp 
	 }
	 
	 
	 
	 @RequestMapping("/insert")
	 public String insert(Person p, Model m){
		//DB�Է�		
		try {
			if(dao.insert(p)){
				m.addAttribute("msg","������ �����մϴ�!!^^*");
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
		  //model���� == request����
		 model.addAttribute("list", list); 		
		return "1023/list"; 
	 }
	 
	 @RequestMapping("/updateForm")//��������û�� ���´ٸ�
	 public String updateForm(@RequestParam String name,Model model){
	          //(@RequestParam(name="nas",required=false,defaultValue="����") 
	           //                   String userName){//������: ����������� ����
		  //System.out.println("���� �̸�: "+ userName);		 
		model.addAttribute("person", dao.select(name)); 		 
		return "1023/update_form"; 
	 }
	 
	 @RequestMapping("/update")//������û�� ���´ٸ�
	 public String update(Person person){
		if(dao.update(person)) return "redirect:/list";
		 else return "1023/update_form";
	 }
	 
}















