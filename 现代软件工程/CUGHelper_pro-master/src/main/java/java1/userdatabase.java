package java1;

public class userdatabase {
    public static int insert(USER_TABLE user){
        String sql = "insert into 注册 values(?,?,?,?)";
        Object[] params = {
                user.getName(),
                user.getPhone(),
                user.getEmail(),
                user.getPassword(),
        };
        return userdb.IUD(sql,params,0);
    }


    public static int select(USER_TABLE user){
        String sql = "select * from 注册 where 姓名=? and 手机号= ? and 密码= ?;";
        Object[] params = {
                user.getName(),
                user.getPhone(),
//                user.getEmail(),
                user.getPassword(),
        };
        return userdb.IUD(sql,params,1);
    }
}
