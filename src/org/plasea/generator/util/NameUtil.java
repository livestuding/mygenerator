package org.plasea.generator.util;

import org.plasea.generator.database.mysql.TableField;

/**
 * 
 * @author ���غ�
 *
 */
public class NameUtil {

	public static final char LINK_FLAG  = '_';
	
	/**
	 * �����ݿ��ֶ�����ת����java����
	 * @param originalName
	 * @return
	 */
	public static String dealName(String originalName){
		String newName = null;
		if(originalName.contains("_")){
			//ȫ��Сд��
			char[] c = originalName.toCharArray();
			int lenth = c.length;
			for(int i=0;i<c.length;i++){
				if(c[i]>='A' && c[i]<='Z'){
					c[i] = (char)(c[i]+32);
				}
			}
			for(int i=0;i<c.length;i++){
				if(LINK_FLAG == c[i]){
					if(i+1 < lenth){
						c[i+1] = (char)(c[i+1]-32);
					}
				}
			}
			
			newName = new String(c);
			newName = newName.replaceAll("_", "");
			
		}else{//���û���»�������
			newName = originalName;
		}
		return newName;
		
	}
	
	/**
	 * 
	 * @param originalField
	 * @return
	 */
	public static TableField dealTable(TableField originalField){
		TableField resultField = originalField;
		resultField.setField(dealName(resultField.getColumnName()));
		resultField.setType(getJavaType(resultField.getType()));
		return resultField;
	}
	
	/**
	 * ��jdbc����ת����java����
	 * @param jdbcType
	 * @return
	 */
	public static String getJavaType(String jdbcType){
		String newStr = jdbcType.toLowerCase();
		if(newStr.contains("bigint") || newStr.contains("decimal") || newStr.contains("numeric")){
			return "Long";
		}else if(newStr.contains("datetime") || newStr.contains("date") || newStr.contains("time")|| newStr.contains("timestamp")){
			return "Date";
		}else if(newStr.contains("char") || newStr.contains("tinytext") || newStr.contains("enum")){
			return "String";
		}else if(newStr.contains("blob") || newStr.contains("binary") ){
			return "byte[]";
		}else if(newStr.contains("bit")){
			return "Boolean";
		}else if(newStr.contains("double")){
			return "Double";
		}else if(newStr.contains("int")){
			return "Integer";
		}
		return "String";
	}
	
	public static void main(String[] args) {
		System.out.println(dealName("_T_state_UPDate_Info_"));
	}
}
