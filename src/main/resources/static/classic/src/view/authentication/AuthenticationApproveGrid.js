Ext.define('Admin.view.authentication.AuthenticationApproveGrid', {
    extend: 'Ext.grid.Panel',
	xtype:'authenticationApproveGrid',
	title: 'authenticationApprove',		//需要修改
	iconCls: 'fa-arrow-circle-o-up',
	//bind: '{AuthenticationStore}',//调用组件4
	columns: [{
			xtype: 'actioncolumn',
			items: [{
				xtype: 'button',
				iconCls: 'x-fa fa-pencil',
				tooltip: '签收任务',
				getClass: function(v, meta, rec) {
		            		if (rec.get('assignee')!='') {
		                  		return 'x-hidden';
		            		}
		            		return 'x-fa fa-pencil';
				},
				handler: 'authenticationApproveClaimButton'	//ajax  taskId
			},{
				xtype: 'button',
				iconCls: 'x-fa fa-edit',
				tooltip: '审批任务',
				getClass: function(v, meta, rec) {
		           		 if (rec.get('assignee')=='') {
		                  		return 'x-hidden';
		           		 }
		            		return 'x-fa fa-edit';
				},
				handler: 'authenticationApproveCompleteWindowButton'	//taskDefinitionKey 动态表单
				}/*,{
				xtype: 'button',
				iconCls: 'x-fa fa-object-group',
				tooltip: '任务跟踪',
				handler: 'authenticationApproveTraceButton'	//流程跟踪
			}*/],
			cls: 'content-column',
			width: 120,
			dataIndex: 'bool',
			text: 'Actions',
			tooltip: 'edit '
		}
		,{header: 'id' ,dataIndex: 'id',sortable: true,hidden:true}
		,{header: 'state',dataIndex: 'state',sortable: true,
              renderer: function(val) {
	            if (val =='NEW') {
		            return '<span style="color:green;">新建</span>';
		        } else if (val =='APPROVAL') {
		            return '<span style="color:blue;">审批中...</span>';
		        } else if (val =='COMPLETE') {
		            return '<span style="color:orange;">完成审批</span>';
		        }else{
		        	return '<span style="color:red;">取消申请</span>';
		        }
		        return val;
               }
		}
	,{header: 'userName',dataIndex: 'userName',sortable: true}
	,{header: 'realName',dataIndex: 'realName',sortable: true}
	,{header: 'idCardNumber',dataIndex: 'idCardNumber',width:120,sortable: true}
	,{header: 'idCardPicture' ,dataIndex: 'idCardPicture',width:120,sortable: true}
	,{header: 'applyTime' ,dataIndex: 'applyTime',sortable: true}
	],
	dockedItems: [{
	    xtype: 'pagingtoolbar',
	    dock: 'bottom',
	    //bind: '{leaveApproveStore}',	//调用组件4
	    displayInfo: true,
	    items: ['-',{
            text: 'Add',
            iconCls: 'x-fa fa-plus',
			listeners: {
				click: 'realNameAuthenticationSubmitButton'
            }
        }, '-',{
            text: 'Update',
            iconCls: 'x-fa fa-pencil',
            listeners: {
				click: 'modifyInformationSubmitButton'
            }
        }, '-', {
            text: 'Delete',
            iconCls: 'x-fa fa-close',
			listeners: {
				click: 'modifyAuthenticationApplySubmitButton'
            }
        }]
	}]
});
