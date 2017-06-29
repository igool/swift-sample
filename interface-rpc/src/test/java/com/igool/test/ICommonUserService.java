/**
 * 
 */
package com.igool.test;

import java.util.List;
import java.util.Map;

/**
 * @author hongliuliao
 *
 * createTime:2012-11-23 下午1:05:44
 */
public interface ICommonUserService {

	public User login(int id, String name);
	
	public User getUserById(long id);
	
	public boolean saveUser(User user);
	
	public List<User> getUserIds(long id);
	
	public Map<Long, User> getUserByIds(List<User> ids);
	
	public Map<String, List<User>> getUsersByName(List<String> names);

	public Map<Long, List<Long>> getGroupUsers(List<String> names, List<User> userList, List<Long> lns, long ll);
	
	public List<String> testCase1(Map<Integer, String> num1, List<User> num2, List<String> num3, long num4, String num5);
}
