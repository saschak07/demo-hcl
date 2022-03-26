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
@Table(name = "asset")
public class Asset implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "assetId", nullable = false, unique = true)
	private long portfolioId;

	@Column(name = "securityName", nullable = false)
	private String securityName;

	@Column(name = "companyName", nullable = false)
	private String companyName;

	@Column(name = "stockPrice", nullable = false)
	private int stockPrice;

	@Column(name = "createTimeStamp")
	private LocalDate createTimeStamp;

	@Column(name = "modifyTimeStamp")
	private LocalDate modifyTimeStamp;
}
