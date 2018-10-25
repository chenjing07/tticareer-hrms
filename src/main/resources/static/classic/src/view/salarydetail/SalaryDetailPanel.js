
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
       	   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'userName',text: 'employee Number',flex:2},
       	   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'realName',text: 'Real Name',flex:1},
           {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'basicSalary',text: 'Basic Salary',flex:1},
       	   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'bonus',text: 'Bonus',flex:1},
       	   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'subsidy',text: 'Subsidy',flex:1},
       	   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'overWorkSalary',text: 'over Work Salary',flex:1},
           {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'attendanceDeduction',text: 'Attendance Deduction',flex:1},
           {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'salaryTotal',text: 'Salary Total',flex:1},
           {xtype: 'datecolumn',cls: 'content-column',dataIndex: 'createTime',text: 'Create Time',renderer:Ext.util.Format.dateRenderer('Y/m/d H:i:s')},
		   {xtype: 'datecolumn',cls: 'content-column',width: 160,dataIndex: 'nowYearMonth',text: 'now Year Month',renderer:Ext.util.Format.dateRenderer('Y/m')},
		   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'statement',text: 'Statement',flex:1},
		   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'checkStatusment',text: 'Check Statusment',flex:1},
		   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'note',text: 'Note',flex:1},
		   
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
				        text: 'Search',
				        iconCls: 'fa fa-search',
				        handler: 'quickSearch'
				    },'-',{
				        text: 'Search More',
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
