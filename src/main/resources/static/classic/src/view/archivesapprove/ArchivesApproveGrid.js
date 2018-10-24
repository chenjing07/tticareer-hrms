Ext.define('Admin.view.archivesapprove.ArchivesApproveGrid', {
    extend: 'Ext.grid.Panel',
	xtype:'archivesApproveGrid',
	title: '待审批档案信息',		//需要修改
	//iconCls: 'fa-arrow-circle-o-up',
	bind: '{archivesApproveStore}',//调用组件4
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
				handler: 'onClickArchivesApproveClaimButton'	//ajax  taskId
			}],
			cls: 'content-column',
			width: 60,
			dataIndex: 'bool',
			text: 'Actions',
			tooltip: 'edit '
		}
		,{header: 'id' 		,dataIndex: 'id',width: 60,sortable: true	,hidden:true}
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
		,{header: '转入时间'  	,dataIndex: 'inTime',width: 60,sortable: true,renderer: Ext.util.Format.dateRenderer('Y/m/d H:i:s')}
		,{header: '转出时间'  	,dataIndex: 'outTime',width: 60,sortable: true,renderer: Ext.util.Format.dateRenderer('Y/m/d H:i:s')}
		,{header: '档案来源'  	,dataIndex: 'archivesSource',width: 60,sortable: true}
		,{header: '档案去处'  	,dataIndex: 'archivesDestination',width: 60,sortable: true}
		,{header: '档案变更'  	,dataIndex: 'archivesChange',width: 60,sortable: true}
		,{header: '创建日期' 	,dataIndex: 'createTime',width: 150,sortable: true,renderer: Ext.util.Format.dateRenderer('Y/m/d H:i:s')}
		,{header: '状态' 	,dataIndex: 'state',width: 60,sortable: true}
		,{header: '审查状态' 	,dataIndex: 'checkStatus',width: 150,sortable: true}
		,{header: '备注' 	,dataIndex: 'note',width: 150,sortable: true}
		
	],
	dockedItems: [{
	    xtype: 'pagingtoolbar',
	    dock: 'bottom',
		bind: '{archivesApproveStore}',	//调用组件4
	    displayInfo: true,
	   
	}]
});
