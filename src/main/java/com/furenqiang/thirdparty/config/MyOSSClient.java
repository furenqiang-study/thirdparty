package com.furenqiang.thirdparty.config;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyOSSClient {

    private OSS oss=null;

    @Value("${alibaba.cloud.access-key}")
    private String accessKeyId;

    @Value("${alibaba.cloud.secret-key}")
    private String accessKeySecret;

    @Value("${alibaba.cloud.oss.endpoint}")
    private String endpoint;

    @Value("${alibaba.cloud.oss.bucket}")
    private String bucket;


    public OSS getInstanceMyOSSClient() {
        if(this.oss==null){
            synchronized(OSS.class){
                if(this.oss==null){
                    return new OSSClientBuilder().build(this.endpoint, this.accessKeyId, this.accessKeySecret);
                }
            }
        }
        return oss;
    }

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public String getAccessKeySecret() {
        return accessKeySecret;
    }

    public void setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }
}
