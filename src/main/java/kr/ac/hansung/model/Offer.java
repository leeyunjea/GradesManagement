package kr.ac.hansung.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Offer {
	
	private int take_year;
	
	private int semester;
	
	@Size(min=2, max=10, message="Name must be between 2 and 10 chars")
	private String code;
	
	@Size(min=2, max=50, message="Name must be between 2 and 50 chars")
	private String courseName;
	
	@Size(min=2, max=10, message="Name must be between 2 and 10 chars")
	private String divide;
	
	private int credit;
	
}
