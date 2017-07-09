package com.sf.dbswitch.core.db;

import com.sf.dbswitch.core.db.ormlite.SimpleData;

public interface IRepository {

  void addSimpleData(SimpleData data, ISimpleDataGet iSimpleDataGet);
  void querySimpleData(SimpleData data, ISimpleDataGet iSimpleDataGet);

  void release();
}
