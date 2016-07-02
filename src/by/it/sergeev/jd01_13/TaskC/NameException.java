package by.it.sergeev.jd01_13.TaskC;

public class NameException extends Exception {
    public NameException(){
    }
    public NameException(String message, Throwable exception){
        super(message,exception);
    }
    public NameException(String message){
        super(message);
    }
    public NameException(Throwable exception){
        super(exception);
    }
}

