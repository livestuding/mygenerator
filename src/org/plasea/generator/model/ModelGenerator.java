package org.plasea.generator.model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.plasea.generator.database.mysql.Table;
import org.plasea.generator.util.GenerateInfo;
import org.plasea.generator.util.PathUtil;
import org.plasea.generator.util.UpperFirstCharacter;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * ʵ����������
 * 
 * @author ���غ�
 *
 */
public class ModelGenerator {

	/**
	 * 
	 *  
	 * @param args
	 */
    public static void main(String[] args) {  
        Configuration cfg = new Configuration();  
        try {  
            cfg.setClassForTemplateLoading(ModelGenerator.class, "/org/plasea/generator/model");//ָ��ģ�����ڵ�classpathĿ¼  
            cfg.setSharedVariable("upperFC", new UpperFirstCharacter());//���һ��"��"�����������������������ĸ��д  
            Template t = cfg.getTemplate("model.html");//ָ��ģ��  
            FileOutputStream fos = new FileOutputStream(new File("d:/Student.java"));//java�ļ�������Ŀ¼  
              
            //ģ������Դ  
            Map data = new HashMap();  
            data.put("package", "edu");//����  
            data.put("className", "Student");  
              
            List pros = new ArrayList();  
            Map pro_1 = new HashMap();  
            pro_1.put("proType", String.class.getSimpleName());  
            pro_1.put("proName", "name");  
            pros.add(pro_1);  
              
            Map pro_2 = new HashMap();  
            pro_2.put("proType", String.class.getSimpleName());  
            pro_2.put("proName", "sex");  
            pros.add(pro_2);  
              
            Map pro_3 = new HashMap();  
            pro_3.put("proType", Integer.class.getSimpleName());  
            pro_3.put("proName", "age");  
            pros.add(pro_3);  
              
            data.put("properties", pros);  
            t.process(data, new OutputStreamWriter(fos,"utf-8"));//  
            fos.flush();  
            fos.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } catch (TemplateException e) {  
            e.printStackTrace();  
        }  
    }
    
    /**
     * ����ʵ����
     * @param generateInfo
     * @param table
     */
    public static void generateModel(GenerateInfo generateInfo,Table table){
    	
    	 String modelPath = PathUtil.getPackagePath(generateInfo.getProjectPath(), generateInfo.getModelPackage());
    	
    	 Configuration cfg = new Configuration();  
         try {  
             cfg.setClassForTemplateLoading(ModelGenerator.class, "/org/plasea/generator/model");//ָ��ģ�����ڵ�classpathĿ¼  
             cfg.setSharedVariable("upperFC", new UpperFirstCharacter());//���һ��"��"�����������������������ĸ��д  
             Template t = cfg.getTemplate("model.html");//ָ��ģ��  
             String className= table.getTableName().substring(0, 1).toUpperCase()+table.getTableName().substring(1);
             String fileName = className+".java";
             System.out.println("�ļ����ƣ�"+fileName);
             File file = new File(modelPath);
             if(!file.exists()){
            	 file.mkdir();
             }
             FileOutputStream fos = new FileOutputStream(new File(modelPath+fileName));//java�ļ�������Ŀ¼  
               
             //����Դ  
             Map data = new HashMap();  
             data.put("generateInfo", generateInfo);//������Ϣ��
             data.put("className", className); //����
             data.put("table", table);//�����
             data.put("generateTime", new Date());//����ʱ��
             t.process(data, new OutputStreamWriter(fos,"utf-8"));//  
             fos.flush();  
             fos.close();  
         } catch (IOException e) {  
             e.printStackTrace();  
         } catch (TemplateException e) {  
             e.printStackTrace();  
         }  
    	
    }
    
}
