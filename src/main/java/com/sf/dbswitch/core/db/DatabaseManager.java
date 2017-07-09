package com.sf.dbswitch.core.db;

public class DatabaseManager {

  private volatile DatabaseManager mInstance = null;

  private DatabaseManager() {

  }

  public DatabaseManager getInstance() {
    if (mInstance == null) {
      synchronized (DatabaseManager.class) {
        if (mInstance == null) {
          mInstance = new DatabaseManager();
        }
      }
    }
    return mInstance;
  }

  //初始化不同的数据库
  public void init() {

  }
  //数据库升级用
  public void update(){
    //建表
    //内容迁移
    //删表
    //改表

  }
}
