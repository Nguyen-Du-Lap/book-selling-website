package vn.edu.hcmuaf.fit.model;

public class Logging {
    private static Logging install;
    private static Logging me() {
        if(install == null)  install = new Logging();
        return install;
    }
    private Logging() {

    }

    private void log(int level, int userID,String src, String content) {

    }
}
