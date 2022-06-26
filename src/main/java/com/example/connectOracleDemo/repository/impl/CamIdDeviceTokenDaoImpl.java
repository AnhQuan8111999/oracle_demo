package com.example.connectOracleDemo.repository.impl;

import com.example.connectOracleDemo.repository.CamIdDeviceTokenDao;
import com.example.connectOracleDemo.repository.entity.CamIdDeviceToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Repository
public class CamIdDeviceTokenDaoImpl implements CamIdDeviceTokenDao {

    private static Logger logger = LoggerFactory.getLogger(CamIdDeviceTokenDao.class);

    @Autowired
    @Qualifier("CamIdOracleJdbcTempalte")
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public int COUNT_ACCOUNT_CAMID(String SQL) {
        int result = 0;
        try{
            result=jdbcTemplate.queryForObject(SQL, new MapSqlParameterSource(), Integer.class);
        }catch (Exception e){
            logger.info("COUNT_ACCOUNT_CAMID_METFONE |EXCEPTION : "+e.getMessage());
        }
        return result;
    }

    @Override
    public int COUNT_ACCOUNT_CAMID_ISDN(String SQL ,List<String> isdns) {
        int result = 0;
        try{
            result=jdbcTemplate.queryForObject(SQL, new MapSqlParameterSource().addValue("isdn",isdns), Integer.class);
        }catch (Exception e){
            logger.info("COUNT_ACCOUNT_CAMID_METFONE |EXCEPTION : "+e.getMessage());
        }
        return result;
    }

    @Override
    public int COUNT_ACCOUNT_CAMID_BY_ACCOUNTID(String SQL, List<String> camid) {
        int result = 0;
        try{
            result=jdbcTemplate.queryForObject(SQL, new MapSqlParameterSource().addValue("camid",camid), Integer.class);
        }catch (Exception e){
            logger.info("COUNT_ACCOUNT_CAMID_METFONE |EXCEPTION : "+e.getMessage());
        }
        return result;
    }

    @Override
    public List<CamIdDeviceToken> GET_ACCOUNT_CAMID_METFONE(int count, int userSize, String SQL_GET_ACCOUNT_CAMID_METFONE) {

        List<CamIdDeviceToken> camId = new ArrayList<>();
        try {
            camId = jdbcTemplate.query(SQL_GET_ACCOUNT_CAMID_METFONE,new MapSqlParameterSource()
                            .addValue("offset", count * userSize)
                            .addValue("limit", userSize),
                    new RowMapper<CamIdDeviceToken>() {
                @Override
                public CamIdDeviceToken mapRow(ResultSet rs, int rowNum) throws SQLException {
                    CamIdDeviceToken camId = new CamIdDeviceToken();
                    camId.setId(rs.getLong("ID"));
                    camId.setCam_id(rs.getLong("CAM_ID"));
                    camId.setToken(rs.getString("TOKEN"));
                    camId.setPhone_number(rs.getString("PHONE_NUMBER"));
                    return camId;
                }

            });
        } catch (Exception e) {
            logger.error("Get_ACCOUNT_CAMID_METFONE | EXCEPTION : " + e.getMessage());
            return null;
        }
        return camId;
    }

    @Override
    public List<CamIdDeviceToken> GET_ACCOUNT_CAMID_NON_METFONE(int count, int userSize, String SQL_GET_ACCOUNT_CAMID_NON_METFONE) {
        List<CamIdDeviceToken> camId = new ArrayList<>();
        try {
            camId = jdbcTemplate.query(SQL_GET_ACCOUNT_CAMID_NON_METFONE,new MapSqlParameterSource()
                            .addValue("offset", count * userSize)
                            .addValue("limit", userSize),
                    new RowMapper<CamIdDeviceToken>() {
                        @Override
                        public CamIdDeviceToken mapRow(ResultSet rs, int rowNum) throws SQLException {
                            CamIdDeviceToken camId = new CamIdDeviceToken();
                            camId.setId(rs.getLong("ID"));
                            camId.setCam_id(rs.getLong("CAM_ID"));
                            camId.setToken(rs.getString("TOKEN"));
                            camId.setPhone_number(rs.getString("PHONE_NUMBER"));
                            return camId;
                        }

                    });
        } catch (Exception e) {
            logger.error("Get_ACCOUNT_CAMID_METFONE | EXCEPTION : " + e.getMessage());
            return null;
        }
        return camId;
    }

    @Override
    public List<CamIdDeviceToken> GET_ACCOUNT_FID(int count, int userSize, String SQL_GET_ACCOUNT_FID) {
        List<CamIdDeviceToken> camId = new ArrayList<>();
        try {
            camId = jdbcTemplate.query(SQL_GET_ACCOUNT_FID,new MapSqlParameterSource()
                            .addValue("offset", count * userSize)
                            .addValue("limit", userSize),
                    new RowMapper<CamIdDeviceToken>() {
                        @Override
                        public CamIdDeviceToken mapRow(ResultSet rs, int rowNum) throws SQLException {
                            CamIdDeviceToken camId = new CamIdDeviceToken();
                            camId.setId(rs.getLong("ID"));
                            camId.setCam_id(rs.getLong("CAM_ID"));
                            camId.setToken(rs.getString("TOKEN"));
                            camId.setPhone_number(rs.getString("PHONE_NUMBER"));
                            return camId;
                        }

                    });
        } catch (Exception e) {
            logger.error("Get_ACCOUNT_CAMID_METFONE | EXCEPTION : " + e.getMessage());
            return null;
        }
        return camId;
    }

    @Override
    public List<CamIdDeviceToken> GET_ACCOUNT_GID(int count, int userSize, String SQL_GET_ACCOUNT_GID) {
        List<CamIdDeviceToken> camId = new ArrayList<>();
        try {
            camId = jdbcTemplate.query(SQL_GET_ACCOUNT_GID,new MapSqlParameterSource()
                            .addValue("offset", count * userSize)
                            .addValue("limit", userSize),
                    new RowMapper<CamIdDeviceToken>() {
                        @Override
                        public CamIdDeviceToken mapRow(ResultSet rs, int rowNum) throws SQLException {
                            CamIdDeviceToken camId = new CamIdDeviceToken();
                            camId.setId(rs.getLong("ID"));
                            camId.setCam_id(rs.getLong("CAM_ID"));
                            camId.setToken(rs.getString("TOKEN"));
                            camId.setPhone_number(rs.getString("PHONE_NUMBER"));
                            return camId;
                        }

                    });
        } catch (Exception e) {
            logger.error("Get_ACCOUNT_CAMID_METFONE | EXCEPTION : " + e.getMessage());
            return null;
        }
        return camId;
    }

    @Override
    public List<CamIdDeviceToken> GET_ACCOUNT_APPLEID(int count, int userSize, String SQL_GET_ACCOUNT_APPLEID) {
        List<CamIdDeviceToken> camId = new ArrayList<>();
        try {
            camId = jdbcTemplate.query(SQL_GET_ACCOUNT_APPLEID,new MapSqlParameterSource()
                            .addValue("offset", count * userSize)
                            .addValue("limit", userSize),
                    new RowMapper<CamIdDeviceToken>() {
                        @Override
                        public CamIdDeviceToken mapRow(ResultSet rs, int rowNum) throws SQLException {
                            CamIdDeviceToken camId = new CamIdDeviceToken();
                            camId.setId(rs.getLong("ID"));
                            camId.setCam_id(rs.getLong("CAM_ID"));
                            camId.setToken(rs.getString("TOKEN"));
                            camId.setPhone_number(rs.getString("PHONE_NUMBER"));
                            return camId;
                        }

                    });
        } catch (Exception e) {
            logger.error("Get_ACCOUNT_CAMID_METFONE | EXCEPTION : " + e.getMessage());
            return null;
        }
        return camId;
    }

    @Override
    public List<CamIdDeviceToken> GET_ACCOUNT_CAMID_NON_LOGIN(int count, int userSize, String SQL_GET_ACCOUNT_CAMID_NON_LOGIN) {
        List<CamIdDeviceToken> camId = new ArrayList<>();
        try {
            camId = jdbcTemplate.query(SQL_GET_ACCOUNT_CAMID_NON_LOGIN,new MapSqlParameterSource()
                            .addValue("offset", count * userSize)
                            .addValue("limit", userSize),
                    new RowMapper<CamIdDeviceToken>() {
                        @Override
                        public CamIdDeviceToken mapRow(ResultSet rs, int rowNum) throws SQLException {
                            CamIdDeviceToken camId = new CamIdDeviceToken();
                            camId.setId(rs.getLong("ID"));
                            camId.setCam_id(rs.getLong("CAM_ID"));
                            camId.setToken(rs.getString("TOKEN"));
                            camId.setPhone_number(rs.getString("PHONE_NUMBER"));
                            return camId;
                        }

                    });
        } catch (Exception e) {
            logger.error("Get_ACCOUNT_CAMID_METFONE | EXCEPTION : " + e.getMessage());
            return null;
        }
        return camId;
    }

    @Override
    public List<CamIdDeviceToken> GET_ACCOUNT_CAMID_NON_SIGNUP(int count, int userSize, String SQL_GET_ACCOUNT_CAMID_NON_SIGNUP) {
        List<CamIdDeviceToken> camId = new ArrayList<>();
        try {
            camId = jdbcTemplate.query(SQL_GET_ACCOUNT_CAMID_NON_SIGNUP,new MapSqlParameterSource()
                            .addValue("offset", count * userSize)
                            .addValue("limit", userSize),
                    new RowMapper<CamIdDeviceToken>() {
                        @Override
                        public CamIdDeviceToken mapRow(ResultSet rs, int rowNum) throws SQLException {
                            CamIdDeviceToken camId = new CamIdDeviceToken();
                            camId.setId(rs.getLong("ID"));
                            camId.setCam_id(rs.getLong("CAM_ID"));
                            camId.setToken(rs.getString("TOKEN"));
                            camId.setPhone_number(rs.getString("PHONE_NUMBER"));
                            return camId;
                        }

                    });
        } catch (Exception e) {
            logger.error("Get_ACCOUNT_CAMID_METFONE | EXCEPTION : " + e.getMessage());
            return null;
        }
        return camId;
    }

    @Override
    public List<CamIdDeviceToken> GET_ACCOUNT_CAMID_ALL(int count, int userSize, String SQL_GET_ACCOUNT_CAMID_ALL) {
        List<CamIdDeviceToken> camId = new ArrayList<>();
        try {
            camId = jdbcTemplate.query(SQL_GET_ACCOUNT_CAMID_ALL,new MapSqlParameterSource()
                            .addValue("offset", count * userSize)
                            .addValue("limit", userSize),
                    new RowMapper<CamIdDeviceToken>() {
                        @Override
                        public CamIdDeviceToken mapRow(ResultSet rs, int rowNum) throws SQLException {
                            CamIdDeviceToken camId = new CamIdDeviceToken();
                            camId.setId(rs.getLong("ID"));
                            camId.setCam_id(rs.getLong("CAM_ID"));
                            camId.setToken(rs.getString("TOKEN"));
                            camId.setPhone_number(rs.getString("PHONE_NUMBER"));
                            return camId;
                        }

                    });
        } catch (Exception e) {
            logger.error("Get_ACCOUNT_CAMID_METFONE | EXCEPTION : " + e.getMessage());
            return null;
        }
        return camId;
    }

    @Override
    public List<CamIdDeviceToken> GET_ACCOUNT_CAMID_ANDROID(int count, int userSize, String SQL_GET_ACCOUNT_CAMID_ANDROID) {
        List<CamIdDeviceToken> camId = new ArrayList<>();
        try {
            camId = jdbcTemplate.query(SQL_GET_ACCOUNT_CAMID_ANDROID,new MapSqlParameterSource()
                            .addValue("offset", count * userSize)
                            .addValue("limit", userSize),
                    new RowMapper<CamIdDeviceToken>() {
                        @Override
                        public CamIdDeviceToken mapRow(ResultSet rs, int rowNum) throws SQLException {
                            CamIdDeviceToken camId = new CamIdDeviceToken();
                            camId.setId(rs.getLong("ID"));
                            camId.setCam_id(rs.getLong("CAM_ID"));
                            camId.setToken(rs.getString("TOKEN"));
                            camId.setPhone_number(rs.getString("PHONE_NUMBER"));
                            return camId;
                        }

                    });
        } catch (Exception e) {
            logger.error("Get_ACCOUNT_CAMID_METFONE | EXCEPTION : " + e.getMessage());
            return null;
        }
        return camId;
    }

    @Override
    public List<CamIdDeviceToken> GET_ACCOUNT_CAMID_IOS(int count, int userSize, String SQL_GET_ACCOUNT_CAMID_IOS) {
        List<CamIdDeviceToken> camId = new ArrayList<>();
        try {
            camId = jdbcTemplate.query(SQL_GET_ACCOUNT_CAMID_IOS,new MapSqlParameterSource()
                            .addValue("offset", count * userSize)
                            .addValue("limit", userSize),
                    new RowMapper<CamIdDeviceToken>() {
                        @Override
                        public CamIdDeviceToken mapRow(ResultSet rs, int rowNum) throws SQLException {
                            CamIdDeviceToken camId = new CamIdDeviceToken();
                            camId.setId(rs.getLong("ID"));
                            camId.setCam_id(rs.getLong("CAM_ID"));
                            camId.setToken(rs.getString("TOKEN"));
                            camId.setPhone_number(rs.getString("PHONE_NUMBER"));
                            return camId;
                        }

                    });
        } catch (Exception e) {
            logger.error("Get_ACCOUNT_CAMID_METFONE | EXCEPTION : " + e.getMessage());
            return null;
        }
        return camId;
    }

    @Override
    public List<CamIdDeviceToken> GET_ACCOUNT_ISDN(int count, int userSize,List<String> isdns, String SQL_GET_ACCOUNT_ISDN) {
        List<CamIdDeviceToken> camId = new ArrayList<>();
        try {
            camId = jdbcTemplate.query(SQL_GET_ACCOUNT_ISDN,new MapSqlParameterSource()
                            .addValue("isdn",isdns)
                            .addValue("offset", count * userSize)
                            .addValue("limit", userSize),
                    new RowMapper<CamIdDeviceToken>() {
                        @Override
                        public CamIdDeviceToken mapRow(ResultSet rs, int rowNum) throws SQLException {
                            CamIdDeviceToken camId = new CamIdDeviceToken();
                            camId.setId(rs.getLong("ID"));
                            camId.setCam_id(rs.getLong("CAM_ID"));
                            camId.setToken(rs.getString("TOKEN"));
                            camId.setPhone_number(rs.getString("PHONE_NUMBER"));
                            return camId;
                        }

                    });
        } catch (Exception e) {
            logger.error("Get_ACCOUNT_CAMID_METFONE | EXCEPTION : " + e.getMessage());
            return null;
        }
        return camId;
    }

    @Override
    public List<CamIdDeviceToken> GET_ACCOUNT_CAMID(int count, int userSize,List<String> camid, String SQL_GET_ACCOUNT_CAMID) {
        List<CamIdDeviceToken> camId = new ArrayList<>();
        try {
            camId = jdbcTemplate.query(SQL_GET_ACCOUNT_CAMID,new MapSqlParameterSource()
                            .addValue("camid",camid)
                            .addValue("offset", count * userSize)
                            .addValue("limit", userSize),
                    new RowMapper<CamIdDeviceToken>() {
                        @Override
                        public CamIdDeviceToken mapRow(ResultSet rs, int rowNum) throws SQLException {
                            CamIdDeviceToken camId = new CamIdDeviceToken();
                            camId.setId(rs.getLong("ID"));
                            camId.setCam_id(rs.getLong("CAM_ID"));
                            camId.setToken(rs.getString("TOKEN"));
                            camId.setPhone_number(rs.getString("PHONE_NUMBER"));
                            return camId;
                        }

                    });
        } catch (Exception e) {
            logger.error("Get_ACCOUNT_CAMID_METFONE | EXCEPTION : " + e.getMessage());
            return null;
        }
        return camId;
    }

}
