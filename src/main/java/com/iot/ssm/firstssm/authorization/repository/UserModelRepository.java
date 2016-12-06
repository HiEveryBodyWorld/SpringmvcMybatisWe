package com.iot.ssm.firstssm.authorization.repository;

public interface UserModelRepository<T> {

	/**
     * 通过Key获得用户模型
     * @param key
     * @return
     */
    T getCurrentUser(String key);
}
