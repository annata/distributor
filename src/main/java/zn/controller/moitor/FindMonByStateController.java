/**
 * 
 */
package zn.controller.moitor;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import zn.service.MonitorService;
import zn.until.NoteResult;

/**
 * @author hq
 *
 */
@Controller  
@RequestMapping("/monitor") 
public class FindMonByStateController {
	@Resource
	private MonitorService monitorService;
	
	@RequestMapping("/findMonByState")
	@ResponseBody
	public NoteResult execute(Integer monState){
		NoteResult note=monitorService.findMonByState(monState);	
		return note;
		
	}
}
