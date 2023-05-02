package vn.edu.hcmuaf.fit.services.impl;

import vn.edu.hcmuaf.fit.bean.Log;
import vn.edu.hcmuaf.fit.dao.ILogManagmentDao;
import vn.edu.hcmuaf.fit.dao.impl.LogManagmentDao;
import vn.edu.hcmuaf.fit.services.ILogManagmentService;

import java.util.List;

public class LogManagmentService implements ILogManagmentService {
    ILogManagmentDao dao = new LogManagmentDao();

    @Override
    public List<Log> getAll() {
        return dao.getAll();
    }
}
