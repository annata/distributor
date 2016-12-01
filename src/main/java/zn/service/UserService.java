package zn.service;


import javax.servlet.http.HttpSession;

import zn.until.NoteResult;

public interface UserService {
	public NoteResult checkTel(String checkTel);
	public NoteResult checkLogin(String telephone,String password);
	public NoteResult creatUser(String userStr,Integer userId);
	public NoteResult changeUserInfo(String information,String userName,Integer userId,Integer orgId);
	public NoteResult selectUserByOrg(Integer orgId);
	public NoteResult selectUserById(Integer userId);
	public NoteResult changePassword(String oldPassword,String nowFirstPassword,String nowTwoPassword,Integer userId,HttpSession session);
	public NoteResult deleteUser(Integer userId);
	public NoteResult userAddMon(String jsonStr);
	public NoteResult seleteUserByMonId(Integer monId);
}
