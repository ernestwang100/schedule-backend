package com.ernest.schedule.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SysUser {
    private Integer uid;
    private String username;
    @JsonProperty("userPwd") // Maps the JSON field "userPwd" to "user_pwd"
    private String user_pwd;


}
