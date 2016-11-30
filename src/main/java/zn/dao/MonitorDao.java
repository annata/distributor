/**
 * 
 */
package zn.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import zn.entity.Monitor;

/**
 * @author hq
 *
 */
public interface MonitorDao {
	      public List<Monitor> findAllMon();
	      public int  monIsExist(String monNumber);
	      public int  addMon(Monitor monitor);
	      public int  deleteMon(int monId);
	      public int changeMon(Monitor monitor);
	      public int deleteMonPlace(@Param("monPlace")String monPlace,@Param("monPlaceLevel")int monPlaceLevel);
	      public int  changeMonPlace(@Param("monOldPlace")String monOldPlace,@Param("monNewPlace")String monNewPlace,@Param("monPlaceLevel")int monPlaceLevel);
	      public    Monitor       findMonById(int monId);
	      public int monAddUser(Map<String,Object> param);
	      public int monDelteUser(int monId);
	      public Monitor selectMonByNum(String monNumber);
	      public List<Monitor> seleteMonByUserId(int userId);
}