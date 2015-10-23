package kr.ac.doowon.model;

public class Calculator {//두 수(데이터)에 대한 계산 기능
     private int su1;
     private int su2;
     private String oper;
     
     private int result;
	 public Calculator(int su1, int su2, String oper) {
	    this.su1 = su1;
	    this.su2 = su2;
	    this.oper = oper;
	    
	    choice();
	 }//생성자
	 
	 private void choice(){
		if(oper.equals("+")){
			plus();
		}else if(oper.equals("-")){
			minus();
		}else if(oper.equals("*")){
			multi();
		}else{
			div();
		}
	 }
	 
	 public void plus(){ result = su1+su2; }
	 public void minus(){ result = su1-su2; }
	 public void multi(){ result = su1*su2; }
	 public void div(){ result = su1/su2; }
	 
	 public String getResult(){
		 return "결과값 : "+su1+ " "+oper+ " "+ su2+ " = "+ result;
		    //"결과값 : 2 + 3 = 5"
	 }
	 
	 
	 
}





