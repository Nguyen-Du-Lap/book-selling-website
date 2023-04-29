package vn.edu.hcmuaf.fit.services.impl;

import vn.edu.hcmuaf.fit.dao.ISliderManagmentDao;
import vn.edu.hcmuaf.fit.dao.impl.SliderManagmentDao;

import vn.edu.hcmuaf.fit.model.SlidePrModel;
import vn.edu.hcmuaf.fit.services.ISliderManagementService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Date;
import java.util.List;

public class SliderManagementService implements ISliderManagementService {
    ISliderManagmentDao dao = new SliderManagmentDao();
    @Override
    public List<SlidePrModel> getAll() {
        return dao.getAll();
    }

    @Override
    public void hiddenSilde(String id) {
        dao.hiddenSilde(id);
    }

    @Override
    public void activitySilde(String id) {
        dao.activitySilde(id);
    }

    @Override
    public void insert(String name, String image, String link, String timeS, String timeF) {
        dao.insert(name,image,link,timeS,timeF);
    }
    @Override
    public void addImage(HttpServletRequest request, HttpServletResponse response, String name, Part part, String timeS, String timeF) {
        try {
            String realPath = request.getServletContext().getRealPath("/templates/images/sachUpload");
            String filename = Path.of(part.getSubmittedFileName()).getFileName().toString();

            if(!Files.exists(Path.of(realPath))) {
                Files.createDirectory(Path.of(realPath));
            }
            if( !filename.equals("")) {
                //luu vao thu muc
                String pathF = realPath +"\\"+"-"+filename;
                part.write(pathF);
                //luu vao database
                dao.insert(name,filename, "/templates/images/"+filename,timeS,timeF);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
