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
       	   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'userName',text: '工号',flex:1},
       	   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'realName',text: '真实姓名',flex:1},
       	   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'idCardNumber',text: '身份证号',flex:1},
		   {xtype: 'datecolumn',cls: 'content-column', width: 160,dataIndex: 'createTime',text: '创建时间',renderer:Ext.util.Format.dateRenderer('Y/m/d H:i:s')},
                {xtype: 'actioncolumn',cls: 'content-column', width: 120,text: 'Actions',tooltip: 'edit ',
                    items: [
                        {xtype: 'button', iconCls: 'x-fa fa-pencil' ,handler: 'openEditWindow'},
                        {xtype: 'button',iconCls: 'x-fa fa-close',handler: 'deleteOneRow'},
                        {xtype: 'button',iconCls: 'x-fa fa-ban',handler: 'onDisableButton'}
                    ]
                }
            ],
            tbar: [		{ 
		                    xtype: 'combobox',
		                    reference:'searchFieldName',
		                    hideLabel: true, 
		                    store:Ext.create("Ext.data.Store", {
						    fields: ["name", "value"],
						    data: [
						      	{ name: '工号', value: 'userName' },
								{ name: '真实姓名', value: 'realName' }]
							}),     
		                    displayField: 'name',
		                    valueField:'value',
							value:'userName',
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
		                     xtype:'textfield',            
							 reference:'searchFieldValue1',
							 hidden :true,
							 name:'employeePanelSearchField1',
							 
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
