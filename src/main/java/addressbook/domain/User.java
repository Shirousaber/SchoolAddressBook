package addressbook.domain;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * User. 
 * @author 
 * @date 
 */

@Entity // 实体
public class User {
	@Id //主键
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 自增测略
	private long id; // 用户的唯一标识
 	private String name;
	private int age;

	protected User() {//防止直接使用
	}

	public User(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String toString()
	{
		return String.format("User[id=%d, name = %ds, age = %d]",id, name,age);
	}
}
