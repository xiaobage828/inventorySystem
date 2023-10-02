package cn.xiaobage.config.util;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import cn.xiaobage.config.exception.IsException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.CharEncoding;

import java.io.FileInputStream;

/**
 * @author xiaobage
 * @package cn.xiaobage.config.util
 * @createTime 2022/12/7 - 23:56
 * @description
 */
@Slf4j
public class FileLoad {

    public static String read(String fileName) {
        String val = "";
        try {
            val = IoUtil.read(new FileInputStream(FileUtil.file(fileName)), CharEncoding.UTF_8);
        } catch (Exception e) {
            //错误处理
            log.error("文件路径读取失败：{}", fileName, e);
            throw new IsException(String.format("文件路径读取失败: %s", fileName));
        }
        return val;
    }
}
