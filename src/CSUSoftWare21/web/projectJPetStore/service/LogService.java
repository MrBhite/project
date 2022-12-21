package CSUSoftWare21.web.projectJPetStore.service;

import CSUSoftWare21.web.projectJPetStore.domain.Log;
import CSUSoftWare21.web.projectJPetStore.persistence.Dao.LogDAO;
import CSUSoftWare21.web.projectJPetStore.persistence.impl.LogDAOImpl;

public class LogService {
    Log log;
    private LogDAO logDAO;

    public LogService(){
        log = new Log();
        logDAO = new LogDAOImpl();
    }

    public String logInfo(Object ...s){
        return log.logInfomation(s);
    }

    public void insertLogInfo(String username, String logInfo){
        logDAO.insertLog(username, logInfo);
    }
}
