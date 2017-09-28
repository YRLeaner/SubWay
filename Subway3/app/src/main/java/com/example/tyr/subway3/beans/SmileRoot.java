package com.example.tyr.subway3.beans;

import java.io.Serializable;
import java.util.List;

/**
 * Created by tyr on 2017/8/5.
 */
public class SmileRoot implements Serializable{
    private int error_code;
    private String reason;
    private Result result;
    public void setError_code(int error_code) {
        this.error_code = error_code;
    }
    public int getError_code() {
        return error_code;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
    public String getReason() {
        return reason;
    }

    public void setResult(Result result) {
        this.result = result;
    }
    public Result getResult() {
        return result;
    }



    public static class Result implements Serializable{

        private List<Data> data;
        public void setData(List<Data> data) {
            this.data = data;
        }
        public List<Data> getData() {
            return data;
        }

    }


    public class Data implements Serializable{

        private String content;
        private String hashId;
        private int unixtime;
        private String updatetime;
        public void setContent(String content) {
            this.content = content;
        }
        public String getContent() {
            return content;
        }

        public void setHashId(String hashId) {
            this.hashId = hashId;
        }
        public String getHashId() {
            return hashId;
        }

        public void setUnixtime(int unixtime) {
            this.unixtime = unixtime;
        }
        public int getUnixtime() {
            return unixtime;
        }

        public void setUpdatetime(String updatetime) {
            this.updatetime = updatetime;
        }
        public String getUpdatetime() {
            return updatetime;
        }

    }
}
