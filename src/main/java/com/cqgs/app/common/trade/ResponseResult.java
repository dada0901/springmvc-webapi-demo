package com.cqgs.app.common.trade;

import java.util.HashMap;
import java.util.Map;

/**
 * webapi响应json数据结构
 * Created by fuda on 15/8/11.
 */
public class ResponseResult {

    /**
     * webapi响应头
     */
    private ResponseHeader header;

    /**
     * webapi响应体
     */
    private Map<String,Object> content;

    private ResponseResult(Builder b) {
        ResponseHeader header = new ResponseHeader(b.status,b.message);
        this.header = header;
        this.content = b.content;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Map content) {
        this.content = content;
    }

    public ResponseHeader getHeader() {
        return header;
    }

    public void setHeader(ResponseHeader header) {
        this.header = header;
    }

    public static class Builder{

        private ResponseStatus status;

        private String message="";

        private Map<String,Object> content = new HashMap<String, Object>();

        public Builder(ResponseStatus status){
            this.status = status;
        }

        public Builder message(String message){
            this.message = message;
            return this;
        }

        public Builder setContentMap(Map map) {
            this.content.putAll(map);
            return this;
        }

        public Builder content(String k, Object v) {
            this.content.put(k, v);
            return this;
        }

        public ResponseResult build() {
            return new ResponseResult(this);
        }
    }

    /**
     * 接口响应头
     */
    public class ResponseHeader{

        public ResponseHeader(ResponseStatus status, String message) {
            this.status = status;
            this.message = message;
        }

        private ResponseStatus status;

        private String message;

        public int getStatus() {
            return Integer.parseInt(status.toString());
        }

        public void setStatus(ResponseStatus status) {
            this.status = status;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

}
