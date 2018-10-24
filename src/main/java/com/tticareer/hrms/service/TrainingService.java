package com.tticareer.hrms.service;

import java.util.List;
import com.tticareer.hrms.pojo.TrainingFeedback;
import com.tticareer.hrms.pojo.TrainingInfo;
import com.tticareer.hrms.pojo.dto.DepartmentTrainingDto;
import com.tticareer.hrms.pojo.dto.EmployeeTrainingDto;
import com.tticareer.hrms.pojo.dto.TrainingFeedbackDto;

/**
 * <p>CreateTime: 2018年9月26日 上午8:51:05 </p>
 * <p>ProjectName: hrms</p>
 * <p>FiletName: TrainingService.java</p>
 * @author dong
 * @version 1.0
 * <p>Description: ITrainingService的接口</p>
 */
public interface TrainingService {
	
	/**
	 * <p>Title: saveTrainingInfo</p>
	 * <p>Description: 培训信息添加</p>
	 * @param ti
	 */
	public void saveTrainingInfo(TrainingInfo ti);
	
	/**
	 * <p>Title: updateTrainingInfo</p>
	 * <p>Description: 培训信息修改</p>
	 * @param ti
	 */
	public void updateTrainingInfo(TrainingInfo ti);
	
	/**
	 * <p>Title: deleteTrainingInfo</p>
	 * <p>Description: 培训信息删除一条</p>
	 * @param id
	 */
	public void deleteTrainingInfo(Long id);
	
	/**
	 * <p>Title: deleteTrainingInfoList</p>
	 * <p>Description: 培训信息删除多条</p>
	 * @param ids
	 */
	public void deleteTrainingInfoList(Long[] ids);
	
	/**
	 * 
	 * <p>Title: queryTrainingInfo</p>
	 * <p>Description: 查询培训信息中是否有该记录，用于插入数据验证</p>
	 * @param ti
	 * @return
	 */
	public TrainingInfo queryTrainingInfo(TrainingInfo ti);
	
	/**
	 * <p>Title: queryTrainingInfoById</p>
	 * <p>Description: 培训信息根据id查询一条</p>
	 * @param id
	 * @return
	 */
	public TrainingInfo queryTrainingInfoById(Long id);
	
	/**
	 * <p>Title: queryTrainingInfoByDepartmentId</p>
	 * <p>Description: 培训信息根据部门id查询</p>
	 * @param departmentId
	 * @return
	 */
	public List<TrainingInfo> queryTrainingInfoByDepartmentId(Long departmentId);
	
	/**
	 * <p>Title: queryTrainingInfoByEmployeeId</p>
	 * <p>Description: 培训信息根据员工id查询</p>
	 * @param employeeId
	 * @return
	 */
	public List<TrainingInfo> queryTrainingInfoByEmployeeId(Long employeeId);
	
	/**
	 * <p>Title: queryTrainingInfoByLecturer</p>
	 * <p>Description: 培训信息根据讲师名称查询</p>
	 * @param lecturer
	 * @return
	 */
	public List<TrainingInfo> queryTrainingInfoByLecturer(String lecturer);
	
	/**
	 * <p>Title: queryAllTrainingInfo</p>
	 * <p>Description: 查询所有培训信息</p>
	 * @return
	 */
	public List<TrainingInfo> queryAllTrainingInfo();
	
	/**
	 * <p>Title: queryTrainingInfoState</p>
	 * <p>Description: 查询被冻结即状态为0的培训信息,查询未进行的即状态为1的培训信息,查询在进行的即状态为2的培训信息,查询已结束的即状态为3的培训信息</p>
	 * @param state
	 * @return
	 */
	public List<TrainingInfo> queryTrainingInfoDelete();
	
	/**
	 * <p>Title: queryTrainingInfoWhoIsNotDelete</p>
	 * <p>Description: 查询状态不为0的培训信息</p>
	 * @return
	 */
	public List<TrainingInfo> queryTrainingInfoWhoIsNotDelete();
	
	/**
	 * <p>Title: queryTrainingInfoList</p>
	 * <p>Description: 自定义查询，可做模糊查询</p>
	 * @param ti
	 * @return
	 */
	public List<TrainingInfo> queryTrainingInfoList(TrainingInfo ti);
	
	public List<DepartmentTrainingDto> selectDepartTraining(Integer page);
	public List<EmployeeTrainingDto> selectEmpTraining(Integer page);
	
	/**
	 * <p>Title: saveTrainingFeedback</p>
	 * <p>Description: 培训反馈添加</p>
	 * @param tf
	 */
	public void saveTrainingFeedback(TrainingFeedback tf);
	
	/**
	 * <p>Title: updateTrainingFeedback</p>
	 * <p>Description: 培训反馈更新</p>
	 * @param tf
	 */
	public void updateTrainingFeedback(TrainingFeedback tf);
	
	/**
	 * <p>Title: deleteTrainingFeedback</p>
	 * <p>Description: 培训反馈删除一条</p>
	 * @param id
	 */
	public void deleteTrainingFeedback(Long id);
	
	/**
	 * <p>Title: deleteTrainingFeedbackList</p>
	 * <p>Description: 培训反馈删除多条</p>
	 * @param ids
	 */
	public void deleteTrainingFeedbackList(Long[] ids);
	
	/**
	 * <p>Title: queryTrainingFeedbackById</p>
	 * <p>Description: 根据id查询培训反馈信息</p>
	 * @param id
	 * @return
	 */
	public TrainingFeedback queryTrainingFeedbackById(Long id);
	
	/**
	 * <p>Title: queryTrainingFeedbackByEmployeeIdAndTrainingInfoId</p>
	 * <p>Description: 根据员工信息id和培训信息id查询培训反馈信息</p>
	 * @param employeeId
	 * @return
	 */
	public TrainingFeedback queryTrainingFeedbackByEmployeeIdAndTrainingInfoId(Long employeeId, Long trainingInfoId);
	
	/**
	 * <p>Title: queryTrainingFeedbackByEmployeeId</p>
	 * <p>Description: 根据员工信息id查询培训反馈信息</p>
	 * @param employeeId
	 * @return
	 */
	public List<TrainingFeedback> queryTrainingFeedbackByEmployeeId(Long employeeId);
	
	/**
	 * <p>Title: queryTrainingFeedbackByTrainingInfoId</p>
	 * <p>Description: 根据培训信息id查询培训反馈信息</p>
	 * @param trainingInfoId
	 * @return
	 */
	public List<TrainingFeedback> queryTrainingFeedbackByTrainingInfoId(Long trainingInfoId);
	
	/**
	 * <p>Title: queryAllTrainingFeedback</p>
	 * <p>Description: 查询所有反馈信息</p>
	 * @return
	 */
	public List<TrainingFeedback> queryAllTrainingFeedback();
	
	/**
	 * <p>Title: queryTrainingFeedbackWhoIsDelete</p>
	 * <p>Description: 查询被删除的反馈信息</p>
	 * @return
	 */
	public List<TrainingFeedback> queryTrainingFeedbackWhoIsDelete();
	
	/**
	 * <p>Title: queryTrainingFeedbackWhoIsNotDelete</p>
	 * <p>Description: 查询未被删除的反馈信息</p>
	 * @return
	 */
	public List<TrainingFeedback> queryTrainingFeedbackWhoIsNotDelete();
	
	/**
	 * <p>Title: queryTrainingFeedbackList</p>
	 * <p>Description: 自定义模糊查询</p>
	 * @param tf
	 * @return
	 */
	public List<TrainingFeedback> queryTrainingFeedbackList(TrainingFeedback tf);
	
	public List<TrainingFeedbackDto> selectTfTraining(Integer page);
}
