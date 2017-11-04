package co.rappi.backEndSumaMatriz.exceptions;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class represents a technical exception handled by the system.
 * 
 * @author LeanFactory
 */
public class TechnicalException extends Throwable implements IException{

    /**
	 * 
	 */
	private static final long serialVersionUID = 2755649904071112509L;

    private final String errorId;
    
    private final String errorCode;
    
    private final String errorMessage;
    
    private final Exception exception;

    
    @JsonCreator
    public TechnicalException( @JsonProperty("errorCode") String errorCode,
    		@JsonProperty("errorMessage") String errorMessage) {

    	this.errorId = UUID.randomUUID().toString();
    	this.errorCode = errorCode;
    	this.errorMessage = errorMessage;
        this.exception = null;
    }
    
    @JsonCreator
    public TechnicalException( @JsonProperty("errorCode") String errorCode,
    		@JsonProperty("errorMessage") String errorMessage,
    		@JsonProperty("exception") Exception exception) {
        
    	this.errorId = UUID.randomUUID().toString();
    	this.errorCode = errorCode;
    	this.errorMessage = errorMessage;
        this.exception = exception;
    }
    
    

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getErrorId() {
		return errorId;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public Exception getException() {
		return exception;
	}

    


}