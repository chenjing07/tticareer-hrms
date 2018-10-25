Ext.define('Admin.view.attendance.LeaveDetailPanel', {
    extend: 'Ext.tab.Panel',
    xtype: 'leaveDetailPanel',

    requires: [
        'Ext.grid.Panel',
        'Ext.toolbar.Paging',
        'Ext.form.field.ComboBox',
        'Ext.selection.CheckboxModel',
        'Ext.form.field.Date',
        'Ext.grid.column.Date',
        'Ext.grid.column.RowNumberer',
        'Ext.view.MultiSelector'
    ],
    layout: 'fit',
    items: [
        {
            xtype: 'gridpanel',
            cls: 'user-grid',
            title: '请假信息管理',
            //routeId: 'user',
            selModel: {type: 'checkboxmodel'},
            bind: '{leaveDetailLists}',
            scrollable: false,
            columns: [
            	{xtype: 'gridcolumn',width: 40,dataIndex: 'id',text: 'id',hidden:true},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'employeeId',text: 'employeeId',flex: 1,hidden:true},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'userName',text: '员工编号',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'realName',text: '员工名称',flex: 1},
                {xtype: 'datecolumn',cls: 'content-column',width: 180,dataIndex: 'leaveStart',text: '申请请假开始时间',formatter: 'date("Y/m/d H:i:s")'},
                {xtype: 'datecolumn',cls: 'content-column',width: 180,dataIndex: 'leaveEnd',text: '申请请假结束时间',formatter: 'date("Y/m/d H:i:s")'},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'leaveDays',text: '请假天数',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'reason',text: '请假原因',flex: 1},
                {xtype: 'datecolumn',cls: 'content-column',width: 180,dataIndex: 'realStart',text: '审核后假期开始时间',formatter: 'date("Y/m/d H:i:s")'},
                {xtype: 'datecolumn',cls: 'content-column',width: 180,dataIndex: 'realEnd',text: '审核后假期结束时间（销假）',formatter: 'date("Y/m/d H:i:s")'},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'state',text: '状态',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'checkStatus',text: '审核情况',
                	renderer: function(val) {
	        			return '<span style="color:green;">'+ val +'</span>';
                	}
                },
                {xtype: 'datecolumn',cls: 'content-column',width: 180,dataIndex: 'createTime',text: '录入时间',formatter: 'date("Y/m/d H:i:s")'},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'note',text: '备注',flex: 1},
                {xtype: 'actioncolumn',cls: 'content-column', width: 120,text: '操作',tooltip: 'Action',
                    items: [
                        {xtype: 'button', iconCls: 'x-fa fa-pencil' ,handler: 'openLeaveDetailEditWindow'}
                    ]
                }
            ],
            tbar: [{
	            xtype: 'combobox',
                reference:'searchFieldName',
	            hideLabel: true,
	            store:Ext.create("Ext.data.Store", {
				    fields: ["name", "value"],
				    data: [
				      	{ name: '员工编号', value: 'userName' },
						{ name: '员工名称', value: 'realName' }
				    ]
				}),
	            displayField: 'name',
	            valueField:'value',
	            value:'请选择',
	            editable: false,
	            queryMode: 'local',
	            triggerAction: 'all',
	            emptyText: 'Select a state...',
	            width: 135
	        }, '-',{
            	xtype:'textfield',
                reference:'searchFieldValue',
            	name:'leaveDetailSearchField'
		    }, '-',{
		        text: 'Search',
		        tooltip: '搜索',
		        iconCls: 'fa fa-search',
		        handler: 'quickSearchLeaveDetail'
		    }, '-',{
                text: 'Clear Text',
                tooltip: '清空搜索框',
                iconCls: 'fa fa-eraser',
                handler: 'clearText' 
            }, '->',{
		        text: 'Add',
		        tooltip: '添加请假信息',
		        iconCls: 'fa fa-plus',
		        handler: 'openLeaveDetailAddWindow'	
		    },'-',{
		        text: 'Removes',
		        tooltip: '删除选中的信息',
		        iconCls:'fa fa-trash',
		        handler: 'deleteLeaveDetailMoreRows'	
		    }],			
            dockedItems: [{
                xtype: 'pagingtoolbar',
                dock: 'bottom',
                displayInfo: true,
                bind: '{leaveDetailLists}'
            }]
    	},
    	{
            xtype: 'gridpanel',
            cls: 'user-grid',
            title: '请假信息复核',
            //routeId: 'user',
            selModel: {type: 'checkboxmodel'},
            bind: '{leaveDetailCheckLists}',
            scrollable: false,
            columns: [
                {xtype: 'gridcolumn',width: 40,dataIndex: 'id',text: 'id',hidden:true},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'employeeId',text: 'employeeId',flex: 1,hidden:true},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'userName',text: '员工编号',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'realName',text: '员工名称',flex: 1},
                {xtype: 'datecolumn',cls: 'content-column',width: 180,dataIndex: 'leaveStart',text: '申请请假开始时间',formatter: 'date("Y/m/d H:i:s")'},
                {xtype: 'datecolumn',cls: 'content-column',width: 180,dataIndex: 'leaveEnd',text: '申请请假结束时间',formatter: 'date("Y/m/d H:i:s")'},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'leaveDays',text: '请假天数',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'reason',text: '请假原因',flex: 1},
                {xtype: 'datecolumn',cls: 'content-column',width: 180,dataIndex: 'realStart',text: '审核后假期开始时间',formatter: 'date("Y/m/d H:i:s")'},
                {xtype: 'datecolumn',cls: 'content-column',width: 180,dataIndex: 'realEnd',text: '审核后假期结束时间（销假）',formatter: 'date("Y/m/d H:i:s")'},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'state',text: '状态',
                	renderer: function(val) {
                		if (val == "激活") {
                			return '<span style="color:green;">'+ val +'</span>';
						} else if(val == "销假申请") {
							return '<span style="color:yellow;">'+ val +'</span>';
						} else if(val == "销假成功") {
							return '<span style="color:green;">'+ val +'</span>';
						} else {
							return '<span style="color:red;">'+ val +'</span>';
						}
                	}
                },
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'checkStatus',text: '审核情况',
                	renderer: function(val) {
	        			return '<span style="color:red;">'+ val +'</span>';
                	}
                },
                {xtype: 'datecolumn',cls: 'content-column',width: 180,dataIndex: 'createTime',text: '录入时间',formatter: 'date("Y/m/d H:i:s")'},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'note',text: '备注',flex: 1},
                {xtype: 'actioncolumn',cls: 'content-column', width: 180,text: '操作',tooltip: 'Action',
                    items: [
                        {xtype: 'button', iconCls: 'x-fa fa-play' ,handler: 'checkStatusSuccess'},
                        {xtype: 'button', iconCls: 'x-fa fa-ban' ,handler: 'checkStatusFail'},
                        {xtype: 'button', iconCls: 'x-fa fa-play' ,handler: 'checkXiaoSuccess'},
                        {xtype: 'button', iconCls: 'x-fa fa-stop' ,handler: 'checkXiaoFail'}
                    ]
                }
            ],
            tbar: [{
	            xtype: 'combobox',
                reference:'searchFieldName',
	            hideLabel: true,
	            store:Ext.create("Ext.data.Store", {
				    fields: ["name", "value"],
				    data: [
				      	{ name: '员工编号', value: 'userName' },
						{ name: '员工名称', value: 'realName' }
				    ]
				}),
	            displayField: 'name',
	            valueField:'value',
	            value:'请选择',
	            editable: false,
	            queryMode: 'local',
	            triggerAction: 'all',
	            emptyText: 'Select a state...',
	            width: 135
	        }, '-',{
            	xtype:'textfield',
                reference:'searchFieldValue',
            	name:'leaveDetailSearchField'
		    }, '-',{
		        text: 'Search',
		        tooltip: '搜索',
		        iconCls: 'fa fa-search',
		        handler: 'quickSearchLeaveDetailCheck'
		    }, '-',{
                text: 'Clear Text',
                tooltip: '清空搜索框',
                iconCls: 'fa fa-eraser',
                handler: 'clearText' 
            }],			
            dockedItems: [{
                xtype: 'pagingtoolbar',
                dock: 'bottom',
                displayInfo: true,
                bind: '{leaveDetailCheckLists}'
            }]
    	}
    ]
});
