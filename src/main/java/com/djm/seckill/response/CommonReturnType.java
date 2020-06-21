package com.djm.seckill.response;

/**
 * Created by Xiao_Ming on 2020/6/21.
 */
public class CommonReturnType {
    //status 表明返回状态“success” “fail”
    private String status;
    private Object data;
    // 若status=success，则data内返回前端需要的json数据
    // 若status=fail，则data内使用通用的错误码格式

    public static CommonReturnType create(Object result) {
        return CommonReturnType.create(result,"success");
    }

    public static CommonReturnType create(Object result,String status) {
        CommonReturnType type= new CommonReturnType();
        type.setStatus(status);
        type.setData(result);
        return type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
