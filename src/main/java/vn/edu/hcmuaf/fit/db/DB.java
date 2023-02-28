package vn.edu.hcmuaf.fit.db;

import org.jdbi.v3.core.Jdbi;
import vn.edu.hcmuaf.fit.bean.AbBean;
import vn.edu.hcmuaf.fit.bean.Log;

public class DB {
        private static DB install;
        public static  DB me() {
                if(install == null) install = new DB();
                return install;
        }
        private DB() {

        }
        public boolean insert(AbBean bean){
                return  bean.insert();

        }

        public static void main(String[] args) {
                Log log = new Log(Log.INFO,-1,"Login","Login false",0);
                DB.me().insert(log);
        }
}
