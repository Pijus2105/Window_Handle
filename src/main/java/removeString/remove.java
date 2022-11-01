package removeString;

public class remove {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		String s = "123elphill@#!Tech456"; 
	     int count=0;
	     
	      String NotAlpha="";
	   //  s = s.replaceAll("[^a-zA-Z]", ""); //regex=regular expression
	     for(int i=0 ;i<s.length();i++) 
	     {
	    	 if(!Character.isLetter(s.charAt(i))&&!Character.isWhitespace(s.charAt(i))) 
	    	 {
	    		count++; 
	    		 
	    	 }else 
	    	 {
	    		 NotAlpha=NotAlpha+s.charAt(i);
	    	 } 
	    	  
	     }
	     
	     if(count==0) 
	     {
	    	 System.out.println(" Threre is not Alpha Character");
	     }else 
	     {
	    	 System.out.println(" Threre  Alpha Character " +NotAlpha );
	     }
	     
	  //  System.out.println(NotAlpha);
		
		
	}

}
