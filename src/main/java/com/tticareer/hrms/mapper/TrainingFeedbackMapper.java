package com.tticareer.hrms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.tticareer.hrms.pojo.TrainingFeedback;
import com.tticareer.hrms.pojo.dto.TrainingFeedbackDto;
import com.tticareer.hrms.util.MyMapper;

public interface TrainingFeedbackMapper extends MyMapper<TrainingFeedback> {
	
	@Select("select tf.*, tf.training_info_id as trainingInfoId,tf.training_feedback as trainingFeedback,tf.employee_id as employeeId, tf.create_time as `createTime`,e.user_name as userName,e.real_name as realName,ti.* from (select * from training_feedback where state != 0) as tf left join training_info as ti on tf.training_info_id = ti.id left join employee e on tf.employee_id = e.id")
	List<TrainingFeedbackDto> selectTfTraining();
}