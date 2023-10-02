package cn.xiaobage.common.handler;

import cn.xiaobage.config.exception.IsCodeException;
import cn.xiaobage.config.exception.IsException;
import cn.xiaobage.config.exception.TokenAuthException;
import cn.xiaobage.config.vo.FailInfo;
import com.mysql.cj.jdbc.exceptions.MysqlDataTruncation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

/**
 * @author xiaobage
 * @package cn.xiaobage.common.handler
 * @createTime 2023/10/01 - 16:01
 * @description
 */
@Slf4j
@RestControllerAdvice
public class SysExceptionHandler {

    /**
     * 最大的兜底错误处理
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public FailInfo exception(Exception ex) {
        log.error("Exception_info:{}", ex.getMessage());
        log.error("Exception_info:", ex);
        FailInfo failInfo = FailInfo.builder().exception(ex.getMessage()).build();
        return failInfo;
    }

    /**
     * 参数绑定错误
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(value = BindException.class)
    public FailInfo exception(BindException ex) {
        String defaultMessage = Objects.requireNonNull(ex.getBindingResult().getFieldError()).getDefaultMessage();
        log.error("Exception_info:{}", defaultMessage);
        log.error("Exception_info:", ex);
        FailInfo failInfo = FailInfo.builder().exception(defaultMessage).build();
        return failInfo;
    }

    @ExceptionHandler(value = IsCodeException.class)
    public FailInfo ldCodeException(IsCodeException ex) {
        log.error("Exception_info:{}", ex.getMessage());
        log.error("Exception_info:", ex);
        FailInfo failInfo = new FailInfo(ex.getCode(), ex.getMessage());
        return failInfo;
    }

    @ExceptionHandler(value = IsException.class)
    public FailInfo sysException(Exception ex) {
        log.error("Exception_info:{}", ex.getMessage());
        log.error("Exception_info:", ex);
        FailInfo failInfo = FailInfo.builder().exception(ex.getMessage()).build();
        return failInfo;
    }

    @ExceptionHandler(value = TokenAuthException.class)
    public FailInfo tokenAuthException(Exception ex) {
        log.error("Exception_info:{}", ex.getMessage());
        log.error("Exception_info:", ex);
        FailInfo failInfo = FailInfo.builder().exception(ex.getMessage()).build();
        return failInfo;
    }


    @ExceptionHandler(value = MysqlDataTruncation.class)
    public FailInfo mysqlDataTruncation(Exception ex) {
        log.error("Exception_info:{}", ex.getMessage());
        log.error("Exception_info:", ex);
        return new FailInfo(500, ex.getMessage());
    }

    @ExceptionHandler(value = DataIntegrityViolationException.class)
    public FailInfo dataIntegrityViolationException(Exception ex) {
        log.error("Exception_info:{}", ex.getMessage());
        log.error("Exception_info:", ex);
        String message = ex.getMessage();
        String[] split = message.split("\r\n###");
        for (String str : split) {
            if (StringUtils.isBlank(str.trim()) || str.trim().contains("Error")){
                continue;
            }
            String[] split1 = str.split(":");
            if (split1.length > 0) {
                message = split1[split1.length - 1].trim();
            }
        }
        return new FailInfo(500, message);
    }
}
