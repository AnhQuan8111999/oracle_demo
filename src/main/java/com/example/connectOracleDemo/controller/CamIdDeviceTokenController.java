//package com.example.connectOracleDemo.controller;
//
//import com.example.connectOracleDemo.repository.CamIdDeviceTokenDao;
//import com.example.connectOracleDemo.repository.entity.CamIdDeviceToken;
//import com.example.connectOracleDemo.service.CamIdDeviceTokenService;
//import com.google.gson.Gson;
//import com.google.gson.JsonElement;
//import com.google.gson.JsonObject;
//import com.google.gson.reflect.TypeToken;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Controller
//@RequestMapping("/v1/segment_user")
//public class CamIdDeviceTokenController {
//    @Autowired
//    CamIdDeviceTokenService camIdDeviceTokenService;
//
//    private static Logger logger = LoggerFactory.getLogger(CamIdDeviceTokenController.class);
//
//    @RequestMapping(value = "/get_account_camid_metfone", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
//    @ResponseBody
//    public String GET_ACCOUNT_CAMID_METFONE() {
//        String result = "";
//        long start = System.currentTimeMillis();
//        JsonObject jsonObject = new JsonObject();
//        try {
//            List<CamIdDeviceToken> camid = camIdDeviceTokenService.GET_ACCOUNT_CAMID_METFONE();
//
//            jsonObject.addProperty("code", 200);
//            jsonObject.addProperty("message", "GET_ACCOUNT_CAMID_METFONE");
//            JsonElement element = new Gson().toJsonTree(camid, new TypeToken<List<CamIdDeviceToken>>() {
//            }.getType());
//
//            jsonObject.addProperty("count", camid.size());
//            jsonObject.add("data", element);
//
//            long proc = System.currentTimeMillis() - start;
//            logger.info("Get_ACCOUNT_CAMID_METFONE : " + "|ExecuteTime|" + proc);
//        } catch (Exception e) {
//            logger.error("Get_ACCOUNT_CAMID_METFONE|Exception : " + e.getMessage(), e);
//            jsonObject.addProperty("code", 400);
//            jsonObject.addProperty("message", "GET_ACCOUNT_CAMID_NON_METFONE fail");
//            jsonObject.addProperty("data", "");
//        }
//        result = jsonObject.toString();
//        return result;
//    }
//
//    @RequestMapping(value = "/get_account_camid_non_metfone", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
//    @ResponseBody
//    public String GET_ACCOUNT_CAMID_NON_METFONE() {
//        String result = "";
//        long start = System.currentTimeMillis();
//        JsonObject jsonObject = new JsonObject();
//        try {
//            List<CamIdDeviceToken> camid = camIdDeviceTokenService.GET_ACCOUNT_CAMID_NON_METFONE();
//
//            jsonObject.addProperty("code", 200);
//            jsonObject.addProperty("message", "GET_ACCOUNT_CAMID_NON_METFONE");
//            JsonElement element = new Gson().toJsonTree(camid, new TypeToken<List<CamIdDeviceToken>>() {
//            }.getType());
//
//            jsonObject.addProperty("count", camid.size());
//            jsonObject.add("data", element);
//
//            long proc = System.currentTimeMillis() - start;
//            logger.info("Get_ACCOUNT_CAMID_NON_METFONE : " + "|ExecuteTime|" + proc);
//        } catch (Exception e) {
//            logger.error("Get_ACCOUNT_CAMID_NON_METFONE|Exception : " + e.getMessage(), e);
//            jsonObject.addProperty("code", 400);
//            jsonObject.addProperty("message", "GET_ACCOUNT_CAMID_NON_METFONE fail");
//            jsonObject.addProperty("data", "");
//        }
//        result = jsonObject.toString();
//        return result;
//    }
//
//    @RequestMapping(value = "/get_account_camid_fid", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
//    @ResponseBody
//    public String GET_ACCOUNT_CAMID_FID() {
//        String result = "";
//        long start = System.currentTimeMillis();
//        JsonObject jsonObject = new JsonObject();
//        try {
//            List<CamIdDeviceToken> camid = camIdDeviceTokenService.GET_ACCOUNT_FID();
//
//            jsonObject.addProperty("code", 200);
//            jsonObject.addProperty("message", "GET_ACCOUNT_CAMID_FID");
//            JsonElement element = new Gson().toJsonTree(camid, new TypeToken<List<CamIdDeviceToken>>() {
//            }.getType());
//
//            jsonObject.addProperty("count", camid.size());
//            jsonObject.add("data", element);
//
//            long proc = System.currentTimeMillis() - start;
//            logger.info("GET_ACCOUNT_CAMID_FID : " + "|ExecuteTime|" + proc);
//        } catch (Exception e) {
//            logger.error("GET_ACCOUNT_CAMID_FID|Exception : " + e.getMessage(), e);
//            jsonObject.addProperty("code", 400);
//            jsonObject.addProperty("message", "GET_ACCOUNT_CAMID_FID fail");
//            jsonObject.addProperty("data", "");
//        }
//        result = jsonObject.toString();
//        return result;
//    }
//
//    @RequestMapping(value = "/get_account_camid_gid", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
//    @ResponseBody
//    public String GET_ACCOUNT_CAMID_GID() {
//        String result = "";
//        long start = System.currentTimeMillis();
//        JsonObject jsonObject = new JsonObject();
//        try {
//            List<CamIdDeviceToken> camid = camIdDeviceTokenService.GET_ACCOUNT_GID();
//
//            jsonObject.addProperty("code", 200);
//            jsonObject.addProperty("message", "GET_ACCOUNT_CAMID_GID");
//            JsonElement element = new Gson().toJsonTree(camid, new TypeToken<List<CamIdDeviceToken>>() {
//            }.getType());
//
//            jsonObject.addProperty("count", camid.size());
//            jsonObject.add("data", element);
//
//            long proc = System.currentTimeMillis() - start;
//            logger.info("GET_ACCOUNT_CAMID_GID : " + "|ExecuteTime|" + proc);
//        } catch (Exception e) {
//            logger.error("GET_ACCOUNT_CAMID_GID|Exception : " + e.getMessage(), e);
//            jsonObject.addProperty("code", 400);
//            jsonObject.addProperty("message", "GET_ACCOUNT_CAMID_GID fail");
//            jsonObject.addProperty("data", "");
//        }
//        result = jsonObject.toString();
//        return result;
//    }
//
//    @RequestMapping(value = "/get_account_camid_appleid",method = RequestMethod.GET,produces="application/json;charset=UTF-8")
//    @ResponseBody
//    public String GET_ACCOUNT_CAMID_APPLEID(){
//        String result="";
//        long start=System.currentTimeMillis();
//        JsonObject jsonObject=new JsonObject();
//        try{
//            List<CamIdDeviceToken> camIdApple = camIdDeviceTokenService.GET_ACCOUNT_APPLEID();
//
//            jsonObject.addProperty("code",200);
//            jsonObject.addProperty("message","GET_ACCOUNT_CAMID");
//            JsonElement element=new Gson().toJsonTree(camIdApple,new TypeToken<List<CamIdDeviceToken>>(){}.getType());
//
//            jsonObject.addProperty("count",camIdApple.size());
//            jsonObject.add("data",element);
//
//            long proc=System.currentTimeMillis()-start;
//            logger.info("GET_ACCOUNT_CAMID_APPLEID : "+ "|ExecuteTime|"+proc);
//        }catch(Exception e){
//            logger.error("GET_ACCOUNT_CAMID_APPLEID | Exception : " + e.getMessage(), e);
//            jsonObject.addProperty("code", 400);
//            jsonObject.addProperty("message", "GET_ACCOUNT_CAMID_APPLEID fail");
//            jsonObject.addProperty("data", "");
//        }
//        result=jsonObject.toString();
//        return result;
//    }
//
//    @RequestMapping(value = "/get_account_camid_non_login",method = RequestMethod.GET,produces="application/json;charset=UTF-8")
//    @ResponseBody
//    public String GET_ACCOUNT_CAMID_NON_LOGIN(){
//        String result="";
//        long start=System.currentTimeMillis();
//        JsonObject jsonObject=new JsonObject();
//        try{
//            List<CamIdDeviceToken> camIdNonLogin = camIdDeviceTokenService.GET_ACCOUNT_CAMID_NON_LOGIN();
//
//            jsonObject.addProperty("code",200);
//            jsonObject.addProperty("message","GET_ACCOUNT_CAMID");
//            JsonElement element=new Gson().toJsonTree(camIdNonLogin,new TypeToken<List<CamIdDeviceToken>>(){}.getType());
//
//            jsonObject.addProperty("count",camIdNonLogin.size());
//            jsonObject.add("data",element);
//
//            long proc=System.currentTimeMillis()-start;
//            logger.info("GET_ACCOUNT_CAMID_NON_LOGIN : "+ "|ExecuteTime|"+proc);
//        }catch(Exception e){
//            logger.error("GET_ACCOUNT_CAMID_NON_LOGIN | Exception : " + e.getMessage(), e);
//            jsonObject.addProperty("code", 400);
//            jsonObject.addProperty("message", "GET_ACCOUNT_CAMID_NON_LOGIN fail");
//            jsonObject.addProperty("data", "");
//        }
//        result=jsonObject.toString();
//        return result;
//    }
//
//    @RequestMapping(value = "/get_account_camid_non_singup",method = RequestMethod.GET,produces="application/json;charset=UTF-8")
//    @ResponseBody
//    public String GET_ACCOUNT_CAMID_NON_SINGUP() {
//        String result = "";
//        long start = System.currentTimeMillis();
//        JsonObject jsonObject = new JsonObject();
//        try {
//            List<CamIdDeviceToken> camIdNonSingup = camIdDeviceTokenService.GET_ACCOUNT_CAMID_NON_SIGNUP();
//
//            jsonObject.addProperty("code", 200);
//            jsonObject.addProperty("message", "GET_ACCOUNT_CAMID");
//            JsonElement element = new Gson().toJsonTree(camIdNonSingup, new TypeToken<List<CamIdDeviceToken>>() {
//            }.getType());
//
//            jsonObject.addProperty("count", camIdNonSingup.size());
//            jsonObject.add("data", element);
//
//            long proc = System.currentTimeMillis() - start;
//            logger.info("GET_ACCOUNT_CAMID_NON_SINGUP : " + "|ExecuteTime|" + proc);
//        } catch (Exception e) {
//            logger.error("GET_ACCOUNT_CAMID_NON_SIGNUP | Exception : " + e.getMessage(), e);
//            jsonObject.addProperty("code", 400);
//            jsonObject.addProperty("message", "GET_ACCOUNT_CAMID_NON_SIGNUP fail");
//            jsonObject.addProperty("data", "");
//        }
//        result = jsonObject.toString();
//        return result;
//    }
//
//    @RequestMapping(value = "/get_account_camid_android",method = RequestMethod.GET,produces="application/json;charset=UTF-8")
//    @ResponseBody
//    public String GET_ACCOUNT_CAMID_ANDROID(){
//        String result="";
//        long start=System.currentTimeMillis();
//        JsonObject jsonObject=new JsonObject();
//        try{
//            List<CamIdDeviceToken> camIdAndroid = camIdDeviceTokenService.GET_ACCOUNT_CAMID_ANDROID();
//
//            jsonObject.addProperty("code",200);
//            jsonObject.addProperty("message","GET_ACCOUNT_CAMID");
//            JsonElement element=new Gson().toJsonTree(camIdAndroid,new TypeToken<List<CamIdDeviceToken>>(){}.getType());
//
//            jsonObject.addProperty("count",camIdAndroid.size());
//            jsonObject.add("data",element);
//
//            long proc=System.currentTimeMillis()-start;
//            logger.info("GET_ACCOUNT_CAMID_ANDROID : "+ "|ExecuteTime|"+proc);
//        }catch(Exception e){
//            logger.error("GET_ACCOUNT_CAMID_ANDROID | Exception : " + e.getMessage(), e);
//            jsonObject.addProperty("code", 400);
//            jsonObject.addProperty("message", "GET_ACCOUNT_CAMID_ANDROID fail");
//            jsonObject.addProperty("data", "");
//        }
//        result=jsonObject.toString();
//        return result;
//    }
//
//    @RequestMapping(value = "/get_account_camid_ios",method = RequestMethod.GET,produces="application/json;charset=UTF-8")
//    @ResponseBody
//    public String GET_ACCOUNT_CAMID_IOS(){
//        String result="";
//        long start=System.currentTimeMillis();
//        JsonObject jsonObject=new JsonObject();
//        try{
//            List<CamIdDeviceToken> camIdIOS = camIdDeviceTokenService.GET_ACCOUNT_CAMID_IOS();
//
//            jsonObject.addProperty("code",200);
//            jsonObject.addProperty("message","GET_ACCOUNT_CAMID");
//            JsonElement element=new Gson().toJsonTree(camIdIOS,new TypeToken<List<CamIdDeviceToken>>(){}.getType());
//
//            jsonObject.addProperty("count",camIdIOS.size());
//            jsonObject.add("data",element);
//
//            long proc=System.currentTimeMillis()-start;
//            logger.info("GET_ACCOUNT_CAMID_IOS : "+ "|ExecuteTime|"+proc);
//        }catch(Exception e){
//            logger.error("GET_ACCOUNT_CAMID_IOS | Exception : " + e.getMessage(), e);
//            jsonObject.addProperty("code", 400);
//            jsonObject.addProperty("message", "GET_ACCOUNT_CAMID_IOS fail");
//            jsonObject.addProperty("data", "");
//        }
//        result=jsonObject.toString();
//        return result;
//    }
//
//    @RequestMapping(value = "/get_account_camid_isdn",method = RequestMethod.GET,produces="application/json;charset=UTF-8")
//    @ResponseBody
//    public String GET_ACCOUNT_CAMID_ISDN(@RequestParam("isdn") String isdn){
//
//        String result="";
//        long start=System.currentTimeMillis();
//        JsonObject jsonObject=new JsonObject();
//        try{
//            List<CamIdDeviceToken> camIdIsdn = camIdDeviceTokenService.GET_ACCOUNT_ISDN(isdn);
//
//            jsonObject.addProperty("code",200);
//            jsonObject.addProperty("message","GET_ACCOUNT_CAMID");
//            JsonElement element=new Gson().toJsonTree(camIdIsdn,new TypeToken<List<CamIdDeviceToken>>(){}.getType());
//
//            jsonObject.addProperty("count",camIdIsdn.size());
//            jsonObject.add("data",element);
//
//            long proc=System.currentTimeMillis()-start;
//            logger.info("GET_ACCOUNT_CAMID_ISDN : "+ "|ExecuteTime|"+proc);
//        }catch(Exception e){
//            logger.error("GET_ACCOUNT_CAMID_ISDN | Exception : " + e.getMessage(), e);
//            jsonObject.addProperty("code", 400);
//            jsonObject.addProperty("message", "GET_ACCOUNT_CAMID_ISDN fail");
//            jsonObject.addProperty("data", "");
//        }
//        result=jsonObject.toString();
//        return result;
//    }
//
//    @RequestMapping(value = "/get_account_camid",method = RequestMethod.GET,produces="application/json;charset=UTF-8")
//    @ResponseBody
//    public String GET_ACCOUNT_CAMID(@RequestParam("camid") String camid){
//
//        String result="";
//        long start=System.currentTimeMillis();
//        JsonObject jsonObject=new JsonObject();
//        try{
//            List<CamIdDeviceToken> camId = camIdDeviceTokenService.GET_ACCOUNT_CAMID(camid);
//
//            jsonObject.addProperty("code",200);
//            jsonObject.addProperty("message","GET_ACCOUNT_CAMID");
//            JsonElement element=new Gson().toJsonTree(camId,new TypeToken<List<CamIdDeviceToken>>(){}.getType());
//
//            jsonObject.addProperty("count",camId.size());
//            jsonObject.add("data",element);
//
//            long proc=System.currentTimeMillis()-start;
//            logger.info("GET_ACCOUNT_CAMID : "+ "|ExecuteTime|"+proc);
//        }catch(Exception e){
//            logger.error("GET_ACCOUNT_CAMID | Exception : " + e.getMessage(), e);
//            jsonObject.addProperty("code", 400);
//            jsonObject.addProperty("message", "GET_ACCOUNT_CAMID fail");
//            jsonObject.addProperty("data", "");
//        }
//        result=jsonObject.toString();
//        return result;
//    }
//
//    @RequestMapping(value = "/new_segment",method = RequestMethod.POST,produces="application/json;charset=UTF-8")
//    @ResponseBody
//    public String NEW_SEGMENT(@RequestParam("login") String login,
//                              @RequestParam("status") String status,
//                              @RequestParam("phone") String phone ,
//                              @RequestParam("operate") String operate,
//                              @RequestParam("active ") int active,
//                              @RequestParam("version") String version){
//
//        String result="";
//        long start=System.currentTimeMillis();
//        JsonObject jsonObject=new JsonObject();
//        try{
//            List<CamIdDeviceToken> camId = camIdDeviceTokenService.GET_ACCOUNT_APPLEID();
//
//            jsonObject.addProperty("code",200);
//            jsonObject.addProperty("message","GET_ACCOUNT_CAMID");
//            JsonElement element=new Gson().toJsonTree(camId,new TypeToken<List<CamIdDeviceToken>>(){}.getType());
//
//            jsonObject.addProperty("count",camId.size());
//            jsonObject.add("data",element);
//
//            long proc=System.currentTimeMillis()-start;
//            logger.info("GET_ACCOUNT_CAMID : "+ "|ExecuteTime|"+proc);
//        }catch(Exception e){
//            logger.error("GET_ACCOUNT_CAMID | Exception : " + e.getMessage(), e);
//            jsonObject.addProperty("code", 400);
//            jsonObject.addProperty("message", "GET_ACCOUNT_CAMID fail");
//            jsonObject.addProperty("data", "");
//        }
//        result=jsonObject.toString();
//        return result;
//    }
//
//    private String getSqlNewSegment(String login,String status,String phone,String operate,int active,String version){
//        String sql = "SELECT * FROM (SELECT CDT.* ,ROW_NUMBER() OVER( ORDER BY CDT.id DESC ) row_num FROM CAMID_DEVICE_TOKEN CDT, " +
//                "ACCOUNT A WHERE CDT.CAM_ID=A.ID AND";
//        return null;
//    }
//
//}