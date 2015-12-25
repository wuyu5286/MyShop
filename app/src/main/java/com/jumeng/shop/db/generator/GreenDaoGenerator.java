package com.jumeng.shop.db.generator;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

/**
 * ============================================================
<<<<<<< Updated upstream
 * 描 述 :
 * 作 者 : 鸿浩
 * 时 间 : 2015/12/18.
=======
 * 描 述 : 用来为GreenDao框架生成Dao文件
 * 作 者 : 鸿浩
 * 时 间 : 2015/12/17.
>>>>>>> Stashed changes
 * ============================================================
 */
public class GreenDaoGenerator {
    //辅助文件生成的相对路径
    public static final String DAO_PATH = "./app/src/main/java";
    //辅助文件的包名
    public static final String MODEL_NAME = "com.jumeng.shop.db.model";
    public static final String DAO_NAME = "com.jumeng.shop.db.dao";
    //数据库的版本号
    public static final int DATA_VERSION_CODE = 1;

    public static void main(String[] args) throws Exception {
        Schema schema = new Schema(DATA_VERSION_CODE, MODEL_NAME);
        schema.setDefaultJavaPackageDao(DAO_NAME);
        schema.enableKeepSectionsByDefault();
        addCache(schema, "CacheModel");
        //生成Dao文件路径
        new DaoGenerator().generateAll(schema, DAO_PATH);
    }

    /**
     * 添加不同的缓存表
     * @param schema
     * @param tableName
     */
    private static void addCache(Schema schema, String tableName) {
        Entity cache = schema.addEntity(tableName);
        //主键id自增长
        cache.addIdProperty().primaryKey().autoincrement();
        cache.addStringProperty("name");
        //请求结果
        cache.addStringProperty("json");
        //插入时间，暂时无用
        cache.addLongProperty("time");
    }
}
