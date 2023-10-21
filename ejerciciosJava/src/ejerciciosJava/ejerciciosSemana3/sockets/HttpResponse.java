package ejerciciosJava.ejerciciosSemana3.sockets;

import java.io.Serializable;
import java.util.Map;

public class HttpResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String body;
	private Map<String, String> headers;
	private Integer httpStatus;
	
	public HttpResponse(String body, Map<String, String> headers, Integer httpStatus) {
		super();
		this.body = body;
		this.headers = headers;
		this.httpStatus = httpStatus;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Map<String, String> getHeaders() {
		return headers;
	}

	public void setHeaders(Map<String, String> headers) {
		this.headers = headers;
	}

	public Integer getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(Integer httpStatus) {
		this.httpStatus = httpStatus;
	}
}
