package com.padawans.framework.model;

import java.io.Serializable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@EqualsAndHashCode @NoArgsConstructor
public class Post implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer userId;
	private Integer id;
	private String title;
	private String body;

}
