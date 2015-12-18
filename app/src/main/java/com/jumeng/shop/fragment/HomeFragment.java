package com.jumeng.shop.fragment;

import android.view.View;

import com.jumeng.shop.R;
import com.jumeng.shop.db.dao.CacheModelDao;
import com.jumeng.shop.db.model.CacheModel;
import com.jumeng.shop.db.service.CacheService;
import com.jumeng.shop.db.util.DbCore;
import com.jumeng.shop.db.util.DbUtil;
import com.jumeng.shop.fragment.delegate.HomeDelegate;
import com.socks.library.KLog;

import java.util.List;

/**
 * ============================================================
 * 描 述 : 首页
 * 作 者 : 鸿浩
 * 时 间 : 2015/12/15.
 * ============================================================
 */
public class HomeFragment extends BaseFragment<HomeDelegate> implements View.OnClickListener {
    @Override
    protected Class<HomeDelegate> getDelegateClass() {
        return HomeDelegate.class;
    }

    CacheService mService;

    @Override
    protected void onBind() {
        super.onBind();
        DbCore.enableQueryBuilderLog();
        viewDelegate.getSave().setOnClickListener(this);
        viewDelegate.getQuery().setOnClickListener(this);
        mService = DbUtil.getCacheService();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.save:
                CacheModel model = new CacheModel();
                model.setJson("json" + System.currentTimeMillis());
                model.setName("name");
                model.setTime(System.currentTimeMillis());
                mService.save(model);
                break;
            case R.id.query:
                List<CacheModel> name = mService.queryBuilder().where(CacheModelDao.Properties.Name.eq("name")).list();
                for (CacheModel tm : name) {
                    KLog.e(tm.getJson());
                }
                break;
        }
    }
}
