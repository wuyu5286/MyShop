package com.jumeng.shop.db.util;

import com.jumeng.shop.db.dao.TestModelDao;
import com.jumeng.shop.db.service.TestService;

/**
 * ============================================================
 * 描 述 :
 * 作 者 : 鸿浩
 * 时 间 : 2015/12/18.
 * ============================================================
 */
public class DbUtil {
    private static TestService testService;

    private static TestModelDao getCardDao() {
        return DbCore.getDaoSession().getTestModelDao();
    }

    public static TestService getTestService() {
        if (testService == null) {
            testService = new TestService(getCardDao());
        }
        return testService;
    }
}
