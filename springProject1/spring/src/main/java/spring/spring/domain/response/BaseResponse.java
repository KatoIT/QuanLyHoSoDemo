package spring.spring.domain.response;

import lombok.Data;

@Data
public class BaseResponse {
    protected int code;
    protected String detail;

    public BaseResponse setSuccess() {
        code = 0;
        detail = "Thành công!";
        return this;
    }

    public BaseResponse setFail() {
        code = -999;
        detail = "Thất bại!";
        return this;
    }

    public BaseResponse setFail(String detail) {
        this.code = -999;
        this.detail = detail;
        return this;
    }
}
