package org.suh.account;

import com.jk.data.dataaccess.JKDataAccessFactory;
import com.jk.data.dataaccess.core.JKDataAccessService;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DataAccess {

    JKDataAccessService dataAccessService = JKDataAccessFactory.getDataAccessService();

    public void transfer(int fromAccNum, int toAccNum, int amount){
        Model fromUser = find(fromAccNum);
        int fromAmount = fromUser.getAmount() - amount;
        updateAmount(fromUser,fromAmount);

        Model toUser = find(toAccNum);
        int toAmount = toUser.getAmount() + amount;
        updateAmount(toUser,toAmount);


    }

    private Model find(int accNum){
        return dataAccessService.find("SELECT * FROM account WHERE acc_Num=?",this::account,accNum);
    }

    private Boolean updateAmount(Model model , int amount){
        String sql = "UPDATE account SET amount=? WHERE id=?";
        int records = dataAccessService.execute(sql,amount, model.getId());
        return records==1;
    }

    protected Model account(ResultSet resultSet) throws SQLException{
        Model user = new Model();
        user.setId((int) resultSet.getObject("id")) ;
        user.setAccName((String)resultSet.getObject("acc_Name"));
        user.setAccNum((int)resultSet.getObject("acc_Num"));
        user.setAmount((int) resultSet.getObject("amount"));
        return user;
    }
}
