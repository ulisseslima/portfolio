package com.dvlcube.servlet;

/**
 * 
 * @author wonka
 * @since 09/08/2012
 */
public enum Processor {
	Option("com.dvlcube.servlet");
	private final String packageName;

	Processor(final String packageName) {
		this.packageName = packageName;
	}

	public final String getClassName() {
		return packageName.concat(".").concat(name());
	}
}
