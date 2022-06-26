package com.example.connectOracleDemo.repository.entity;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CamIdDeviceToken {

    private long id;
    private long cam_id;
    private String token;
    private long operating_system;
    private Date create_date;
    private Date last_update;
    private String lang;
    private long is_login;
    private String device_id;
    private String status;
    private String phone_number;

}
