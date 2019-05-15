# Log
 - DEBUG < INFO < WARN < ERROR < FATAL
   - DEBUG
   - INFO
   - WARN - 경고로 주의가 필요한 상황에 사용합니다.
   - ERROR - 일반적으로 에러가 발생했을 때 사용합니다.
   - FATAL - 위험한 에러가 발생했을 때 사용합니다.
 
   
# Log4j 
 
 - private static Logger logger = Logger.getLogger(My.class);
 - logger.fatal("fatal()");
 - logger.error("error()");
 - logger.warn("warn()");
 - logger.info("info()");
 - logger.debug("debug()");
