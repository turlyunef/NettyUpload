package ru.turlyunef.core.response;

/**
 * @author Turlyun
 *         Possible values of the status for transferred file to the server
 */
public enum Status {
	Ok("ok"), ErrorUpload("error-upload"), ErrorMD5("error-md5"), Progress("progress"), Done("done");
	
	private String value;

	Status(String v) {
		value = v;
	}
	public String getValue() {
		return this.value;
	}

}
