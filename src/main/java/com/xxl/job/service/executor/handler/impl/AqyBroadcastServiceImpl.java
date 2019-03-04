package com.xxl.job.service.executor.handler.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xxl.job.executor.dao.AqyBroadcastDao;
import com.xxl.job.executor.po.AqyBroadcast;
import com.xxl.job.service.executor.handler.AqyBroadcastService;

@Service
public class AqyBroadcastServiceImpl implements AqyBroadcastService {

	@Resource
	AqyBroadcastDao aqyBroadcastDao;

	@Override
	public int insertAqyBroadcastList(List<AqyBroadcast> aqyBroadcastList) {
		if (aqyBroadcastList != null && aqyBroadcastList.size() > 0) {
			return aqyBroadcastDao.insertBatch(aqyBroadcastList);
		}
		return 0;
	}

	@Override
	public String selectVideoString() {
		return aqyBroadcastDao.selectVideoString();
	}

}
