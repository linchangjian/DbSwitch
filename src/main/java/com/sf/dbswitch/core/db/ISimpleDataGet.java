package com.sf.dbswitch.core.db;

import com.sf.dbswitch.core.db.ormlite.SimpleData;
import java.util.List;

public interface ISimpleDataGet {
  void Get(SimpleData data);

  void Get(List<SimpleData> data);

  void index(int index);
}
