package org.plasea.generator.main;

import org.plasea.generator.controller.ControllerGenerator;
import org.plasea.generator.dao.hibernate.dao.DaoBaseGenerator;
import org.plasea.generator.dao.hibernate.imp.DaoImpGenerator;
import org.plasea.generator.database.mysql.Table;
import org.plasea.generator.database.mysql.TableFactory;
import org.plasea.generator.model.ModelGenerator;
import org.plasea.generator.service.imp.ServiceImpGenerator;
import org.plasea.generator.service.service.ServiceBaseGenerator;
import org.plasea.generator.util.GenerateInfo;
import org.plasea.generator.util.PropUtil;

/**
 * �������������࣬���
 * @author ���غ�
 *
 */
public class GenerateMain {

	//���뻷��
	public static String environment ;
	//��Ŀ����
	public static String projectName;
	
	//ʵ�����
	public static String modelPackage;
	
	//����
	public static String tableName;
	
	//��Ŀ��·��
	public static String projectPath;
	
	//basedao����
	public static String baseDaoPackage;
	
	//dao��ӿڰ���
	public static String daoBasePackage;
	
	//dao��ӿ�ʵ�ְ���
	public static String daoImpPackage;
	
	//ҵ���ӿڰ���
	public static String serviceBasePackage;
	
	//ҵ���ӿ�ʵ�ְ���
	public static String serviceImpPackage;
	//���Ʋ����
	public static String controllerPackage;
	
	/**
	 * ��ʼ��ϵͳ����
	 */
	public  void init(){
		PropUtil.getInstatance();
		environment = PropUtil.getValue("environment");
		projectName = PropUtil.getValue("projectName");
		
		modelPackage = PropUtil.getValue("modelPackage");
		tableName = PropUtil.getValue("tableName");
		baseDaoPackage = PropUtil.getValue("baseDaoPackage");
		daoBasePackage = PropUtil.getValue("daoBasePackage");
		daoImpPackage = PropUtil.getValue("daoImpPackage");
		serviceBasePackage = PropUtil.getValue("serviceBasePackage");
		serviceImpPackage = PropUtil.getValue("serviceImpPackage");
		controllerPackage = PropUtil.getValue("controllerPackage");
		
		String temp = PropUtil.getValue("projectPath");
		
		if(temp != null && !temp.equals("")){//�����������Ŀ����·��
			projectPath = temp;
		}else{//��ȡ��Ŀ·��
			String rootPath = getClass().getResource("/").getFile().toString();
			rootPath = rootPath.substring(1);
			System.out.println("rootPath:"+rootPath);
		    String[] pathes = rootPath.split("/");
		    String newPath = "";
		    for(int i=0;i<pathes.length-2;i++){//ʡȥbin����Ŀ·��
		    	newPath+= pathes[i]+"/";
		    }
		    System.out.println("newPath:"+newPath);
		    newPath += projectName+"/src/";
		    projectPath = newPath;
		    System.out.println("��Ŀ·����"+projectPath);
		}
		
		
	}
	/**
	 * ���ɸ����ļ�
	 */
	public static void generate(){
		//��ȡ�����ļ�����ʼ������
		new GenerateMain().init();
		//��ȡ��Ӧ������javaʵ��
		String tables[] = tableName.split(",");
		Table table = null;
		GenerateInfo generateInfo = null;
		//���������
		for(int i=0;i<tables.length;i++){
			table= TableFactory.generateTable(tables[i].trim());
			
			generateInfo = new GenerateInfo();
			//���ɰ������һ��
			String tablePackageName = table.getTableName().toLowerCase();
			
			generateInfo.setProjectPath(projectPath);
			generateInfo.setBaseDaoPackage(baseDaoPackage);
			generateInfo.setDaoBasePackage(daoBasePackage+"."+tablePackageName);
			generateInfo.setDaoImpPackage(daoImpPackage+"."+tablePackageName);
			generateInfo.setServiceBasePackage(serviceBasePackage+"."+tablePackageName);
			generateInfo.setServiceImpPackage(serviceImpPackage+"."+tablePackageName);
			generateInfo.setModelPackage(modelPackage+"."+tablePackageName);
			generateInfo.setControllerPackage(controllerPackage+"."+tablePackageName);
			generateInfo.setUrlPrefix(tablePackageName);
			
			//���ɸ����ļ�
			ModelGenerator.generateModel( generateInfo,table);
			DaoBaseGenerator.generateBaseDao( generateInfo,table);
			DaoImpGenerator.generateBaseDao(generateInfo, table);
			ServiceBaseGenerator.generateServiceBase(generateInfo, table);
			ServiceImpGenerator.generateServiceBase(generateInfo, table);
			ControllerGenerator.generateController(generateInfo, table);
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		generate();
		
		
		
	}

}
