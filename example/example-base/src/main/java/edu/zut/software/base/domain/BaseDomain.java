package edu.zut.software.base.domain;

import java.io.Serializable;

/**
 * 
 * base abstract class for model objects. Child objects should implement
 * toString() equals() hashCode()
 * 
 * @author KouShiXiang
 *
 */
@SuppressWarnings("serial")
public abstract class BaseDomain implements Serializable {

	/**
	 * to compare objects whether or not same
	 * 
	 * @param o
	 * 
	 * @return true/false if same return true,else false
	 */
	public abstract boolean equals(Object o);

	/**
	 * 
	 * @return hashCode
	 */
	public abstract int hashCode();

	/**
	 * Returns a multi-line String with key=value pairs.
	 * 
	 * @return a String representation of this class.
	 */
	public abstract String toString();

}
