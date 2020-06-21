package com.djm.seckill.error;

/**
 * Created by Xiao_Ming on 2020/6/21.
 */
public interface CommonError {
    public int getErrcode();
    public String getErrMsg();
    public CommonError setErrMsg(String errMsg);
}
