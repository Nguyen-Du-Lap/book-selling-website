package vn.edu.hcmuaf.fit.bean;


import org.jdbi.v3.core.Jdbi;
import vn.edu.hcmuaf.fit.db.JDBCConnector;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Log extends AbBean implements Serializable {
    int id;
    int level;
    String ip;
    String src;
    int user;
    String content;
    Date createAt;
    int status;

    static Map<Integer, String>  levelMapping = new HashMap<>();
    {
        levelMapping.put(0,"INFO");
        levelMapping.put(1,"ALER");
        levelMapping.put(2,"WARNNING");
        levelMapping.put(3,"DANGER");

    }

    public static int INFO = 0;
    public static int ALER = 1;
    public static int WARNING = 2;
    public static int DANGER = 3;

    public Log( int level, String ip, String src, int user, String content,  int status) {
        this.level = level;
        this.ip = ip;
        this.src = src;
        this.user = user;
        this.content = content;
        this.status = status;
    }

    public Log(int level, int user, String src, String content, int status) {

        this.level = level;
        this.src = src;
        this.user = user;
        this.content = content;

        this.status = status;
    }

    public Log() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public String getLevelWithName() {
        return levelMapping.get(levelMapping.containsKey(this.level)?this.level:0);
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public boolean  insert() {

        String sql = new String("insert into logs(`level`,`user`,ip,src,content,createAt,`status`) values (?,?,?,?,?,NOW(),?)");
        PreparedStatement statement = null;
        try {
            Connection connection = JDBCConnector.getConnection();
            statement = connection.prepareStatement(sql.toString());
            statement.setInt(1, this.level);
            statement.setInt(2, getUser());
            statement.setString(3,getIp());
            statement.setString(4, getSrc());
            statement.setString(5, getContent());
            statement.setInt(6, getStatus());
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
        }
        return false;
    }
}
