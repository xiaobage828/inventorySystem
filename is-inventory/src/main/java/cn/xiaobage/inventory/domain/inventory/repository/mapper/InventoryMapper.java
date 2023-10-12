package cn.xiaobage.inventory.domain.inventory.repository.mapper;

import cn.xiaobage.inventory.domain.inventory.repository.po.InventoryPO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.time.LocalDate;

/**
 * <p>
 * 库存 Mapper 接口
 * </p>
 *
 * @author xiaobage
 * @since 2023年10月05日
 */
@Mapper
public interface InventoryMapper extends BaseMapper<InventoryPO> {

    @Update("update inventory set total_quantity = total_quantity + #{quantity}, update_time = #{updateTime} where id = #{inventoryId}")
    int inventoryIncrement(@Param("inventoryId") Long inventoryId,@Param("quantity") Integer quantity,@Param("updateTime") LocalDate updateTime);

    @Update("update inventory set total_quantity = total_quantity - #{quantity}, update_time = #{updateTime} where id = #{inventoryId}")
    int inventoryDecrement(@Param("inventoryId") Long inventoryId,@Param("quantity") Integer quantity,@Param("updateTime") LocalDate updateTime);
}
