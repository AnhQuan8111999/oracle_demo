package com.example.connectOracleDemo.controller;

import com.example.connectOracleDemo.repository.CamIdDeviceTokenDao;
import com.example.connectOracleDemo.service.CamIdDeviceTokenService;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/v1/segment_user")
public class CountCamIdTokenController {

    @Autowired
    CamIdDeviceTokenService camIdDeviceTokenService;

    private static Logger logger = LoggerFactory.getLogger(CountCamIdTokenController.class);

    @RequestMapping(value = "/count_account_camid_metfone", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String COUNT_ACCOUNT_CAMID_METFONE() {
        String result = "";
        long start = System.currentTimeMillis();
        JsonObject jsonObject = new JsonObject();
        try {
            int metfone=camIdDeviceTokenService.COUNT_ACCOUNT_CAMID_METFONE();

            jsonObject.addProperty("code", 200);
            jsonObject.addProperty("message", "COUNT_ACCOUNT_CAMID_METFONE");
            jsonObject.addProperty("count  " ,metfone);

            long proc = System.currentTimeMillis() - start;
            logger.info("COUNT_ACCOUNT_CAMID_METFONE : " + "|ExecuteTime|" + proc);
        } catch (Exception e) {
            logger.error("COUNT_ACCOUNT_CAMID_METFONE|Exception : " + e.getMessage(), e);
            jsonObject.addProperty("code", 400);
            jsonObject.addProperty("message", "COUNT_ACCOUNT_CAMID_METFONE fail");
            jsonObject.addProperty("data", "");
        }
        result = jsonObject.toString();
        return result;
    }

    @RequestMapping(value = "/count_account_camid_non_metfone", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String COUNT_ACCOUNT_CAMID_NON_METFONE() {
        String result = "";
        long start = System.currentTimeMillis();
        JsonObject jsonObject = new JsonObject();
        try {
            int non_metfone=camIdDeviceTokenService.COUNT_GET_ACCOUNT_CAMID_NON_METFONE();

            jsonObject.addProperty("code", 200);
            jsonObject.addProperty("message", "COUNT_GET_ACCOUNT_CAMID_NON_METFONE");
            jsonObject.addProperty("count  " ,non_metfone);

            long proc = System.currentTimeMillis() - start;
            logger.info("COUNT_GET_ACCOUNT_CAMID_NON_METFONE : " + "|ExecuteTime|" + proc);
        } catch (Exception e) {
            logger.error("COUNT_GET_ACCOUNT_CAMID_NON_METFONE|Exception : " + e.getMessage(), e);
            jsonObject.addProperty("code", 400);
            jsonObject.addProperty("message", "COUNT_GET_ACCOUNT_CAMID_NON_METFONE fail");
            jsonObject.addProperty("data", "");
        }
        result = jsonObject.toString();
        return result;
    }

    @RequestMapping(value = "/count_account_fid", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String COUNT_ACCOUNT_FID() {
        String result = "";
        long start = System.currentTimeMillis();
        JsonObject jsonObject = new JsonObject();
        try {
            int fid=camIdDeviceTokenService.COUNT_GET_ACCOUNT_FID();

            jsonObject.addProperty("code", 200);
            jsonObject.addProperty("message", "COUNT_ACCOUNT_FID");
            jsonObject.addProperty("count  " ,fid);

            long proc = System.currentTimeMillis() - start;
            logger.info("COUNT_ACCOUNT_FID : " + "|ExecuteTime|" + proc);
        } catch (Exception e) {
            logger.error("COUNT_ACCOUNT_FID|Exception : " + e.getMessage(), e);
            jsonObject.addProperty("code", 400);
            jsonObject.addProperty("message", "COUNT_ACCOUNT_FID fail");
            jsonObject.addProperty("data", "");
        }
        result = jsonObject.toString();
        return result;
    }

    @RequestMapping(value = "/count_account_gid", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String COUNT_ACCOUNT_GID() {
        String result = "";
        long start = System.currentTimeMillis();
        JsonObject jsonObject = new JsonObject();
        try {
            int gid=camIdDeviceTokenService.COUNT_GET_ACCOUNT_GID();

            jsonObject.addProperty("code", 200);
            jsonObject.addProperty("message", "COUNT_ACCOUNT_GID");
            jsonObject.addProperty("count  " ,gid);

            long proc = System.currentTimeMillis() - start;
            logger.info("COUNT_ACCOUNT_GID : " + "|ExecuteTime|" + proc);
        } catch (Exception e) {
            logger.error("COUNT_ACCOUNT_GID|Exception : " + e.getMessage(), e);
            jsonObject.addProperty("code", 400);
            jsonObject.addProperty("message", "COUNT_ACCOUNT_GID fail");
            jsonObject.addProperty("data", "");
        }
        result = jsonObject.toString();
        return result;
    }

    @RequestMapping(value = "/count_account_appleid", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String COUNT_ACCOUNT_APPLEID() {
        String result = "";
        long start = System.currentTimeMillis();
        JsonObject jsonObject = new JsonObject();
        try {
            int appleid=camIdDeviceTokenService.COUNT_GET_ACCOUNT_APPLEID();

            jsonObject.addProperty("code", 200);
            jsonObject.addProperty("message", "COUNT_ACCOUNT_APPLEID");
            jsonObject.addProperty("count  " ,appleid);

            long proc = System.currentTimeMillis() - start;
            logger.info("COUNT_ACCOUNT_APPLEID : " + "|ExecuteTime|" + proc);
        } catch (Exception e) {
            logger.error("COUNT_ACCOUNT_APPLEID|Exception : " + e.getMessage(), e);
            jsonObject.addProperty("code", 400);
            jsonObject.addProperty("message", "COUNT_ACCOUNT_APPLEID fail");
            jsonObject.addProperty("data", "");
        }
        result = jsonObject.toString();
        return result;
    }

    @RequestMapping(value = "/count_account_camid_non_login", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String COUNT_ACCOUNT_CAMID_NON_LOGIN() {
        String result = "";
        long start = System.currentTimeMillis();
        JsonObject jsonObject = new JsonObject();
        try {
            int nonLogin=camIdDeviceTokenService.COUNT_GET_ACCOUNT_APPLEID();

            jsonObject.addProperty("code", 200);
            jsonObject.addProperty("message", "COUNT_ACCOUNT_CAMID_NON_LOGIN");
            jsonObject.addProperty("count " ,nonLogin);

            long proc = System.currentTimeMillis() - start;
            logger.info("COUNT_ACCOUNT_CAMID_NON_LOGIN : " + "|ExecuteTime|" + proc);
        } catch (Exception e) {
            logger.error("COUNT_ACCOUNT_CAMID_NON_LOGIN|Exception : " + e.getMessage(), e);
            jsonObject.addProperty("code", 400);
            jsonObject.addProperty("message", "COUNT_ACCOUNT_CAMID_NON_LOGIN fail");
            jsonObject.addProperty("data", "");
        }
        result = jsonObject.toString();
        return result;
    }

    @RequestMapping(value = "/count_account_camid_non_signup", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String COUNT_ACCOUNT_CAMID_NON_SIGNUP() {
        String result = "";
        long start = System.currentTimeMillis();
        JsonObject jsonObject = new JsonObject();
        try {
            int nonSingup=camIdDeviceTokenService.COUNT_GET_ACCOUNT_APPLEID();

            jsonObject.addProperty("code", 200);
            jsonObject.addProperty("message", "COUNT_ACCOUNT_CAMID_NON_SIGNUP");
            jsonObject.addProperty("count " ,nonSingup);

            long proc = System.currentTimeMillis() - start;
            logger.info("COUNT_ACCOUNT_CAMID_NON_SIGNUP : " + "|ExecuteTime|" + proc);
        } catch (Exception e) {
            logger.error("COUNT_ACCOUNT_CAMID_NON_SIGNUP|Exception : " + e.getMessage(), e);
            jsonObject.addProperty("code", 400);
            jsonObject.addProperty("message", "COUNT_ACCOUNT_CAMID_NON_SIGNUP fail");
            jsonObject.addProperty("data", "");
        }
        result = jsonObject.toString();
        return result;
    }

    @RequestMapping(value = "/count_account_camid_all", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String COUNT_ACCOUNT_CAMID_ALL() {
        String result = "";
        long start = System.currentTimeMillis();
        JsonObject jsonObject = new JsonObject();
        try {
            int all=camIdDeviceTokenService.COUNT_GET_ACCOUNT_CAMID_ALL();

            jsonObject.addProperty("code", 200);
            jsonObject.addProperty("message", "COUNT_ACCOUNT_CAMID_ALL");
            jsonObject.addProperty("count " ,all);

            long proc = System.currentTimeMillis() - start;
            logger.info("COUNT_ACCOUNT_CAMID_ALL : " + "|ExecuteTime|" + proc);
        } catch (Exception e) {
            logger.error("COUNT_ACCOUNT_CAMID_ALL|Exception : " + e.getMessage(), e);
            jsonObject.addProperty("code", 400);
            jsonObject.addProperty("message", "COUNT_ACCOUNT_CAMID_ALL fail");
            jsonObject.addProperty("data", "");
        }
        result = jsonObject.toString();
        return result;
    }

    @RequestMapping(value = "/count_account_camid_android", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String COUNT_ACCOUNT_CAMID_ANDROID() {
        String result = "";
        long start = System.currentTimeMillis();
        JsonObject jsonObject = new JsonObject();
        try {
            int all=camIdDeviceTokenService.COUNT_GET_ACCOUNT_CAMID_ANDROID();

            jsonObject.addProperty("code", 200);
            jsonObject.addProperty("message", "COUNT_ACCOUNT_CAMID_ANDROID");
            jsonObject.addProperty("count " ,all);

            long proc = System.currentTimeMillis() - start;
            logger.info("COUNT_ACCOUNT_CAMID_ANDROID : " + "|ExecuteTime|" + proc);
        } catch (Exception e) {
            logger.error("COUNT_ACCOUNT_CAMID_ANDROID|Exception : " + e.getMessage(), e);
            jsonObject.addProperty("code", 400);
            jsonObject.addProperty("message", "COUNT_ACCOUNT_CAMID_ANDROID fail");
            jsonObject.addProperty("data", "");
        }
        result = jsonObject.toString();
        return result;
    }

    @RequestMapping(value = "/count_account_camid_ios", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String COUNT_ACCOUNT_CAMID_IOS() {
        String result = "";
        long start = System.currentTimeMillis();
        JsonObject jsonObject = new JsonObject();
        try {
            int ios=camIdDeviceTokenService.COUNT_GET_ACCOUNT_CAMID_IOS();

            jsonObject.addProperty("code", 200);
            jsonObject.addProperty("message", "COUNT_ACCOUNT_CAMID_IOS");
            jsonObject.addProperty("count " ,ios);

            long proc = System.currentTimeMillis() - start;
            logger.info("COUNT_ACCOUNT_CAMID_IOS : " + "|ExecuteTime|" + proc);
        } catch (Exception e) {
            logger.error("COUNT_ACCOUNT_CAMID_IOS|Exception : " + e.getMessage(), e);
            jsonObject.addProperty("code", 400);
            jsonObject.addProperty("message", "COUNT_ACCOUNT_CAMID_IOS fail");
            jsonObject.addProperty("data", "");
        }
        result = jsonObject.toString();
        return result;
    }

    @RequestMapping(value = "/count_account_camid_isdn", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String COUNT_ACCOUNT_CAMID_ISDN(@RequestParam("isdn") String isdn) {
        String[] i=isdn.split(",");
        List<String> isdns= Arrays.asList(i);
        String result = "";
        long start = System.currentTimeMillis();
        JsonObject jsonObject = new JsonObject();
        try {
            int isdncount=camIdDeviceTokenService.COUNT_GET_ACCOUNT_ISDN(isdns);

            jsonObject.addProperty("code", 200);
            jsonObject.addProperty("message", "COUNT_ACCOUNT_CAMID_ISDN");
            jsonObject.addProperty("count " ,isdncount);

            long proc = System.currentTimeMillis() - start;
            logger.info("COUNT_ACCOUNT_CAMID_ISDN : " + "|ExecuteTime|" + proc);
        } catch (Exception e) {
            logger.error("COUNT_ACCOUNT_CAMID_ISDN|Exception : " + e.getMessage(), e);
            jsonObject.addProperty("code", 400);
            jsonObject.addProperty("message", "COUNT_ACCOUNT_CAMID_ISDN fail");
            jsonObject.addProperty("data", "");
        }
        result = jsonObject.toString();
        return result;
    }

    @RequestMapping(value = "/count_account_camid", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String COUNT_ACCOUNT_CAMID(@RequestParam("camid") String camid) {
        String[] i=camid.split(",");
        List<String> camids= Arrays.asList(i);
        String result = "";
        long start = System.currentTimeMillis();
        JsonObject jsonObject = new JsonObject();
        try {
            int camidcount=camIdDeviceTokenService.COUNT_GET_ACCOUNT_ISDN(camids);

            jsonObject.addProperty("code", 200);
            jsonObject.addProperty("message", "COUNT_ACCOUNT_CAMID");
            jsonObject.addProperty("count " ,camidcount);

            long proc = System.currentTimeMillis() - start;
            logger.info("COUNT_ACCOUNT_CAMID : " + "|ExecuteTime|" + proc);
        } catch (Exception e) {
            logger.error("COUNT_ACCOUNT_CAMID|Exception : " + e.getMessage(), e);
            jsonObject.addProperty("code", 400);
            jsonObject.addProperty("message", "COUNT_ACCOUNT_CAMID fail");
            jsonObject.addProperty("data", "");
        }
        result = jsonObject.toString();
        return result;
    }

}
