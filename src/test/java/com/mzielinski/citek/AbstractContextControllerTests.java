package com.mzielinski.citek;

import com.mzielinski.citek.config.WebConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

@WebAppConfiguration
@ContextConfiguration(classes=WebConfig.class, loader=AnnotationConfigContextLoader.class)
public class AbstractContextControllerTests {

	@Autowired
	protected WebApplicationContext wac;

}
