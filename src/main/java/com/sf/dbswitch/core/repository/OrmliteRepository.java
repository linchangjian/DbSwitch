package com.sf.dbswitch.core.repository;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;
import com.sf.dbswitch.App;
import com.sf.dbswitch.core.db.IRepository;
import com.sf.dbswitch.core.db.ISimpleDataGet;
import com.sf.dbswitch.core.db.ormlite.DatabaseHelper;
import com.sf.dbswitch.core.db.ormlite.SimpleData;
import java.sql.SQLException;
import java.util.List;

public class OrmliteRepository implements IRepository {
  private DatabaseHelper databaseHelper = null;
  private final Dao<SimpleData, Integer> simpleDao;

  public OrmliteRepository() throws SQLException {
    simpleDao = getHelper().getSimpleDataDao();

  }

  /**
   * You'll need this in your class to get the helper from the manager once per class.
   */
  private DatabaseHelper getHelper() {
    if (databaseHelper == null) {
      databaseHelper = new DatabaseHelper(App.appContext);
    }
    return databaseHelper;
  }
  @Override
  public void addSimpleData(SimpleData data, ISimpleDataGet iSimpleDataGet) {
    try {
      int i = simpleDao.create(data);
      iSimpleDataGet.index(i);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void querySimpleData(SimpleData data, ISimpleDataGet iSimpleDataGet) {
    try {
      List<SimpleData> simpleDatas = simpleDao.queryForAll();
      iSimpleDataGet.Get(simpleDatas);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void release() {
    /*
		 * You'll need this in your class to release the helper when done.
		 */
    if (databaseHelper != null) {
      OpenHelperManager.releaseHelper();
      databaseHelper = null;
    }
  }
}
