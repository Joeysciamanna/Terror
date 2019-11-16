package ch.g_7.terror.bean;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ch.g_7.terror.model.Log;
import ch.g_7.terror.service.ILogService;

@Named
@RequestScoped
public class LogBean {

	@Inject
	private ILogService logService;
	
	
	
	public List<Log> getAllLogs(){
		return logService.getAllLogsOfUser();
	}
	
}
