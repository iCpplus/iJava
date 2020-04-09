package edu.zut.software.base.domain;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class BaseEntity<PK extends Serializable> extends BaseDomain {

	private static final long serialVersionUID = -6163675075289529459L;

	protected PK id;

//	@Override
//	public boolean equals(Object obj) {
//		if (null != obj) {
//			if (obj instanceof BaseEntity) {
//				BaseEntity domain = (BaseEntity) obj;
//				if (this.id == domain.id) {
//					return true;
//				}
//			}
//		}
//		return false;
//	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

	public PK getId() {
		return id;
	}

	public void setId(PK id) {
		this.id = id;
	}

}
