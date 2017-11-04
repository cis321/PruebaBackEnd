package co.rappi.backEndSumaMatriz.exceptions;


/**
 * The common interface implemented by all the exceptions handled by the system.
 * 
 * @author LeanFactory
 */
public interface IException  {

	
	 public static final int INTERNAL_BUSINESS_ERROR = 418;
	
	 public String getErrorId();
	    
	 public String getErrorCode();
    
	 public String getErrorMessage();

}