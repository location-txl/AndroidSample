package com.sun.hm_sp_lib;

import java.util.Set;

/**
 * @author tianxiaolong
 * time：2020-01-12 17:00
 * description：
 */
public interface HmEditor  {
	void putSet(String key, Set<String> stringSet);

	void putString(String key,String value);

	void remove(String key);

	void clear();

	void apply();
}
