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
	@Column(name = "id", nullable = false, unique = true)
	private long id;

	@Column(name = "employeeId", nullable = false, unique = true)
	private String employeeId;

	@Column(name = "employeeName", nullable = false)
	private String employeeName;

	@Column(name = "createdDate")
	private LocalDate createdDate;

	@Column(name = "updateDate")
	private LocalDate updateDate;

	@Column(name = "createdByUser")
	private String createdByUser;

	@Column(name = "updateByUser")
	private String updateByUser;
}
