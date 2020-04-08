package edu.zut.software.base.domain;

import base.domain.BaseEntity;

public class BaseEntity extends BaseDomain {
	@Override
	public boolean equals(Object obj) {
		if (null != obj) {
			if (obj instanceof BaseEntity) {
				BaseEntity domain = (BaseEntity) obj;
				if (this.id == domain.id) {
					return true;
				}
			}
		}
		return false;
	}
}
