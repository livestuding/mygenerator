package org.plasea.generator.util;

/**
 * ������Ϣ��
 * @author ���غ�
 *
 */
public class GenerateInfo {

	/**
	 * ��Ŀ����·��
	 */
	private String projectPath;
	/**
	 * ʵ�����
	 */
	private String modelPackage;
	
	/**
	 * basedao����
	 */
	private String baseDaoPackage;
	/**
	 * dao�ӿڰ���
	 */
	private String daoBasePackage;
	/**
	 * daoʵ�ְ���
	 */
	private String daoImpPackage;
	/**
	 * ҵ���ӿڰ���
	 */
	private String serviceBasePackage;
	/**
	 * ҵ���ʵ�ְ���
	 */
	private String serviceImpPackage;
	
	/**
	 * ���Ʋ��ʵ�ְ���
	 */
	private String controllerPackage;

	/**
	 * ���Ʋ�urlǰ׺
	 */
	private String urlPrefix;
	
	
	
	public String getUrlPrefix() {
		return urlPrefix;
	}

	public void setUrlPrefix(String urlPrefix) {
		this.urlPrefix = urlPrefix;
	}

	public String getProjectPath() {
		return projectPath;
	}

	public void setProjectPath(String projectPath) {
		this.projectPath = projectPath;
	}

	public String getModelPackage() {
		return modelPackage;
	}

	public void setModelPackage(String modelPackage) {
		this.modelPackage = modelPackage;
	}

	public String getBaseDaoPackage() {
		return baseDaoPackage;
	}

	public void setBaseDaoPackage(String baseDaoPackage) {
		this.baseDaoPackage = baseDaoPackage;
	}

	public String getDaoBasePackage() {
		return daoBasePackage;
	}

	public void setDaoBasePackage(String daoBasePackage) {
		this.daoBasePackage = daoBasePackage;
	}

	public String getDaoImpPackage() {
		return daoImpPackage;
	}

	public void setDaoImpPackage(String daoImpPackage) {
		this.daoImpPackage = daoImpPackage;
	}

	public String getServiceBasePackage() {
		return serviceBasePackage;
	}

	public void setServiceBasePackage(String serviceBasePackage) {
		this.serviceBasePackage = serviceBasePackage;
	}

	public String getServiceImpPackage() {
		return serviceImpPackage;
	}

	public void setServiceImpPackage(String serviceImpPackage) {
		this.serviceImpPackage = serviceImpPackage;
	}

	public String getControllerPackage() {
		return controllerPackage;
	}

	public void setControllerPackage(String controllerPackage) {
		this.controllerPackage = controllerPackage;
	}

	
	
	
	
	
}
