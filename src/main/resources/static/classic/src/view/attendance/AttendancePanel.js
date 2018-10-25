Ext.define('Admin.view.attendance.AttendancePanel', {
    extend: 'Ext.tab.Panel',
    xtype: 'attendancePanel',

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
            title: '打卡签到信息管理',
            //routeId: 'user',
            selModel: {type: 'checkboxmodel'},
            bind: '{clockDetailLists}',
            scrollable: false,
            columns: [
                {xtype: 'gridcolumn',width: 40,dataIndex: 'id',text: 'id',hidden:true},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'employeeId',text: 'employeeId',flex: 1,hidden:true},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'userName',text: '员工编号',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'realName',text: '员工名称',flex: 1},
                {xtype: 'datecolumn',cls: 'content-column',width: 300,dataIndex: 'clockIn',text: '签到时间',formatter: 'date("Y/m/d H:i:s")'},
                {xtype: 'datecolumn',cls: 'content-column',width: 300,dataIndex: 'clockOut',text: '签退时间',formatter: 'date("Y/m/d H:i:s")'},
                {xtype: 'datecolumn',cls: 'content-column',width: 300,dataIndex: 'createTime',text: '录入时间',formatter: 'date("Y/m/d H:i:s")'},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'note',text: '备注',flex: 1}
            ],
            tbar: [{
	            xtype: 'combobox',
                reference:'searchFieldName',
	            hideLabel: true,
	            store:Ext.create("Ext.data.Store", {
				    fields: ["name", "value"],
				    data: [
				      	{ name: '员工编号', value: 'userName' },
						{ name: '员工名称', value: 'realName' },
                        { name: '备注', value: 'note' }
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
            	name:'clockDetailSearchField'
		    }, '-',{
		        text: 'Search',
		        tooltip: '搜索',
		        iconCls: 'fa fa-search',
		        handler: 'quickSearchClockDetail'
		    }, '-',{
                text: 'Clear Text',
                tooltip: '清空搜索框',
                iconCls: 'fa fa-eraser',
                handler: 'clearText' 
            }, '->',{
		        text: 'Clear Today',
		        tooltip: '清空今天的签到打卡信息',
		        iconCls:'fa fa-ban',
		        handler: 'clearToday'	
		    }],			
            dockedItems: [{
                xtype: 'pagingtoolbar',
                dock: 'bottom',
                displayInfo: true,
                bind: '{clockDetailLists}'
            }]
        },
        {
            xtype: 'gridpanel',
            cls: 'user-grid',
            title: '迟到早退信息管理',
            //routeId: 'user',
            selModel: {type: 'checkboxmodel'},
            bind: '{lateEarlyLists}',
            scrollable: false,
            columns: [
                {xtype: 'gridcolumn',width: 40,dataIndex: 'id',text: 'id',hidden:true},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'employeeId',text: 'employeeId',flex: 1,hidden:true},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'userName',text: '员工编号',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'realName',text: '员工名称',flex: 1},
                {xtype: 'datecolumn',cls: 'content-column',width: 200,dataIndex: 'lateEarlyTime',text: '迟到早退时间',formatter: 'date("Y/m/d H:i:s")'},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'lateEarlyReason',text: '迟到早退原因',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'state',text: '迟到/早退',flex: 1},
                {xtype: 'datecolumn',cls: 'content-column',width: 180,dataIndex: 'createTime',text: '录入时间',formatter: 'date("Y/m/d H:i:s")'},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'note',text: '备注',flex: 1},
                {xtype: 'actioncolumn',cls: 'content-column', width: 120,text: '操作',tooltip: 'Action',
                    items: [
                        {xtype: 'button', iconCls: 'x-fa fa-pencil' ,handler: 'openLateEarlyEditWindow'}
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
						{ name: '员工名称', value: 'realName' },
                        { name: '迟到/早退', value: 'stateContent' }
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
            	name:'lateEarlySearchField'
		    }, '-',{
		        text: 'Search',
		        tooltip: '搜索',
		        iconCls: 'fa fa-search',
		        handler: 'quickSearchLateEarly'
		    }, '-',{
                text: 'Clear Text',
                tooltip: '清空搜索框',
                iconCls: 'fa fa-eraser',
                handler: 'clearText' 
            }, '->',{
		        text: 'Add',
		        tooltip: '添加培迟到早退信息',
		        iconCls: 'fa fa-plus',
		        handler: 'openLateEarlyAddWindow'	
		    },'-',{
		        text: 'Removes',
		        tooltip: '删除选中的信息',
		        iconCls:'fa fa-trash',
		        handler: 'deleteLateEarlyMoreRows'	
		    }],			
            dockedItems: [{
                xtype: 'pagingtoolbar',
                dock: 'bottom',
                displayInfo: true,
                bind: '{lateEarlyLists}'
            }]
    	},
    	{
            xtype: 'gridpanel',
            cls: 'user-grid',
            title: '加班信息管理',
            //routeId: 'user',
            selModel: {type: 'checkboxmodel'},
            bind: '{overWorkLists}',
            scrollable: false,
            columns: [
                {xtype: 'gridcolumn',width: 40,dataIndex: 'id',text: 'id',hidden:true},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'employeeId',text: 'employeeId',flex: 1,hidden:true},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'userName',text: '员工编号',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'realName',text: '员工名称',flex: 1},
                {xtype: 'datecolumn',cls: 'content-column',width: 200,dataIndex: 'time',text: '加班日期',formatter: 'date("Y/m/d H:i:s")'},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'duration',text: '加班时长',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'content',text: '加班内容',flex: 1},
                {xtype: 'datecolumn',cls: 'content-column',width: 180,dataIndex: 'createTime',text: '录入时间',formatter: 'date("Y/m/d H:i:s")'},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'note',text: '备注',flex: 1},
                {xtype: 'actioncolumn',cls: 'content-column', width: 120,text: '操作',tooltip: 'Action',
                    items: [
                        {xtype: 'button', iconCls: 'x-fa fa-pencil' ,handler: 'openOverWorkEditWindow'}
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
            	name:'lateEarlySearchField'
		    }, '-',{
		        text: 'Search',
		        tooltip: '搜索',
		        iconCls: 'fa fa-search',
		        handler: 'quickSearchOverWork'
		    }, '-',{
                text: 'Clear Text',
                tooltip: '清空搜索框',
                iconCls: 'fa fa-eraser',
                handler: 'clearText' 
            }, '->',{
		        text: 'Add',
		        tooltip: '添加加班信息',
		        iconCls: 'fa fa-plus',
		        handler: 'openOverWorkAddWindow'	
		    },'-',{
		        text: 'Removes',
		        tooltip: '删除选中的信息',
		        iconCls:'fa fa-trash',
		        handler: 'deleteOverWorkMoreRows'	
		    }],			
            dockedItems: [{
                xtype: 'pagingtoolbar',
                dock: 'bottom',
                displayInfo: true,
                bind: '{overWorkLists}'
            }]
    	}
    ]
});
