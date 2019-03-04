package com.xxl.job.executor.service.jobhandler;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import com.xxl.job.executor.po.AqyBroadcast;
import com.xxl.job.executor.util.HttpDataUtil;
import com.xxl.job.executor.util.JsoupParserUtil;
import com.xxl.job.service.executor.handler.AqyBroadcastService;

@JobHandler(value = "aqyJobHandler")
@Component
public class AqyFlimListGlueJobHandler extends IJobHandler {

	@Resource
	AqyBroadcastService aqyBroadcastService;

	@Override
	public ReturnT<String> execute(String param) throws Exception {
		String html = HttpDataUtil.getHtml("https://www.iqiyi.com/weidianying/");
		Elements elements = JsoupParserUtil.getElementsByClassNameTagName(html, "img-list", "a");
		int i = 1;
		List<AqyBroadcast> aqyBroadcastList = new ArrayList<AqyBroadcast>();
		for (Element element : elements) {
			String href = JsoupParserUtil.getAttributeValue(element, "href");
			aqyBroadcastList.add(new AqyBroadcast("id", href, i++));
		}
		int count = aqyBroadcastService.insertAqyBroadcastList(aqyBroadcastList);
		System.out.println(count);
		return null;
	}

}
