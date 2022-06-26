package com.example.connectOracleDemo.repository;

import com.example.connectOracleDemo.repository.entity.CamIdDeviceToken;


import java.util.List;

public interface CamIdDeviceTokenDao {

    public int COUNT_ACCOUNT_CAMID(String sql);

    public int COUNT_ACCOUNT_CAMID_ISDN(String sql,List<String> isdns); // count camid by list phone number

    public int COUNT_ACCOUNT_CAMID_BY_ACCOUNTID(String sql,List<String> camid); //// count camid by list Acount ID

    public List<CamIdDeviceToken> GET_ACCOUNT_CAMID_METFONE(int count, int userSize, String SQL_GET_ACCOUNT_CAMID_METFONE);

    public List<CamIdDeviceToken> GET_ACCOUNT_CAMID_NON_METFONE(int count, int userSize, String SQL_GET_ACCOUNT_CAMID_NON_METFONE);

    public List<CamIdDeviceToken> GET_ACCOUNT_FID(int count, int userSize, String SQL_GET_ACCOUNT_FID);

    public List<CamIdDeviceToken> GET_ACCOUNT_GID(int count, int userSize, String SQL_GET_ACCOUNT_GID);

    public List<CamIdDeviceToken> GET_ACCOUNT_APPLEID(int count, int userSize, String SQL_GET_ACCOUNT_APPLEID);

    public List<CamIdDeviceToken> GET_ACCOUNT_CAMID_NON_LOGIN(int count, int userSize, String SQL_GET_ACCOUNT_CAMID_NON_LOGIN);

    public List<CamIdDeviceToken> GET_ACCOUNT_CAMID_NON_SIGNUP(int count, int userSize, String SQL_GET_ACCOUNT_CAMID_NON_SIGNUP);

    public List<CamIdDeviceToken> GET_ACCOUNT_CAMID_ALL(int count, int userSize, String SQL_GET_ACCOUNT_CAMID_ALL);

    public List<CamIdDeviceToken> GET_ACCOUNT_CAMID_ANDROID(int count, int userSize, String SQL_GET_ACCOUNT_CAMID_ANDROID);

    public List<CamIdDeviceToken> GET_ACCOUNT_CAMID_IOS(int count, int userSize, String SQL_GET_ACCOUNT_CAMID_IOS);

    public List<CamIdDeviceToken> GET_ACCOUNT_ISDN(int count, int userSize,List<String> isdns, String SQL_GET_ACCOUNT_ISDN);

    public List<CamIdDeviceToken> GET_ACCOUNT_CAMID(int count, int userSize,List<String> camid, String SQL_GET_ACCOUNT_CAMID);

}
