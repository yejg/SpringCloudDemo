package com.ye.app.contributor;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

@Component
public class CustomInfoContributor implements InfoContributor {
	@Override
	public void contribute(Info.Builder builder) {
		builder.withDetail("CustomInfo.desc", "自定义CustomInfoContributor").build();
	}
}
