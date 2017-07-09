package com.sf.dbswitch.core.repository;

import com.sf.dbswitch.core.db.IRepository;

public class Repo {

  public static IRepository getInstance() {
    try {
      return new GreenDaoRepository();
    } catch (Exception e) {
      e.printStackTrace();
      throw new NullPointerException("the repo is null");
    }
  }
}
