/**
 * 
 */
package org.plasea.generator.database.mysql;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class News
{
	//��Ϣ��ı�ʶ����
	@Column(name="id")
	@Id
	private int id;
	//��Ϣ����
	@Column(name="title")
	private String title;
	//��Ϣ����
	@Column(name="content")
	private String content;
	//������
	public News()
	{
	}
	//��ʶ���Ե�setter��getter����
	public void setId(int id) 
	{
		this.id = id; 
	}
	public int getId()
	{
		return (this.id); 
	}
	//��Ϣ�����setter������getter����
	public void setTitle(String title) 
	{
		this.title = title; 
	}
	public String getTitle() 
	{
		return (this.title); 
	}

	//��Ϣ���ݵ�setter������getter����
	public void setContent(String content)
	{
		this.content = content; 
	}
	public String getContent()
	{
		return (this.content); 
	}
}