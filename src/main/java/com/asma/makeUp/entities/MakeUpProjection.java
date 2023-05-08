package com.asma.makeUp.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nomMake", types = { MakeUp.class })
public interface MakeUpProjection {
	public String getNomMakeUp();

}
