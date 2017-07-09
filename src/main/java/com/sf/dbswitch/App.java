package com.sf.dbswitch;

import android.app.Application;
import com.sf.greendao.gen.DaoMaster;
import com.sf.greendao.gen.DaoMaster.DevOpenHelper;
import com.sf.greendao.gen.DaoSession;
import org.greenrobot.greendao.database.Database;

public class App extends Application {
  public static App appContext;
  /** A flag to show how easily you can switch from standard SQLite to the encrypted SQLCipher. */
  public static final boolean ENCRYPTED = true;
  private DaoSession daoSession;

  @Override
  public void onCreate() {
    super.onCreate();
    appContext = this;

    DevOpenHelper helper = new DevOpenHelper(this, ENCRYPTED ? "notes-db-encrypted" : "notes-db");
    Database db = ENCRYPTED ? helper.getEncryptedWritableDb("super-secret") : helper.getWritableDb();
    daoSession = new DaoMaster(db).newSession();
  }
  public DaoSession getDaoSession() {
    return daoSession;
  }
}
