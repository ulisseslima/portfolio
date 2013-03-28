package com.dvlcube.rmi;

/**
 * 
 * @author wonka
 * @since 28/01/2013
 */
public class MrBean {

	private int bar;
	private String foo;

	/**
	 * @return the bar
	 */
	public int getBar() {
		return bar;
	}

	/**
	 * @return the foo
	 */
	public String getFoo() {
		return foo;
	}

	/**
	 * @param bar
	 *            the bar to set
	 */
	public void setBar(final int bar) {
		this.bar = bar;
	}

	/**
	 * @param foo
	 *            the foo to set
	 */
	public void setFoo(final String foo) {
		this.foo = foo;
	}
}
