/**
 * Copyright (c) 2020 All Rights Reserved.
 */
package com.example.ktormjdk8.conf

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import kotlin.Exception

/**
 * @author owen
 * @version $$Id: ControllerExceptionHandler, v 0.1 2020/12/9 上午10:31 owen Exp $$
 */
@ControllerAdvice
class ExceptionAdviceHandler {

    companion object {
        private val LOGGER = LoggerFactory.getLogger(ExceptionAdviceHandler::class.java)
    }

    @ResponseBody
    @ExceptionHandler(value = [Exception::class])
    fun errorHandler(e: Exception): kotlin.String {
        LOGGER.error("ControllerExceptionHandler#errorHandler msg [" + e.message + "]", e)
        return "error"
    }


}