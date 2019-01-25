package org.boluo.utils.wrapper.util;

import java.util.regex.Pattern;


/**
 * 数据验证工具类
 * 
 * @author chenjinbiao
 * @date 2019年1月18日
 *
 */
public class ValidUtil {
	
	/**
	 * 是手机?
	 * 
	 * @param mobile
	 * @return
	 */
	public static boolean isMobile(final String mobile) {
		return Pattern.compile("^1([358][0-9]|4[579]|66|7[0135678]|9[89])[0-9]{8}$").matcher(mobile).matches();
	}

	/**
	 * 是电话?
	 * 
	 * @param mobile
	 * @return
	 */
	public static boolean isTel(final String tel) {
		return Pattern.compile("^(0[1-9]{2})-\\d{8}$|^(0[1-9]{3}-(\\d{7,8}))$").matcher(tel).matches();
	}

	/**
	 * 是邮箱?
	 * 
	 * @param email
	 * @return
	 */
	public static boolean isEmail(final String email) {
		return Pattern.compile("^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$")
				.matcher(email).matches();
	}

	/**
	 * 是用户名?
	 * 
	 * @param userName
	 * @return
	 */
	public static boolean isUserName(final String userName) {
		return Pattern.compile("^[A-Za-z0-9]{2,22}$").matcher(userName).matches();
	}

	/**
	 * 是密码?
	 * 
	 * @param pwd
	 * @return
	 */
	public static boolean isPwd(final String pwd) {
		return Pattern.compile("^.{6,20}$").matcher(pwd).matches();
	}

	/**
	 * 是中文?
	 * 
	 * @param chinese
	 * @return
	 */
	public static boolean isChinese(final String chinese) {
		return Pattern.compile("^[\u4e00-\u9fa5]+$").matcher(chinese).matches();
	}
	/**
	 * 是数字.数字.数字?
	 * 
	 * @param String
	 * @return
	 */
	public static boolean isVersionNumber(final String chinese) {
		return Pattern.compile("^\\d{1}\\.{1}\\d{1}\\.{1}\\d{1}$").matcher(chinese).matches();
	}
	/**
	 * 是微信?
	 * 
	 * @param 
	 * @return
	 */
	public static boolean isWechat(final String chinese) {
		return Pattern.compile("^[a-zA-Z]{1}[-_a-zA-Z0-9]{5,19}$|^1([358][0-9]|4[579]|66|7[0135678]|9[89])[0-9]{8}$|^[1-9][0-9]{4,14}$").matcher(chinese).matches();
	}
	/**
	 * 是姓名？
	 * 
	 * @param 
	 * @return
	 */
	public static boolean isName(final String chinese) {
		return Pattern.compile("^[\\u4E00-\\u9FA5A-Za-z\\d*]{2,8}$").matcher(chinese).matches();
	}
	
}