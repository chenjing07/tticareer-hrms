
Ext.define('Admin.view.salarydetail.SalaryDetailPanel', {
    extend: 'Ext.panel.Panel',
    xtype: 'salaryDetailPanel',

    requires: [
        'Ext.grid.Panel',
        'Ext.toolbar.Paging',
        'Ext.form.field.ComboBox',
        'Ext.selection.CheckboxModel',
        'Ext.grid.column.RowNumberer',
        'Ext.grid.column.Date'
    ],
    //controller: 'searchresults',
   // viewModel: {type: 'orderViewModel'},
    layout: 'fit',
    items: [{
            xtype: 'gridpanel',
            cls: 'salarydetail-grid',
            title: '薪酬信息',
            selModel: {type: 'checkboxmodel',checkOnly: true},
            //routeId: 'user',
            bind: '{salaryDetailLists}',
            scrollable: false,
            columns: [
           {xtype: 'gridcolumn',width: 40,dataIndex: 'id',text: 'id',hidden:true},
       	   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'employeeId',text: 'employee Id',flex:1,hidden:true},
       	   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'userName',text: '员工编号',flex:2},
       	   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'realName',text: '员工名字',flex:1},
           {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'basicSalary',text: '基本工资',flex:1},
       	   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'bonus',text: '奖金',flex:1},
       	   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'subsidy',text: '津贴',flex:1},
       	   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'overWorkSalary',text: '加班工资',flex:1},
           {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'attendanceDeduction',text: '考勤需扣',flex:1},
           {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'salaryTotal',text: '工资总和',flex:1},
           {xtype: 'datecolumn',cls: 'content-column',dataIndex: 'createTime',text: '创建时间',renderer:Ext.util.Format.dateRenderer('Y/m/d H:i:s')},
		   {xtype: 'datecolumn',cls: 'content-column',dataIndex: 'nowYearMonth',text: '工资所属年月',renderer:Ext.util.Format.dateRenderer('Y/m')},
		   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'statement',text: '状态',flex:1,hidden:true},
		   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'checkStatus',text: '审查状态',flex:1,
			   renderer: function(val) {
		            if (val =='1') {
			            return '<span style="color:green;">已审查</span>';
			        } else {
			            return '<span style="color:blue;">待审查</span>';
			        }
       	   }},
		   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'note',text: '备注',flex:1},
		   
                {xtype: 'actioncolumn',cls: 'content-column', width: 120,text: 'Actions',tooltip: 'edit ',
                    items: [
                        {xtype: 'button', iconCls: 'x-fa fa-pencil' ,handler: 'openEditWindow'},
                        {xtype: 'button',iconCls: 'x-fa fa-close',handler: 'deleteOneRow'},
                        {xtype: 'button',iconCls: 'x-fa fa-check',handler: 'openCheckWindow'}
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
						      	{ name: '工号', value: 'employee_number' },
								{ name: '年月', value: 'now_year_month' },
								{ name: '未审查', value: 'check_status' },
						    ]
						}),     
		                    displayField: 'name',
		                    valueField:'value',
	           			 value:'employee_number',
	           			 editable: false,
		                    queryMode: 'local',
		                    triggerAction: 'all',
		                    emptyText: 'Select a state...',
		                    width: 135,
		                    listeners:{
						select: 'searchComboboxSelectChuang'
				}
		                },'-', {
		                     xtype:'textfield',
		                     reference:'searchNumberFieldValue',
            			 name:'salaryDetailPanelSearchNumberField'
		                } ,'-', {
		                     xtype:'monthfield',            
            			  reference:'searchDateFieldValue',
            		 	  hidden :true,
            			  name:'salaryDetailPanelSearchDateField',
            			 format: 'Y/m/d H:i:s'
		                },'-',{
				        text: '快捷查询',
				        iconCls: 'fa fa-search',
				        handler: 'quickSearch'
				    },'-',{
				        text: '复杂查询',
				        iconCls: 'fa fa-search-plus',
				        handler: 'openSearchWindow'	
				    },'->',{
				        text: 'Add',
				        tooltip: '添加工资信息',
				        iconCls: 'fa fa-plus',
				        handler: 'openAddWindow'	
				    },'-',{
				        text: 'Removes',
				        tooltip: 'Remove the selected item',
				        iconCls:'fa fa-trash',
				        itemId:'salaryDetailGridPanelRemove', 
				        disabled: true,
				        handler: 'deleteMoreRows'	     			 
		            }
],	
            dockedItems: [{
                xtype: 'pagingtoolbar',
                dock: 'bottom',
                //itemId: 'userPaginationToolbar',
                displayInfo: true,
                bind: '{salaryDetailLists}',
            }],
            listeners:{selectionchange:function(selModel, selections) {
  				this.down('#salaryDetailGridPanelRemove').setDisabled(selections.length === 0);}}
        }]
});
