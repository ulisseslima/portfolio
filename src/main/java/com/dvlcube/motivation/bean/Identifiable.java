package com.dvlcube.motivation.bean;

import java.io.Serializable;

/**
 * 
 * @author wonka
 * @since 11/09/2012
 */
public interface Identifiable extends Serializable {
	Serializable getId();

	String getLabel();
}
