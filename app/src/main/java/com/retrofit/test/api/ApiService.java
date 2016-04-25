package com.retrofit.test.api;

import com.retrofit.test.api.model.IpInfo;
import com.retrofit.test.api.response.BaseResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


/**
 * Created by rames on 2016/4/22.
 * yangju1@staff.weibo.com
 */
public interface ApiService {
    @GET("service/getIpInfo.php")
    Call<BaseResponse<IpInfo>> getIpInfo(@Query("ip") String ip);

    @GET("service/getIpInfo.php")
    Call<String> getIpInfo2(@Query("ip") String ip);
}
