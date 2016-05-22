package Model;

public class LogData {
	private String caller_name;
	private boolean success;
	private String message;
	private int error_code;
	
	public LogData(String caller, boolean success, String msg, int code) {
		this.caller_name = caller;
		this.success = success;
		this.message = msg;
		this.error_code = code;
	}
	
	public String getMessage() {return this.message;}
	public int getErrorCode() {return this.error_code;}
	public String getCallerName() { return this.caller_name; }
	public boolean isProcessSuccess() { return this.success; }
}
