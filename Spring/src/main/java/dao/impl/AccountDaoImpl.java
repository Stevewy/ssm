package dao.impl;

import dao.AccountDao;
import entity.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author WangYao
 * @date 2020/4/13
 * @function dao实现类
 */
@Repository("accountDao")
public class AccountDaoImpl extends JdbcDaoSupport /*如果继承,就只能使用xml配置,不继承都可*/ implements AccountDao {

    @Override
    public void saveAccount(Account account) {
        getJdbcTemplate().update("insert into account(id,uid,money)values (?,?,?)",account.getId(),account.getUid(),account.getMoney());
    }

    @Override
    public void deleteAccount(Account account) {
        getJdbcTemplate().update("delete from account where id = ?",account.getId());
    }

    @Override
    public void updateAccount(Account account) {
        getJdbcTemplate().update("update account set uid = ?, money = ? where id = ?",account.getUid(),account.getMoney(),account.getId());
    }

    /*
     * 可以使用Spring,也可以自己封装
     */
    @Override
    public List<Account> findAllAccount() {
        return getJdbcTemplate().query("select * from account", new BeanPropertyRowMapper<Account>(Account.class));
    }

    @Override
    public Account findAccountById(Integer id) {
        List<Account> l = getJdbcTemplate().query("select * from account where id = ?", new RowMapper<Account>() {
            @Override
            public Account mapRow(ResultSet resultSet, int i) throws SQLException {
                Account account = new Account();
                account.setId(resultSet.getInt("id"));
                account.setUid(resultSet.getInt("uid"));
                account.setMoney(resultSet.getDouble("money"));
                return account;
            }
        },id);
        if(l != null && l.size() == 1) return l.get(0);
        throw new RuntimeException("id出错");
    }
}
