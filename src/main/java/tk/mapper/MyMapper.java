package tk.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 自己的 Mapper
 *
 * 特别注意，该接口不能被扫描到，否则会出错
 * @Title:
 * @Description:
 * @auther: Administrator
 * @date: 2019/5/17 9:22
 */
public interface MyMapper<T> extends Mapper<T>,MySqlMapper<T> {

}
