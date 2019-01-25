package org.boluo.utils.constant;

public class Constant {

	public static class IsEnabel {
		public final static Integer ENABEL = 1;
		public final static Integer DISABLED = 0;
	}
	/**
	 * 公用code
	 * @author 树袋老师
	 *
	 */
	public static class commenStatus {
		public final static String NORMAL = "0";
		public final static String FREEZE = "1";
	}

	public static class CallTarget {
		public final static String CALL_TARGET_CODE = "call_target_code";
		public final static String SALE_CALL = "0";
	}

	public static class Default {
		/* 默认关系：其他 */
		public final static Integer RELATIONSHIP = 7;
		/* 默认关系：其他 */
		public final static Integer CURRVERSION = 0;

	}
	/*
	 * public static class Sys { public final static String SYS_CODE = "sys"; }
	 */

	/**
	 * 角色
	 * 
	 * @author liushuang
	 *
	 */
	public static class roleCode {
		// 系统管理员
		public final static String SUPERADMIN = "superadmin";
		// 销售总监
		public final static String ORGADMIN = "orgadmin";
		// 教学总监
		public final static String TEACHDESIGNER = "teachDesigner";
		// 老师
		public final static String TEACHER = "teacher";
		// 渠道总监
		public final static String SOURCEDIRECTOR = "sourcedirector";
		// 渠道经理
		public final static String SOURCEMANAGE = "sourcemanage";
		// 教学总监
		/* public final static String ORGADMIN="orgadmin"; */
		// 销售经理
		/* public final static String ORGADMIN="orgadmin"; */
		// 学生
		/* public final static String TEACHDESIGNER="teachDesigner"; */
	}

	/**
	 * 渠道分配状态
	 * 
	 * @author liushuang
	 *
	 */
	public static class DitchStatus {
		// 未分配
		public final static String UNASSIGNED = "0";
		// 已分配
		public final static String ASSIGNED = "1";
		// 全部
		public final static String ALL = "2";
	}

	/**
	 * 名单上锁状态
	 * 
	 * @author 树袋老师
	 *
	 */
	public static class listManageLockStatus {
		public final static String UNLOCAK = "0";
		public final static String LOCAKED = "1";
	}

	/**
	 * 渠道历史操作状态
	 * 
	 * @author liushuang
	 *
	 */
	public static class DitchOperaType {
		// 经理重新分配
		public final static String REDISTRIBUTION_CODE = "0";
		public final static String REDISTRIBUTION_REMARK = "经理重新分配";
		// 到时自动回归公有池
		public final static String AUTOREGRESSIVE_CODE = "1";
		public final static String AUTOREGRESSIVE_REMARK = "到时自动回归公有池";
		// 删除
		public final static String DEL_CODE = "2";
		public final static String DEL_REMARK = "删除";
		// 更新
		public final static String UPDATE_CODE = "3";
		public final static String UPDATE_REMARK = "更新";
	}

	/**
	 * 名单以及名单家长历史操作状态
	 * 
	 * @author liushuang
	 *
	 */
	public static class ListManageOperaType {
		// 名单上传覆盖
		public final static String UPLOAD_OVERLAY_CODE = "1";
		public final static String UPLOAD_OVERLAY_REMARK = "名单上传覆盖";
		// 手动抽回
		public final static String MANUAL_WITHDRAW_CODE = "2";
		public final static String MANUAL_WITHDRAW_REMARK = "手动抽回";
		// 指定期限未销售抽回
		public final static String EXTENDED_WITHDRAWAL_CODE = "3";
		public final static String EXTENDED_WITHDRAWAL_REMARK = "指定期限未销售抽回";
		// 手动分配
		public final static String MANUAL_ALLOCATION_CODE = "4";
		public final static String MANUAL_ALLOCATION_REMARK = "手动分配";
		// 置为黑名单
		public final static String BLACKLISTING_CODE = "5";
		public final static String BLACKLISTING_REMARK = "置为黑名单";
		// 加锁
		public final static String LOCKING_CODE = "6";
		public final static String LOCKING_REMARK = "加锁";
		// 解锁
		public final static String UNLOCK_CODE = "7";
		public final static String UNLOCK_REMARK = "解锁";
		// 删除名单
		public final static String DELETE_LIST_CODE = "8";
		public final static String DELETE_LIST_REMARK = "删除名单";
		// 新增名单(不覆盖)删除重复名单
		public final static String DELETE_DUPLICATE_LIST_CODE= "9";
		public final static String DELETE_DUPLICATE_LIST_REMARK = "新增名单删除重复名单";
		// 新增名单(覆盖)删除家长信息
		public final static String DELETE_COVER_PARENTS_CODE= "10";
		public final static String DELETE_COVER_PARENTS_REMARK = "新增名单(覆盖)删除家长信息";
		// 新增名单(覆盖)修改名单信息
		public final static String EDIT_COVER_LIST_CODE= "11";
		public final static String EDIT_COVER_LIST_REMARK = " 新增名单(覆盖)修改名单信息";
	}

	/**
	 * 日志记录表中日志状态
	 * 
	 * @author chenjinbiao
	 *
	 */
	public static class LogCallOutStatus {
		/** 初始化 */
		public final static String INIT = "0";
		/** 处理中 */
		public final static String UNDER_PROCESS = "1";
		/** 成功 */
		public final static String SUCCESS = "2";
		/** 失败 */
		public final static String FAIL = "3";
	}

	/**
	 * 日志记录表中日志类型
	 * 
	 * @author chenjinbiao
	 *
	 */
	public static class LogCallOutType {
		/** 请求 */
		public final static String REQUEST = "1";
		/** 响应 */
		public final static String RESPONSE = "2";
	}

	/**
	 * 日志记录表中日志服务编码
	 * 
	 * @author chenjinbiao
	 *
	 */
	public static class LogCallOutServiceCode {
		/** 拓课云服务 */
		public final static String TALK = "talk";
		/** 支付宝支付服务 */
		public final static String ALIPAY = "alipay";
		/** 微信支付服务 */
		public final static String WXPAY = "wxpay";
		/** 呼叫服务 */
		public final static String CALL_ENGINE = "hantian";
	}

	/**
	 * 销售状态
	 * 
	 * @author liushuang
	 *
	 */
	public static class SaleCode {
		/** 未分配 */
		public final static String TO_BE_SOLD = "0";
		/** 已分配未拨打 */
		public final static String ACTIVATED = "1";
		/** 已拨打未试听 */
		public final static String TRACKING_PROCESS = "2";
		/** 已申请试听 */
		public final static String APPLY = "3";
		/** 已安排试听 */
		public final static String ARRANGE = "4";
		/** 已申请试听 */
		public final static String FAIL = "8";
		/** 已签单 */
		public final static String SUCCESS = "9";
	}

	/**
	 * A~Z优先级逐级增高
	 * 
	 * @author liushuang
	 *
	 */
	public static class ListManagePriorityCode {
		/** 普通名单/已分配销售 */
		public final static String A = "100";
		/** 精准名单/已分配销售 */
		public final static String B = "200";
		/** 活动名单/已分配销售 */
		public final static String B1 = "250";
		/** 已拨打未试听 */
		public final static String C = "300";
		/** 已安排试听 */
		public final static String D = "400";
	}

	/**
	 * 名单类型
	 * 
	 * @author liushuang
	 *
	 */
	public static class ListTypeCode {
		/** 名单 */
		public final static String BATCH = "0";
		/** 线索 */
		public final static String ACCURATE = "1";
		/** 运营 */
		public final static String CAMPAIGN = "2";
		/** 精推 */
		public final static String PRECISE = "3";
	}

	/**
	 * 名单类型
	 * @author chenjinbiao
	 *
	 */
	public static class ListLevelCode {
		/**S级名单 */
		public final static String S = "0";
		/**A级名单 */
		public final static String A = "1";
		/**B级名单*/
		public final static String B = "2";
		/**C级名单*/
		public final static String C = "3";
	}
	/**
	 * 名单标识
	 * 
	 * @author liushuang
	 *
	 */
	public static class ListManageFlagCode {
		/** 无标识 */
		public final static String NO_MARK = "0";
		/** TMK标识 */
		public final static String TMK = "1";
		/** 回抽标识 */
		public final static String PUMPBACK = "2";
	}

	/**
	 * 定时任务状态 0为可排 / 1为不可排
	 * 
	 * @author liushuang
	 *
	 */
	public static class OptStatusCode {
		/** 无标识 */
		public final static String NORMAL = "正常";
		/** TMK标识 */
		public final static String TAKEOUT = "已取出";
	}
	
}