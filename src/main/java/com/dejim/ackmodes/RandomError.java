package com.dejim.ackmodes;

import java.util.Random;

import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RandomError implements Callable{

	private static final Logger logger = LoggerFactory.getLogger(RandomError.class);
	
	@Override
    public Object onCall(MuleEventContext eventContext) throws Exception {
            int randomInt = new Random().nextInt(100);
            
            logger.info("Random Int " + randomInt);
            
            if (randomInt > 66) {
                    throw new IllegalStateException("This should be retried");
            } else if (randomInt > 33) {
                    throw new UnsupportedOperationException("This should not be retried");
            } else {
                    return eventContext;
            }
    }
	
}
