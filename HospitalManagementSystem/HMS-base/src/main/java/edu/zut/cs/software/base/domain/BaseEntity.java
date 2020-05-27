package edu.zut.cs.software.base.domain;

/**
 * BaseEntity for each model
 * 
 * @author shishuqian
 */
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@MappedSuperclass
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
@Access(value = AccessType.FIELD)
public class BaseEntity<PK extends Serializable> extends BaseDomain {

	/**
	 *
	 */
	private static final long serialVersionUID = -6163675075289529459L;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATECREATED")
	protected Date dateCreated = new Date();

	/**
	 * 实体修改时间
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATEMODIFIED")
	protected Date dateModified = new Date();

	/**
	 * 实体是否被删除
	 */
	@Column(name = "DELETED")
	protected Boolean deleted;

	@Column(name = "ENTITY_NAME")
	protected String entityName;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected PK id;

	@Version
	@Access(AccessType.FIELD)
	private long version;

	@Override
	public boolean equals(Object obj) {
		if (null != obj) {
			if (obj instanceof BaseEntity) {
				@SuppressWarnings("unchecked")
				BaseEntity<PK> domain =  (BaseEntity<PK>) obj;
				if (this.id == domain.id) {
					return true;
				}
			}
		}
		return false;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public Date getDateModified() {
		return dateModified;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public String getEntityName() {
		return entityName;
	}

	public PK getId() {
		return id;
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this.id);
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public void setDateModified(Date dateModified) {
		this.dateModified = dateModified;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public void setId(PK id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

}
