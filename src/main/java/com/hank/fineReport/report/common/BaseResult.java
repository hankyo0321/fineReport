package com.hank.fineReport.report.common;

import org.springframework.http.HttpStatus;

public class BaseResult<T> {
    private int code;
    private String message;
    private T data;
    private String error; // 需要就留，不需要可移除

    public BaseResult() {}

    public BaseResult(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public BaseResult(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public BaseResult(int code, String message, T data, String error) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.error = error;
    }

    /* ====== 工廠方法（Java 8 友善）====== */

    /** 成功（有資料） */
    public static <T> BaseResult<T> success(T data, String message) {
        return new BaseResult<>(HttpStatus.OK.value(), message, data);
    }

    /** 成功（無資料）——避免 data=null 造成型別無法推斷 */
    public static BaseResult<Void> successMsg(String message) {
        return new BaseResult<>(HttpStatus.OK.value(), message, null);
    }

    /** 失敗（用 HttpStatus） */
    public static <T> BaseResult<T> failure(HttpStatus status, String message, String error) {
        return new BaseResult<>(status.value(), message, null, error);
    }

    /** 失敗（自訂 code） */
    public static <T> BaseResult<T> failure(int code, String message, String error) {
        return new BaseResult<>(code, message, null, error);
    }

    /* ====== getters / setters ====== */
    public int getCode() { return code; }
    public void setCode(int code) { this.code = code; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    public T getData() { return data; }
    public void setData(T data) { this.data = data; }
    public String getError() { return error; }
    public void setError(String error) { this.error = error; }
}
