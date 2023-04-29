package vn.edu.hcmuaf.fit.dao;

import vn.edu.hcmuaf.fit.model.RateModel;
import vn.edu.hcmuaf.fit.model.SlidePrModel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.util.List;

public interface ISliderManagmentDao {
    List<SlidePrModel> getAll();
    void hiddenSilde(String id);
    void activitySilde(String id);
    void insert(String name, String image, String link, String timeS, String timeF);
    void addImage(HttpServletRequest request, HttpServletResponse response, String name, String image, Part part, String timeS, String timeF);
}
