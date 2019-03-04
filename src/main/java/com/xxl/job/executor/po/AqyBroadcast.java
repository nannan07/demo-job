package com.xxl.job.executor.po;

public class AqyBroadcast {

	private String id;

	private String href;

	private int sort;

	public AqyBroadcast() {

	}

	public AqyBroadcast(String id, String href, int sort) {
		this.id = id;
		this.href = href;
		this.sort = sort;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

}
