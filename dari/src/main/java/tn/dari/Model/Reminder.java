package tn.dari.Model;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;



@Entity(name = "Reminder")
public class Reminder {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long remId;
	private String remMessage;
	@ManyToOne(fetch = FetchType.LAZY)
	private User emp;
	private LocalDateTime dueTime;
	private boolean active;

	public Reminder() {
		super();
	}
	public Reminder(Long remId, String remMessage, User emp, LocalDateTime dueTime, boolean active) {
		super();
		this.remId = remId;
		this.remMessage = remMessage;
		this.emp = emp;
		this.dueTime = dueTime;
		this.active = active;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (active ? 1231 : 1237);
		result = prime * result + ((dueTime == null) ? 0 : dueTime.hashCode());
		result = prime * result + ((emp == null) ? 0 : emp.hashCode());
		result = prime * result + ((remId == null) ? 0 : remId.hashCode());
		result = prime * result + ((remMessage == null) ? 0 : remMessage.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Reminder other = (Reminder) obj;
		if (active != other.active) {
			return false;
		}
		if (dueTime == null) {
			if (other.dueTime != null) {
				return false;
			}
		} else if (!dueTime.equals(other.dueTime)) {
			return false;
		}
		if (emp == null) {
			if (other.emp != null) {
				return false;
			}
		} else if (!emp.equals(other.emp)) {
			return false;
		}
		if (remId == null) {
			if (other.remId != null) {
				return false;
			}
		} else if (!remId.equals(other.remId)) {
			return false;
		}
		if (remMessage == null) {
			if (other.remMessage != null) {
				return false;
			}
		} else if (!remMessage.equals(other.remMessage)) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		return "Reminder [remId=" + remId + ", remMessage=" + remMessage + ", emp=" + emp + ", dueTime=" + dueTime
				+ ", active=" + active + "]";
	}

	public Long getRemId() {
		return remId;
	}

	public void setRemId(Long remId) {
		this.remId = remId;
	}

	public String getRemMessage() {
		return remMessage;
	}

	public void setRemMessage(String remMessage) {
		this.remMessage = remMessage;
	}

	public User getEmp() {
		return emp;
	}

	public void setEmp(User emp) {
		this.emp = emp;
	}

	public LocalDateTime getDueTime() {
		return dueTime;
	}

	public void setDueTime(LocalDateTime dueTime) {
		this.dueTime = dueTime;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
}