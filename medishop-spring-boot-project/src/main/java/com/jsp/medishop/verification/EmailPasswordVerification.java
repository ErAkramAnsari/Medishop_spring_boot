package com.jsp.medishop.verification;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

@Component
public class EmailPasswordVerification {

	public String verifyEmail(String email) {

		boolean alphabet = Pattern.compile("[a-zA-Z]").matcher(email).find();
		boolean number = Pattern.compile("[0-9]").matcher(email).find();
		boolean special = Pattern.compile("[@,.]").matcher(email).find();

		if ((alphabet && special && number)) {

			return email;
		} else {
			return null;
		}
	}

	public String verifyPassword(String password) {

		boolean alphabet = Pattern.compile("[a-zA-Z]").matcher(password).find();
		boolean number = Pattern.compile("[0-9]").matcher(password).find();
		boolean special = Pattern.compile("[@.#$%^&*]").matcher(password).find();

		int length = password.length();
		
		if ((alphabet && special && number)&&(length>=8 && length<=16)) {
			return password;
		} else {
			return null;
		}
	}
}
