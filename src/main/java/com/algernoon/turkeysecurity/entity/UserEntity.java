package com.algernoon.turkeysecurity.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "t_user")
public class UserEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@NotNull(message = "用户ID不能为空！", groups = UserUpdate.class)
	@Id
	@GeneratedValue
	@Column(name = "t_id")
	private Integer id;
	
	@NotEmpty(message = "名字不能为空！", groups = {UserAdd.class, UserUpdate.class})
	@Column(name = "t_name")
	private String name;
	
	@Min(value = 18, message = "年龄不合法！", groups = {UserAdd.class, UserUpdate.class})
	@Column(name = "t_age")
	private Integer age;
	
	@Column(name = "t_address")
	private String address;

	public final Integer getId() {
		return id;
	}

	public final void setId(Integer id) {
		this.id = id;
	}

	public final String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name = name;
	}

	public final Integer getAge() {
		return age;
	}

	public final void setAge(Integer age) {
		this.age = age;
	}

	public final String getAddress() {
		return address;
	}

	public final void setAddress(String address) {
		this.address = address;
	}
	
	public interface UserAdd{}
	
	public interface UserUpdate{}
	
}
