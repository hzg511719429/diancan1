package com.zknu.shop.common.mapper;

import com.zknu.shop.common.pojo.Productimg;
import com.zknu.shop.common.pojo.ProductimgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductimgMapper {
    int countByExample(ProductimgExample example);

    int deleteByExample(ProductimgExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Productimg record);

    int insertSelective(Productimg record);

    List<Productimg> selectByExample(ProductimgExample example);

    Productimg selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Productimg record, @Param("example") ProductimgExample example);

    int updateByExample(@Param("record") Productimg record, @Param("example") ProductimgExample example);

    int updateByPrimaryKeySelective(Productimg record);

    int updateByPrimaryKey(Productimg record);
}