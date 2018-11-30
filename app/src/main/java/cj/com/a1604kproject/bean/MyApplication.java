package cj.com.a1604kproject.bean;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import cj.com.a1604kproject.greendao.DaoMaster;
import cj.com.a1604kproject.greendao.DaoSession;

public class MyApplication extends Application {
    private final static  String DB_NAME = "test.db";
    private static DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        initGreenDao();
    }

    private void initGreenDao() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, DB_NAME);
        SQLiteDatabase db = devOpenHelper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
    }

    public static DaoSession getDaoSession(){
        return daoSession;
    }
}
