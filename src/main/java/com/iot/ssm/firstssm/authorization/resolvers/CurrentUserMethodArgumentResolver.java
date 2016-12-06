package com.iot.ssm.firstssm.authorization.resolvers;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

import com.iot.ssm.firstssm.authorization.annotation.CurrentUser;
import com.iot.ssm.firstssm.authorization.interceptor.AuthorizationInterceptor;
import com.iot.ssm.firstssm.authorization.repository.UserModelRepository;


public class CurrentUserMethodArgumentResolver<T> implements
		HandlerMethodArgumentResolver {

	private Class<T> userModelClass;

	private UserModelRepository<T> userModelRepository;

	public void setUserModelClass(String className) {
		try {
			this.userModelClass = (Class<T>) Class.forName(className);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void setUserModelClass(Class<T> clazz) {
		this.userModelClass = clazz;
	}

	public void setUserModelRepository(
			UserModelRepository<T> userModelRepository) {
		this.userModelRepository = userModelRepository;
	}

	@Override
	public Object resolveArgument(MethodParameter parameter,
			ModelAndViewContainer mavContainer, NativeWebRequest webRequest,
			WebDataBinderFactory binderFactory) throws Exception {
		Object object = webRequest.getAttribute(
				AuthorizationInterceptor.REQUEST_CURRENT_KEY,
				RequestAttributes.SCOPE_REQUEST);
		if (object != null) {
			String key = String.valueOf(object);
			// 从数据库中查询并返回
			Object userModel = userModelRepository.getCurrentUser(key);
			if (userModel != null) {
				return userModel;
			}
			// 有key但是得不到用户，抛出异常
			throw new MissingServletRequestPartException(
					AuthorizationInterceptor.REQUEST_CURRENT_KEY);
		}
		// 没有key就直接返回null
		return null;
	}

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		return parameter.getParameterType().isAssignableFrom(userModelClass)
				&& parameter.hasParameterAnnotation(CurrentUser.class);
	}

}
