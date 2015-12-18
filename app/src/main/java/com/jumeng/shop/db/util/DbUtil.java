package com.jumeng.shop.db.util;

import com.jumeng.shop.db.dao.CacheModelDao;
import com.jumeng.shop.db.service.CacheService;

/**
 * ============================================================
 * 描 述 :
 * 作 者 : 鸿浩
 * 时 间 : 2015/12/18.
 * ============================================================
 */
public class DbUtil {
    private static CacheService cacheService;

    private static CacheModelDao getCardDao() {
        return DbCore.getDaoSession().getCacheModelDao();
    }

    public static CacheService getCacheService() {
        if (cacheService == null) {
            cacheService = new CacheService(getCardDao());
        }
        return cacheService;
    }
}
