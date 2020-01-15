package temp.temp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    /**
    * 角色id
    */
    private Integer id;

    /**
    * 用户名
    */
    private String username;

    /**
    * 电话
    */
    private String phone;

    /**
    * 邮箱
    */
    private String email;

    /**
    * 密码
    */
    private String password;

    /**
    * '状态:正常,锁定,注销'
    */
    private String status;

    /**
    * 头像地址
    */
    private String url;

    private String useridTitle;
}