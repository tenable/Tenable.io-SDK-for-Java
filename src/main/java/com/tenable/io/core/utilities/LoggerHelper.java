package com.tenable.io.core.utilities;


import com.tenable.io.core.utilities.models.LogLevel;

import lombok.extern.slf4j.Slf4j;

/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
@Slf4j
public class LoggerHelper {
    public static LogLevel getLogLevel() {
        if( log.isTraceEnabled() )
            return LogLevel.TRACE;
        else if( log.isDebugEnabled() )
            return LogLevel.DEBUG;
        else if( log.isInfoEnabled() )
            return LogLevel.INFO;
        else if( log.isWarnEnabled() )
            return LogLevel.WARN;
        else if( log.isErrorEnabled() )
            return LogLevel.ERROR;

        return LogLevel.NONE;
    }
}
