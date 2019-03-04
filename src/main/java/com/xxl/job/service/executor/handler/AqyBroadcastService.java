package com.xxl.job.service.executor.handler;

import java.util.List;

import com.xxl.job.executor.po.AqyBroadcast;

public interface AqyBroadcastService {
	
	int insertAqyBroadcastList(List<AqyBroadcast> aqyBroadcastList);
	
	String selectVideoString();

}
