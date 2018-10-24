Ext.define('Admin.view.assessment.AssessmentStandardPanel', {
    extend: 'Ext.tab.Panel',
    xtype: 'assessmentStandardPanel',

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
            cls: 'AssessmentStandard-grid',
            title: '考核标准信息管理',
            //routeId: 'user',
            selModel: {type: 'checkboxmodel'},
            bind: '{assessmentStandardLists}',
            scrollable: false,
            columns: [
                {xtype: 'gridcolumn',width: 40,dataIndex: 'id',text: 'id',hidden:true},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'positionId',text: 'positionId',flex: 1,hidden:true},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'positionNumber',text: '岗位编号',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'positionName',text: '岗位名称',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'workResult',text: '工作业绩说明',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'attitude',text: '工作态度说明',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'quality',text: '工作质量说明',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'skill',text: '工作技能说明',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'calculationWay',text: '考核计算方法说明',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'assessmentType',text: '考核分类说明',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'resultLevel',text: '结果级别划分说明',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'state',text: '状态',flex: 1,hidden:true},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'checkStatus',text: '审核情况',flex: 1},
                {xtype: 'datecolumn',cls: 'content-column',width: 180,dataIndex: 'createTime',text: '录入时间',formatter: 'date("Y/m/d H:i:s")'},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'note',text: '备注',flex: 1},
                {xtype: 'actioncolumn',cls: 'content-column', width: 120,text: '操作',tooltip: 'Action',
                    items: [
                        {xtype: 'button', iconCls: 'x-fa fa-pencil' ,handler: 'openAssessmentStandardEditWindow'}
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
				      	{ name: '岗位编号', value: 'positionNumber' },
						{ name: '岗位名称', value: 'positionName' }
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
            	name:'assessmentStandardSearchField'
		    }, '-',{
		        text: 'Search',
		        tooltip: '搜索',
		        iconCls: 'fa fa-search',
		        handler: 'quickSearchAssessmentStandard'
		    }, '-',{
                text: 'Clear Text',
                tooltip: '清空搜索框',
                iconCls: 'fa fa-eraser',
                handler: 'clearText' 
            }, '->',{
		        text: 'Add',
		        tooltip: '添加考核标准信息',
		        iconCls: 'fa fa-plus',
		        handler: 'openAssessmentStandardAddWindow'	
		    },'-',{
		        text: 'Removes',
		        tooltip: '删除选中的信息',
		        iconCls:'fa fa-trash',
		        handler: 'deleteAssessmentStandardMoreRows'	
		    }],			
            dockedItems: [{
                xtype: 'pagingtoolbar',
                dock: 'bottom',
                displayInfo: true,
                bind: '{assessmentStandardLists}'
            }]
    	},
    	{
            xtype: 'gridpanel',
            cls: 'AssessmentStandardCheck-grid',
            title: '考核标准信息复核',
            //routeId: 'user',
            selModel: {type: 'checkboxmodel'},
            bind: '{assessmentStandardCheckLists}',
            scrollable: false,
            columns: [
                {xtype: 'gridcolumn',width: 40,dataIndex: 'id',text: 'id',hidden:true},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'positionId',text: 'positionId',flex: 1,hidden:true},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'positionNumber',text: '岗位编号',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'positionName',text: '岗位名称',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'workResult',text: '工作业绩说明',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'attitude',text: '工作态度说明',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'quality',text: '工作质量说明',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'skill',text: '工作技能说明',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'calculationWay',text: '考核计算方法说明',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'assessmentType',text: '考核分类说明',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'resultLevel',text: '结果级别划分说明',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'state',text: '状态',flex: 1,hidden:true},
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
				      	{ name: '岗位编号', value: 'positionNumber' },
						{ name: '岗位名称', value: 'positionName' }
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
            	name:'assessmentStandardSearchField'
		    }, '-',{
		        text: 'Search',
		        tooltip: '搜索',
		        iconCls: 'fa fa-search',
		        handler: 'quickSearchAssessmentStandardCheck'
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
                bind: '{assessmentStandardCheckLists}'
            }]
    	}
    ]
});
