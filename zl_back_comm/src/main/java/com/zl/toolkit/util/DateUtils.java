package com.zl.toolkit.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间工具类
 *
 * @author YangQing
 * @version 1.0.0
 */

public class DateUtils extends ObjectUtils {

	public static String FM_DATA_TIME = "yyyy-MM-dd HH:mm:ss";

	// 判断选择的日期是否是本周
	public static boolean isThisWeek(long time) {
		Calendar calendar = Calendar.getInstance();
		int currentWeek = calendar.get(Calendar.WEEK_OF_YEAR);
		calendar.setTime(new Date(time));
		int paramWeek = calendar.get(Calendar.WEEK_OF_YEAR);
		if (paramWeek == currentWeek) {
			return true;
		}
		return false;
	}

	// 判断选择的日期是否是今天
	public static boolean isToday(long time) {
		return isThisTime(time, "yyyy-MM-dd");
	}

	// 判断选择的日期是否是本月
	public static boolean isThisMonth(long time) {
		return isThisTime(time, "yyyy-MM");
	}

	private static boolean isThisTime(long time, String pattern) {
		Date date = new Date(time);
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String param = sdf.format(date);// 参数时间
		String now = sdf.format(new Date());// 当前时间
		if (param.equals(now)) {
			return true;
		}
		return false;
	}

	/**
	 * 计算两个日期之间相差的天数
	 *
	 * @param smdate
	 *            较小的时间
	 * @param bdate
	 *            较大的时间
	 * @return 相差天数
	 * @throws ParseException
	 */
	public static int daysBetween(Date smdate, Date bdate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			smdate = sdf.parse(sdf.format(smdate));

			bdate = sdf.parse(sdf.format(bdate));
			Calendar cal = Calendar.getInstance();
			cal.setTime(smdate);
			long time1 = cal.getTimeInMillis();
			cal.setTime(bdate);
			long time2 = cal.getTimeInMillis();
			long between_days = (time2 - time1) / (1000 * 3600 * 24);

			return Integer.parseInt(String.valueOf(between_days));
		} catch (ParseException e) {
			e.printStackTrace();
			return -1;
		}
	}

	/**
	 * 计算两个日期之间相差的天数
	 *
	 * @param smdate
	 *            较小的时间
	 * @param bdate
	 *            较大的时间
	 * @return 相差天数
	 */
	public static int daysBetween(String smdate, String bdate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(sdf.parse(smdate));
		long time1 = cal.getTimeInMillis();
		cal.setTime(sdf.parse(bdate));
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);

		return Integer.parseInt(String.valueOf(between_days));
	}

	/**
	 * 时间转int
	 * 
	 * @param smdate
	 *            时间
	 * @return int型
	 */
	public static int dateFomateYM(Date smdate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		return Integer.parseInt(sdf.format(smdate));
	}

	/**
	 * 时间格式转换
	 * 
	 * @param smdate
	 *            时间
	 * @return string型
	 */
	public static String dateFomate(Date smdate, String simpleDateFormat) {
		SimpleDateFormat sdf = new SimpleDateFormat(simpleDateFormat);
		return sdf.format(smdate);
	}

	/**
	 * 获取当前时间字符串
	 */
	public static String getNowStr() {
		DateFormat format = new SimpleDateFormat("HH:mm");
		String time = format.format(new Date());
		return time;
	}

	/**
	 * 获取今天周几（中国）
	 * 
	 * @return
	 */
	public static int getChineseDayOffsetOfWeek(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int weekday = c.get(Calendar.DAY_OF_WEEK);
		if (weekday == 1) {
			return 7;
		} else {
			return weekday - 1;
		}
	}

	/**
	 * 获取今天周几（国际）
	 * 
	 * @return
	 */
	public static int getDayOffsetOfWeek(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int weekday = c.get(Calendar.DAY_OF_WEEK);
		return weekday;
	}

	/**
	 * 获取今天是本月的第几天
	 * 
	 * @return
	 */
	public static int getDayOffsetOfMonth() {
		Calendar c = Calendar.getInstance();
		int datenum = c.get(Calendar.DATE);
		return datenum;
	}

	public static Date strToDate(String dateStr) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return format.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String dateToStr(Date date){
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(date);
	}


}
