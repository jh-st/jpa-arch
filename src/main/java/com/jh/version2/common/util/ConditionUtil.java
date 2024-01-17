package com.jh.version2.common.util;

import org.springframework.data.domain.PageRequest;

import lombok.experimental.UtilityClass;
import org.springframework.data.domain.Sort;
@UtilityClass
public class ConditionUtil {

	/**
	 * Gets page request.
	 *
	 * @return the page request
	 * @author [오지훈]
	 * @implNote Paging 처리를 위한 PageRequest return
	 * @since 2020. 10. 27. 오후 3:08:17
	 */
	public PageRequest getPageRequest(int page, int size, Sort sort) {
	    return PageRequest.of(page, size, sort);
	}

}
