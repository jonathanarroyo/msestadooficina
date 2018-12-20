/**
 * 
 */
package com.bdg.dashboard.reponse;

import java.io.Serializable;

/**
 * @author programador
 * @date 7/12/2018
 * @description GeneralResponse.java
 */

public class GeneralResponse<T> implements Serializable {

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 2975454650689834772L;

	/**
	 * The result data to response
	 */
	private T data;

	/**
	 * The result of operation
	 */
	private boolean success;

	/**
	 * The result message
	 */
	private String message;
	
	/**
	 * Informacion cuando se presenta error
	 */
	//private ApiError apiError;
	
	/**
	 * Constructor
	 */
	public GeneralResponse() {
	}
	
	/**
	 * Constructor
	 */
	public GeneralResponse(boolean success, String message) {
		this.success = success;
		this.message = message;
	}
	
	/**
	 * Constructor
	 */
	public GeneralResponse(boolean success, String message, T data) {
		this.success = success;
		this.message = message;
		this.data = data;
	}

	/**
	 * Gets the data
	 * 
	 * @return the data value
	 */
	public T getData() {
		return data;
	}

	/**
	 * Gets the success
	 * 
	 * @return the success value
	 */
	public boolean isSuccess() {
		return success;
	}

	/**
	 * Gets the message
	 * 
	 * @return the message value
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Sets the data value
	 * 
	 * @param data
	 *            the data to set
	 */
	public void setData(T data) {
		this.data = data;
	}

	/**
	 * Sets the success value
	 * 
	 * @param success
	 *            the success to set
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}

	/**
	 * Sets the message value
	 * 
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/*public ApiError getApiError() {
		return apiError;
	}

	public void setApiError(ApiError apiError) {
		this.apiError = apiError;
	}*/

}
