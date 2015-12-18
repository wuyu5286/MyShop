package com.jumeng.shop.db.service;

import com.jumeng.shop.db.model.TestModel;

import de.greenrobot.dao.AbstractDao;

/**
 * ============================================================
 * 描 述 :
 * 作 者 : 鸿浩
 * 时 间 : 2015/12/18.
 * ============================================================
 */
public class TestService extends BaseService<TestModel,Long> {
    public TestService(AbstractDao dao) {
        super(dao);
    }
}
