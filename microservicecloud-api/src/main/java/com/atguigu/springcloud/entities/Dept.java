package com.atguigu.springcloud.entities;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@NoArgsConstructor//生成无参构造器
@Data//生成setter,getter方法
@Accessors(chain=true)//可以链式调用
public class Dept implements Serializable {

	private static final long serialVersionUID = 4569025923585330700L;

	/*部门id */
	private Long id;
	
	/*部门名 */
	private String dName;
	
	/*所在数据库*/
	private String dbSource;
	
}
