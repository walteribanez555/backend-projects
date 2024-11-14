package demo.walter.projectsapp.response;

public class ResponseWrapper<T> {
    private T data;
    private String errorMessage;
    private int status;

    // Constructors
    public ResponseWrapper(T data, int status) {
        this.data = data;
        this.status = status;
        this.errorMessage = null;
    }

    public ResponseWrapper(String errorMessage, int status) {
        this.data = null;
        this.status = status;
        this.errorMessage = errorMessage;
    }

    // Getters and setters
    public T getData() {
        return data;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public int getStatus() {
        return status;
    }
}