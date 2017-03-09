package com.tenable.io.core.utilities;


import com.tenable.io.core.utilities.models.LogLevel;
import org.slf4j.Logger;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class LoggerHelper {
    public static LogLevel getLogLevel( Logger logger ) {
        if( logger.isTraceEnabled() )
            return LogLevel.TRACE;
        else if( logger.isDebugEnabled() )
            return LogLevel.DEBUG;
        else if( logger.isInfoEnabled() )
            return LogLevel.INFO;
        else if( logger.isWarnEnabled() )
            return LogLevel.WARN;
        else if( logger.isErrorEnabled() )
            return LogLevel.ERROR;

        return LogLevel.NONE;
    }
}
