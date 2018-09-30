
Ext.define('Admin.view.employee.EmployeePanel', {
    extend: 'Ext.panel.Panel',
    xtype: 'employeePanel',

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
            cls: 'user-grid',
            title: 'Employee Grid Results',
            selModel: {type: 'checkboxmodel',checkOnly: true},
            //routeId: 'user',
            bind: '{employeeLists}',
            scrollable: false,
            columns: [
           {xtype: 'gridcolumn',width: 40,dataIndex: 'id',text: 'id',hidden:true},
       	   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'userName',text: 'UserName',flex:1},
       	   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'realName',text: 'Real Name',flex:1},
       	   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'idCardNumber',text: 'id Card Number',flex:1},
		   {xtype: 'datecolumn',cls: 'content-column', width: 160,dataIndex: 'createTime',text: 'Create Time',renderer:Ext.util.Format.dateRenderer('Y/m/d H:i:s')},
                {xtype: 'actioncolumn',cls: 'content-column', width: 120,text: 'Actions',tooltip: 'edit ',
                    items: [
                        {xtype: 'button', iconCls: 'x-fa fa-pencil' ,handler: 'openEditWindow'},
                        {xtype: 'button',iconCls: 'x-fa fa-close',handler: 'deleteOneRow'},
                        {xtype: 'button',iconCls: 'x-fa fa-ban',handler: 'onDisableButton'}
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
								{ name: '创建时间', value: 'create_time' }
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
		                     reference:'searchFieldValue',
            			 name:'employeePanelSearchField'
		                } ,'-', {
		                     xtype:'datefield',            
            			  reference:'searchDateFieldValue1',
            		 	  hidden :true,
            			  name:'employeePanelSearchDateField1',
            			 format: 'Y/m/d H:i:s'
		                },'-', {
		                     xtype:'datefield',            
            			  reference:'searchDateFieldValue2',
            		 	  hidden :true,
            			  name:'employeePanelSearchDateField2',
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
				        tooltip: 'Add a new row',
				        iconCls: 'fa fa-plus',
				        handler: 'openAddWindow'	
				    },'-',{
				        text: 'Removes',
				        tooltip: 'Remove the selected item',
				        iconCls:'fa fa-trash',
				        itemId:'employeeGridPanelRemove', 
				        disabled: true,
				        handler: 'deleteMoreRows'	     			 
		}
],	
            dockedItems: [{
                xtype: 'pagingtoolbar',
                dock: 'bottom',
                //itemId: 'userPaginationToolbar',
                displayInfo: true,
                bind: '{employeeLists}',
            }],
            listeners:{selectionchange:function(selModel, selections) {
  				this.down('#employeeGridPanelRemove').setDisabled(selections.length === 0);}}
        }]
});
