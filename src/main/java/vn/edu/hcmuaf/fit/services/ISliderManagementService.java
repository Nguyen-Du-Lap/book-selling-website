package vn.edu.hcmuaf.fit.services;

import vn.edu.hcmuaf.fit.model.SlidePrModel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.sql.Date;
import java.util.List;

public interface ISliderManagementService {
    List<SlidePrModel> getAll();
    void hiddenSilde(String id);
    void activitySilde(String id);
    void insert(String name, String image, String link, String timeS, String timeF);
    void addImage(HttpServletRequest request, HttpServletResponse response, String name,  Part part, String timeS, String timeF);
}
