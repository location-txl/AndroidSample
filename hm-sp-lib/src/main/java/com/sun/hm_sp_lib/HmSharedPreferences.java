package com.sun.hm_sp_lib;

import java.sql.Statement;

/**
 * @author tianxiaolong
 * time：2020-01-12 16:57
 * description：
 */
public interface HmSharedPreferences {

	<T> T  get(String key,T defaultValue);


	HmEditor editor();


}

