package com.sensiple.drm.account.utility;

import org.springframework.security.core.context.SecurityContextHolder;


/**
 * @author saravanan.k
 *
 */
public class SecurityUtil {

	public static String loggedInUser() {
		if (SecurityContextHolder.getContext() != null && SecurityContextHolder.getContext().getAuthentication() != null
				&& SecurityContextHolder.getContext().getAuthentication().getName() != null) {
			return SecurityContextHolder.getContext().getAuthentication().getName();
		}
		return "System";
	}
	}