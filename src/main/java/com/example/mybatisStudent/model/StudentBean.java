package com.example.mybatisStudent.model;

import java.io.Serializable;
import lombok.Data;

@Data
public class StudentBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name, birth, gender, phone, education,attend[];
	
}
