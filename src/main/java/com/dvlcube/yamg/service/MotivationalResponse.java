package com.dvlcube.yamg.service;

/**
 * 
 * @author wonka
 * @since 10/09/2012
 */
public class MotivationalResponse {
	private final boolean success;

	public MotivationalResponse(final boolean success) {
		this.success = success;
	}

	/**
	 * @return the success
	 */
	public boolean isSuccess() {
		return success;
	}
}
