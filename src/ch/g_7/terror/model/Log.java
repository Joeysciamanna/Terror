package ch.g_7.terror.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "log")
public class Log implements Serializable {

	private static final long serialVersionUID = 21408761231288809L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "short_name")
	private String shortName;

	@Column(name = "description")
	private String description;

	@Column(name = "location")
	private String location;

	@Column(name = "creation_time")
	private Date creationTime;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "severity_id")
	private Severity severity;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "application_id")
	private Application application;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}

	public Date getCreationTime() {
		return creationTime;
	}
	
	public String getFormatedCreationDate() {
		return new SimpleDateFormat("dd.MM.yy HH:mm").format(creationTime);
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}
	
	public Severity getSeverity() {
		return severity;
	}
	
	public void setSeverity(Severity severity) {
		this.severity = severity;
	}

	public Application getApplication() {
		return application;
	}
	
	public void setApplication(Application application) {
		this.application = application;
	}
}
