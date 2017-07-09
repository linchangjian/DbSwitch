package com.sf.dbswitch.core.repository;

import com.sf.dbswitch.App;
import com.sf.dbswitch.core.db.IRepository;
import com.sf.dbswitch.core.db.ISimpleDataGet;
import com.sf.dbswitch.core.db.ormlite.SimpleData;
import com.sf.greendao.gen.DaoSession;
import com.sf.greendao.gen.SimpleDataDao;
import java.util.List;

public class GreenDaoRepository implements IRepository {

  private final SimpleDataDao simpleDataDao;

  public GreenDaoRepository() {
    DaoSession daoSession = App.appContext.getDaoSession();
    simpleDataDao = daoSession.getSimpleDataDao();
  }

  @Override
  public void addSimpleData(SimpleData data, ISimpleDataGet iSimpleDataGet) {
    simpleDataDao.insert(data);
    iSimpleDataGet.index(0);
  }

  @Override
  public void querySimpleData(SimpleData data, ISimpleDataGet iSimpleDataGet) {
    List<SimpleData> list = simpleDataDao.queryBuilder().build().list();
    iSimpleDataGet.Get(list);
  }

  @Override
  public void release() {

  }
}
