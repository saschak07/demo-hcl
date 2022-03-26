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
@Table(name = "orders")
public class Order implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "orderRefNo", nullable = false, unique = true)
	private long orderRefNo;

	//	@OneToOne
	//	@JoinColumn(name = "portfolioId")
	//	private Portfolio portfolio;
	@Column(name = "portfolioId", nullable = false)
	private int portfolioId;

	//	@OneToOne
	//	@JoinColumn(name = "assetId")
	//	private Asset asset;
	@Column(name = "assetId", nullable = false)
	private int assetId;

	@Column(name = "orderStatus", nullable = false)
	private String orderStatus;

	@Column(name = "orderPrice", nullable = false)
	private int orderPrice;

	@Column(name = "orderQty", nullable = false)
	private int orderQty;

	@Column(name = "orderDate")
	private LocalDate orderDate;

	@Column(name = "createTimeStamp")
	private LocalDate createTimeStamp;

	@Column(name = "modifyTimeStamp")
	private LocalDate modifyTimeStamp;
}
