Ext.define('Admin.view.assessment.EmployeeAssessmentPanel', {
    extend: 'Ext.tab.Panel',
    xtype: 'employeeAssessmentPanel',

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
            cls: 'EmployeeAssessment-grid',
            title: '员工考核信息管理',
            //routeId: 'user',
            selModel: {type: 'checkboxmodel'},
            bind: '{EmployeeAssessmentLists}',
            scrollable: false,
            columns: [
                {xtype: 'gridcolumn',width: 40,dataIndex: 'id',text: 'id',hidden:true},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'employeeId',text: 'employeeId',flex: 1,hidden:true},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'userName',text: '员工编号',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'realName',text: '员工名称',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'assessmentType',text: '考核分类',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'workResult',text: '工作业绩',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'attitude',text: '工作态度',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'quality',text: '工作质量',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'skill',text: '工作技能',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'assessmentResult',text: '考核结果',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'evaluate',text: '评价',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'checkStatus',text: '审核情况',flex: 1},
                {xtype: 'datecolumn',cls: 'content-column',width: 180,dataIndex: 'createTime',text: '录入时间',formatter: 'date("Y/m/d H:i:s")'},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'note',text: '备注',flex: 1},
                {xtype: 'actioncolumn',cls: 'content-column', width: 120,text: '操作',tooltip: 'Action',
                    items: [
                        {xtype: 'button', iconCls: 'x-fa fa-pencil' ,handler: 'openEmployeeAssessmentEditWindow'}
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
	            width: 135,
                listeners:{
                    select: 'searchComboboxSelectChuang'
                }
	        }, '-',{
            	xtype:'textfield',
                reference:'searchFieldValue',
            	name:'employeeAssessmentSearchField'
		    }, '-',{
		        text: 'Search',
		        tooltip: '搜索',
		        iconCls: 'fa fa-search',
		        handler: 'quickSearchEmployeeAssessment'
		    }, '-',{
                text: 'Clear Text',
                tooltip: '清空搜索框',
                iconCls: 'fa fa-eraser',
                handler: 'clearText' 
            }, '->',{
		        text: 'Add',
		        tooltip: '添加员工考核信息',
		        iconCls: 'fa fa-plus',
		        handler: 'openEmployeeAssessmentAddWindow'	
		    },'-',{
		        text: 'Removes',
		        tooltip: '删除选中的信息',
		        iconCls:'fa fa-trash',
		        handler: 'deleteEmployeeAssessmentMoreRows'	
		    }],			
            dockedItems: [{
                xtype: 'pagingtoolbar',
                dock: 'bottom',
                displayInfo: true,
                bind: '{EmployeeAssessmentLists}'
            }]
    	},
    	{
            xtype: 'gridpanel',
            cls: 'EmployeeAssessmentCheck-grid',
            title: '员工考核信息复核',
            //routeId: 'user',
            selModel: {type: 'checkboxmodel'},
            bind: '{EmployeeAssessmentCheckLists}',
            scrollable: false,
            columns: [
                {xtype: 'gridcolumn',width: 40,dataIndex: 'id',text: 'id',hidden:true},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'employeeId',text: 'positionId',flex: 1,hidden:true},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'userName',text: '员工编号',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'realName',text: '员工名称',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'assessmentType',text: '考核分类',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'workResult',text: '工作业绩',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'attitude',text: '工作态度',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'quality',text: '工作质量',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'skill',text: '工作技能',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'assessmentResult',text: '考核结果',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'evaluate',text: '评价',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'checkStatus',text: '审核情况',flex: 1},
                {xtype: 'datecolumn',cls: 'content-column',width: 180,dataIndex: 'createTime',text: '录入时间',formatter: 'date("Y/m/d H:i:s")'},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'note',text: '备注',flex: 1},
                {xtype: 'actioncolumn',cls: 'content-column', width: 120,text: '操作',tooltip: 'Action',
                    items: [
                        {xtype: 'button', iconCls: 'x-fa fa-play' ,handler: 'checkStatusSuccess'},
                        {xtype: 'button', iconCls: 'x-fa fa-ban' ,handler: 'checkStatusFail'}
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
	            width: 135,
                listeners:{
                    select: 'searchComboboxSelectChuang'
                }
	        }, '-',{
            	xtype:'textfield',
                reference:'searchFieldValue',
            	name:'employeeAssessmentSearchField'
		    }, '-',{
		        text: 'Search',
		        tooltip: '搜索',
		        iconCls: 'fa fa-search',
		        handler: 'quickSearchEmployeeAssessmentCheck'
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
                bind: '{EmployeeAssessmentCheckLists}'
            }]
    	}
    ]
});
