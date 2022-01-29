package cool.tdl.seckill.utils;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;


/**
 * @Author tdl
 * @Date 2022/1/5 23:05
 * @description 代码自动生成工具类
 * @Version 1.0
 */
public class AutoCode {
    public static void main(String[] args) {

        //构建代码生成器对象
        AutoGenerator autoGenerator = new AutoGenerator();
        /*配置策略*/
        //全局配置
        GlobalConfig config = new GlobalConfig();
        //代码生成的目录
        String path = System.getProperty("user.dir");
        //设置代码最终输出的目录
        config.setOutputDir(path + "/src/main/java");
        //设置作者
        config.setAuthor("tdl");
        //配置是否打开目录，false 为不打开
        config.setOpen(false);
        //是否覆盖已有的
        config.setFileOverride(false);
        //去除service前缀
        config.setServiceName("%sService");
        //主键
        config.setIdType(IdType.ID_WORKER);//默认的
        //设置时间类型
        config.setDateType(DateType.ONLY_DATE);//只显示日期
        //是否生成Swagger文档
        config.setSwagger2(true);
        //设置策略
        autoGenerator.setGlobalConfig(config);
        /*设置数据源*/
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver"); //驱动
        dataSourceConfig.setUrl("jdbc:mysql://47.103.142.24:3306/seckill?serverTimezone=UTC");  //连接地址
        dataSourceConfig.setUsername("seckill"); //数据库名
        dataSourceConfig.setPassword("123456"); //数据库密码
        dataSourceConfig.setDbType(DbType.MYSQL);   //数据库类型
        //设置数据源
        autoGenerator.setDataSource(dataSourceConfig);
        /*项目包的配置*/
        PackageConfig packageConfig = new PackageConfig();
//        packageConfig.setModuleName("tdl");//模块名
        packageConfig.setParent("cool.tdl.seckill");//设置父目录
        packageConfig.setEntity("entity");//实体类包名
        packageConfig.setMapper("mapper");//mapper映射文件包名
        packageConfig.setService("service");//业务接口包名
        packageConfig.setServiceImpl("service.Impl");//业务层实现类包名
        packageConfig.setController("controller");//控制层包名
        //添加项目包配置
        autoGenerator.setPackageInfo(packageConfig);
        /*策略配置*/
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setInclude("t_goods","t_order","t_seckill_goods","t_seckill_order");//表名
        strategyConfig.setTablePrefix("t_");
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);//配置数据表与实体类名之间映射的策略
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);//配置数据表的字段与实体类的属性名之间映射的策略
        strategyConfig.setEntityLombokModel(true);//是否启用Lombok
        strategyConfig.setLogicDeleteFieldName("deleted");//逻辑删除字段名
        TableFill field1 = new TableFill("createTime", FieldFill.INSERT);//自动填充的字段 -数据插入时间
        TableFill field2 = new TableFill("updateTime", FieldFill.INSERT_UPDATE);//自动填充的字段 -数据修改时间
        //自动填充配置集合
        ArrayList<TableFill> list = new ArrayList<>();
        list.add(field1);
        list.add(field2);
        strategyConfig.setTableFillList(list);
        strategyConfig.setVersionFieldName("version");//乐观锁
        strategyConfig.setRestControllerStyle(true);//配置 rest风格的控制器
        strategyConfig.setControllerMappingHyphenStyle(true);//配置驼峰转连字符
        //添加策略配置
        autoGenerator.setStrategy(strategyConfig);
        //执行
        autoGenerator.execute();
    }
}