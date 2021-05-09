package eCommerceDemo.core.logger;

import eCommerceDemo.logger.EmailLog;

public class LoggerManagerAdapter implements LoggerService{
    @Override
    public void logToSystem(String message) {
        EmailLog emailLog = new EmailLog();
        emailLog.log(message);
    }
}
