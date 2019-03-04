package com.xxl.job.executor.service.jobhandler;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.allmsi.sys.util.StrUtil;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.executor.util.HttpDataUtil;
import com.xxl.job.executor.util.JsonUtil;
import com.xxl.job.service.executor.handler.AqyBroadcastService;


@Component
public class AqyHotGlueJobHandler extends IJobHandler {

	@Resource
	AqyBroadcastService aqyBroadcastService;

	@SuppressWarnings("rawtypes")
	@Override
	public ReturnT<String> execute(String param) throws Exception {
		String videoString = aqyBroadcastService.selectVideoString();
		if(StrUtil.notEmpty(videoString)) {
			videoString = "https://pcw-api.iqiyi.com/video/video/hotplaytimes/"+"1948526400";
          	String json = HttpDataUtil.getHtml(videoString);
          	Map map = JsonUtil.toMap(json);
          	String data = (String) map.get("data");
          	List list = JsonUtil.toList(data);
          	for (Object object : list) {
				System.out.println(object);
			}
          	
		}
		return null;
	}

}
