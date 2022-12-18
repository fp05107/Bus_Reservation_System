package com.masai.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Feedback {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer feedBackId;
	private Integer driverRating;

	@Min(value = 1, message = "Minimum Rating must be 1")
	@Max(value = 5, message = "Maximum Rating must be 5")
	private Integer serviceRating;

	private Integer overallRating;

	private String comments;
	private LocalDateTime feedbackDateTime;

	@OneToOne
	private User user;

	@OneToOne
	private Bus bus;

}
