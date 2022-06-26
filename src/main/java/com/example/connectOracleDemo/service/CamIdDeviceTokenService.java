package com.example.connectOracleDemo.service;

import com.example.connectOracleDemo.repository.CamIdDeviceTokenDao;
import com.example.connectOracleDemo.repository.entity.CamIdDeviceToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CamIdDeviceTokenService {
    private static  Logger logger = LoggerFactory.getLogger(CamIdDeviceTokenService.class);

    @Autowired
    CamIdDeviceTokenDao camIdDeviceTokenDao;


    private static final int userSize=1000;

    public static final String COUNT=" SELECT COUNT(*)FROM( ";

    public static final String START_SQL="SELECT * FROM ( ";

    public static final String END_SQL =" ) WHERE row_num> :offset AND row_num <= :limit ";

    public static final String SQL_GET_ACCOUNT_CAMID_METFONE="SELECT CDT.* ,a.PHONE_NUMBER,ROW_NUMBER() OVER( ORDER BY CDT.id DESC ) row_num FROM CAMID_DEVICE_TOKEN_TEST CDT, ACCOUNT_TEST A WHERE CDT.CAM_ID=A.ID AND ((A.PHONE_NUMBER LIKE '97%' OR A.PHONE_NUMBER LIKE '88%' OR A.PHONE_NUMBER LIKE '71%' OR A.PHONE_NUMBER LIKE '31%' OR A.PHONE_NUMBER LIKE '60%' OR A.PHONE_NUMBER LIKE '66%' OR A.PHONE_NUMBER LIKE '67%' OR A.PHONE_NUMBER LIKE '68%' OR A.PHONE_NUMBER LIKE '90%')AND A.PHONE_NUMBER IS NOT NULL and (CDT.status =1 or CDT.status is null  )) AND A.STATE='ACTIVE' AND (CDT.IS_LOGIN = 1 OR CDT.IS_LOGIN IS NULL) ";

    public static final String SQL_GET_ACCOUNT_CAMID_NON_METFONE="SELECT CDT.*,a.PHONE_NUMBER,ROW_NUMBER() OVER( ORDER BY CDT.id DESC ) row_num FROM CAMID_DEVICE_TOKEN_TEST CDT, ACCOUNT_TEST A WHERE CDT.CAM_ID=A.ID AND ((A.PHONE_NUMBER NOT LIKE '97%' AND A.PHONE_NUMBER NOT LIKE '88%' AND A.PHONE_NUMBER NOT LIKE '71%' AND A.PHONE_NUMBER NOT LIKE '31%' AND A.PHONE_NUMBER NOT LIKE '60%' AND A.PHONE_NUMBER NOT LIKE '66%' AND A.PHONE_NUMBER NOT LIKE '67%' AND A.PHONE_NUMBER NOT LIKE '68%' AND A.PHONE_NUMBER NOT LIKE '90%') OR A.PHONE_NUMBER IS NULL) AND A.STATE='ACTIVE' and (CDT.status=1 or CDT.status is null )  AND (CDT.IS_LOGIN = 1 OR CDT.IS_LOGIN IS NULL) ";

    public static final String SQL_GET_ACCOUNT_FID="SELECT CDT.* ,a.PHONE_NUMBER,ROW_NUMBER() OVER( ORDER BY CDT.id DESC ) row_num FROM CAMID_DEVICE_TOKEN_TEST CDT, ACCOUNT_TEST A WHERE CDT.CAM_ID=A.ID AND A.FID IS NOT NULL and A.PHONE_NUMBER IS NULL and (CDT.status =1 or CDT.status is null  ) AND A.STATE='ACTIVE' ";

    public static final String SQL_GET_ACCOUNT_GID="SELECT CDT.* ,a.PHONE_NUMBER,ROW_NUMBER() OVER( ORDER BY CDT.id DESC ) row_num FROM CAMID_DEVICE_TOKEN_TEST CDT, ACCOUNT_TEST A WHERE CDT.CAM_ID=A.ID AND A.GID IS NOT NULL and A.PHONE_NUMBER IS NULL and (CDT.status =1 or CDT.status is null  ) AND A.STATE='ACTIVE' ";

    public static final String SQL_GET_ACCOUNT_APPLEID="SELECT CDT.* ,a.PHONE_NUMBER,ROW_NUMBER() OVER( ORDER BY CDT.id DESC ) row_num FROM CAMID_DEVICE_TOKEN_TEST CDT, ACCOUNT_TEST A WHERE CDT.CAM_ID=A.ID AND A.APPLEID IS NOT NULL and A.PHONE_NUMBER IS NULL and (CDT.status =1 or CDT.status is null  ) AND A.STATE='ACTIVE' ";

    public static final String SQL_GET_ACCOUNT_CAMID_NON_LOGIN="SELECT cdt.*, a.phone_number, ROW_NUMBER() OVER( ORDER BY cdt.id DESC ) row_num FROM camid_device_token_TEST cdt, account_TEST a WHERE cdt.cam_id = a.id AND cdt.is_login = 0 AND cdt.device_id IS NOT NULL AND cdt.cam_id IS NOT NULL AND ( status = 1 OR status IS NULL ) ";

    public static final String SQL_GET_ACCOUNT_CAMID_NON_SIGNUP="SELECT cdt.*, a.phone_number, ROW_NUMBER() OVER( ORDER BY cdt.id DESC ) row_num FROM camid_device_token_TEST cdt, account_TEST a WHERE cdt.cam_id = a.id AND cdt.is_login = 0 AND cdt.device_id IS NOT NULL AND ( cdt.status = 1 OR cdt.status IS NULL ) AND cdt.cam_id IS NULL ";

    public static final String SQL_GET_ACCOUNT_CAMID_ALL="SELECT CDT.*,a.PHONE_NUMBER,ROW_NUMBER() OVER( ORDER BY CDT.id DESC ) row_num FROM CAMID_DEVICE_TOKEN_TEST CDT, account_TEST a WHERE cdt.cam_id = a.id AND CDT.TOKEN IS NOT NULL AND (CDT.STATUS=1 or CDT.STATUS is null) ";

    public static final String SQL_GET_ACCOUNT_CAMID_ANDROID="SELECT cdt.*,a.PHONE_NUMBER, ROW_NUMBER() OVER( ORDER BY cdt.id DESC ) row_num FROM camid_device_token_test, account_TEST a WHERE cdt.cam_id = a.id AND cdt.token IS NOT NULL AND cdt.OPERATING_SYSTEM = 0 AND CDT.IS_LOGIN IS NOT NULL AND ( cdt.status = 1 OR cdt.status IS NULL ) ";

    public static final String SQL_GET_ACCOUNT_CAMID_IOS="SELECT cdt.*,a.PHONE_NUMBER, ROW_NUMBER() OVER( ORDER BY cdt.id DESC ) row_num FROM camid_device_token_test cdt, account_TEST a WHERE cdt.cam_id = a.id AND cdt.token IS NOT NULL AND cdt.OPERATING_SYSTEM = 1 AND CDT.IS_LOGIN IS NOT NULL AND ( cdt.status = 1 OR cdt.status IS NULL ) ";

    public static final String SQL_GET_ACCOUNT_ISDN ="SELECT CDT.*,a.PHONE_NUMBER,ROW_NUMBER() OVER( ORDER BY CDT.id DESC ) row_num FROM CAMID_DEVICE_TOKEN_TEST CDT, ACCOUNT_TEST A WHERE CDT.CAM_ID=A.ID AND A.STATE='ACTIVE' AND A.PHONE_NUMBER IN (:isdn) AND (CDT.IS_LOGIN = 1 OR CDT.IS_LOGIN IS NULL) ";

    public static final String SQL_GET_ACCOUNT_CAMID="SELECT cdt.*,a.PHONE_NUMBER, ROW_NUMBER() OVER( ORDER BY cdt.id DESC ) row_num FROM camid_device_token_TEST cdt, account_TEST a WHERE cdt.cam_id = a.id AND a.state = 'ACTIVE' AND a.id IN (:camid) AND ( cdt.is_login = 1 OR cdt.is_login IS NULL ) ";


    private int count_user(String sql){
        int totalUser=camIdDeviceTokenDao.COUNT_ACCOUNT_CAMID(sql);
        int number_of_page = 0;
        if (totalUser % 1000 == 0) number_of_page = totalUser / 1000;
        else number_of_page = (totalUser / 1000) + 1;
        return number_of_page;
    }

    public int COUNT_ACCOUNT_CAMID_METFONE (){
        String countSql=COUNT + SQL_GET_ACCOUNT_CAMID_METFONE +")";
        int totalAccount=camIdDeviceTokenDao.COUNT_ACCOUNT_CAMID(countSql);
        return totalAccount;
    }

    public int COUNT_GET_ACCOUNT_CAMID_NON_METFONE (){
        String countSql=COUNT + SQL_GET_ACCOUNT_CAMID_NON_METFONE +")";
        int totalAccount=camIdDeviceTokenDao.COUNT_ACCOUNT_CAMID(countSql);
        return totalAccount;
    }

    public int COUNT_GET_ACCOUNT_FID (){
        String countSql=COUNT + SQL_GET_ACCOUNT_FID +")";
        int totalAccount=camIdDeviceTokenDao.COUNT_ACCOUNT_CAMID(countSql);
        return totalAccount;
    }

    public int COUNT_GET_ACCOUNT_GID (){
        String countSql=COUNT + SQL_GET_ACCOUNT_GID +")";
        int totalAccount=camIdDeviceTokenDao.COUNT_ACCOUNT_CAMID(countSql);
        return totalAccount;
    }

    public int COUNT_GET_ACCOUNT_APPLEID ( ){
        String countSql=COUNT + SQL_GET_ACCOUNT_APPLEID +")";
        int totalAccount=camIdDeviceTokenDao.COUNT_ACCOUNT_CAMID(countSql);
        return totalAccount;
    }

    public int COUNT_GET_ACCOUNT_CAMID_NON_LOGIN (){
        String countSql=COUNT + SQL_GET_ACCOUNT_CAMID_NON_LOGIN +")";
        int totalAccount=camIdDeviceTokenDao.COUNT_ACCOUNT_CAMID(countSql);
        return totalAccount;
    }

    public int COUNT_GET_ACCOUNT_CAMID_NON_SIGNUP (){
        String countSql=COUNT + SQL_GET_ACCOUNT_CAMID_NON_SIGNUP +")";
        int totalAccount=camIdDeviceTokenDao.COUNT_ACCOUNT_CAMID(countSql);
        return totalAccount;
    }

    public int COUNT_GET_ACCOUNT_CAMID_ALL (){
        String countSql=COUNT + SQL_GET_ACCOUNT_CAMID +")";
        int totalAccount=camIdDeviceTokenDao.COUNT_ACCOUNT_CAMID(countSql);
        return totalAccount;
    }

    public int COUNT_GET_ACCOUNT_CAMID_ANDROID (){
        String countSql=COUNT + SQL_GET_ACCOUNT_CAMID_METFONE +")";
        int totalAccount=camIdDeviceTokenDao.COUNT_ACCOUNT_CAMID(countSql);
        return totalAccount;
    }

    public int COUNT_GET_ACCOUNT_CAMID_IOS (){
        String countSql=COUNT + SQL_GET_ACCOUNT_CAMID_IOS +")";
        int totalAccount=camIdDeviceTokenDao.COUNT_ACCOUNT_CAMID(countSql);
        return totalAccount;
    }

    public int COUNT_GET_ACCOUNT_ISDN (List<String> isdns){
        String countSql=COUNT + SQL_GET_ACCOUNT_CAMID_METFONE +")";
        int totalAccount=camIdDeviceTokenDao.COUNT_ACCOUNT_CAMID_ISDN(countSql,isdns);
        return totalAccount;
    }

    public int COUNT_ (List<String> camid){
        String countSql=COUNT + SQL_GET_ACCOUNT_CAMID_METFONE +")";
        int totalAccount=camIdDeviceTokenDao.COUNT_ACCOUNT_CAMID_BY_ACCOUNTID(countSql,camid);
        return totalAccount;
    }

    public void GET_ACCOUNT_CAMID_METFONE(){
        String countSql=COUNT + SQL_GET_ACCOUNT_CAMID_METFONE +")";
        String sql = START_SQL + SQL_GET_ACCOUNT_CAMID_METFONE + END_SQL ;

        List<CamIdDeviceToken> camIdMetfone = new ArrayList<>();
        int count =0;
        int number_of_page=count_user(countSql);
        try{
            if (count < number_of_page){
                camIdMetfone=camIdDeviceTokenDao.GET_ACCOUNT_CAMID_METFONE(count,userSize,sql);
                count++;
            }
        }catch(Exception e) {
            logger.info("GET_ACCOUNT_CAMID_METFONE|EXCEPTION : " + e.getMessage());
        }
    }

    public void GET_ACCOUNT_CAMID_NON_METFONE(){
        String countSql=COUNT + SQL_GET_ACCOUNT_CAMID_NON_METFONE +")";
        String sql = START_SQL + SQL_GET_ACCOUNT_CAMID_NON_METFONE + END_SQL ;

        List<CamIdDeviceToken> camIdMetfone = new ArrayList<>();
        int count =0;
        int number_of_page=count_user(countSql);
        try{
            if (count < number_of_page){
                camIdMetfone=camIdDeviceTokenDao.GET_ACCOUNT_CAMID_NON_METFONE(count,userSize,sql);
                count++;
            }
        }catch(Exception e) {
            logger.info("GET_ACCOUNT_CAMID_NON_METFONE|EXCEPTION : " + e.getMessage());
        }
    }

    public void GET_ACCOUNT_FID(){
        String countSql=COUNT + SQL_GET_ACCOUNT_FID +")";
        String sql = START_SQL + SQL_GET_ACCOUNT_FID + END_SQL ;

        List<CamIdDeviceToken> camIdMetfone = new ArrayList<>();
        int count =0;
        int number_of_page=count_user(countSql);
        try{
            if (count < number_of_page){
                camIdMetfone=camIdDeviceTokenDao.GET_ACCOUNT_FID(count,userSize,sql);
                count++;
            }
        }catch(Exception e) {
            logger.info("GET_ACCOUNT_FID|EXCEPTION : " + e.getMessage());
        }
    }

    public void GET_ACCOUNT_GID(){
        String countSql=COUNT + SQL_GET_ACCOUNT_GID +")";
        String sql = START_SQL + SQL_GET_ACCOUNT_GID + END_SQL ;

        List<CamIdDeviceToken> camIdMetfone = new ArrayList<>();
        int count =0;
        int number_of_page=count_user(countSql);
        try{
            if (count < number_of_page){
                camIdMetfone=camIdDeviceTokenDao.GET_ACCOUNT_GID(count,userSize,sql);
                count++;
            }
        }catch(Exception e) {
            logger.info("GET_ACCOUNT_GID|EXCEPTION : " + e.getMessage());
        }
    }

    public void GET_ACCOUNT_APPLEID(){
        String countSql=COUNT + SQL_GET_ACCOUNT_APPLEID +")";
        String sql = START_SQL + SQL_GET_ACCOUNT_APPLEID + END_SQL ;

        List<CamIdDeviceToken> camId = new ArrayList<>();
        int count =0;
        int number_of_page=count_user(countSql);
        try{
            if (count < number_of_page){
                camId=camIdDeviceTokenDao.GET_ACCOUNT_APPLEID(count,userSize,sql);
                count++;
            }
        }catch(Exception e) {
            logger.info("GET_ACCOUNT_APPLEID|EXCEPTION : " + e.getMessage());
        }
    }

    public void GET_ACCOUNT_CAMID_NON_LOGIN(){
        String countSql=COUNT + SQL_GET_ACCOUNT_CAMID_NON_LOGIN +")";
        String sql = START_SQL + SQL_GET_ACCOUNT_CAMID_NON_LOGIN + END_SQL ;

        List<CamIdDeviceToken> camId = new ArrayList<>();
        int count =0;
        int number_of_page=count_user(countSql);
        try{
            if (count < number_of_page){
                camId=camIdDeviceTokenDao.GET_ACCOUNT_CAMID_NON_LOGIN(count,userSize,sql);
                count++;
            }
        }catch(Exception e) {
            logger.info("GET_ACCOUNT_CAMID_NON_LOGIN|EXCEPTION : " + e.getMessage());
        }
    }

    public void GET_ACCOUNT_CAMID_NON_SIGNUP(){
        String countSql=COUNT + SQL_GET_ACCOUNT_CAMID_NON_SIGNUP +")";
        String sql = START_SQL + SQL_GET_ACCOUNT_CAMID_NON_SIGNUP + END_SQL ;

        List<CamIdDeviceToken> camId = new ArrayList<>();
        int count =0;
        int number_of_page=count_user(countSql);
        try{
            if (count < number_of_page){
                camId=camIdDeviceTokenDao.GET_ACCOUNT_CAMID_NON_SIGNUP(count,userSize,sql);
                count++;
            }
        }catch(Exception e) {
            logger.info("GET_ACCOUNT_CAMID_NON_SIGNUP|EXCEPTION : " + e.getMessage());
        }
    }

    public void GET_ACCOUNT_CAMID_ALL(){
        String countSql=COUNT + SQL_GET_ACCOUNT_CAMID_ALL +")";
        String sql = START_SQL + SQL_GET_ACCOUNT_CAMID_ALL + END_SQL ;

        List<CamIdDeviceToken> camId = new ArrayList<>();
        int count =0;
        int number_of_page=count_user(countSql);
        try{
            if (count < number_of_page){
                camId=camIdDeviceTokenDao.GET_ACCOUNT_CAMID_ALL(count,userSize,sql);
                count++;
            }
        }catch(Exception e) {
            logger.info("GET_ACCOUNT_CAMID_ALL|EXCEPTION : " + e.getMessage());
        }
    }

    public void GET_ACCOUNT_CAMID_ANDROID(){
        String countSql=COUNT + SQL_GET_ACCOUNT_CAMID_ANDROID +")";
        String sql = START_SQL + SQL_GET_ACCOUNT_CAMID_ANDROID + END_SQL ;

        List<CamIdDeviceToken> camId = new ArrayList<>();
        int count =0;
        int number_of_page=count_user(countSql);
        try{
            if (count < number_of_page){
                camId=camIdDeviceTokenDao.GET_ACCOUNT_CAMID_ANDROID(count,userSize,sql);
                count++;
            }
        }catch(Exception e) {
            logger.info("GET_ACCOUNT_CAMID_ANDROID|EXCEPTION : " + e.getMessage());
        }
    }

    public void GET_ACCOUNT_CAMID_IOS(){
        String countSql=COUNT + SQL_GET_ACCOUNT_CAMID_IOS +")";
        String sql = START_SQL + SQL_GET_ACCOUNT_CAMID_IOS + END_SQL ;

        List<CamIdDeviceToken> camId = new ArrayList<>();
        int count =0;
        int number_of_page=count_user(countSql);
        try{
            if (count < number_of_page){
                camId=camIdDeviceTokenDao.GET_ACCOUNT_CAMID_IOS(count,userSize,sql);
                count++;
            }
        }catch(Exception e) {
            logger.info("GET_ACCOUNT_CAMID_IOS|EXCEPTION : " + e.getMessage());
        }
    }

    public void GET_ACCOUNT_ISDN(List<String> isdns){
        String countSql=COUNT + SQL_GET_ACCOUNT_ISDN +")";
        String sql = START_SQL + SQL_GET_ACCOUNT_ISDN + END_SQL ;

        int totalUser=camIdDeviceTokenDao.COUNT_ACCOUNT_CAMID_ISDN(countSql,isdns);
        int number_of_page = 0;
        if (totalUser % 1000 == 0) number_of_page = totalUser / 1000;
        else number_of_page = (totalUser / 1000) + 1;

        List<CamIdDeviceToken> camId = new ArrayList<>();
        int count =0;
        try{
            if (count < number_of_page){
                camId=camIdDeviceTokenDao.GET_ACCOUNT_ISDN(count,userSize,isdns,sql);
                count++;
            }
        }catch(Exception e) {
            logger.info("GET_ACCOUNT_ISDN|EXCEPTION : " + e.getMessage());
        }
    }

    public void GET_ACCOUNT_CAMID( List<String> camid){
        String countSql=COUNT + SQL_GET_ACCOUNT_CAMID +")";
        String sql = START_SQL + SQL_GET_ACCOUNT_CAMID + END_SQL ;
        int totalUser=camIdDeviceTokenDao.COUNT_ACCOUNT_CAMID_BY_ACCOUNTID(countSql,camid);
        int number_of_page = 0;
        if (totalUser % 1000 == 0) number_of_page = totalUser / 1000;
        else number_of_page = (totalUser / 1000) + 1;

        List<CamIdDeviceToken> camId = new ArrayList<>();
        int count =0;
        try{
            if (count < number_of_page){
                camId=camIdDeviceTokenDao.GET_ACCOUNT_CAMID(count,userSize,camid,sql);
                count++;
            }
        }catch(Exception e) {
            logger.info("GET_ACCOUNT_CAMID|EXCEPTION : " + e.getMessage());
        }
    }
}
