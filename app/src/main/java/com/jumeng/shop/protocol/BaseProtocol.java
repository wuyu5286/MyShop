package com.jumeng.shop.protocol;

import com.jumeng.shop.constant.Constans;
import com.jumeng.shop.utils.IOUtils;
import com.socks.library.KLog;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Map;

/**
 * ============================================================
 * 描 述 :
 * 作 者 : 鸿浩
 * 时 间 : 2015/12/16.
 * ============================================================
 */
public abstract class BaseProtocol<Data> {

    public Data loadData(String url) {
        //1.到本地中去缓存数据
        Data data = getDataFromLocal(url);
        if (data != null) {
            KLog.d("使用本地缓存");
            return data;
        }
        return getDataFromNet(url);
    }

    /**
     * 去本地获取缓存
     */
    private Data getDataFromLocal(String url) {
        File file = getCacheFile(url);
        if (!file.exists()) return null;//如果不存在
        //读取file,拿到json字符
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String timeString = reader.readLine();//第一行:时间戳
            long time = Long.valueOf(timeString);

            if (System.currentTimeMillis() > (time + Constans.REFRESH_DELAY)) {
                return null;//数据过期,无效
            }
            //将json解析返回
            String json = reader.readLine();//第二行:json
            return parseJson(json);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            IOUtils.close(reader);
        }
    }

    private File getCacheFile(String url) {
        return null;
    }

    private Data getDataFromNet(String url) {
        return null;
    }

    private String getName() {
        String name = null;
        Map<String, String> params = getParams();
        if (params != null) {
            StringBuffer sb = new StringBuffer();
            for (Map.Entry<String, String> me : params.entrySet()) {
                sb.append("_" + me.getValue());
            }
            name = getKey() + sb.toString();
        } else {
            name = getKey();
        }
        return name;
    }

    protected abstract String getKey();

    protected abstract Map<String, String> getParams();

    protected abstract Data parseJson(String json);
}
