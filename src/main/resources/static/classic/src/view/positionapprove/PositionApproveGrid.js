Ext.define('Admin.view.positionapprove.PositionApproveGrid', {
    extend: 'Ext.grid.Panel',
	xtype:'positionApproveGrid',
	title: '待审批岗位信息',		//需要修改
	//iconCls: 'fa-arrow-circle-o-up',
	bind: '{positionApproveStore}',//调用组件4
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
				handler: 'onClickPositionApproveClaimButton'	//ajax  taskId
			}],
			cls: 'content-column',
			width: 60,
			dataIndex: 'bool',
			text: 'Actions',
			tooltip: 'edit '
		}
		,{header: 'id' 		,dataIndex: 'id',width: 60,sortable: true	,hidden:true}
		,{header: '部门id'  	,dataIndex: 'departmentId',width: 60,sortable: true,
				renderer: function(val) {
				   var result;
		           Ext.Ajax.request({
					   url:'/department/getDepartmentNameById', 
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
		,{header: '岗位编号'  	,dataIndex: 'positionNumber',width: 60,sortable: true}
		,{header: '岗位名称'  	,dataIndex: 'positionName',width: 60,sortable: true}
		,{header: '上级岗位id' 	,dataIndex: 'superiorPositionid',width: 150,sortable: true,
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
		,{header: '岗位简介' 	,dataIndex: 'positionIntroduction',width: 60,sortable: true}
		,{header: '创建日期' 	,dataIndex: 'createTime',width: 150,sortable: true,renderer: Ext.util.Format.dateRenderer('Y/m/d H:i:s')}
		,{header: '状态' 	,dataIndex: 'state',width: 60,sortable: true}
		,{header: '审查状态' 	,dataIndex: 'checkStatus',width: 150,sortable: true}
		,{header: '备注' 	,dataIndex: 'note',width: 150,sortable: true}
		
	],
	dockedItems: [{
	    xtype: 'pagingtoolbar',
	    dock: 'bottom',
		bind: '{positionApproveStore}',	//调用组件4
	    displayInfo: true,
	   
	}]
});
