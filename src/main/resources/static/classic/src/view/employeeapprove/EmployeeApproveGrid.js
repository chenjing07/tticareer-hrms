Ext.define('Admin.view.employeeapprove.EmployeeApproveGrid', {
    extend: 'Ext.grid.Panel',
	xtype:'employeeApproveGrid',
	title: '待审批员工信息',		//需要修改
	//iconCls: 'fa-arrow-circle-o-up',
	bind: '{employeeApproveStore}',//调用组件4
	columns: [{
			xtype: 'actioncolumn',
			items: [{
				xtype: 'button',
				iconCls: 'x-fa fa-edit',
				tooltip: '审批任务',
				
				handler: 'openApproveWindow'	//taskDefinitionKey 动态表单
			},{
				xtype: 'button',
				iconCls: 'x-fa fa-object-group',
				tooltip: '查看任务',
				handler: 'onClickEmployeeApproveClaimButton'	//ajax  taskId
			}],
			cls: 'content-column',
			width: 60,
			dataIndex: 'bool',
			text: 'Actions',
			tooltip: 'edit '
		}
		,{header: 'id' 		,dataIndex: 'id',width: 60,sortable: true	,hidden:true}
		,{header: '工号'  	,dataIndex: 'userName',width: 60,sortable: true}
		,{header: '密码'  	,dataIndex: 'password',width: 60,sortable: true,hidden:true}
		,{header: '真实姓名'  	,dataIndex: 'realName',width: 60,sortable: true}
		,{header: '身份证号'  	,dataIndex: 'idCardNumber',width: 60,sortable: true}
		,{header: '身份证图片存放地址'  ,dataIndex: 'idCardPicture',width: 60,sortable: true,hidden:true}
		,{header: '出生日期' 	,dataIndex: 'birthday',width: 150,sortable: true,renderer: Ext.util.Format.dateRenderer('Y/m/d H:i:s')}
		,{header: '性别' 	,dataIndex: 'gender',width: 60,sortable: true,
				renderer: function(val) {
		            if (val =='1') {
			            return '男';
			        } else if (val =='0') {
			            return '女';
			        } 
			        return val;}
		 }
		,{header: '民族' 	,dataIndex: 'nation',width: 150,sortable: true}
		,{header: '籍贯' 	,dataIndex: 'nativePlace',width: 150,sortable: true}
		,{header: '户口地址' 	,dataIndex: 'registeredAddress',width: 150,sortable: true}
		,{header: '家庭住址'  	,dataIndex: 'houseAddress',width: 150,sortable: true}
		,{header: '学历' 	,dataIndex: 'education',width: 60,sortable: true}
		,{header: '学位' 	,dataIndex: 'academicDegree',width: 60,sortable: true}
		,{header: '专业' 	,dataIndex: 'major',width: 60,sortable: true}
		,{header: '系别' 	,dataIndex: 'tie',width: 60,sortable: true}
		,{header: '毕业院校'  	,dataIndex: 'graduatedSchool',width: 150,sortable: true}
		,{header: '毕业时间' 	,dataIndex: 'graduatedTime',width: 150,sortable: true,renderer: Ext.util.Format.dateRenderer('Y/m/d H:i:s')}
		,{header: '政治面貌' 	,dataIndex: 'politicalStatus',width: 60,sortable: true,
				renderer: function(val) {
		            if (val =='0') {
			            return '群众';
			        } else if (val =='1') {
			            return '中共党员';
			        }  else if (val =='2') {
			            return '中共预备党员';
			        }  else if (val =='3') {
			            return '共青团员';
			        }  else {
			            return '其他';
			        } 
			        return val;}
			}
		,{header: '婚姻状况 ' 	,dataIndex: 'maritalStatus',width: 150,sortable: true,
				renderer: function(val) {
		            if (val =='0') {
			            return '未婚';
			        } else if (val =='1') {
			            return '已婚';
			        }  
			        return val;}
			}
		,{header: '招聘来源' 	,dataIndex: 'recruitmentSource',width: 150,sortable: true,
				renderer: function(val) {
		            if (val =='0') {
			            return '简历应聘';
			        } else if (val =='1') {
			            return '招聘网站';
			        }  else if (val =='2') {
			            return '其它途径';
			        } 
			        return val;}
			}
		,{header: '开户银行' 	,dataIndex: 'accountBank',width: 60,sortable: true}
		,{header: '工资账户 ' 	,dataIndex: 'accountNumber',width: 150,sortable: true}
		,{header: '手机号码' 	,dataIndex: 'phoneNumber',width: 150,sortable: true}
		,{header: '邮箱' 	,dataIndex: 'email',width: 60,sortable: true}
		,{header: 'QQ号码 ' 	,dataIndex: 'qq',width: 150,sortable: true}
		,{header: '微信号' 	,dataIndex: 'wechat',width: 150,sortable: true}
		,{header: 'MSN' 	,dataIndex: 'msn',width: 60,sortable: true}
		,{header: ' 紧急联系人姓名 ' 	,dataIndex: 'emergencyContactName',width: 150,sortable: true}
		,{header: '紧急联系人关系' 	,dataIndex: 'emergencyContactRelationship',width: 150,sortable: true}
		,{header: '紧急联系人电话 ' 	,dataIndex: 'emergencyContactNumber',width: 150,sortable: true}
		,{header: '入职时间' 	,dataIndex: 'workStart',width: 150,sortable: true,renderer: Ext.util.Format.dateRenderer('Y/m/d H:i:s')}
		,{header: '离职时间' 	,dataIndex: 'workEnd',width: 60,sortable: true,renderer: Ext.util.Format.dateRenderer('Y/m/d H:i:s')}
		,{header: ' 实习开始时间 ' 	,dataIndex: 'practiceStart',width: 150,sortable: true,renderer: Ext.util.Format.dateRenderer('Y/m/d H:i:s')}
		,{header: '实习结束时间' 	,dataIndex: 'practiceEnd',width: 150,sortable: true,renderer: Ext.util.Format.dateRenderer('Y/m/d H:i:s')}
		,{header: '工作状态 ' 	,dataIndex: 'iswork',width: 150,sortable: true,
				renderer: function(val) {
		            if (val =='0') {
			            return '离职';
			        } else if (val =='1') {
			            return '正式';
			        }  else if (val =='2') {
			            return '实习';
			        } 
			        return val;}
		 }
		,{header: '创建日期' 	,dataIndex: 'createTime',width: 150,sortable: true,renderer: Ext.util.Format.dateRenderer('Y/m/d H:i:s')}
		,{header: '状态' 	,dataIndex: 'state',width: 60,sortable: true}
		,{header: '审查状态' 	,dataIndex: 'checkSatus',width: 150,sortable: true,
				renderer: function(val) {
		            if (val =='1') {
			            return '<span style="color:green;">已通过审查</span>';
			        } else if (val =='0') {
			            return '<span style="color:blue;">待审查</span>';
			        } else{
			            return '<span style="color:red;">未通过审查</span>';
			        }
			        return val;}
		 }
		,{header: '备注' 	,dataIndex: 'note',width: 150,sortable: true}
		
	],
	dockedItems: [{
	    xtype: 'pagingtoolbar',
	    dock: 'bottom',
		bind: '{employeeApproveStore}',	//调用组件4
	    displayInfo: true,
	   
	}]
});
