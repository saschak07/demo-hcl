package start.myprojectbe.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "audit")
public class Audit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "auditId", nullable = false, unique = true)
	private long auditId;

	//	@OneToOne
	//	@JoinColumn(name = "orderRefNo")
	//	private Order order;
	@Column(name = "orderRefNo", nullable = false)
	private int orderRefNo;

	//	@OneToOne
	//	@JoinColumn(name = "portfolioId")
	//	private Portfolio portfolio;
	@Column(name = "portfolioId", nullable = false)
	private int portfolioId;

	@Column(name = "transactionType", nullable = false)
	private String transactionType;

	@Column(name = "transactionAmount", nullable = false)
	private int transactionAmount;

	@Column(name = "createTimeStamp")
	private LocalDate createTimeStamp;

	@Column(name = "modifyTimeStamp")
	private LocalDate modifyTimeStamp;
}
