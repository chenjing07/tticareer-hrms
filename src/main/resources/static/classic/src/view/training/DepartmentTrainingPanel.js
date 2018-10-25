Ext.define('Admin.view.training.DepartmentTrainingPanel', {
    extend: 'Ext.panel.Panel',
    xtype: 'departmentTrainingPanel',

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
            cls: 'user-grid',
            title: '部门培训信息管理',
            //routeId: 'user',
            selModel: {type: 'checkboxmodel'},
            bind: '{departmentTrainingLists}',
            scrollable: false,
            columns: [
                {xtype: 'gridcolumn',width: 40,dataIndex: 'id',text: 'id',hidden:true},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'departmentId',text: 'departmentId',flex: 1,hidden:true},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'departmentNumber',text: '部门编号',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'departmentName',text: '部门名称',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'lecturer',text: '讲师',flex: 1},
                {xtype: 'datecolumn',cls: 'content-column',width: 180,dataIndex: 'time',text: '培训开始时间',formatter: 'date("Y/m/d H:i:s")'},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'duration',text: '培训计划时长',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'purpose',text: '培训目的',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'number',text: '计划人数',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'cost',text: '计划费用',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'place',text: '培训地点',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'content',text: '培训内容',flex: 1},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'state',text: '状态',
                		renderer: function(val) {
                			if (val == '未进行') {
                				return '<span style="color:red;">未进行</span>';
							} else {
								return '<span style="color:green;">正在进行</span>';
							}
                		}
                },
                {xtype: 'datecolumn',cls: 'content-column',width: 180,dataIndex: 'createTime',text: '录入时间',formatter: 'date("Y/m/d H:i:s")'},
                {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'note',text: '备注',flex: 1},
                {xtype: 'actioncolumn',cls: 'content-column', width: 120,text: '操作',tooltip: 'Action',
                    items: [
                        {xtype: 'button', iconCls: 'x-fa fa-pencil' ,handler: 'openEditWindow'},
                        {xtype: 'button', iconCls: 'x-fa fa-play' ,handler: 'startTraining'}
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
				      	{ name: '部门编号', value: 'departmentNumber' }
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
                reference:'searchFieldValue'
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
                bind: '{departmentTrainingLists}'
            }]
        }]
});
