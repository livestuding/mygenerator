package org.plasea.generator.util;


/**
 * ·��������
 * @author ���غ�
 *
 */
public class PathUtil {

	/**
	 * ���ɰ���·��
	 * @param projectPath
	 * @param packageName
	 * @return
	 */
	public static String getPackagePath(String projectPath,String packageName ){
    	
    	String packagePath = packageName.replace(".", "/");//��·��
    	packagePath = projectPath +packagePath+"/";//����ʵ����·��
    	System.out.println("��·����"+packagePath);
    	
    	return packagePath;
	}
}
