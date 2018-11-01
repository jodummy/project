package com.common.www.dto;

//1. PagingDto
public class PagingDto {

	private int pageCnt; // 출력할 페이지번호 갯수
	private int index; // 출력할 페이지번호
	private int pageStartNum; // 출력할 페이지 시작 번호
	private int listCnt; // 출력할 리스트 갯수
	private int total; // 리스트 총 갯수

	private int mem_no; // 전자결재 회원 번호
	private String doc_status; // 전자결재 문서 상태
	private String app_status; // 전자결재 결재 상태
	private int ctgr_no; // 게시판 카테고리 분류
	private String dept_no; // 게시판 팀,클래스 카테고리 분류

	{
		pageCnt = 5;
		index = 0;
		pageStartNum = 1;
		listCnt = 10;
	}

	public PagingDto() {
	}

	public PagingDto(String index, String pageStartNum, String listCnt) {
		if (index != null) {
			this.index = Integer.parseInt(index);
		}
		if (pageStartNum != null) {
			this.pageStartNum = Integer.parseInt(pageStartNum);
		}
		if (listCnt != null) {
			this.listCnt = Integer.parseInt(listCnt);
		}
	}

	public int getStart() {
		return index * listCnt + 1;
	}

	public int getLast() {
		return (index * listCnt) + listCnt;
	}

	public int getPageLastNum() {
		int remainListCnt = total - listCnt * (pageStartNum - 1);
		int remainPageCnt = remainListCnt / listCnt;
		if (remainListCnt % listCnt != 0) {
			remainPageCnt++;
		}
		int pageLastNum = 0;
		if (remainListCnt <= listCnt) {
			pageLastNum = pageStartNum;
		} else if (remainPageCnt <= pageCnt) {
			pageLastNum = remainPageCnt + pageStartNum - 1;
		} else {
			pageLastNum = pageCnt + pageStartNum - 1;
		}
		return pageLastNum;
	}

	public int getPageCnt() {
		return pageCnt;
	}

	public void setPageCnt(int pageCnt) {
		this.pageCnt = pageCnt;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getPageStartNum() {
		return pageStartNum;
	}

	public void setPageStartNum(int pageStartNum) {
		this.pageStartNum = pageStartNum;
	}

	public int getListCnt() {
		return listCnt;
	}

	public void setListCnt(int listCnt) {
		this.listCnt = listCnt;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getCtgr_no() {
		return ctgr_no;
	}

	public void setCtgr_no(int ctgr_no) {
		this.ctgr_no = ctgr_no;
	}

	public String getDept_no() {
		return dept_no;
	}

	public void setDept_no(String dept_no) {
		this.dept_no = dept_no;
	}

	public int getMem_no() {
		return mem_no;
	}

	public void setMem_no(int mem_no) {
		this.mem_no = mem_no;
	}

	public String getDoc_status() {
		return doc_status;
	}

	public void setDoc_status(String doc_status) {
		this.doc_status = doc_status;
	}

	public String getApp_status() {
		return app_status;
	}

	public void setApp_status(String app_status) {
		this.app_status = app_status;
	}

	@Override
	public String toString() {
		return "PagingDto [pageCnt=" + pageCnt + ", index=" + index + ", pageStartNum=" + pageStartNum + ", listCnt="
				+ listCnt + ", total=" + total + ", mem_no=" + mem_no + ", doc_status=" + doc_status + ", app_status="
				+ app_status + ", ctgr_no=" + ctgr_no + ", dept_no=" + dept_no + "]";
	}

}