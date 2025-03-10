package com.nt.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "tbluser")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User 
{
    @Id
    @SequenceGenerator(sequenceName = "dev",name = "h1",initialValue = 1001,allocationSize = 1)
	@GeneratedValue(generator = "h1",strategy =GenerationType.SEQUENCE )
    private Integer userId;
	
	private String userName;
	
	private String password;

	private String email;
	
	private Long mobile;
	
	
}
