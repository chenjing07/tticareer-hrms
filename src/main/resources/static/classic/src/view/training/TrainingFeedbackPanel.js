Ext.define('Admin.view.training.TrainingFeedbackPanel', {
    extend: 'Ext.panel.Panel',
    xtype: 'trainingFeedbackPanel',

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
    items: [{
            xtype: 'gridpanel',
            cls: 'training-feedback-grid',
            title: '培训反馈信息管理',
            //routeId: 'user',
            selModel: {type: 'checkboxmodel'},
            bind: '{trainingFeedbackLists}',
            scrollable: false,
            columns: [
                {xtype: 'gridcolumn',width: 40,dataIndex: 'id',text: 'id',hidden:true},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'trainingInfoId',text: 'trainingInfoId',flex: 1,hidden:true},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'userName',text: '员工编号',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'realName',text: '员工名称',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'lecturer',text: '讲师',flex: 1},
                {xtype: 'datecolumn',cls: 'content-column',width: 180,dataIndex: 'time',text: '培训开始时间',formatter: 'date("Y/m/d H:i:s")'},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'duration',text: '培训计划时长',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'purpose',text: '培训目的',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'place',text: '培训地点',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'content',text: '培训内容',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'trainingFeedback',text: '反馈信息',flex: 1},
                {xtype: 'datecolumn',cls: 'content-column',width: 180,dataIndex: 'createTime',text: '录入时间',formatter: 'date("Y/m/d H:i:s")'},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'note',text: '备注',flex: 1},
                {xtype: 'actioncolumn',cls: 'content-column', width: 120,text: '操作',tooltip: 'Action',
                    items: [
                        {xtype: 'button', iconCls: 'x-fa fa-pencil' ,handler: 'openEditWindow'}
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
                        { name: '讲师', value: 'lecturer' }
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
            	name:'trainingFeedbackPanelSearchField'
		    }, '-',{
		        text: 'Search',
		        tooltip: '搜索',
		        iconCls: 'fa fa-search',
		        handler: 'quickSearch'
		    }, '-',{
                text: 'Clear Text',
                tooltip: '清空搜索框',
                iconCls: 'fa fa-eraser',
                handler: 'clearText' 
            }, '->',{
		        text: 'Add',
		        tooltip: '添加培训信息',
		        iconCls: 'fa fa-plus',
		        handler: 'openAddWindow'	
		    },'-',{
		        text: 'Removes',
		        tooltip: '删除选中的信息',
		        iconCls:'fa fa-trash',
		        handler: 'deleteMoreRows'	
		    }],			
            dockedItems: [{
                xtype: 'pagingtoolbar',
                dock: 'bottom',
                displayInfo: true,
                bind: '{trainingFeedbackLists}'
            }]
        }]
});