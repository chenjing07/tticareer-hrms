Ext.define('Admin.view.authenticationApprove.AuthenticationApproveGrid', {
    extend: 'Ext.grid.Panel',
	xtype:'authenticationApproveGrid',
	title: '待审核人事部人员信息',		//需要修改
	iconCls: 'fa-arrow-circle-o-up',
	bind: '{authenticationApproveStore}',//调用组件4
	columns: [{
			xtype: 'actioncolumn',
			items: [{
				xtype: 'button',
				iconCls: 'x-fa fa-edit',
				tooltip: '审批任务',
			
				handler: 'openAuthenticationApproveWindow'	//taskDefinitionKey 动态表单
				}],
			cls: 'content-column',
			width: 120,
			dataIndex: 'bool',
			text: 'Actions',
			tooltip: 'edit '
		}
	,{header: 'userName',reference:'selectFieldName',dataIndex: 'userName',sortable: true}
	,{header: 'realName',dataIndex: 'realName',sortable: true}
	,{header: 'idCardNumber',dataIndex: 'idCardNumber',width:120,sortable: true}
	,{header: 'idCardPicture' ,dataIndex: 'idCardPicture',width:120,sortable: true}
	],
	dockedItems: [{
	    xtype: 'pagingtoolbar',
	    dock: 'bottom',
	    bind: '{authenticationApproveStore}',	//调用组件4
	    displayInfo: true
	}]
});
