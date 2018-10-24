Ext.define('Admin.view.employeePositionInfoapprove.EmployeePositionInfoApproveGrid', {
    extend: 'Ext.grid.Panel',
	xtype:'employeePositionInfoApproveGrid',
	title: '待审批人员调动信息',		//需要修改
	//iconCls: 'fa-arrow-circle-o-up',
	bind: '{employeePositionInfoApproveStore}',//调用组件4
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
				handler: 'onClickEmployeePositionInfoApproveClaimButton'	//ajax  taskId
			}],
			cls: 'content-column',
			width: 60,
			dataIndex: 'bool',
			text: 'Actions',
			tooltip: 'edit '
		}
		,{header: 'id' 		,dataIndex: 'id',width: 60,sortable: true	,hidden:true}
		,{header: '员工Id'  ,dataIndex: 'employeeId',width: 60,sortable: true,
				renderer: function(val) {
				   var result;
		           Ext.Ajax.request({
					   url:'/employee/getEmployeeNameById', 
					   method:'get', 
					   params:{id:val}, 
					  async: false,
					   success:function(response, options) {
          					var json = Ext.util.JSON.decode(response.responseText);
          					if (json.data) {
            					result = json.data;
								//console.log(result);
         				 	}
						}
					});
					return result;
			    }
			}
		,{header: '岗位id'  	,dataIndex: 'positionId',width: 60,sortable: true,
				renderer: function(val) {
				   var result;
		           Ext.Ajax.request({
					   url:'/position/getPositionNameById', 
					   method:'get', 
					   params:{id:val}, 
					   async: false,
					   success:function(response, options) {
          					var json = Ext.util.JSON.decode(response.responseText);
          					if (json.data) {
            					result = json.data;
								//console.log(result);
         				 	}
						}
					});
					return result;
			    }
			}
		,{header: '到岗时间' 	,dataIndex: 'arrivePost',width: 150,sortable: true,renderer: Ext.util.Format.dateRenderer('Y/m/d H:i:s')}
		,{header: '调岗时间' 	,dataIndex: 'leavePost',width: 150,sortable: true,renderer: Ext.util.Format.dateRenderer('Y/m/d H:i:s')}
		,{header: '调岗原因' 	,dataIndex: 'transferReason',width: 150,sortable: true}
		,{header: '调出部门意见' 	,dataIndex: 'leaveOpinion',width: 150,sortable: true}
		,{header: '调入部门意见' 	,dataIndex: 'arriveOpinion',width: 150,sortable: true}
		,{header: '创建日期' 	,dataIndex: 'createTime',width: 150,sortable: true,renderer: Ext.util.Format.dateRenderer('Y/m/d H:i:s')}
		,{header: '状态' 	,dataIndex: 'state',width: 60,sortable: true}
		,{header: '审查状态' 	,dataIndex: 'checkStatus',width: 150,sortable: true}
		,{header: '备注' 	,dataIndex: 'note',width: 150,sortable: true}
	],
	dockedItems: [{
	    xtype: 'pagingtoolbar',
	    dock: 'bottom',
		bind: '{employeePositionInfoApproveStore}',	//调用组件4
	    displayInfo: true,
	   
	}]
});
