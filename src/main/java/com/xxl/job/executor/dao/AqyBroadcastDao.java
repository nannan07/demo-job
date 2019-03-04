package com.xxl.job.executor.dao;

import java.util.List;

import com.xxl.job.executor.po.AqyBroadcast;

public interface AqyBroadcastDao {
	
	int insertBatch(List<AqyBroadcast> aqyBroadcastList);
	
	String selectVideoString();

}
