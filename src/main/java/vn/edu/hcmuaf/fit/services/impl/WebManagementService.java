package vn.edu.hcmuaf.fit.services.impl;

import vn.edu.hcmuaf.fit.dao.IManagementWebDAO;
import vn.edu.hcmuaf.fit.dao.impl.ManagementWebDAO;
import vn.edu.hcmuaf.fit.services.IWebManagementService;

public class WebManagementService implements IWebManagementService {
    IManagementWebDAO iManagementWebDAO = new ManagementWebDAO();
    @Override
    public void saveWebManagement(String name, String nameWeb, String content) {
        iManagementWebDAO.saveWebManagement(name, nameWeb, content);
    }
}
