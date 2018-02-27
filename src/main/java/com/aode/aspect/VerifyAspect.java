package com.aode.aspect;

import com.tools.exception.ServiceException;
import net.sf.json.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 审核切面
 *
 * @author moutian
 */
@Aspect
public class VerifyAspect {

    private static Logger logger = LogManager.getLogger(VerifyAspect.class);

    @Pointcut("execution(* com.aode.service.impl.*..*(..))")
    private void anyTransfer() {
        //nothing to do
    }

	/*暂时没有业务需要处理
     * @Before( "anyTransfer() && args( params )" )
	public void beforeVerify( JoinPoint joinPoint , JSONObject params ) throws ServiceException{
		System.out.println( "====before==" );
	}*/

    @After("anyTransfer() && args( params )")
    public void afterVerify(/*JoinPoint joinPoint ,*/ JSONObject params) throws ServiceException {
        logger.info("----------do some thing--------------");


    }

/*    //    	暂时没有业务需要处理
    @After("anyTransfer() && args( params )")
    public void beforeVerify(JoinPoint joinPoint, JSONObject params) throws ServiceException {
        logger.info("================after=================");
    }*/

}
