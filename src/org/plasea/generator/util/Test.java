package org.plasea.generator.util;

public class Test {

	
	public String getCurrentPath(){  
	       //ȡ�ø�Ŀ¼·��  
	       String rootPath=getClass().getResource("/").getFile().toString();  
	       System.out.println("rootPath:"+rootPath);
	       //��ǰĿ¼·��  
	       String currentPath1=getClass().getResource(".").getFile().toString();  
	       System.out.println("currentPath1:"+currentPath1);
	       String currentPath2=getClass().getResource("").getFile().toString();  
	       System.out.println("currentPath2:"+currentPath2);
	       //��ǰĿ¼���ϼ�Ŀ¼·��  
	       String parentPath=getClass().getResource("../").getFile().toString();  
	       System.out.println("parentPath:"+parentPath);
	          
	       return rootPath;         
	   
	   }
	
	
	public static void main(String[] args) {
		 Test t = new Test();
		 t.getCurrentPath();
	}

}
