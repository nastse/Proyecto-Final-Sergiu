package com.demo.jobs;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.StatefulJob;
import org.springframework.scheduling.quartz.QuartzJobBean;


//CREO TAREAS PROGRAMADAS TIPO CRON
//HAY QUE CONFIGURAR PREVIAMENTE EN WEB-INF/CONFIG - SPRING-SERVLET
public class FirstJob extends QuartzJobBean implements StatefulJob{

	@Override
	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
		
		System.out.println("He ejecutado mi primera tarea");
		
	}
	
}
