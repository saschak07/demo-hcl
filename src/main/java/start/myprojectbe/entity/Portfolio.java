package start.myprojectbe.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

// Serializable makes storing and sending objects easy. It has nothing to do with security
@Data
@Entity
@Table(name = "portfolio")
public class Portfolio implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "portfolioId", nullable = false, unique = true)
	private long portfolioId;

	@Column(name = "portfolioName", nullable = false)
	private String portfolioName;

	@Column(name = "createTimeStamp")
	private LocalDate createTimeStamp;

	@Column(name = "modifyTimeStamp")
	private LocalDate modifyTimeStamp;

	@Column(name = "runningBalance")
	private int runningBalance = 10000;
}
