Ext.define('Admin.view.laborContractapprove.LaborContractApproveGrid', {
    extend: 'Ext.grid.Panel',
	xtype:'laborContractApproveGrid',
	title: '待审批合同信息',		//需要修改
	//iconCls: 'fa-arrow-circle-o-up',
	bind: '{laborContractApproveStore}',//调用组件4
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
				handler: 'onClickLaborContractApproveClaimButton'	//ajax  taskId
			}],
			cls: 'content-column',
			width: 60,
			dataIndex: 'bool',
			text: 'Actions',
			tooltip: 'edit '
		}
		,{header: 'id' 		,dataIndex: 'id',width: 60,sortable: true	,hidden:true}
		,{header: '甲方名称'  	,dataIndex: 'employerName',width: 60,sortable: true}
		,{header: '员工Id'  	,dataIndex: 'employeeId',width: 60,sortable: true,
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
		,{header: '合同期限'  	,dataIndex: 'contractTimeLimit',width: 60,sortable: true}
		,{header: '生效日期' 	,dataIndex: 'contractStart',width: 150,sortable: true,renderer: Ext.util.Format.dateRenderer('Y/m/d H:i:s')}
		,{header: '终止日期' 	,dataIndex: 'contractEnd',width: 150,sortable: true,renderer: Ext.util.Format.dateRenderer('Y/m/d H:i:s')}
		,{header: '工作内容' 	,dataIndex: 'workContent',width: 150,sortable: true}
		,{header: '工作地点' 	,dataIndex: 'workPlace',width: 150,sortable: true}
		,{header: '劳动保护' 	,dataIndex: 'laborProtection',width: 150,sortable: true}
		,{header: '劳动条件' 	,dataIndex: 'laborConditions',width: 150,sortable: true}
		,{header: '劳动报酬'  	,dataIndex: 'laborReward',width: 150,sortable: true}
		,{header: '违约责任' 	,dataIndex: 'defaultResponsibility',width: 150,sortable: true}
		,{header: '社会保险' 	,dataIndex: 'socialInsurance',width: 150,sortable: true}
		,{header: '合同变更'  	,dataIndex: 'contractChange',width: 150,sortable: true}
		,{header: '创建日期' 	,dataIndex: 'createTime',width: 150,sortable: true,renderer: Ext.util.Format.dateRenderer('Y/m/d H:i:s')}
		,{header: '状态' 	,dataIndex: 'state',width: 60,sortable: true}
		,{header: '审查状态' 	,dataIndex: 'checkStatus',width: 150,sortable: true}
		,{header: '备注' 	,dataIndex: 'note',width: 150,sortable: true}
	],
	dockedItems: [{
	    xtype: 'pagingtoolbar',
	    dock: 'bottom',
		bind: '{laborContractApproveStore}',	//调用组件4
	    displayInfo: true,
	   
	}]
});
