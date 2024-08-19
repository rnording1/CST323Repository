package com.gcu;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderUtil {

	public static void main(String[] args) {

		String encoded = new BCryptPasswordEncoder().encode("password1");
		System.out.println(encoded);

	}

}
