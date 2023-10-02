package cn.xiaobage.common.config;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author xiaobage
 * @package cn.xiaobage.common.config
 * @createTime 2023/10/01 - 21:51
 * @description
 */
@Slf4j
@Configuration
@MapperScan("cn.xiaobage.*.mapper")
public class MapperScanConfig {
}
