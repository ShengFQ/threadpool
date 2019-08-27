package demo.shengfq.logger;
public class Logger {

    public static void debug(String message) {
        StackTraceElement[] stackTraceElements = (new Throwable()).getStackTrace();
        StackTraceElement stackTraceElement = stackTraceElements[1];
        String className = stackTraceElement.getClassName();
        String fileName = stackTraceElement.getFileName();
        String methodName = stackTraceElement.getMethodName();
        int lineNumber = stackTraceElement.getLineNumber();
        System.out.println(className + "." + methodName + "(" + fileName + "/" + lineNumber + ")" + message);
    }
}