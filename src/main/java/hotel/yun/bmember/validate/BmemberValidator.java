package hotel.yun.bmember.validate;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


import hotel.yun.bmember.model.BmemberBean;

public class BmemberValidator implements Validator {
	private static final Pattern EMAIL_REGEX = Pattern.compile("^[\\w\\d._-]+@[\\w\\d.-]+\\.[\\w\\d]{2,6}$");

	@Override
	public boolean supports(Class<?> clazz) {
		return BmemberBean.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user_id", "bmemberBean.user_id.empty", "姓名欄位不正確");

		ValidationUtils.rejectIfEmpty(errors, "bs_password", "bmemberBean.bs_password.empty", "密碼欄不能空白");
		ValidationUtils.rejectIfEmpty(errors, "bs_email", "bmemberBean.bs_email.empty", "email欄不能空白");

		BmemberBean bb = (BmemberBean) target;
//		String name = customer.getName();
//		if (name == null || name.trim().length() == 0) {
//			errors.rejectValue("name", "customerBean.name.size");
//		}
		
		
		if (bb.getUser_id() != null && bb.getUser_id().length() < 2 || bb.getUser_id().length() > 30) {
			errors.rejectValue("user_id", "bmemberBean.user_id.size");
		}


		if (bb.getBs_email() != null && !EMAIL_REGEX.matcher(bb.getBs_email()).matches()) {
			errors.rejectValue("bs_password", "bmemberBean.bs_password.invalid");
		}

		if (bb.getBs_email() != null && !EMAIL_REGEX.matcher(bb.getBs_email()).matches()) {
			errors.rejectValue("bs_email", "bmemberBean.email.invalid");
		}

	}

}
